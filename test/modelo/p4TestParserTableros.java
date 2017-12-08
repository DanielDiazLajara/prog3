package modelo;

import org.junit.Test;

import entradasalida.ParserTableros;
import entradasalida.excepciones.ExcepcionLectura;

public class p4TestParserTableros {

	@Test
	public void test() {
		String s1="";
		String s2="***   ***   ***   ***";
		String s3="**\n  \n**\n";
		String s4="******\n      ";

		try {
			Tablero t=ParserTableros.leeTablero(s1);
			System.out.println(t.toString());
		} catch (ExcepcionLectura e) {
			e.printStackTrace();
		}
		try {
			Tablero t=ParserTableros.leeTablero(s2);
			System.out.println(t.toString());
		} catch (ExcepcionLectura e) {
			e.printStackTrace();
		}
		try {
			Tablero t=ParserTableros.leeTablero(s3);
			System.out.println(t.toString());
		} catch (ExcepcionLectura e) {
			e.printStackTrace();
		}
		try {
			Tablero t=ParserTableros.leeTablero(s4);
			System.out.println(t.toString());
		} catch (ExcepcionLectura e) {
			e.printStackTrace();
		}
	}
}
