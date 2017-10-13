/**
 * @author Daniel Díaz Lajara
 */
package modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Tablero {
	private HashMap<Coordenada,EstadoCelda> celdas= new HashMap<Coordenada,EstadoCelda>();
	private Coordenada dimensiones;
//REVISAR COPIAS DEFENSIVAS	
	public Tablero(Coordenada dimensiones){
		this.dimensiones=new Coordenada(dimensiones);
		for(int i=0;i<this.dimensiones.getX();i++) {
			for(int j=0;j<this.dimensiones.getY();j++) {
				celdas.put(new Coordenada(i,j),
						       EstadoCelda.MUERTA);
			}
		}
	}
	public Coordenada getDimensiones() {
		return(dimensiones);
	}
	public Collection<Coordenada> getPosiciones(){
		Collection <Coordenada> coordenadas = celdas.keySet();
		return(coordenadas);
	}
	private void muestraErrorPosicionInvalida(Coordenada c){
		System.out.println("Error: La celda "+c.toString()+" no exite\n");
	}
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
	public void setCelda(Coordenada posicion,EstadoCelda e) {
		Collection<Coordenada> coordenadas=this.getPosiciones();
		if(coordenadas.contains(posicion)) {
			celdas.put(new Coordenada(posicion),e);
		}
		else
			muestraErrorPosicionInvalida(posicion);
	}
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
	boolean cargaPatron(Patron patron, Coordenada coordinicial) {
		boolean result=true;
		Collection<Coordenada> coords_tablero=getPosiciones();
		Collection<Coordenada> coords_patron=patron.getPosiciones();
		for(Coordenada i : coords_patron) {
			if(result==true&&!coords_tablero.contains(i.suma(coordinicial))) {
				result=false;
				muestraErrorPosicionInvalida(i);
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
	boolean contiene(Coordenada posicion) {
		Collection<Coordenada> coordenadas=getPosiciones();
		if(coordenadas.contains(posicion))
			return(true);
		else
			return(false);
	}
	@Override
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
		for(int i=0;i<(x+3);i++) {
			if(i==0||i==x+2) {
				cadena.append("+");
				for(int k=0;k<y+1;k++)
					cadena.append("-");
				cadena.append("+\n");	
			}
			else {
				cadena.append("|");
				for(int j=0;j<y+1;j++) {
					if(getCelda(new Coordenada(i-1,j))==estado_viva)
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
