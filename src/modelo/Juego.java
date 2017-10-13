package modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Juego {
	private ReglaConway regla;
	private Tablero tablero;
	private List<Patron> patronesUsados=new ArrayList<Patron>();
	public Juego(Tablero tab, ReglaConway regla) {
		tablero=tab;
		this.regla=regla;
	}
	public void cargaPatron(Patron patron,Coordenada coord) {
		if(tablero.cargaPatron(patron,coord)) {
			patronesUsados.add(patron);
		}
		else
			System.out.println("Error cargando plantilla "+patron.getNombre()+" en "+coord.toString());
	}
	public void actualiza() {
		Tablero tab= new Tablero(tablero.getDimensiones());
		Collection<Coordenada> coordenadas=tablero.getPosiciones();
		for(Coordenada coord:coordenadas) {
			tab.setCelda(coord, regla.calculaSiguienteEstado(tablero, coord));
		}
		for(Coordenada coord: coordenadas)
			tablero.setCelda(coord, tab.getCelda(coord));
	}
	public Tablero getTablero() {
		return(tablero);
	}
	public ArrayList<Patron> getPatrones(){
		ArrayList<Patron> patrones= new ArrayList<Patron>();
		for(Patron patron: patronesUsados) {
			patrones.add(patron);
		}
		return(patrones);	
	}
	
}
