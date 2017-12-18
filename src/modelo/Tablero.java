/**
 * @author Daniel Díaz Lajara 77634861V
 */
package modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;
/**
 * Esta clase nos permite crear un tablero
 * que tiene dimensiones  y operar las 
 * diferentes celdas que allí se encuentran
 * @param <TipoCoordenada> coordenada tipo que pasamos
 *
 */
public abstract class Tablero<TipoCoordenada extends Coordenada> {
	/**
	 * celdas contiene un hashmap en el que cada celda tiene una TipoCoordenada y un estado
	 * 
	 */
	protected HashMap<TipoCoordenada,EstadoCelda> celdas= new HashMap<TipoCoordenada,EstadoCelda>();
	/**
	 * dimensiones contiene las dimensiones x*y del tablero
	 */
	protected TipoCoordenada dimensiones;
	/**
	 * Constructor por defecto que crea el tablero e inicializa sus celdas a MUERTA
	 * @param dimensiones pasa las medidas del tablero
	 * @throws ExcepcionArgumentosIncorrectos excepción argumentos
	 */
	protected Tablero(TipoCoordenada dimensiones) throws ExcepcionArgumentosIncorrectos{
		if(dimensiones==null)
			throw new ExcepcionArgumentosIncorrectos();
		this.dimensiones=dimensiones;
	}
	/**
	 * getter de dimensiones
	 * @return devuelve las dimensiones del tablero
	 */
	public TipoCoordenada getDimensiones() {
		return(dimensiones);
	}
	/**
	 * getter de las posiciones del tablero
	 * @return devuelve un collection con las coordenadas de las celdas
	 */
	public Collection<TipoCoordenada> getPosiciones(){
		Collection <TipoCoordenada> coordenadas = celdas.keySet();
		return(coordenadas);
	}
	
	/**
	 * getter del estado de una celda que se pasa por parámetros
	 * @param posicion celda de la que queremos saber el estado
	 * @return devuelve el estado de la celda posicion
	 * @throws ExcepcionPosicionFueraTablero excepción posición 
	 * @throws ExcepcionArgumentosIncorrectos excepción argumentos
	 */
	public EstadoCelda getCelda(TipoCoordenada posicion) throws ExcepcionPosicionFueraTablero, ExcepcionArgumentosIncorrectos{
		if(posicion==null)
			throw new ExcepcionArgumentosIncorrectos();
		EstadoCelda estado;
		Collection<TipoCoordenada> coordenadas=getPosiciones();
		if(coordenadas.contains(posicion)) {
			estado=celdas.get(posicion);
			return(estado);
		}
		else {
			throw new ExcepcionPosicionFueraTablero(dimensiones,posicion);
		}
	}
	/**
	 * Setter para cambiar el estado de una celda
	 * @param coord2 es la celda cuyo estado queremos cambiar
	 * @param e es el nuevo estado que queremos para la celda
	 * @throws ExcepcionArgumentosIncorrectos excepción argumentos
	 * @throws ExcepcionPosicionFueraTablero excepción posición
	 */
	public void setCelda(TipoCoordenada coord2,EstadoCelda e) throws ExcepcionArgumentosIncorrectos,ExcepcionPosicionFueraTablero{
		if(coord2==null||e==null)
			throw new ExcepcionArgumentosIncorrectos();
		Collection<TipoCoordenada> coordenadas=this.getPosiciones();
		if(coordenadas.contains(coord2)) {
			celdas.put(coord2,e);
		}
		else
			throw new ExcepcionPosicionFueraTablero(dimensiones,coord2);
		}
	/**
	 * devuelve un array con las posiciones alrededor de una celda dada,
	 * comenzando por la esquina superior izquierda y en sentido antihorario
	 * @param p celda cuyas vecinas queremos conocer
	 * @return devuelve un array con las celdas vecinas
	 * @throws ExcepcionPosicionFueraTablero excepción posición
	 * @throws ExcepcionEjecucion excepción ejecución 
	 * @throws ExcepcionArgumentosIncorrectos excepción argumentos
	 */
	public abstract ArrayList<TipoCoordenada> getPosicionesVecinasCCW (TipoCoordenada p)throws ExcepcionPosicionFueraTablero, ExcepcionArgumentosIncorrectos,ExcepcionEjecucion;
	/**
	 * Intenta cargar un patron a partir de una celda dada
	 * @param patron es el patron que quermos cargar en nuestro tablero
	 * @param coordinicial celda sobre la que queremos comenzar la carga del tablero
	 * @throws ExcepcionArgumentosIncorrectos excepción argumentos
	 * @throws ExcepcionPosicionFueraTablero excepción posición
	 * @throws ExcepcionEjecucion excepción ejecución
	 */
	public void cargaPatron(Patron<TipoCoordenada> patron, TipoCoordenada coordinicial) throws ExcepcionArgumentosIncorrectos,ExcepcionEjecucion,ExcepcionPosicionFueraTablero{
		if(patron==null||coordinicial==null)
			throw new ExcepcionArgumentosIncorrectos();
		try {
			boolean result=true;
			Collection<TipoCoordenada> coords_tablero=this.getPosiciones();
			Collection<TipoCoordenada> coords_patron=patron.getPosiciones();
			for(TipoCoordenada coord : coords_patron) {
			
					if(result==true&&!coords_tablero.contains(coord.suma(coordinicial))) {
						throw new ExcepcionPosicionFueraTablero(dimensiones,coord.suma(coordinicial));
					}
			}
			if(result) {
				for(TipoCoordenada i : coords_patron) {
					setCelda((TipoCoordenada)i.suma(coordinicial),patron.getCelda(i));
				}
			}
		}catch(ExcepcionCoordenadaIncorrecta e) {throw new ExcepcionEjecucion(e);}
	}
	/**
	 * Comprueba que las celdas estén en un tablero concreto
	 * @param posicion es la celda que queremos comprobar
	 * @return devuelve true si la celda se encuentra en el tablero y false si no
	 * @throws ExcepcionArgumentosIncorrectos excepción argumentos 
	 */
	public boolean contiene(TipoCoordenada posicion) throws ExcepcionArgumentosIncorrectos{
		if(posicion==null)
			throw new ExcepcionArgumentosIncorrectos();
		Collection<TipoCoordenada> coordenadas=getPosiciones();
		if(coordenadas.contains(posicion))
			return(true);
		else
			return(false);
	}
}
