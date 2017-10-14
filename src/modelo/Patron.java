/**
 * @author Daniel Díaz Lajara 77634861V
 */
package modelo;

import java.util.Collection;
/**
 * La clase Patron nos ayuda a crear patrrones en forma de tableros
 * Estos patrones podrán ser añadidos a los tableros en el juego
 * siempre que quepan en el mismo
 */
public class Patron {
	/**
	 * El atributo nombre contiene el nombre del patrón
	 */
	private String nombre;
	/** 
	* El atributo tablero contiene el tablero de la clase
	*/
	Tablero tablero;
	/**
	 * Constructor de Patron
	 * @param nombre pasa un nombre al patrón
	 * @param tablero da un tablero al patrón
	 */
	public Patron(String nombre,Tablero tablero) {
		this.nombre=nombre;
		this.tablero=tablero;
	}
	/**
	 * getter para la clase Patron de nombre
	 * @return el nombre del patrón
	 */
	public String getNombre() {
		return(nombre);
	}
	/**
	 * Dada una coordenada del patrón devuelve el estado de la celda asignada
	 * @param coord coordenada de la que queremos saber el estado
	 * @return devuelve el estado de la celda con coordenada coord
	 */
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
	/**
	 * Devuelve las coordenadas de un tablero en un orden cualquiera
	 * @return un collection de coordenadas del tablero
	 */
	public Collection<Coordenada> getPosiciones(){
		Collection <Coordenada> coordenadas = tablero.getPosiciones();
		return(coordenadas);		
	}
	@Override
	/**
	 * toString de la clase Patrón, imprime el nombre y el tablero
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(nombre);
		s.append("\n");
		s.append(tablero.toString());
		return(s.toString());
		
	}
	
}
