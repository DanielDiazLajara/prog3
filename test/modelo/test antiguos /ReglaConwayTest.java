package modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReglaConwayTest {
	ReglaConway regla=new ReglaConway();
	
	@Test
	public void test() {
		Tablero tablero=new Tablero(new Coordenada(4,5));
		tablero.setCelda(new Coordenada(0,0),EstadoCelda.VIVA);
		tablero.setCelda(new Coordenada(1,0),EstadoCelda.VIVA);
		tablero.setCelda(new Coordenada(2,1),EstadoCelda.VIVA);
		tablero.setCelda(new Coordenada(1,2),EstadoCelda.VIVA);
		tablero.setCelda(new Coordenada(3,2),EstadoCelda.VIVA);
		tablero.setCelda(new Coordenada(3,3),EstadoCelda.VIVA);
		tablero.setCelda(new Coordenada(2,4),EstadoCelda.VIVA);
		assertEquals(regla.calculaSiguienteEstadoCelda(tablero,new Coordenada(0,0)),EstadoCelda.MUERTA);
		assertEquals(regla.calculaSiguienteEstadoCelda(tablero,new Coordenada(1,0)),EstadoCelda.VIVA);
		assertEquals(regla.calculaSiguienteEstadoCelda(tablero,new Coordenada(2,0)),EstadoCelda.MUERTA);
		assertEquals(regla.calculaSiguienteEstadoCelda(tablero,new Coordenada(3,0)),EstadoCelda.MUERTA);
		assertEquals(regla.calculaSiguienteEstadoCelda(tablero,new Coordenada(1,1)),EstadoCelda.MUERTA);
		assertEquals(regla.calculaSiguienteEstadoCelda(tablero,new Coordenada(1,2)),EstadoCelda.MUERTA);
		assertEquals(regla.calculaSiguienteEstadoCelda(tablero,new Coordenada(1,3)),EstadoCelda.MUERTA);
		assertEquals(regla.calculaSiguienteEstadoCelda(tablero,new Coordenada(1,4)),EstadoCelda.MUERTA);
		assertEquals(regla.calculaSiguienteEstadoCelda(tablero,new Coordenada(2,1)),EstadoCelda.VIVA);
		assertEquals(regla.calculaSiguienteEstadoCelda(tablero,new Coordenada(2,2)),EstadoCelda.MUERTA);
		assertEquals(regla.calculaSiguienteEstadoCelda(tablero,new Coordenada(2,3)),EstadoCelda.MUERTA);
		assertEquals(regla.calculaSiguienteEstadoCelda(tablero,new Coordenada(2,4)),EstadoCelda.MUERTA);
		assertEquals(regla.calculaSiguienteEstadoCelda(tablero,new Coordenada(3,1)),EstadoCelda.MUERTA);
		assertEquals(regla.calculaSiguienteEstadoCelda(tablero,new Coordenada(3,2)),EstadoCelda.VIVA);
		assertEquals(regla.calculaSiguienteEstadoCelda(tablero,new Coordenada(3,3)),EstadoCelda.VIVA);
		assertEquals(regla.calculaSiguienteEstadoCelda(tablero,new Coordenada(0,1)),EstadoCelda.VIVA);
		assertEquals(regla.calculaSiguienteEstadoCelda(tablero,new Coordenada(0,2)),EstadoCelda.MUERTA);
		assertEquals(regla.calculaSiguienteEstadoCelda(tablero,new Coordenada(0,3)),EstadoCelda.MUERTA);
		assertEquals(regla.calculaSiguienteEstadoCelda(tablero,new Coordenada(0,4)),EstadoCelda.MUERTA);
	}
}
