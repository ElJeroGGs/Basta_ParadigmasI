package controlador;

import modelo.Estados;
import modelo.jugador;
import modelo.resultados;
import vista.Inicio;
import vista.JuegoBasta;

public class ControlJuego implements ControlJuegoInterfaz, EstadoListener{
    
	private int estado;
	private EstadoListener mListener;
	private Inicio vInicial;
	private JuegoBasta vJuego;
	private ControlNet ctrlComunicacion;
	
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
	
	public void setVJuego(JuegoBasta v) {
		this.vJuego = v;
	}
	
	public void setVInicial(Inicio v) {
		this.vInicial = v;
	}
	
	@Override
	public void unirmeAPartida(String jugador) {
		new Thread(new Runnable() {  
            public void run(){  
            	String edo;
                // Registrame a la partida con el servidor
            	edo = ctrlComunicacion.registra(jugador); 
				vJuego.setJugador(jugador);

                //Preguntamos para ver cuando se llena la partida
                while(edo.compareToIgnoreCase("LISTO")!=0) {
                	edo = ctrlComunicacion.getEstado(); //Ya estas listo?
                }
                // Invoca la funcion callback de mi clase
                mListener.setEstado(edo);
            }  
        }).start();  
	}
	
	@Override
	public void setEstado(String edo) {
		switch(edo) {
			case "INICIAL": 
				this.estado = Estados.INICIAL;
				this.vJuego.setVisible(false);
				this.vInicial.setVisible(true);
				break;
			case "CARGANDO":
				this.estado = Estados.CARGANDO;
				this.vJuego.setVisible(false);
				this.vInicial.setVisible(true);
				break;
			case "LISTO":
				this.estado = Estados.LISTO;
				this.vInicial.setVisible(false);
				this.vJuego.setVisible(true);
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

		String prueba = data.toString();
		System.out.println(prueba);
		vJuego.setResultado(data);
	}

	@Override
	public String verLetra() {

		return ctrlComunicacion.verLetra();	}


	

	
}
