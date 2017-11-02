/**
 * @author Daniel Díaz Lajara 77634861V
 */
package modelo;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;

/**
 * La clase Coordenada nos permite crear coordenadas
 * bidimensionales y realizar operaciones con ellas,
 * tales como sumarlas, copiarlas, crearlas...
 */
public class Coordenada {
	/**
	 * EL atributo x denota la posición en fila de la coordenada
	 */
	private int x;
	/**
	 * El atributo y denota la posición en columna de la coordenada
	 */
	private int y;
	/**
	 * Constructor por defecto
	 * @param x fila de la nueva coordenada a crear.
	 * @param y columna de la nueva coordenada a crear.
	 */
	public Coordenada(int x,int y) throws ExcepcionCoordenadaIncorrecta{
		if(x<0||y<0)
			throw new ExcepcionCoordenadaIncorrecta();
		this.x=new Integer(x);
		this.y=new Integer(y);
	}
	/**
	 * Constructor de copia.
	 * @param otra, Coordenada que queremos copiar.
	 */
	public Coordenada(Coordenada otra) throws ExcepcionArgumentosIncorrectos{
		if(otra==null)
			throw new ExcepcionArgumentosIncorrectos();
		x=new Integer(otra.x);
		y=new Integer(otra.y);
	}
	/**
	 * Muestra coordenada en formato (x,y).
	 */
	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	/**
	 * Compara objetos.
	 * @return true si dichos objetos son iguales.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordenada other = (Coordenada) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	/**
	 * @return valor de x.
	 */
	public int getX() {
		return x;
	}
	/**
	 * @return valor de y.
	 */
	public int getY() {
		return y;
	}
	/**
	 * Suma 2 coordenadas y devuelve otra resultado de dicha operación.
	 * @param otra almacena la coordenada que queremos sumar.
	 * @return coordenada resultado de la suma.
	 */
	public Coordenada suma(Coordenada otra) throws ExcepcionArgumentosIncorrectos, ExcepcionCoordenadaIncorrecta{
		if(otra == null)
			throw new ExcepcionArgumentosIncorrectos();
		Coordenada nueva=new Coordenada(x+otra.x,y+otra.y);
		return(nueva);
	}
}
