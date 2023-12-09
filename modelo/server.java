package modelo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import modelo.jugador;
import modelo.PartidaEstado;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String postTirada(String usuario) {
		// TODO Auto-generated method stub
		return null;
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