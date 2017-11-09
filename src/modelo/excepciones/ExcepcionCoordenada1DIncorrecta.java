/**
 * @author Daniel Díaz Lajara 77634861V
 */
package modelo.excepciones;

@SuppressWarnings("serial")
/**
 * Esta clase notificará
 * errores en la introducción
 * de coordenadas 1D
 */
public class ExcepcionCoordenada1DIncorrecta extends ExcepcionCoordenadaIncorrecta{
	/**
	 * coordenada x
	 */
	private int x;
	/**
	 * constructor con una coordenada unidimensional
	 * @param x
	 */
	public ExcepcionCoordenada1DIncorrecta(int x) {
		super();
		this.x=new Integer(x);
	}
	/**
	 * tostring de la clase muestra el error
	 */
	public String getMessage() {return("La coordenada ("+x+") es incorrecta\n");}
	/**
	 * getter de x
	 * @return x
	 */
	public int getX() {return(x);}
}


