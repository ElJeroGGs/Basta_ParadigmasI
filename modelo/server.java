package modelo;

import java.util.Random;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import modelo.jugador;
import modelo.PartidaEstado;
import modelo.Puntuaciones;

public class server implements BastaServer {

	
	
	private String estado;
	private String jugadorNombre;
	
	public server() {
		super();
		estado = "INICIAL";
	}
	
	@Override
	public String getEstado() {
		return this.generaRespuestaEstado(this.estado);
	}

    @Override
    public String getLetra() {
    Random random = new Random();
    char letra = (char) (random.nextInt(26) + 'a');
    return String.valueOf(letra);
}

	private static final int[] PUNTUACIONES = {Puntuaciones.CERO_REPETICIONES, Puntuaciones.UNA_REPETICIONES,Puntuaciones.DOS_REPETICIONES ,Puntuaciones.MUCHAS_REPETICIONES};

	@Override
	public String postTirada(String jugador) {

		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();
		

		jugador j = gson.fromJson(jugador, jugador.class);

		int TotalPartida = j.getTotalPartida();
		Random random = new Random();
		int val1,val2,val3,val4,val5;
		val1 = PUNTUACIONES[random.nextInt(PUNTUACIONES.length)];
		val2 = PUNTUACIONES[random.nextInt(PUNTUACIONES.length)];
		val3 = PUNTUACIONES[random.nextInt(PUNTUACIONES.length)];
		val4 = PUNTUACIONES[random.nextInt(PUNTUACIONES.length)];
		val5 = PUNTUACIONES[random.nextInt(PUNTUACIONES.length)];
		resultados r = new resultados(val1,val2,val3,val4,val5, TotalPartida);
		
		String respuestaJson;
		
		respuestaJson = gson.toJson(r);
		
		return respuestaJson;
	}

	@Override
	public String registra(String cadenaJson) {
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();
		
		//Paso (2)
		jugador jugador = gson.fromJson(cadenaJson, jugador.class);
		
		//Registra el jugador
		this.jugadorNombre = jugador.getNombre();
		//Cambia el estado
		this.estado = "LISTO";  //Simulamos que ya se conectaron todos
		//Regenera la respuesta
		return this.generaRespuestaEstado("CARGANDO");
	}
	
	private String generaRespuestaEstado(String edo) {
		PartidaEstado respuesta;
		String cadenaJson;
		
		respuesta = new PartidaEstado();
		respuesta.setEstado(edo);
		respuesta.setJugador(this.jugadorNombre);
		
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();
		
		cadenaJson = gson.toJson(respuesta);
		
		return cadenaJson;
	}

}