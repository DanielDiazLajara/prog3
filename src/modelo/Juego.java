package modelo;

import java.util.List;

public class Juego {
	private ReglaConway regla;
	private Tablero tablero;
	private List<Patron> patronesUsados;
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
	public void actualiza() {}
	public Tablero getTablero() {}
	public ArrayList<Patron> getPatrones(){}
	
}
