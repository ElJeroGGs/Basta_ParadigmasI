/*
INTEGRANTES
*
Alvarez Macedo Efren
Mercado Hernández José Eduardo
Espinoza Castañeda Yonathan
Espinosa Santana Angel David
*/
package modelo;

public interface BastaServer {

	public String getEstado();
	public String getLetra();
	public String postTirada(String usuario);
	public String registra(String j);	
	public void generarLetra();
}
