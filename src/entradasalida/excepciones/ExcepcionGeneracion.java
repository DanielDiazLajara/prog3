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
	ExcepcionGeneracion(){
		super();
	}
	/**
	 * Constructor de la clase con un string
	 * @param cadena string que pasamos
	 */
	ExcepcionGeneracion(String cadena){
		super(cadena);
	}
	/**
	 * Constructor de la clase con otra excepción
	 * @param t excepción que le pasamos
	 */
	ExcepcionGeneracion(Throwable t){
		super(t);
	}
}
