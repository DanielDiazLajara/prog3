/**
 * Daniel Díaz Lajara 77634861V
 */
package entradasalida.imagen;

import java.io.File;
import entradasalida.IGeneradorFichero;
import entradasalida.excepciones.ExcepcionGeneracion;
import gifs.ImagenGIF;
import modelo.Coordenada;
import modelo.Coordenada1D;
import modelo.EstadoCelda;
import modelo.Juego;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;
/**
 * Esta clase grabará en ficheros txt
 * las iteraciones de un juego en concreto
 * sea dicho juego 1D o 2D
 */
public class GeneradorGIFTablero1D implements IGeneradorFichero{
	/**
	 * Constructor
	 */
	public GeneradorGIFTablero1D() {}
	/**
	 * Esta función es la que grabará en el fichero el contenido deseado
	 * @param f es el fichero donde guardar el juego
	 * @param j es el juego a iterar y guardar
	 * @param num es el numero de veces a iterar el juego en cuestión
	 * @throws ExcepcionGeneracion cuando no pueda grabarse o iterarse bien
	 */
	public void generaFichero(File f, Juego j, int num) throws ExcepcionGeneracion {
		if (f==null||j==null)
			throw new ExcepcionArgumentosIncorrectos();
		else if(num<=0)
			throw new ExcepcionGeneracion("ERROR: numeros de iteraciones incorrecto");
		Coordenada c=j.getTablero().getDimensiones();
		int x=new Integer(((Coordenada1D) c).getX());
		ImagenGIF img=new ImagenGIF(x,num);
		for(int y=0;y<num;y++) {
			for(int i=0;i<x;i++) {
				try {
					if(j.getTablero().getCelda(new Coordenada1D(i))==EstadoCelda.VIVA)
						img.pintaCuadrado(i, y);
				} catch (ExcepcionArgumentosIncorrectos | ExcepcionPosicionFueraTablero
						| ExcepcionCoordenadaIncorrecta e) {
					throw new ExcepcionEjecucion(e);
				}
			}
			j.actualiza();
		}
		img.guardaFichero(f);
	}
}
