package modelo;

import java.awt.image.ColorModel;

public class resultados {

private int Flor_Fruto;
private int Animal;
private int Pais;
private int Color;
private int Nombre;
private int TotalRonda = 0;
private int TotalPartida = 0;

public resultados(int Flor_Fruto, int Animal, int Pais, int Color, int Nombre){
this.Animal = Animal;
this.Flor_Fruto = Flor_Fruto;
this.Pais = Pais;
this.Color = Color;
this.Nombre = Nombre;

this.TotalRonda = Animal + Flor_Fruto + Pais + Color + Nombre;
}


}
