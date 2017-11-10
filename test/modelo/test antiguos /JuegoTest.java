package modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class JuegoTest {
	
	

	@Test
	public void test() {
		Tablero tablero=new Tablero(new Coordenada(3,3));
		ReglaConway regla=new ReglaConway();
		tablero.setCelda(new Coordenada(0,2), EstadoCelda.VIVA);
		tablero.setCelda(new Coordenada(0,1), EstadoCelda.VIVA);
		tablero.setCelda(new Coordenada(1,2), EstadoCelda.VIVA);
		Juego juego = new Juego(tablero,regla);
		Patron hola=new Patron("hola",tablero);
		juego.cargaPatron(hola, new Coordenada(2,2));
		juego.cargaPatron(hola, new Coordenada(2,2));
		assertEquals(tablero.toString(),"+---+\n|   |\n|*  |\n|** |\n+---+");
		juego.actualiza();
		assertEquals(tablero.toString(),"+---+\n|   |\n|** |\n|** |\n+---+");
		juego.actualiza();
		assertEquals(tablero.toString(),"+---+\n|   |\n|** |\n|** |\n+---+");
		juego.actualiza();
		assertEquals(tablero.toString(),"+---+\n|   |\n|** |\n|** |\n+---+");
	}
}
