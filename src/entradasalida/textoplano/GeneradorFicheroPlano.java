/**
 * Daniel Díaz Lajara 77634861V
 */
package entradasalida.textoplano;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import entradasalida.IGeneradorFichero;
import entradasalida.excepciones.ExcepcionGeneracion;
import modelo.Imprimible;
import modelo.Juego;
import modelo.Tablero;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
/**
 * Genera un fichero txt donde
 * se escriben las iteraciones
 * de un juego concreto
 */
public class GeneradorFicheroPlano implements IGeneradorFichero{
	/**
	 * Constructor
	 */
	public GeneradorFicheroPlano() {}
	/**
	 * Sirve para generar el fichero txt dicho
	 * @param f archivo donde escribimos
	 * @param j juego a iterar
	 * @param num numero de iteraciones a hacer
	 * @throws ExcepcionGeneracion si no podemos escribir
	 */
	public void generaFichero(File f, Juego j, int num) throws ExcepcionGeneracion {
		if(f==null||j==null)
			throw new ExcepcionArgumentosIncorrectos();
		if(num<=0)
			throw new ExcepcionGeneracion("ERROR: num iteraciones incorrecto");
		for(int i=0;i<num;i++) {
			j.actualiza();
			Tablero tablero=j.getTablero();
			String cadena="";
			if(tablero instanceof Imprimible) {
				cadena=((Imprimible)tablero).generaCadena();
			}
			else
				throw new ExcepcionGeneracion("ERROR: El tablero del juego no es imprimible");
			PrintWriter pw;
			try {
				pw=new PrintWriter(new FileWriter(f,true));
			} catch (IOException e) {
				throw new ExcepcionGeneracion(e);
			}
			pw.println(cadena);
			pw.close();
		}
	}
}
