package entradasalida.imagen;

import java.io.File;

import entradasalida.IGeneradorFichero;
import entradasalida.excepciones.ExcepcionGeneracion;
import gifs.ImagenGIF;
import gifs.ImagenGIFAnimado;
import modelo.Coordenada;
import modelo.Coordenada2D;
import modelo.EstadoCelda;
import modelo.Juego;
import modelo.Tablero;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

public class GeneradorGifAnimadoTablero2D implements IGeneradorFichero{
	
	public GeneradorGifAnimadoTablero2D() {}
	
	public void generaFichero(File f, Juego j, int num) throws ExcepcionGeneracion {
		if(f==null|j==null)
			throw new ExcepcionArgumentosIncorrectos();
		else if(num<=0)
			throw new ExcepcionGeneracion("ERROR: número de iteraciones incorrecto");
		
		Tablero t=j.getTablero();
		Coordenada c=t.getDimensiones();
		Coordenada2D c2d=(Coordenada2D)c;
		int ancho=c2d.getX();
		int alto=c2d.getY();

		ImagenGIFAnimado gif=new ImagenGIFAnimado(100);
		for(int i=0;i<num;i++) {
			ImagenGIF fotograma=new ImagenGIF(ancho,alto);
			for(int x=0;x<ancho;x++) {
				for(int y=0;y<alto;y++) {
					try {
						if(t.getCelda(new Coordenada2D(x,y))==EstadoCelda.VIVA)
							fotograma.pintaCuadrado(x, y);
					} catch (ExcepcionArgumentosIncorrectos | ExcepcionPosicionFueraTablero
							| ExcepcionCoordenadaIncorrecta e) {
						throw new ExcepcionEjecucion(e);
					}	
				}
			}
			gif.addFotograma(fotograma);
			j.actualiza();
		}
		gif.guardaFichero(f);
	}

}
