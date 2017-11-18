/**
 * @author Daniel Díaz Lajara 77634861V
 */
package entradasalida.excepciones;
/**
 * Suppres warnings 
 */
@SuppressWarnings("serial")
/**
 * Esta clase nos servirá para
 * errores relacionados con la
 * lectura de tableros en cadenas
 */
public class ExcepcionLectura extends Exception {
	/**
	 * Constructor por defecto de esta clase
	 */
	public ExcepcionLectura(){
		super();
	}
	/**
	 * Constructor de esta clase con string
	 * @param s string que pasamos
	 */
	public ExcepcionLectura(String s){
		super(s);
	}
	/**
	 * Constructor de esta clase con excepcion
	 * @param t excepcion que pasamos
	 */
	public ExcepcionLectura(Throwable t){
		super(t);
	}

}
