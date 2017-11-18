/**
 * @author Daniel Díaz Lajara 77634861V
 */
package entradasalida;

import entradasalida.excepciones.ExcepcionLectura;
import modelo.Tablero;
import modelo.excepciones.ExcepcionEjecucion;
/**
 * Interfaz que usaremos para leer tableros
 * 
 */
public interface IParserTablero {
	/**
	 * método para lleer tableros 
	 * @param s string que leemos
	 * @return tablero leido
	 * @throws ExcepcionLectura 
	 * @throws ExcepcionEjecucion 
	 */
	public Tablero leeTablero(String s) throws ExcepcionEjecucion, ExcepcionLectura;
}
