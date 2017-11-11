package modelo;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

public class P3TableroCeldasCuadradasTest {

	@Test
	//TEST CONSTRUCTOR
	public void test() {
		try {
			TableroCeldasCuadradas t1=new TableroCeldasCuadradas(1,2);
		} catch (ExcepcionCoordenadaIncorrecta e) {
			System.out.println(e.getMessage());
		}
		try {
			TableroCeldasCuadradas t1=new TableroCeldasCuadradas(0,0);
		} catch (ExcepcionCoordenadaIncorrecta e) {
			System.out.println(e.getMessage());
		}
		try {
			TableroCeldasCuadradas t1=new TableroCeldasCuadradas(3,-1);
		} catch (ExcepcionCoordenadaIncorrecta e) {
			System.out.println(e.getMessage());
		}	
	}
	@Test
	//TESTS REGULARES, GETCELDA, SETCELDA, GET DIMENSIONES
	public void test2() throws ExcepcionEjecucion, ExcepcionCoordenadaIncorrecta {
		TableroCeldasCuadradas t1=new TableroCeldasCuadradas(8,8);
		assertEquals(t1.celdas.size(),64);
		assertEquals(t1.getDimensiones(),new Coordenada2D(8,8));
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				try {
					assertEquals(t1.getCelda(new Coordenada2D(i,j)),EstadoCelda.MUERTA);
				} catch (ExcepcionPosicionFueraTablero e) {
					System.out.println("Error, celdas fuera");
				}
			}
		}
		try {
			t1.setCelda(new Coordenada2D(3,3), EstadoCelda.VIVA);
			assertEquals(t1.getCelda(new Coordenada2D(3,3)),EstadoCelda.VIVA);
		} catch (ExcepcionPosicionFueraTablero e) {
			System.out.println("Error, celdas fuera");
		}
		try {
			t1.getCelda(new Coordenada2D(100,7));
		} catch (ExcepcionPosicionFueraTablero e) {
			System.out.println(e.getMessage());	}
		try {
			t1.setCelda(new Coordenada2D(100,100),EstadoCelda.VIVA);
		} catch (ExcepcionPosicionFueraTablero e) {
			System.out.println(e.getMessage());	}
	}
	@Test
	//GET POSICIONES VECINAS
	public void test6() throws ExcepcionEjecucion, ExcepcionCoordenadaIncorrecta {
		TableroCeldasCuadradas hola;
		hola = new TableroCeldasCuadradas(8,7);
		try {
			System.out.println(hola.getPosicionesVecinasCCW(new Coordenada2D(8,0)));
		} catch (ExcepcionPosicionFueraTablero e) {
			System.out.println(e.getMessage());
		}
		try {
			System.out.println(hola.getPosicionesVecinasCCW(new Coordenada2D(0,0)));
		} catch (ExcepcionPosicionFueraTablero e) {
			System.out.println(e.getMessage());
		}
		try {
			System.out.println(hola.getPosicionesVecinasCCW(new Coordenada2D(7,5)));
		} catch (ExcepcionPosicionFueraTablero e) {
			System.out.println(e.getMessage());
		}
		try {
			System.out.println(hola.getPosicionesVecinasCCW(new Coordenada2D(3,3)));
		} catch (ExcepcionPosicionFueraTablero e) {
			System.out.println(e.getMessage());
		}	
	}
	@Test
	//TEST CONTIENE
	public void test7() throws ExcepcionEjecucion, ExcepcionCoordenadaIncorrecta {
		TableroCeldasCuadradas t1=new TableroCeldasCuadradas(7,6);
		assertEquals(t1.contiene(new Coordenada2D(7,6)), false);
		assertEquals(t1.contiene(new Coordenada2D(7,0)), false);
		assertEquals(t1.contiene(new Coordenada2D(0,6)), false);
		assertEquals(t1.contiene(new Coordenada2D(2,2)), true);
		assertEquals(t1.contiene(new Coordenada2D(6,5)), true);
		
	}
	@Test
	//TEST CARGAPATRÓN
	public void test8() throws ExcepcionEjecucion, ExcepcionCoordenadaIncorrecta {
		TableroCeldasCuadradas t2=new TableroCeldasCuadradas(9,10);
		TableroCeldasCuadradas t3=new TableroCeldasCuadradas(3,3);
		Patron hola=new Patron("hola",t3);

		try {
			t2.cargaPatron(hola, new Coordenada2D(0,0));
		} catch (ExcepcionPosicionFueraTablero e) {
			System.out.println(e.getMessage());
		}
		try {
			t2.cargaPatron(hola, new Coordenada2D(7,7));
		} catch (ExcepcionPosicionFueraTablero e) {
			System.out.println(e.getMessage());
		}
		try {
			t2.cargaPatron(hola, new Coordenada2D(5,6));
		} catch (ExcepcionPosicionFueraTablero e) {
			System.out.println(e.getMessage());
		}
	}
}
