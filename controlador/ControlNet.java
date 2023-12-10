package controlador;
import modelo.BastaServer;
import modelo.jugador;
import modelo.resultados;

public interface ControlNet {
	public String registra(String cadenaJson);
	public String getEstado();
	public void setServidor(BastaServer serv);
    public resultados Califica(jugador j);
	public String verLetra();

}