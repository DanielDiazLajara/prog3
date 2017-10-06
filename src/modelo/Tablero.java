/**
 * @author Daniel Díaz Lajara
 */
package modelo;

import java.util.Collection;
import java.util.HashMap;

public class Tablero {
	private HashMap<Coordenada,EstadoCelda> celdas;
	private Coordenada dimensiones;
	//private hasmap
	
	public Tablero(Coordenada dimensiones) {
		this.dimensiones=dimensiones;
		for(int i=0;i<this.dimensiones.getX();i++) {
			for(int j=0;j<this.dimensiones.getY();j++) {
				celdas.put(new Coordenada(i,j),
						       EstadoCelda.MUERTA);
			}
		}
	}
	public Coordenada getDimensiones() {
		return(dimensiones);
	}
	public Collection<Coordenada> getPosiciones(){
		Collection<Coordenada> coleccion;
		Collection<Coordenada> coordenadas=celdas.keySet();
		for(Coordenada coord:coordenadas) {
			coleccion.add(new Coordenada(coord));
		}
		return(coleccion);
		
		
	}
	
	
	
}
