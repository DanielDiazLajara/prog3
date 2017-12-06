package entradasalida.imagen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

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

public class GeneradorGIFTablero1D implements IGeneradorFichero{
	
	public GeneradorGIFTablero1D() {}
	
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
		PrintWriter pw;
		try {
			pw=new PrintWriter(f);
		
			pw.println(img);
			//CUIDADO
			pw.close();
		} catch (FileNotFoundException e) {
			throw new ExcepcionEjecucion(e);
		}
	}
}
