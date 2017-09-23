/**
 * @author Daniel Díaz Lajara 77634861V
 * @date 
 * @param explica parámetros
 * @return qué devuelve la función 
 */
package modelo;

public class Coordenada {
	private int x;
	private int y;
	private static int NUMERO_COORDENADAS;
	
	public Coordenada(int x,int y) {
		this.x=x;
		this.y=y;
		NUMERO_COORDENADAS++;
	}
	public Coordenada(Coordenada otra) {
		x=otra.x;
		y=otra.y;
	}
	public static int getNumeroCoordenadas() {
		return NUMERO_COORDENADAS;
	}
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
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public Coordenada suma(Coordenada otra) {
		Coordenada nueva=new Coordenada(x+otra.x,y+otra.y);
		return(nueva);
	}
}
