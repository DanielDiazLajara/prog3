/**
 * Daniel Diaz Lajara 77634861V
 */
package entradasalida;

import entradasalida.excepciones.ExcepcionLectura;
import entradasalida.txt.ParserTablero1D;
import entradasalida.txt.ParserTablero2D;
import modelo.Tablero;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
/**
 * Esta clase se usa para crear tablaeros
 * a partir de cadenas, sin importar si 
 * estos son 1D o 2D
 */
public class ParserTableros {
	/**
	 * Constructor
	 */
	public ParserTableros() {}
	/**
	 * Toma una cadena y delega en Parser2D o parser1D
	 * @param s cadena a convertir en tablero
	 * @return el tablero creado
	 * @throws ExcepcionLectura si hay fallos en la cadena introducida
	 */
	public static Tablero leeTablero(String s) throws ExcepcionLectura {
		if(s=="")
			throw new ExcepcionLectura("ERROR: cadena introducida vacía");
		else if(s==null)
			throw new ExcepcionArgumentosIncorrectos();
		int contador =new Integer(0);
		for(int i=0;i<s.length();i++)
			if(s.charAt(i)=='\n')
				contador++;
		if(contador==0) {
			ParserTablero1D t=new ParserTablero1D();
			return(t.leeTablero(s));
		}
		else {
			ParserTablero2D t1=new ParserTablero2D();
			return(t1.leeTablero(s));
		}
	}
}
