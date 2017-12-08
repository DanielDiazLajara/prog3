package modelo;

import org.junit.Test;

import entradasalida.excepciones.ExcepcionLectura;
import entradasalida.textoplano.ParserTablero1D;
import modelo.excepciones.ExcepcionEjecucion;

public class P4TestParserTablero1D {

	@Test
	public void test() {
		ParserTablero1D parser=new ParserTablero1D();
		try {
			Tablero1D tab1=(Tablero1D) parser.leeTablero("***   ***   ***");
			System.out.println(tab1.toString());
		} catch (ExcepcionEjecucion | ExcepcionLectura e) {
			e.printStackTrace();
		}
		try {
			Tablero1D tab1=(Tablero1D) parser.leeTablero("**a   ***   ***");
			System.out.println(tab1.toString());
		} catch (ExcepcionEjecucion | ExcepcionLectura e) {
			e.printStackTrace();
		}
		try {
			Tablero1D tab1=(Tablero1D) parser.leeTablero("***  \n ***   ***");
			System.out.println(tab1.toString());
		} catch (ExcepcionEjecucion | ExcepcionLectura e) {
			e.printStackTrace();
		}
		try {
			Tablero1D tab1=(Tablero1D) parser.leeTablero("");
			System.out.println(tab1.toString());
		} catch (ExcepcionEjecucion | ExcepcionLectura e) {
			e.printStackTrace();
		}
	}
}
