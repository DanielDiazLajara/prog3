/**
 * @author Daniel Díaz Lajara 77634861V
 */
package modelo.excepciones;
/**warning suprimido
 */
@SuppressWarnings("serial")
/**
 * Esta clase se usará
 * cuando los argumentos pasados
 * a funciones o módulos sean null
 */
public class ExcepcionArgumentosIncorrectos extends ExcepcionEjecucion{
	/**
	 * constructor por defecto
	 */
	public ExcepcionArgumentosIncorrectos(){
		super("Error argumentos incorrectos");
	}
}
