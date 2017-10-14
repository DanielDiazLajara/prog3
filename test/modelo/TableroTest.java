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
	
	@Test
	public void test1(){
		Coordenada c=new Coordenada(2,2);
		Coordenada s=new Coordenada(1,1);
		Tablero tablero=new Tablero(c);
		EstadoCelda estado=EstadoCelda.VIVA;
		assertEquals("test",tablero.toString(),"+--+\n|  |\n|  |\n+--+\n");
		
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
		assertEquals("test",tablero.toString(),"+--+\n| *|\n| *|\n+--+\n");

		
		
	}
	
	
	
}
