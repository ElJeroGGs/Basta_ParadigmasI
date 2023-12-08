package controlador;

/**
 * Intefaz donde definimos los metodos a ejecutar despues de la llamada
 * a la inscripcion.
 */


public interface EstadoListener {
	public void setEstado(String edo);
}