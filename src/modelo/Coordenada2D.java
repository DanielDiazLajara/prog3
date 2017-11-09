/**
 * @author Daniel Díaz Lajara 77634861V
 */
package modelo;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenada2DIncorrecta;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;

/**
 * La clase Coordenada2D nos permite crear coordenadas
 * bidimensionales y realizar operaciones con ellas,
 * tales como sumarlas, copiarlas, crearlas...
 */
public class Coordenada2D extends Coordenada{
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
	public Coordenada2D(int x,int y) throws ExcepcionCoordenadaIncorrecta{
		if(x<0||y<0)
			throw new ExcepcionCoordenada2DIncorrecta(x,y);
		this.x=new Integer(x);
		this.y=new Integer(y);
	}
	/**
	 * Constructor de copia.
	 * @param otra, Coordenada que queremos copiar.
	 */
	public Coordenada2D(Coordenada2D otra) throws ExcepcionArgumentosIncorrectos{
		if(otra==null)
			throw new ExcepcionArgumentosIncorrectos();
		x=new Integer(otra.getX());
		y=new Integer(otra.getY());
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
		Coordenada2D other = (Coordenada2D) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	/**
	 * getter de x
	 * @return valor de x.
	 */
	public int getX() {
		return x;
	}
	/**
	 * getter de y 
	 * @return valor de y.
	 */
	public int getY() {
		return y;
	}
	/**
	 * Suma 2 coordenadas2D y devuelve otra resultado de dicha operación.
	 * @param otra almacena la coordenada2D que queremos sumar.
	 * @return coordenada2d resultado de la suma.
	 */
	public Coordenada suma(Coordenada otra) throws ExcepcionArgumentosIncorrectos, ExcepcionCoordenadaIncorrecta{
		
		if(otra == null||!(otra instanceof Coordenada2D))
			throw new ExcepcionArgumentosIncorrectos();
		Coordenada2D coord=(Coordenada2D)otra;
		Coordenada2D nueva=new Coordenada2D(x+coord.getX(),y+coord.getY());
		return(nueva);
	}
}
