/**
 * @author Daniel Díaz Lajara 77634861V
 */
package modelo;

import java.util.ArrayList;
import java.util.Collection;

import modelo.d1.Coordenada1D;
import modelo.d1.Tablero1D;
import modelo.d2.Coordenada2D;
import modelo.d2.TableroCeldasCuadradas;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;
/**
 * La clase juego relaciona un tablero con varios patrones
 * y con una serie de reglas para llevar a cabo el juego
 * de la vida de Conway 
 * @param <TipoCoordenada> tipo coordenada que pasamos
 */
public class Juego<TipoCoordenada extends Coordenada> {
	/**
	 * El atributo reglaconway establece la regla que sigue el juego
	 */
	private Regla<TipoCoordenada> regla;
	/**
	 * El tablero es sobre el que se aplica dicha regla
	 */
	private Tablero<TipoCoordenada> tablero;
	/**
	 * El atributo patrones usados almacena los patrones cargados sobre el tablero
	 */
	private ArrayList<Patron<TipoCoordenada>> patronesUsados=new ArrayList<Patron<TipoCoordenada>>();
	/**
	 * Constructor del Juego
	 * @param tab pasa un tablero para crear el juego
	 * @param regla pasa una reglaConway para crear el juego
	 * @throws ExcepcionArgumentosIncorrectos excepción argumentos
	 */
	public Juego(Tablero<TipoCoordenada> tab, Regla<TipoCoordenada> regla) throws ExcepcionArgumentosIncorrectos{
		if(tab==null||regla==null)
			throw new ExcepcionArgumentosIncorrectos();
		tablero=tab;
		this.regla=regla;
	}
	/**
	 * Intenta cargar un patron en el tablero y si puede, lo añade a patronesusados
	 * @param patron pasa un patrón para cargar sobre el tablero
	 * @param coord indica la celda superior izquierda en la que se cargará el tablero
	 * @throws ExcepcionArgumentosIncorrectos excepción argumentos
	 * @throws ExcepcionEjecucion excepción ejecución
	 * @throws ExcepcionPosicionFueraTablero excepción posición 
	 */
	public void cargaPatron(Patron<TipoCoordenada> patron,TipoCoordenada coord) throws ExcepcionArgumentosIncorrectos,ExcepcionEjecucion,ExcepcionPosicionFueraTablero{
		if(patron==null||coord==null)
			throw new ExcepcionArgumentosIncorrectos();
		tablero.cargaPatron(patron,coord);
		this.patronesUsados.add(patron);
	}
	
	/**
	 * Actualiza todas las celdas del tablero siguiendo la regla de Conway
	 * @throws ExcepcionEjecucion excepción ejecución 
	 */
	public void actualiza() {
		try {
			if(tablero instanceof TableroCeldasCuadradas) {
				Coordenada2D coord=new Coordenada2D((Coordenada2D)tablero.getDimensiones());
				TableroCeldasCuadradas tab= new TableroCeldasCuadradas(coord.getX(),coord.getY());
				Collection<TipoCoordenada> coordenadas=tablero.getPosiciones();
			
				for(TipoCoordenada coord2:coordenadas) {
					tab.setCelda((Coordenada2D)coord2, regla.calculaSiguienteEstadoCelda(tablero, coord2));
				}
				for(TipoCoordenada coord2: coordenadas)
					tablero.setCelda(coord2, tab.getCelda((Coordenada2D)coord2));
			}else if(tablero instanceof Tablero1D) {
				Coordenada1D coord=new Coordenada1D((Coordenada1D)tablero.getDimensiones());
				Tablero1D tab= new Tablero1D(coord.getX());
				Collection<TipoCoordenada> coordenadas=tablero.getPosiciones();
			
				for(TipoCoordenada coord2:coordenadas) {
					tab.setCelda((Coordenada1D)coord2, regla.calculaSiguienteEstadoCelda(tablero, coord2));
				}
				for(TipoCoordenada coord2: coordenadas)
					tablero.setCelda(coord2, tab.getCelda((Coordenada1D)coord2));
				
				
				
			}
		}catch(ExcepcionPosicionFueraTablero | ExcepcionCoordenadaIncorrecta e) {
			throw new ExcepcionEjecucion(e);}
	}
	/**
	 * getter de tablero
	 * @return devuelve el tablero del juego
	 */
	public Tablero<TipoCoordenada> getTablero() {
		return(tablero);
	}
	/**
	 * getter de patrones usados
	 * @return devuelve un arraylist con los patrones que se han usado
	 */
	public ArrayList<Patron<TipoCoordenada>> getPatrones(){
		return(patronesUsados);	
	}
}
