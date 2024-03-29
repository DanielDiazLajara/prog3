/**
 * @author Daniel Díaz Lajara 77634861V
 */
package modelo.d1;

import java.util.ArrayList;
import java.util.Collection;

import modelo.EstadoCelda;
import modelo.Imprimible;
import modelo.Tablero;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;
/**
 * 
 * Esta clase nos permite crear
 * tablero de una dimensión heredando de Tablero
 * Estos tableros solo tienen 1 fila
 */
public class Tablero1D extends Tablero<Coordenada1D> implements Imprimible{
	/**
	 * Constructor de Tablero1D
	 * @param ancho del tablero
	 * @throws ExcepcionArgumentosIncorrectos excepción argumentos
	 * @throws ExcepcionCoordenadaIncorrecta excepción coordenada
	 */
	public Tablero1D(int ancho) throws ExcepcionArgumentosIncorrectos, ExcepcionCoordenadaIncorrecta {
		super(new Coordenada1D(ancho));
		for(int i=0;i<ancho;i++) {
			try {
				celdas.put(new Coordenada1D(i),
				       EstadoCelda.MUERTA);
			}catch(ExcepcionCoordenadaIncorrecta e){
				throw new ExcepcionEjecucion(e);	
			}
		}
	}
	/**
	 * Devuelve las posiciones vecinas a una coordenada
	 * @param coord es la coordenada cuyas vecinas queremos hayar
	 * @return lista con las coordenadas vecinas hayadas
	 * @throws ExcepcionPosicionFueraTablero excepción posición
	 * @throws ExcepcionArgumentosIncorrectos excepción argumentos
	 * @throws ExcepcionEjecucion excepción ejecución
	 */
	public ArrayList<Coordenada1D> getPosicionesVecinasCCW (Coordenada1D coord)throws ExcepcionPosicionFueraTablero, ExcepcionArgumentosIncorrectos,ExcepcionEjecucion{
		int x=new Integer(0);

		if(coord==null||!(coord instanceof Coordenada1D))
			throw new ExcepcionArgumentosIncorrectos();
		Coordenada1D p=(Coordenada1D)coord;
		ArrayList<Coordenada1D> lista =new ArrayList<Coordenada1D>();
		Collection<Coordenada1D> coordenadas=this.getPosiciones();
		if (contiene(p)) {
			try {
				x=p.getX()-1;
				if(x>=0)
					if(coordenadas.contains(new Coordenada1D(x)))
						lista.add(new Coordenada1D(x));
				x=p.getX()+1;
				if(x>=0)
					if(coordenadas.contains(new Coordenada1D(x)))
						lista.add(new Coordenada1D(x));
			}catch(ExcepcionCoordenadaIncorrecta e) {
				throw new ExcepcionEjecucion(e);
			}
		}
		else
			throw new ExcepcionPosicionFueraTablero(p,dimensiones);
		return(lista);
	}
	/**
	 * to string de tablero1d
	 * @return string de tablero
	 * @throws ExcepcionEjecucion excepción ejecución 
	 */
	public String toString() throws ExcepcionEjecucion{
		EstadoCelda estado_viva= EstadoCelda.VIVA;
		Collection<Coordenada1D> coords=getPosiciones();
		StringBuilder cadena=new StringBuilder();
		int x=new Integer(0);
		for(Coordenada1D coord : coords) {
			Coordenada1D coord2=(Coordenada1D)coord;
			if(coord2.getX()>x)
				x=coord2.getX();
		}
		for(int i=0;i<(x+3);i++) {
			if(i==0||i==x+2) {
				cadena.append("|");
			}
			else {
				try {
					if(getCelda(new Coordenada1D(i-1))==estado_viva)
						cadena.append("*");
					else
						cadena.append(" ");
				}catch (ExcepcionPosicionFueraTablero | ExcepcionCoordenadaIncorrecta e) {
						throw new ExcepcionEjecucion(e);
				}
			}
		}
		cadena.append("\n");
		return cadena.toString();
	}
	/**
	 * genera cadena de tablero1d
	 * @return string de tablero
	 * @throws ExcepcionEjecucion excepción ejecución 
	 */
	public String generaCadena() throws ExcepcionEjecucion{
		EstadoCelda estado_viva= EstadoCelda.VIVA;
		Collection<Coordenada1D> coords=getPosiciones();
		StringBuilder cadena=new StringBuilder();
		int x=new Integer(0);
		for(Coordenada1D coord : coords) {
			Coordenada1D coord2=(Coordenada1D)coord;
			if(coord2.getX()>x)
				x=coord2.getX();
		}
		Coordenada1D c=this.getDimensiones();
		int y=new Integer(((Coordenada1D)c).getX());
		cadena.append("|");
		for(int i=0;i<y;i++) {
			try {
				if(getCelda(new Coordenada1D(i))==estado_viva)
					cadena.append("*");
				else
					cadena.append(" ");
			}catch (ExcepcionPosicionFueraTablero | ExcepcionCoordenadaIncorrecta e) {
				throw new ExcepcionEjecucion(e);
			}
		}
		cadena.append("|");
		return cadena.toString();
	}	
}

