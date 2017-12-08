package modelo;

import org.junit.Test;

import entradasalida.Factory;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;

public class P4TestFactory {

	@Test
	public void test1() {
		try {
			Regla regla= Factory.creaRegla(new TableroCeldasCuadradas(2,3));
			if(regla instanceof ReglaConway)
				System.out.println("PRUEBA CORRECTA");
		} catch (ExcepcionEjecucion | ExcepcionCoordenadaIncorrecta e) {
			e.printStackTrace();
		}
		try {
			Regla regla= Factory.creaRegla(new Tablero1D(3));
			if(regla instanceof Regla30)
				System.out.println("PRUEBA CORRECTA");
		} catch (ExcepcionEjecucion | ExcepcionCoordenadaIncorrecta e) {
			e.printStackTrace();
		}
	}
	@Test
	public void test() throws ExcepcionArgumentosIncorrectos, ExcepcionCoordenadaIncorrecta {
	Tablero t=Factory.creaTablero(new Coordenada2D(2,2));
	if (t instanceof TableroCeldasCuadradas)
		System.out.println("PRUEBA CORRECTA\n"+t);
	
	Tablero t22=Factory.creaTablero(new Coordenada1D(2));
	if (t22 instanceof Tablero1D)
		System.out.println("PRUEBA CORRECTA\n"+t22);
	
	
	
	}

}
