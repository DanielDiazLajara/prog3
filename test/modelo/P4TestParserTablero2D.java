package modelo;

import org.junit.Test;

import entradasalida.excepciones.ExcepcionLectura;
import entradasalida.textoplano.ParserTablero2D;
import modelo.excepciones.ExcepcionEjecucion;

public class P4TestParserTablero2D {

	@Test
	public void test() {
		ParserTablero2D parser=new ParserTablero2D();
		String s1="***\n   \n***\n***\n   ";
		String s2="";
		String s3="***   \n   ***";
		String s4="* *\n   \n** \n** ";		
		String s5="* * \n   *\n**  \n**  \n";
		String s6="*\n*\n \n";
		try {
			TableroCeldasCuadradas tab2=(TableroCeldasCuadradas)parser.leeTablero(s1);
			System.out.println(tab2.toString());
		} catch (ExcepcionEjecucion | ExcepcionLectura e) {
			e.printStackTrace();
		}
		try {
			TableroCeldasCuadradas tab2=(TableroCeldasCuadradas)parser.leeTablero(s2);
			System.out.println(tab2.toString());
		} catch (ExcepcionEjecucion | ExcepcionLectura e) {
			e.printStackTrace();
		}
		try {
			TableroCeldasCuadradas tab2=(TableroCeldasCuadradas)parser.leeTablero(s3);
			System.out.println(tab2.toString());
		} catch (ExcepcionEjecucion | ExcepcionLectura e) {
			e.printStackTrace();
		}
		try {
			TableroCeldasCuadradas tab2=(TableroCeldasCuadradas)parser.leeTablero(s4);
			System.out.println(tab2.toString());
		} catch (ExcepcionEjecucion | ExcepcionLectura e) {
			e.printStackTrace();
		}
		try {
			TableroCeldasCuadradas tab2=(TableroCeldasCuadradas)parser.leeTablero(s5);
			System.out.println(tab2.toString());
		} catch (ExcepcionEjecucion | ExcepcionLectura e) {
			e.printStackTrace();
		}
		try {
			TableroCeldasCuadradas tab2=(TableroCeldasCuadradas)parser.leeTablero(s6);
			System.out.println(tab2.toString());
		} catch (ExcepcionEjecucion | ExcepcionLectura e) {
			e.printStackTrace();
		}
	}

}
