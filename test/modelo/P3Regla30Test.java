package modelo;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

public class P3Regla30Test {

	@Test
	public void test() throws ExcepcionArgumentosIncorrectos, ExcepcionCoordenadaIncorrecta, ExcepcionPosicionFueraTablero {
		Regla30 hola=new Regla30();
		Tablero1D tablero=new Tablero1D(9);
		tablero.setCelda(new Coordenada1D(0), EstadoCelda.VIVA);
		tablero.setCelda(new Coordenada1D(0), EstadoCelda.VIVA);
		assertEquals(hola.calculaSiguienteEstadoCelda(tablero, new Coordenada1D(0)),EstadoCelda.MUERTA);
		assertEquals(hola.calculaSiguienteEstadoCelda(tablero, new Coordenada1D(8)),EstadoCelda.MUERTA);
		tablero.setCelda(new Coordenada1D(0), EstadoCelda.VIVA);
		tablero.setCelda(new Coordenada1D(1), EstadoCelda.VIVA);
		tablero.setCelda(new Coordenada1D(2), EstadoCelda.VIVA);
		assertEquals(hola.calculaSiguienteEstadoCelda(tablero, new Coordenada1D(1)),EstadoCelda.MUERTA);
		tablero.setCelda(new Coordenada1D(0), EstadoCelda.VIVA);
		tablero.setCelda(new Coordenada1D(1), EstadoCelda.VIVA);
		tablero.setCelda(new Coordenada1D(2), EstadoCelda.MUERTA);
		assertEquals(hola.calculaSiguienteEstadoCelda(tablero, new Coordenada1D(1)),EstadoCelda.MUERTA);
		tablero.setCelda(new Coordenada1D(0), EstadoCelda.MUERTA);
		tablero.setCelda(new Coordenada1D(1), EstadoCelda.MUERTA);
		tablero.setCelda(new Coordenada1D(2), EstadoCelda.MUERTA);
		assertEquals(hola.calculaSiguienteEstadoCelda(tablero, new Coordenada1D(1)),EstadoCelda.MUERTA);
	}
}
