/*
INTEGRANTES
*
Alvarez Macedo Efren
Mercado Hernández José Eduardo
Espinoza Castañeda Yonathan
Espinosa Santana Angel David
*/
package modelo;

public class jugador {

    private String Animal;
    private String Flor_Fruto;
    private String Pais;
    private String Nombre;
    private String Color;
    private String Usuario;
    private int TotalPartida;

    public jugador() {
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getAnimal() {
        return Animal;
    }

    public void setAnimal(String animal) {
        this.Animal = animal;
    }

    public String getFlor_Fruto() {
        return Flor_Fruto;
    }

    public void setFlor_Fruto(String flor_Fruto) {
        Flor_Fruto = flor_Fruto;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String pais) {
        Pais = pais;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }   

    public String getUsuario() {
        return Usuario;
    }

    public String getColor() {
        return Color;
    }
    
    public void setColor(String color) {
        Color = color;
    }

    public int getTotalPartida() {
        return TotalPartida;
    }

    public void setTotalPartida(int totalPartida) {
        TotalPartida = totalPartida;
    }

}
