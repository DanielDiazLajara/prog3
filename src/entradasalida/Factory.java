/**
 * Daniel Díaz Lajara 77634861V
 */
package entradasalida;

import entradasalida.excepciones.ExcepcionGeneracion;
import entradasalida.imagen.GeneradorGIFTablero1D;
import entradasalida.imagen.GeneradorGifAnimadoTablero2D;
import entradasalida.textoplano.GeneradorFicheroPlano;
import modelo.Coordenada;
import modelo.Coordenada1D;
import modelo.Coordenada2D;
import modelo.Regla;
import modelo.Regla30;
import modelo.ReglaConway;
import modelo.Tablero;
import modelo.Tablero1D;
import modelo.Tablero2D;
import modelo.TableroCeldasCuadradas;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
/**
 * Esta clase nos facilita la creación
 * de reglas, generadores y tableros, 
 * en función de nuestras necesidades
 */
public class Factory {
	/**
	 * Constructor
	 */
	public Factory() {}
	/**
	 * Crea un generador 2D o 1D según el tablero y la extension
	 * @param tablero tablero del que depende el generador
	 * @param extension extension del archivo a crear
	 * @return el generador deseado
	 * @throws ExcepcionGeneracion si no se puede crear el generador
	 */
	public static IGeneradorFichero creaGeneradorFichero(Tablero tablero, String extension) throws ExcepcionGeneracion {
		if(tablero==null||extension==null)
			throw new ExcepcionArgumentosIncorrectos();
		if(extension.equals("txt"))
			return(new GeneradorFicheroPlano());
		else if(extension.equals("gif")) {
			if(tablero instanceof Tablero1D)
				return(new GeneradorGIFTablero1D());
			else if(tablero instanceof Tablero2D)
				return(new GeneradorGifAnimadoTablero2D());
		}	
		else
			throw new ExcepcionGeneracion("ERROR: extensión de archivo incorrecta");
		return(null);
	}
	/**
	 * Crea una reglaConway o Regla30 según el tablero pasado
	 * @param tab tablero que ppasamos
	 * @return la regla que proceda
	 */
	public static Regla creaRegla(Tablero tab) {
		if(tab==null)
			throw new ExcepcionArgumentosIncorrectos();
		if(tab instanceof Tablero1D)
			return(new Regla30());
		else if(tab instanceof Tablero2D)
			return(new ReglaConway());
		else
			throw new ExcepcionEjecucion("ERROR: tablero introducido incorrecto.");
	}
	/**
	 * Crea un tableroCeldasCuadradas o Tablero1D según coordenada
	 * @param coord de la que depende el tablero creado
	 * @return tablero creado
	 * @throws ExcepcionArgumentosIncorrectos si parámetros pasados son null
	 * @throws ExcepcionCoordenadaIncorrecta si la coordenada de creación no es válida
	 */
	public static Tablero creaTablero(Coordenada coord) throws ExcepcionArgumentosIncorrectos, ExcepcionCoordenadaIncorrecta {
		if(coord==null)
			throw new ExcepcionArgumentosIncorrectos();
		if(coord instanceof Coordenada1D) {
			int x=new Integer(((Coordenada1D)coord).getX());
			return(new Tablero1D(x));
		}else if(coord instanceof Coordenada2D) {
			int x=new Integer(((Coordenada2D)coord).getX());
			int y=new Integer(((Coordenada2D)coord).getY());
			return(new TableroCeldasCuadradas(x,y));
		}else
			throw new ExcepcionEjecucion("ERROR: coordenada para crear tablero incorrecta.");	
	}
}
