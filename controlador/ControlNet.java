package controlador;
import modelo.BastaServer;

public interface ControlNet {
	public String registra(String cadenaJson);
	public String getEstado();
	public void setServidor(BastaServer serv);
}