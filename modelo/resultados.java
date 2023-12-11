/*
INTEGRANTES
*
Alvarez Macedo Efren
Mercado Hernández José Eduardo
Espinoza Castañeda Yonathan
Espinosa Santana Angel David
*/
package modelo;

public class resultados {

private int Flor_Fruto;
private int Animal;
private int Pais;
private int Color;
private int Nombre;
private int TotalRonda;
private int TotalPartida ;

public resultados(int Flor_Fruto, int Animal, int Pais, int Color, int Nombre, int TotalPartida){
this.Animal = Animal;
this.Flor_Fruto = Flor_Fruto;
this.Pais = Pais;
this.Color = Color;
this.Nombre = Nombre;

this.TotalRonda = Animal + Flor_Fruto + Pais + Color + Nombre;

this.TotalPartida = TotalPartida + TotalRonda;
}

public int getAnimal(){
return Animal;
}

public int getFlor_Fruto(){
return Flor_Fruto;
}

public int getPais(){
return Pais;
}

public int getColor(){
return Color;
}

public int getNombre(){
return Nombre;
}

public int getTotalRonda(){
return TotalRonda;
}

public int getTotalPartida(){
return TotalPartida;
}

}
