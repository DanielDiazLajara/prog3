package modelo;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;

public class P3Coordenada1DTest {

	@Test
	//TEST CONSTRUCTOR INT 
	public void test() {
		try {
			Coordenada1D c1=new Coordenada1D(1);
			System.out.println(c1.toString()+" creada correctamente.");
		} catch (ExcepcionCoordenadaIncorrecta e) {
			e.getMessage();
		}
		try {
			Coordenada1D c1=new Coordenada1D(0);
			System.out.println(c1.toString()+" creada correctamente.");
		} catch (ExcepcionCoordenadaIncorrecta e) {
			e.getMessage();
		}
		try {
			Coordenada1D c1=new Coordenada1D(80);
			System.out.println(c1.toString()+" creada correctamente.");
		} catch (ExcepcionCoordenadaIncorrecta e) {
			e.getMessage();
		}
		try {
			Coordenada1D c1=new Coordenada1D(-5);
			System.out.println(c1.toString()+" creada correctamente.");
		} catch (ExcepcionCoordenadaIncorrecta e) {
			System.out.println(e.getMessage());
		}
	}
	@Test 
	//TEST CONSTRUCTOR DE COPIA
	public void test1() throws ExcepcionCoordenadaIncorrecta {
		Coordenada1D c1=new Coordenada1D(70);
		System.out.println(c1.toString()+" creada correctamente.");
		Coordenada1D c2=new Coordenada1D(c1);
		System.out.println(c2.toString()+" creada correctamente.");
		Coordenada1D c3=new Coordenada1D(null);
		System.out.println(c3.toString()+" creada correctamente.");
	}
	@Test
	//TEST SUMA
	public void test2() throws ExcepcionCoordenadaIncorrecta {
		Coordenada1D c1=new Coordenada1D(70);
		System.out.println(c1.toString()+" creada correctamente.");
		Coordenada1D c2=new Coordenada1D(20);
		System.out.println(c2.toString()+" creada correctamente.");
		Coordenada1D c3=new Coordenada1D(c1.suma(c2));
		System.out.println(c1.toString()+"+"+c2.toString()+"="+c3.toString());
		Coordenada1D c4=new Coordenada1D(c1.suma(null));
		System.out.println(c1.toString()+"+"+c2.toString()+"="+c3.toString());
	}
}
