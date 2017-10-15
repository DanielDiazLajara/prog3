/**
 * @author Daniel Díaz Lajara 77634861V
 */
package modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
/**
 * La clase juego relaciona un tablero con varios patrones
 * y con una serie de reglas para llevar a cabo el juego
 * de la vida de Conway 
 */
public class Juego {
	/**
	 * El atributo reglaconway establece la regla que sigue el juego
	 */
	private ReglaConway regla;
	/**
	 * El tablero es sobre el que se aplica dicha regla
	 */
	private Tablero tablero;
	/**
	 * El atributo patrones usados almacena los patrones cargados sobre el tablero
	 */
	private List<Patron> patronesUsados=new ArrayList<Patron>();
	/**
	 * Constructor del Juego
	 * @param tab pasa un tablero para crear el juego
	 * @param regla pasa una reglaConway para crear el juego
	 */
	public Juego(Tablero tab, ReglaConway regla) {
		tablero=tab;
		this.regla=regla;
	}
	/**
	 * Intenta cargar un patron en el tablero y si puede, lo añade a patronesusados
	 * @param patron pasa un patrón para cargar sobre el tablero
	 * @param coord indica la celda superior izquierda en la que se cargará el tablero
	 */
	public void cargaPatron(Patron patron,Coordenada coord) {
		if(tablero.cargaPatron(patron,coord)) {
			patronesUsados.add(patron);
		}
		else
			System.out.println("Error cargando plantilla "+patron.getNombre()+" en "+coord.toString());
	}
	/**
	 * Actualiza todas las celdas del tablero siguiendo la regla de Conway
	 */
	public void actualiza() {
		Tablero tab= new Tablero(tablero.getDimensiones());
		Collection<Coordenada> coordenadas=tablero.getPosiciones();
		for(Coordenada coord:coordenadas) {
			tab.setCelda(coord, regla.calculaSiguienteEstadoCelda(tablero, coord));
		}
		for(Coordenada coord: coordenadas)
			tablero.setCelda(coord, tab.getCelda(coord));
	}
	/**
	 * getter de tablero
	 * @return devuelve el tablero del juego
	 */
	public Tablero getTablero() {
		return(tablero);
	}
	/**
	 * getter de patrones usados
	 * @return devuelve un arraylist con los patrones que se han usado
	 */
	public ArrayList<Patron> getPatrones(){
		ArrayList<Patron> patrones= new ArrayList<Patron>();
		for(Patron patron: patronesUsados) {
			patrones.add(patron);
		}
		return(patrones);	
	}
}
