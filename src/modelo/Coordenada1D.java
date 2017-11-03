/**
 * @author Daniel Díaz Lajara 77634861V
 */
package modelo;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenada1DIncorrecta;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;

/**
 * La clase Coordenada1D nos permite crear coordenadas
 * unidimensionales y realizar operaciones con ellas,
 * tales como sumarlas, copiarlas, crearlas...
 */
public class Coordenada1D extends Coordenada{
	/**
	 * EL atributo x denota la posición en fila de la coordenada
	 */
	private int x;
	public Coordenada1D(int x) throws ExcepcionCoordenadaIncorrecta{
		if(x<0)
			throw new ExcepcionCoordenada1DIncorrecta(x);
		this.x=new Integer(x);
	}
	/**
	 * Constructor por defecto
	 * @param x fila de la nueva coordenada a crear.
	 */
	public Coordenada1D(Coordenada1D coord) throws ExcepcionArgumentosIncorrectos{
		if(coord==null)
			throw new ExcepcionArgumentosIncorrectos();
		this.x=new Integer(coord.getX());
	}
	/**
	 * Muestra coordenada en formato (x).
	 */
	@Override
	public String toString() {
		return "("+x+")";
	}
	/**
	 * @return valor de x.
	 */
	public int getX() {return x;}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordenada1D other = (Coordenada1D) obj;
		if (x != other.x)
			return false;
		return true;
	}
	/**
	 * Suma 2 coordenadas1D y devuelve otra resultado de dicha operación.
	 * @param otra almacena la coordenada1D que queremos sumar.
	 * @return coordenada1D resultado de la suma.
	 */
	public Coordenada1D suma(Coordenada c) throws ExcepcionArgumentosIncorrectos, ExcepcionCoordenadaIncorrecta{
		if(c == null||!(c instanceof Coordenada1D))
			throw new ExcepcionArgumentosIncorrectos();
		Coordenada1D coord=(Coordenada1D)c;
		Coordenada1D nueva=new Coordenada1D(x+coord.getX());
		return(nueva);
	}
	
}
