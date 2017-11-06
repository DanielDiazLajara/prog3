/**
 * @author Daniel Díaz Lajara 77634861V
 */
package modelo;

import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
/**
 * Clase abstracta de tablero de 2 dimensiones
 * A partir de ella se crearan mediante herencia diferentes tipos
 * de tablero bidimensionales o de celdas cuadradas
 */
public abstract class Tablero2D extends Tablero{
	/**
	 * 
	 * @param ancho del tablero a crear
	 * @param alto del tablero bidimensional a crear
	 * @throws ExcepcionCoordenadaIncorrecta
	 */
	public Tablero2D(int ancho, int alto) throws ExcepcionCoordenadaIncorrecta{
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
