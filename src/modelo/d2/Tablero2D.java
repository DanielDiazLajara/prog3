/**
 * @author Daniel Díaz Lajara 77634861V
 */
package modelo.d2;

import modelo.EstadoCelda;
import modelo.Tablero;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
/**
 * Clase abstracta de tablero de 2 dimensiones
 * A partir de ella se crearan mediante herencia diferentes tipos
 * de tablero bidimensionales o de celdas cuadradas
 */
public abstract class Tablero2D extends Tablero<Coordenada2D>{
	/**
	 * 
	 * @param ancho del tablero a crear
	 * @param alto del tablero bidimensional a crear
	 * @throws ExcepcionCoordenadaIncorrecta excepción coordenada
	 * @throws ExcepcionEjecucion excepción ejecución
	 */
	public Tablero2D(int ancho, int alto) throws ExcepcionCoordenadaIncorrecta, ExcepcionEjecucion{
		super(new Coordenada2D(ancho,alto));
		Coordenada2D dimensiones=new Coordenada2D(ancho,alto);
		for(int i=0;i<dimensiones.getX();i++) {
			for(int j=0;j<dimensiones.getY();j++) {
				try {
					celdas.put(new Coordenada2D(i,j),
					       EstadoCelda.MUERTA);
				}catch (ExcepcionCoordenadaIncorrecta e) {
					throw new ExcepcionEjecucion(e);
				}
			}
		}	
	}
}
