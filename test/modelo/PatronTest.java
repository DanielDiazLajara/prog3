package modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class PatronTest {
	Patron patron=new Patron("hola",new Tablero(new Coordenada(2,3)));
	@Test
	public void test() {
		assertEquals(patron.getNombre(),"hola");
		System.out.println(patron.getPosiciones());
		assertEquals(patron.getCelda(new Coordenada(1,2)),EstadoCelda.MUERTA);
		assertEquals(patron.getCelda(new Coordenada(1,0)),EstadoCelda.MUERTA);
		assertEquals(patron.getCelda(new Coordenada(0,2)),EstadoCelda.MUERTA);
		assertEquals(patron.getCelda(new Coordenada(1,1)),EstadoCelda.MUERTA);
		assertEquals(patron.getCelda(new Coordenada(0,0)),EstadoCelda.MUERTA);
	}
}
