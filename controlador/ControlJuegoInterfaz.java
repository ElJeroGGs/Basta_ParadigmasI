package controlador;

import modelo.PartidaData;

public interface ControlJuegoInterfaz {
	
	public void unirmeAPartida(String json);
	public PartidaData getDatos();
}