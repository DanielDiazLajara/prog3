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
 * que tiene dimensiones x*y y operar las 
 * diferentes celdas que allí se encuentran
 *
 */
public class Tablero {
	/**
	 * celdas contiene un hashmap en el que cada celda tiene una coordenada y un estado
	 * 
	 */
	private HashMap<Coordenada,EstadoCelda> celdas= new HashMap<Coordenada,EstadoCelda>();
	/**
	 * dimensiones contiene las dimensiones x*y del tablero
	 */
	private Coordenada dimensiones;
	/**
	 * Constructor por defecto que crea el tablero e inicializa sus celdas a MUERTA
	 * @param dimensiones pasa las medidas del tablero, x de ancho e y de largo
	 */
	public Tablero(Coordenada dimensiones) throws ExcepcionArgumentosIncorrectos, ExcepcionCoordenadaIncorrecta{
		if(dimensiones==null)
			throw new ExcepcionArgumentosIncorrectos();
		this.dimensiones=new Coordenada(dimensiones);
		for(int i=0;i<dimensiones.getX();i++) {
			for(int j=0;j<dimensiones.getY();j++) {
				try {
				celdas.put(new Coordenada(i,j),
						       EstadoCelda.MUERTA);
				}catch (ExcepcionCoordenadaIncorrecta e) {
					throw new ExcepcionEjecucion(e);
				}
			}
		}
	}
	/**
	 * getter de dimensiones
	 * @return devuelve las dimensiones del tablero
	 */
	public Coordenada getDimensiones() {
		return(dimensiones);
	}
	/**
	 * getter de las posiciones del tablero
	 * @return devuelve un collection con las coordenadas de las celdas
	 */
	public Collection<Coordenada> getPosiciones(){
		Collection <Coordenada> coordenadas = celdas.keySet();
		return(coordenadas);
	}
	
	/**
	 * getter del estado de una celda que se pasa por parámetros
	 * @param posicion celda de la que queremos saber el estado
	 * @return devuelve el estado de la celda posicion
	 */
	public EstadoCelda getCelda(Coordenada posicion) throws ExcepcionPosicionFueraTablero, ExcepcionArgumentosIncorrectos{
		if(posicion==null)
			throw new ExcepcionArgumentosIncorrectos();
		EstadoCelda estado;
		Collection<Coordenada> coordenadas=getPosiciones();
		if(coordenadas.contains(posicion)) {
			estado=celdas.get(posicion);
			return(estado);
		}
		else {
			throw new ExcepcionPosicionFueraTablero(posicion,dimensiones);
		}
	}
	/**
	 * Setter para cambiar el estado de una celda
	 * @param posicion es la celda cuyo estado queremos cambiar
	 * @param e es el nuevo estado que queremos para la celda
	 */
	public void setCelda(Coordenada posicion,EstadoCelda e) throws ExcepcionArgumentosIncorrectos,ExcepcionPosicionFueraTablero{
		if(posicion==null||e==null)
			throw new ExcepcionArgumentosIncorrectos();
		Collection<Coordenada> coordenadas=this.getPosiciones();
		if(coordenadas.contains(posicion)) {
			celdas.put(new Coordenada(posicion),e);
		}
		else
			throw new ExcepcionPosicionFueraTablero(posicion,dimensiones);
		}
	/**
	 * devuelve un array con las posiciones alrededor de una celda dada,
	 * comenzando por la esquina superior izquierda y en sentido antihorario
	 * @param p celda cuyas vecinas queremos conocer
	 * @return devuelve un array con las celdas vecinas
	 */
	public ArrayList<Coordenada> getPosicionesVecinasCCW (Coordenada p)throws ExcepcionPosicionFueraTablero, ExcepcionArgumentosIncorrectos,ExcepcionEjecucion{
		if(p==null)
			throw new ExcepcionArgumentosIncorrectos();
		ArrayList<Coordenada> lista =new ArrayList<Coordenada>();
		Collection<Coordenada> coordenadas=this.getPosiciones();
		if (contiene(p)) {
			try {
			if(coordenadas.contains(new Coordenada(p.getX()-1,p.getY()-1)))
				lista.add(new Coordenada(p.getX()-1,p.getY()-1));
			if(coordenadas.contains(new Coordenada(p.getX()-1,p.getY())))
				lista.add(new Coordenada(p.getX()-1,p.getY()));
			if(coordenadas.contains(new Coordenada(p.getX()-1,p.getY()+1)))
				lista.add(new Coordenada(p.getX()-1,p.getY()+1));
			if(coordenadas.contains(new Coordenada(p.getX(),p.getY()+1)))
				lista.add(new Coordenada(p.getX(),p.getY()+1));
			if(coordenadas.contains(new Coordenada(p.getX()+1,p.getY()+1)))
				lista.add(new Coordenada(p.getX()+1,p.getY()+1));
			if(coordenadas.contains(new Coordenada(p.getX()+1,p.getY())))
				lista.add(new Coordenada(p.getX()+1,p.getY()));
			if(coordenadas.contains(new Coordenada(p.getX()+1,p.getY()-1)))
				lista.add(new Coordenada(p.getX()+1,p.getY()-1));
			if(coordenadas.contains(new Coordenada(p.getX(),p.getY()-1)))
				lista.add(new Coordenada(p.getX(),p.getY()-1));
			}catch(ExcepcionCoordenadaIncorrecta e) {
				throw new ExcepcionEjecucion(e);
			}
		}
		else
			throw new ExcepcionPosicionFueraTablero(p,dimensiones);
		return(lista);
	}
	/**
	 * Intenta cargar un patron a partir de una celda dada
	 * @param patron es el patron que quermos cargar en nuestro tablero
	 * @param coordinicial celda sobre la que queremos comenzar la carga del tablero
	 * @return devuelve true si se ppuede cargar y false si no
	 */
	public void cargaPatron(Patron patron, Coordenada coordinicial) throws ExcepcionArgumentosIncorrectos,ExcepcionEjecucion,ExcepcionPosicionFueraTablero{
		if(patron==null||coordinicial==null)
			throw new ExcepcionArgumentosIncorrectos();
		try {
			boolean result=true;
			Collection<Coordenada> coords_tablero=this.getPosiciones();
			Collection<Coordenada> coords_patron=patron.getPosiciones();
			for(Coordenada coord : coords_patron) {
			
					if(result==true&&!coords_tablero.contains(coord.suma(coordinicial))) {
						throw new ExcepcionPosicionFueraTablero(coord.suma(coordinicial),dimensiones);
					}
			}
			if(result) {
				for(Coordenada i : coords_patron) {
					setCelda(i.suma(coordinicial),patron.getCelda(i));
				}
			}
		}catch(ExcepcionCoordenadaIncorrecta e) {throw new ExcepcionEjecucion(e);}
	}
	/**
	 * Comprueba que las celdas estén en un tablero concreto
	 * @param posicion es la celda que queremos comprobar
	 * @return devuelve true si la celda se encuentra en el tablero y false si no
	 */
	public boolean contiene(Coordenada posicion) throws ExcepcionArgumentosIncorrectos{
		if(posicion==null)
			throw new ExcepcionArgumentosIncorrectos();
		Collection<Coordenada> coordenadas=getPosiciones();
		if(coordenadas.contains(posicion))
			return(true);
		else
			return(false);
	}
	@Override
	/**
	 * toString de la clase Tablero
	 */
	public String toString() throws ExcepcionEjecucion{
		EstadoCelda estado_viva= EstadoCelda.VIVA;
		Collection<Coordenada> coords=getPosiciones();
		StringBuilder cadena=new StringBuilder();
		int x=new Integer(0);
		int y=new Integer(0);
		for(Coordenada coord : coords) {
			if(coord.getX()>x)
				x=coord.getX();
			if(coord.getY()>y)
				y=coord.getY();
		}
		for(int i=0;i<(y+3);i++) {
			if(i==0||i==y+2) {
				cadena.append("+");
				for(int k=0;k<x+1;k++)
					cadena.append("-");
				cadena.append("+");
			}
			else {
				if(i==1)cadena.append("\n");	
				cadena.append("|");
				for(int j=0;j<x+1;j++) {
					try {
						if(getCelda(new Coordenada(j,i-1))==estado_viva)
							cadena.append("*");
						else
							cadena.append(" ");
					}catch (ExcepcionPosicionFueraTablero | ExcepcionCoordenadaIncorrecta e) {
							throw new ExcepcionEjecucion(e);
					}
				}
				cadena.append("|\n");
			}

		}
		cadena.append("\n");
		return cadena.toString();
	}
	
}
