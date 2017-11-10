package modelo;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.Test;

public class TableroTest {
	
		EstadoCelda estado=EstadoCelda.VIVA;
		Coordenada c=new Coordenada(2,2);
		Coordenada s=new Coordenada(1,1);
		Tablero tablero=new Tablero(c);
		Tablero tab2=new Tablero(c);
		Patron patron=new Patron("hola",tablero);
	
	@Test
	public void test1(){
		Coordenada c=new Coordenada(2,2);
		Coordenada s=new Coordenada(1,1);
		Tablero tablero=new Tablero(c);
		EstadoCelda estado=EstadoCelda.VIVA;
		assertEquals("test",tablero.toString(),"+--+\n|  |\n|  |\n+--+");
		
	}
	
	@Test
	public void test2() {

		tablero.setCelda(s,estado);
		assertEquals("test2",tablero.getCelda(s),estado);
	}
	@Test
	public void test3() {
		tab2.setCelda(new Coordenada(1,1), estado);
		tab2.setCelda(new Coordenada(0,1), estado);
		Patron patron=new Patron("hola",tab2);
		tablero.cargaPatron(patron, new Coordenada(0,0));
		assertEquals("test",tablero.toString(),"+--+\n|  |\n|**|\n+--+");
		
	}
	@Test
	public void test4() {
		System.out.println(tablero.getPosiciones());
	}
	@Test
	public void test5() {
		assertEquals(tablero.getCelda(new Coordenada(0,0)),EstadoCelda.MUERTA);
		assertEquals(tablero.getCelda(new Coordenada(0,1)),EstadoCelda.MUERTA);
		assertEquals(tablero.getCelda(new Coordenada(1,0)),EstadoCelda.MUERTA);
		assertEquals(tablero.getCelda(new Coordenada(1,1)),EstadoCelda.MUERTA);
	}
	@Test
	public void test6() {
		Tablero hola=new Tablero(new Coordenada(8,7));
		System.out.println(hola.getPosicionesVecinasCCW(new Coordenada(0,0)));
		System.out.println(hola.getPosicionesVecinasCCW(new Coordenada(5,5)));
		System.out.println(hola.getPosicionesVecinasCCW(new Coordenada(7,5)));
		System.out.println(hola.getPosicionesVecinasCCW(new Coordenada(7,6)));	
	}
	@Test
	public void test7() {
		assertEquals(tablero.contiene(new Coordenada(1,1)),true);
		assertEquals(tablero.contiene(new Coordenada(2,1)),false);
	}
	@Test
	public void test8() {
		assertEquals(tablero.cargaPatron(patron, new Coordenada(0,0)),true);
		assertEquals(tablero.cargaPatron(patron, new Coordenada(1,0)),false);
	}
	
	
	
	
}
