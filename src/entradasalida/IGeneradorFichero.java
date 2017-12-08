/**
 * @author Daniel Díaz Lajara 77634861V
 */
package entradasalida;

import java.io.File;
import entradasalida.excepciones.ExcepcionGeneracion;
import modelo.Juego;
/**
 * Esta interfaz será implementada por 
 * aquellas clases que se encarguen de
 * generar ficheros txt o gifs
 */
public interface IGeneradorFichero {
	/**
	 * Este procedimiento genera ficheros txt y gif
	 * @param f es el archivo donde guardar el juego iterado
	 * @param j es el juego que queremos grabar en archivo
	 * @param num es el número de veces a iterar el juego
	 * @throws ExcepcionGeneracion cuando no es posible realizar la generación
	 */
	public void generaFichero (File f,Juego j,int num) throws ExcepcionGeneracion;
}
