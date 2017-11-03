package modelo;

import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;

public abstract class Tablero2D extends Tablero{
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
