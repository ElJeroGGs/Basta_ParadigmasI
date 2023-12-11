/*
INTEGRANTES
*
Alvarez Macedo Efren
Mercado Hernández José Eduardo
Espinoza Castañeda Yonathan
Espinosa Santana Angel David
*/
package controlador;

import modelo.Estados;
import modelo.jugador;
import modelo.resultados;
import vista.FinalPartida;
import vista.Inicio;
import vista.JuegoBasta;

public class ControlJuego implements ControlJuegoInterfaz, EstadoListener {

	private int estado;
	private EstadoListener mListener;
	private Inicio vInicial;
	private JuegoBasta vJuego;
	private ControlNet ctrlComunicacion;
	private FinalPartida vFinalizacion;
	private int ronda=-1;

	public void accion(String comando) {

		switch (comando) {
			case "Enviar":
				if(ronda==10){
					termina();
				}else{
				ResultadosRonda();
				}
				break;
			case "VerLetra":
				verLetra();
				break;

		}
	}

	

	public ControlJuego() {
		mListener = this;
		estado = Estados.INICIAL;
	}

	public void setCtrlComunicacion(ControlNet ctrl) {
		this.ctrlComunicacion = ctrl;
	}

	public void inicia() {
		this.setEstado("INICIAL");
	}

	public void termina(){
		this.vJuego.setVisible(false);
		this.vFinalizacion.setPlayer(this.getResultadoFinal());
		this.vFinalizacion.setVisible(true);
	}

	public void setVJuego(JuegoBasta v) {
		this.vJuego = v;
	}

	public void setVInicial(Inicio v) {
		this.vInicial = v;
	}

	@Override
	public void unirmeAPartida(String jugador) {
		new Thread(new Runnable() {
			public void run() {
				String edo;
				// Registrame a la partida con el servidor
				edo = ctrlComunicacion.registra(jugador);
				vJuego.setJugador(jugador);

				// Preguntamos para ver cuando se llena la partida
				while (edo.compareToIgnoreCase("LISTO") != 0) {
					edo = ctrlComunicacion.getEstado(); // Ya estas listo?
				}
				// Invoca la funcion callback de mi clase
				mListener.setEstado(edo);

				while(VerificaCronometro()!=0){
					edo = ctrlComunicacion.getEstado();
					//Esta instruccion es para que no se quede pegado en el while
					//cuando el cronometro llega a 0
					//Pero en realidad no sirve para nada
					//NO BORRAR
				}
				accion("Enviar");
			}
		}).start();
	}

	@Override
	public void setEstado(String edo) {
		switch (edo) {
			case "INICIAL":
				this.estado = Estados.INICIAL;
				this.vJuego.setVisible(false);
				this.vInicial.setVisible(true);
				break;
			case "CARGANDO":
				this.estado = Estados.CARGANDO;
				this.vJuego.setVisible(true);
				this.vInicial.setVisible(false);
				this.vJuego.SwitchBtnLetra("apaga");
				this.vJuego.SwitchBtnEnviar("apaga");
				this.vJuego.SwitchTexto("apaga");
				break;
			case "LISTO":
				this.estado = Estados.LISTO;
				this.vInicial.setVisible(false);
				this.vJuego.setVisible(true);
				this.vJuego.ReadyCronometro();
				this.vJuego.SwitchBtnLetra("prende");
				this.vJuego.SwitchBtnEnviar("prende");
				this.vJuego.SwitchTexto("prende");
				break;
			default:
				break;
		}
	}

	@Override
	public void ResultadosRonda() {
		resultados data;
		jugador j = vJuego.getJugador();
		data = ctrlComunicacion.Califica(j);
		new Thread(new Runnable() {

			public void run() {

				String edo = ctrlComunicacion.getEstado(); // Ya estas listo?
				setEstado(edo);
				while (edo.compareToIgnoreCase("LISTO") != 0) {
					edo = ctrlComunicacion.getEstado(); // Ya estas listo?
				}
				setEstado(edo);
				vJuego.Limpia();
				vJuego.setResultado(data);
				ronda = data.getRonda();

				while(VerificaCronometro()!=0){
					edo = ctrlComunicacion.getEstado();
					//Esta instruccion es para que no se quede pegado en el while
					//cuando el cronometro llega a 0
					//Pero en realidad no sirve para nada
					//NO BORRAR
				}
				accion("Enviar");

			}
		}).start();

	}

	@Override
	public void verLetra() {
		String letra = ctrlComunicacion.verLetra();
		vJuego.setLetra(letra);
		vJuego.SwitchBtnLetra("apaga");
	}

	public void setVFinalizacion(FinalPartida v){
		this.vFinalizacion = v;
	}

	public jugador getResultadoFinal(){
		jugador j = vJuego.getJugador();
		return j;
	}

	public int VerificaCronometro(){
		return vJuego.VerificaCronometro();
	}
}
