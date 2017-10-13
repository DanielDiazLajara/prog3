package modelo;

import java.util.Collection;

public class Patron {
	private String nombre;
	Tablero tablero;
	public Patron(String nombre,Tablero tablero) {
		this.nombre=nombre;
		this.tablero=tablero;
	}
	public String getNombre() {
		return(nombre);
	}
	public EstadoCelda getCelda(Coordenada coord) {
		Collection<Coordenada> coordenadas=tablero.getPosiciones();
		EstadoCelda estado;
		if(coordenadas.contains(coord)) {
			estado=tablero.getCelda(coord);
			return(estado);
		}
		else {
			System.out.println("Error: La celda "+coord.toString()+" no exite\n");
			return(null);
		}
	}
	public Collection<Coordenada> getPosiciones(){
		Collection <Coordenada> coordenadas = tablero.getPosiciones();
		return(coordenadas);		
	}
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(nombre);
		s.append("\n");
		s.append(tablero.toString());
		return(s.toString());
		
	}
	
}
