package modelo;

import java.io.File;

import org.junit.Test;

import entradasalida.ParserTableros;
import entradasalida.excepciones.ExcepcionGeneracion;
import entradasalida.excepciones.ExcepcionLectura;
import entradasalida.textoplano.GeneradorFicheroPlano;

public class P4TestGeneradorFicheroPlano {

	@Test
	public void test1() throws ExcepcionLectura {
		GeneradorFicheroPlano generator=new GeneradorFicheroPlano();
		Tablero tab;
			tab = ParserTableros.leeTablero("** *\n  **\n * *\n* **\n");
			//** *
			//  **
			// * *
			//* **
			int num=new Integer(20);
		Juego j=new Juego(tab,new ReglaConway());
		File f=new File("test1.txt");
		try {
			generator.generaFichero(f, j, num);
		} catch (ExcepcionGeneracion e) {
			e.printStackTrace();
		}
	}
	@Test
	public void test2() throws ExcepcionLectura {
		GeneradorFicheroPlano generator=new GeneradorFicheroPlano();
		Tablero tab;
			tab = ParserTableros.leeTablero("** * * ** ** * **");
			int num=new Integer(20);
		Juego j=new Juego(tab,new Regla30());
		File f=new File("test2.txt");
		try {
			generator.generaFichero(f, j, num);
		} catch (ExcepcionGeneracion e) {
			e.printStackTrace();
		}
	}
	@Test
	public void test3() throws ExcepcionLectura {
		GeneradorFicheroPlano generator=new GeneradorFicheroPlano();
		Tablero tab;
			tab = ParserTableros.leeTablero("** * * ** ** * **");
			int num=new Integer(-2); //EMITE ERROR
		Juego j=new Juego(tab,new Regla30());
		File f=new File("test2.txt");
		try {
			generator.generaFichero(f, j, num);
		} catch (ExcepcionGeneracion e) {
			e.printStackTrace();
		}
	}
}
