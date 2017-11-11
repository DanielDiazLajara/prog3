package modelo;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

public class P3Tablero1DTest {

	@Test
	//TEST CONSTRUCTOR
	public void test() {
		try {
			Tablero1D t1=new Tablero1D(1);
		} catch (ExcepcionCoordenadaIncorrecta e) {
			System.out.println(e.getMessage());
		}
		try {
			Tablero1D t1=new Tablero1D(0);
		} catch (ExcepcionCoordenadaIncorrecta e) {
			System.out.println(e.getMessage());
		}
		try {
			Tablero1D t1=new Tablero1D(-1);
		} catch (ExcepcionCoordenadaIncorrecta e) {
			System.out.println(e.getMessage());
		}	
	}
	@Test
	//TESTS REGULARES, GETCELDA, SETCELDA, GET DIMENSIONES
	public void test2() throws ExcepcionEjecucion, ExcepcionCoordenadaIncorrecta {
		Tablero1D t1=new Tablero1D(8);
		assertEquals(t1.celdas.size(),8);
		assertEquals(t1.getDimensiones(),new Coordenada1D(8));
		for(int i=0;i<8;i++) {
				try {
					assertEquals(t1.getCelda(new Coordenada1D(i)),EstadoCelda.MUERTA);
				} catch (ExcepcionPosicionFueraTablero e) {
					System.out.println("Error, celdas fuera");
				}
		}
		try {
			t1.setCelda(new Coordenada1D(3), EstadoCelda.VIVA);
			assertEquals(t1.getCelda(new Coordenada1D(3)),EstadoCelda.VIVA);
		} catch (ExcepcionPosicionFueraTablero e) {
			System.out.println("Error, celdas fuera");
		}
		try {
			t1.getCelda(new Coordenada1D(100));
		} catch (ExcepcionPosicionFueraTablero e) {
			System.out.println(e.getMessage());	}
		try {
			t1.setCelda(new Coordenada1D(8),EstadoCelda.VIVA);
		} catch (ExcepcionPosicionFueraTablero e) {
			System.out.println(e.getMessage());	}
	}
	@Test
	//GET POSICIONES VECINAS
	public void test6() throws ExcepcionEjecucion, ExcepcionCoordenadaIncorrecta {
		Tablero1D hola;
		hola = new Tablero1D(8);
		try {
			System.out.println(hola.getPosicionesVecinasCCW(new Coordenada1D(8)));
		} catch (ExcepcionPosicionFueraTablero e) {
			System.out.println(e.getMessage());
		}
		try {
			System.out.println(hola.getPosicionesVecinasCCW(new Coordenada1D(0)));
		} catch (ExcepcionPosicionFueraTablero e) {
			System.out.println(e.getMessage());
		}
		try {
			System.out.println(hola.getPosicionesVecinasCCW(new Coordenada1D(7)));
		} catch (ExcepcionPosicionFueraTablero e) {
			System.out.println(e.getMessage());
		}
		try {
			System.out.println(hola.getPosicionesVecinasCCW(new Coordenada1D(3)));
		} catch (ExcepcionPosicionFueraTablero e) {
			System.out.println(e.getMessage());
		}	
	}
	@Test
	//TEST CONTIENE
	public void test7() throws ExcepcionEjecucion, ExcepcionCoordenadaIncorrecta {
		Tablero1D t1=new Tablero1D(7);
		assertEquals(t1.contiene(new Coordenada1D(4)), true);
		assertEquals(t1.contiene(new Coordenada1D(7)), false);
		assertEquals(t1.contiene(new Coordenada1D(0)), true);
		assertEquals(t1.contiene(new Coordenada1D(2)), true);
		assertEquals(t1.contiene(new Coordenada1D(6)), true);
	
	}
	@Test
	//TEST CARGAPATRÓN
	public void test8() throws ExcepcionEjecucion, ExcepcionCoordenadaIncorrecta {
		Tablero1D t2=new Tablero1D(9);
		Tablero1D t3=new Tablero1D(3);
		Patron hola=new Patron("hola",t3);

		try {
			t2.cargaPatron(hola, new Coordenada1D(0));
		} catch (ExcepcionPosicionFueraTablero e) {
			System.out.println(e.getMessage());
		}
		try {
			t2.cargaPatron(hola, new Coordenada1D(9));
		} catch (ExcepcionPosicionFueraTablero e) {
			System.out.println(e.getMessage());
		}
		try {
			t2.cargaPatron(hola, new Coordenada1D(7));
		} catch (ExcepcionPosicionFueraTablero e) {
			System.out.println(e.getMessage());
		}
	}		
}
