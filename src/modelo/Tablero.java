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
	
	public Tablero(Coordenada dimensiones){
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
		Collection <Coordenada> coordenadas = celdas.keySet();
		return(coordenadas);
	}
	private void muestraErrorPosicionInvalida(Coordenada c){
		System.out.println("Error: La celda "+c.toString()+" no exite\n");
	}
	public EstadoCelda getCelda(Coordenada posicion) {
		Collection<Coordenada> coordenadas=this.getPosiciones();
		EstadoCelda estado;
		if(coordenadas.contains(posicion)) {
			estado=celdas.get(posicion);
			return(estado);
		}
		else {
			muestraErrorPosicionInvalida(posicion);
			return(null);
		}
	}
	public void setCelda(Coordenada posicion,EstadoCelda e) {
		Collection<Coordenada> coordenadas=this.getPosiciones();
		if(coordenadas.contains(posicion)) {
			celdas.put(new Coordenada(posicion),e);
		}
		else
			muestraErrorPosicionInvalida(posicion);
	}
	
}
