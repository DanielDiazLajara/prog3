/**
 * @author Daniel Díaz Lajara 77634861V
 */
package modelo.excepciones;

@SuppressWarnings("serial")
/**
 * Esta clase notificará fallos
 * al crear coordenadas 2d
 * hereda de Coordenada
 */
public class ExcepcionCoordenada2DIncorrecta extends ExcepcionCoordenadaIncorrecta{
	/**
	 * denada x de la coordenada incorrecta
	 */
	private int x;
	/**
	 * y de la coordenada incorrecta
	 */
	private int y;
	/**
	 * constructor con coordenada
	 * @param x de la coordenada
	 * @param y de la coordenada
	 */
	public ExcepcionCoordenada2DIncorrecta(int x, int y) {
		super();
		this.x=new Integer(x);
		this.y=new Integer(y);
	}
	/**
	 * to string muestra e mensaje error
	 */
	public String getMessage() {return("La coordenada ("+x+","+y+") es incorrecta\n");}	
	/**
	 * getter de x
	 * @return x
	 */
	public int getX() {return(x);}
	/**
	 * getter de y
	 * @return y
	 */
	public int getY() {return(y);}

}
