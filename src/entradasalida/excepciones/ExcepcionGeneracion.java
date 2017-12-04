/**
 * @author Daniel Díaz Lajara 77634861V
 */
package entradasalida.excepciones;
/**
 * suppres warning
 */
@SuppressWarnings("serial")
/**
 * Esta clase nos servirá para 
 * errores en la generación de
 * ciertos archivos
 */
public class ExcepcionGeneracion extends Exception {
	/**
	 * Constructor de la clase por defecto
	 */
	public ExcepcionGeneracion(){
		super();
	}
	/**
	 * Constructor de la clase con un string
	 * @param cadena string que pasamos
	 */
	public ExcepcionGeneracion(String cadena){
		super(cadena);
	}
	/**
	 * Constructor de la clase con otra excepción
	 * @param t excepción que le pasamos
	 */
	public ExcepcionGeneracion(Throwable t){
		super(t);
	}
}
