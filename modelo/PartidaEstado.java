package modelo;

public class PartidaEstado {

    private String estado;
    private String jugador;
    private resultados data;


    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    public String getEstado() {
        return this.estado;
    }

    public String getJugador() {
        return this.jugador;
    }

    public resultados getData() {
        return data;
    }

    public void setData(resultados data) {
        this.data = data;
    }
    

    

}
