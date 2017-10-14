/**
 * @author Daniel Díaz Lajara
 */
package modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
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
	public Tablero(Coordenada dimensiones){
		this.dimensiones=new Coordenada(dimensiones);
		for(int i=0;i<dimensiones.getX();i++) {
			for(int j=0;j<dimensiones.getY();j++) {
				celdas.put(new Coordenada(i,j),
						       EstadoCelda.MUERTA);
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
	 * MUestra un error de posición de la celda c
	 * @param c es la celda sobre la que se da el error
	 */
	private void muestraErrorPosicionInvalida(Coordenada c){
		System.out.println("Error: La celda "+c.toString()+" no exite\n");
	}
	/**
	 * getter del estado de una celda que se pasa por parámetros
	 * @param posicion celda de la que queremos saber el estado
	 * @return devuelve el estado de la celda posicion
	 */
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
	/**
	 * Setter para cambiar el estado de una celda
	 * @param posicion es la celda cuyo estado queremos cambiar
	 * @param e es el nuevo estado que queremos para la celda
	 */
	public void setCelda(Coordenada posicion,EstadoCelda e) {
		Collection<Coordenada> coordenadas=this.getPosiciones();
		if(coordenadas.contains(posicion)) {
			celdas.put(new Coordenada(posicion),e);
		}
		else
			muestraErrorPosicionInvalida(posicion);
	}
	/**
	 * devuelve un array con las posiciones alrededor de una celda dada,
	 * comenzando por la esquina superior izquierda y en sentido antihorario
	 * @param p celda cuyas vecinas queremos conocer
	 * @return devuelve un array con las celdas vecinas
	 */
	public ArrayList<Coordenada> getPosicionesVecinasCCW (Coordenada p){
		ArrayList<Coordenada> lista =new ArrayList<Coordenada>();
		Collection<Coordenada> coordenadas=this.getPosiciones();
		for(int i=-1;i<=1;i++)
			if(coordenadas.contains(new Coordenada(p.getX(),p.getY()-1)))
				lista.add(new Coordenada(p.getX(),p.getY()-1));
		if(coordenadas.contains(new Coordenada(p.getX()+1,p.getY())))
			lista.add(new Coordenada(p.getX()+1,p.getY()));
		for(int i=1;i>=-1;i--)
			if(coordenadas.contains(new Coordenada(p.getX(),p.getY()+1)))
				lista.add(new Coordenada(p.getX(),p.getY()+1));
		if(coordenadas.contains(new Coordenada(p.getX()-1,p.getY())))
			lista.add(new Coordenada(p.getX()-1,p.getY()));
		return(lista);
	}
	/**
	 * Intenta cargar un patron a partir de una celda dada
	 * @param patron es el patron que quermos cargar en nuestro tablero
	 * @param coordinicial celda sobre la que queremos comenzar la carga del tablero
	 * @return devuelve true si se ppuede cargar y false si no
	 */
	public boolean cargaPatron(Patron patron, Coordenada coordinicial) {
		boolean result=true;
		Collection<Coordenada> coords_tablero=getPosiciones();
		Collection<Coordenada> coords_patron=patron.getPosiciones();
		for(Coordenada i : coords_patron) {
			if(result==true&&!coords_tablero.contains(i.suma(coordinicial))) {
				result=false;
				muestraErrorPosicionInvalida(i.suma(coordinicial));
				return(false);
			}
		}
		if(result) {
			for(Coordenada i : coords_patron) {
				setCelda(i.suma(coordinicial),patron.getCelda(i));
			}
			return(true);
		}
		return result;
	}
	/**
	 * Comprueba que las celdas estén en un tablero concreto
	 * @param posicion es la celda que queremos comprobar
	 * @return devuelve true si la celda se encuentra en el tablero y false si no
	 */
	public boolean contiene(Coordenada posicion) {
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
	public String toString() {
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
					if(getCelda(new Coordenada(j,i-1))==estado_viva)
						cadena.append("*");
					else
						cadena.append(" ");
				}
				cadena.append("|\n");
			}
		}
		return cadena.toString();
				
	}
}
