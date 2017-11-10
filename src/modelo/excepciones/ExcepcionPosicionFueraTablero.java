/**
 * @author Daniel Díaz Lajara 77634861V
 */
package modelo.excepciones;
import modelo.Coordenada;

@SuppressWarnings("serial")
/**
 * Esta clase nos notificará
 * que una coordenada que intentamos 
 * manipular no está en el tablero
 */
public class ExcepcionPosicionFueraTablero extends Exception{
	/**
	 * dimensiones del tablero del error
	 */
	private Coordenada dimensiones;
	/**
	 * coordenada en que se produce el error
	 */
	private Coordenada coordenada;
	
	/**
	 * constructor por defecto
	 * @param d dimensiones
	 * @param c coordenada
	 */
	public ExcepcionPosicionFueraTablero(Coordenada d,Coordenada c) {
		super();
		dimensiones=d;
		coordenada=c;
	}
	/**
	 * tostring de la clase, muestra el error
	 */
	public String getMessage() {return("La coordenada "+coordenada.toString()+" no se encuentra en el tablero"+dimensiones.toString());}	
	/**
	 * getter de dimensiones
	 * @return dimensiones
	 */
	public Coordenada getDimensiones() {return(dimensiones);}
	/**
	 * getter de coordenada
	 * @return coordenada del error
	 */
	public Coordenada getCoordenada() {return(coordenada);}
}
