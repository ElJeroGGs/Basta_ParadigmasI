/*
INTEGRANTES
*
Alvarez Macedo Efren
Mercado Hernández José Eduardo
Espinoza Castañeda Yonathan
Espinosa Santana Angel David
*/
package controlador;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import modelo.BastaServer;
import modelo.jugador;
import modelo.resultados;
import modelo.PartidaEstado;

public class ControlNetFake implements ControlNet {
	private BastaServer servidor;
	
	public void setServidor(BastaServer s) {
		this.servidor = s;
	}
	
	@Override
	public String getEstado() {
		PartidaEstado respuestaReg;
		GsonBuilder builder;
		Gson gson;
		String jsonEstado;
		
		jsonEstado = this.servidor.getEstado();
		//Crear el objeto Gson para desarializar la respuesta
		builder = new GsonBuilder();
		builder.setPrettyPrinting();
		gson = builder.create();
		
		respuestaReg = gson.fromJson(jsonEstado,PartidaEstado.class);
		
		
		return respuestaReg.getEstado();
	}

	@Override
	public String registra(String nombre) {
		jugador j;
		GsonBuilder builder;
		Gson gson;
		String jugadorJson, respuestaJson;
		PartidaEstado respuestaReg;
		
		j = new jugador();
		j.setNombre(nombre);
		
		//Crear la cadena Json para llamar al servidor
		builder = new GsonBuilder();
		builder.setPrettyPrinting();
		gson = builder.create();
		jugadorJson = gson.toJson(j);
		
		respuestaJson = this.servidor.registra(jugadorJson);
		
		//Sacar el estado de la respuesta del servidor
		respuestaReg = gson.fromJson(respuestaJson, PartidaEstado.class);
		
		return respuestaReg.getEstado();
	}

	@Override
	public resultados Califica(jugador j) {

		GsonBuilder builder;
		Gson gson;
		String jugadorJson, respuestaJson;

		//Crear la cadena Json para llamar al servidor
		builder = new GsonBuilder();
		builder.setPrettyPrinting();
		gson = builder.create();
		jugadorJson = gson.toJson(j);

		respuestaJson = this.servidor.postTirada(jugadorJson);

		resultados resultados = gson.fromJson(respuestaJson, resultados.class);
		return resultados;
	}

	@Override
	public String verLetra() {
		return this.servidor.getLetra();
	}

}