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
	//TESTS REGULARES
	public void test2() throws ExcepcionEjecucion, ExcepcionCoordenadaIncorrecta {
		TableroCeldasCuadradas t1=new TableroCeldasCuadradas(8,8);
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
}
