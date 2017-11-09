/**
 * @author Daniel Díaz Lajara 77634861V
 */
package modelo.excepciones;

@SuppressWarnings("serial")
/**
 * Esta clase nos notificará
 * errores de ejecución en el programa
 * por fallos en programación
 */
public class ExcepcionEjecucion extends RuntimeException{

	/**
	 * constructor mediante string
	 * @param mensaje a mostrar
	 */
	public ExcepcionEjecucion(String mensaje){
		super(mensaje);
	}
	/**
	 * constructor mediante excepcion relanzada
	 * @param causa es la excepción a relanzar
	 */
	public ExcepcionEjecucion(Throwable causa){
		super(causa);
	}
}
