/**
 * @author Daniel Díaz Lajara 77634861V
 */
package entradasalida.textoplano;

import entradasalida.IParserTablero;
import entradasalida.excepciones.ExcepcionLectura;
import modelo.Coordenada1D;
import modelo.EstadoCelda;
import modelo.Tablero;
import modelo.Tablero1D;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;
/**
 * Clase que implementa IParserTablero
 * y que se usará, en este caso, para
 * tableros 1D
 */
public class ParserTablero1D implements IParserTablero{
	/**
	 * Constructor por defecto
	 */
	public ParserTablero1D(){}
	/**
	 * método para convertir tablero 1d
	 * @param s string a convertir
	 * @return tablero convertido
	 * @throws ExcepcionEjecucion
	 * @throws ExcepcionArgumentosIncorrectos
	 */
	public Tablero leeTablero (String s) throws ExcepcionEjecucion,ExcepcionLectura,ExcepcionArgumentosIncorrectos{
		Tablero1D t1;
		if(s==null)
			throw new ExcepcionArgumentosIncorrectos();
		if(s=="")
			throw new ExcepcionLectura("ERROR: Cadena introducida vacia.");
		try {
			t1 = new Tablero1D(s.length());
		} catch (ExcepcionCoordenadaIncorrecta e1) {
			throw new ExcepcionEjecucion("ERROR de programacion en ParserTablero1D");
		}
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='*')
				try {
					t1.setCelda(new Coordenada1D(i), EstadoCelda.VIVA);
				} catch (ExcepcionArgumentosIncorrectos | ExcepcionPosicionFueraTablero
						| ExcepcionCoordenadaIncorrecta e) {
					throw new ExcepcionEjecucion("ERROR de programación de ParserTablero1D");
				}
			else if(s.charAt(i)==' ')
				try {
					t1.setCelda(new Coordenada1D(i), EstadoCelda.MUERTA);
				} catch (ExcepcionArgumentosIncorrectos | ExcepcionPosicionFueraTablero
						| ExcepcionCoordenadaIncorrecta e) {
					throw new ExcepcionEjecucion("ERROR de programación de ParserTablero1D");
				}
			else
				throw new ExcepcionLectura("ERROR: Cadena intrducida errónea");
		}
		return(t1);
	}
}
