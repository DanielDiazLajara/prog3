/**
 * @author Daniel Díaz Lajara
 */
package modelo;

import java.util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class Tablero {
	private HashMap<Coordenada,EstadoCelda> celdas;
	private Coordenada dimensiones;
	//private hasmap
	
	public Tablero(Coordenada dimensiones){
		this.dimensiones=dimensiones;
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
				return(result);
			}
		}
		if(result) {
			for(Coordenada i : coords_patron) {
				setCelda(i.suma(coordinicial),patron.getCelda(i));
			}
			return(result);
		}
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
		
	}
	
}
