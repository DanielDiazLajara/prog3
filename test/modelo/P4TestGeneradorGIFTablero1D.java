package modelo;

import java.io.File;

import org.junit.Test;

import entradasalida.ParserTableros;
import entradasalida.excepciones.ExcepcionGeneracion;
import entradasalida.excepciones.ExcepcionLectura;
import entradasalida.imagen.GeneradorGIFTablero1D;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;

public class P4TestGeneradorGIFTablero1D {

	@Test
	public void test() throws ExcepcionLectura {
		GeneradorGIFTablero1D genera=new GeneradorGIFTablero1D();
		Tablero tab;
		tab = ParserTableros.leeTablero("** * * ** ** * **");
		int num=new Integer(20);
		Juego j=new Juego(tab,new Regla30());
		File f=new File("testgif1.gif");
		try {
			genera.generaFichero(null, j, num);
		}catch(ExcepcionArgumentosIncorrectos e){
			System.out.println("ERROR: Argumentos incorrectos 1.");
		} catch (ExcepcionGeneracion e) {
			e.printStackTrace();
		}
		try {
			genera.generaFichero(f, null, num);
		}catch(ExcepcionArgumentosIncorrectos e){
			System.out.println("ERROR: Argumentos incorrectos 2.");
		} catch (ExcepcionGeneracion e) {
			e.printStackTrace();
		}
		try {
			genera.generaFichero(f, j, -3);
		}catch (ExcepcionGeneracion e) {
			e.printStackTrace();
		}
		try {
			genera.generaFichero(f, j, -0);
		}catch (ExcepcionGeneracion e) {
			e.printStackTrace();
		}
		try {
			genera.generaFichero(f, j, 100);
		}catch (ExcepcionGeneracion e) {
			e.printStackTrace();
		}
	}

}
