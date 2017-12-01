/**
 * @author Daniel Díaz Lajara 77634861V
 */
package entradasalida.textoplano;

import entradasalida.IParserTablero;
import entradasalida.excepciones.ExcepcionLectura;
import modelo.Coordenada2D;
import modelo.EstadoCelda;
import modelo.Tablero2D;
import modelo.TableroCeldasCuadradas;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

/**
 * Clase que implementa IParserTablero
 * y que se usará, en este caso, para
 * tableros 1D
 */
public class ParserTablero2D implements IParserTablero{
	/**
	 * Constructor por defecto
	 */
	public ParserTablero2D() {}
	/**
	 * método para convertir tablero 1d
	 * @param s string a convertir
	 * @return tablero convertido
	 * @throws ExcepcionEjecucion
	 * @throws ExcepcionArgumentosIncorrectos
	 */
	@Override
	public Tablero2D leeTablero(String s) throws ExcepcionEjecucion, ExcepcionLectura, ExcepcionArgumentosIncorrectos{
		if(s==null)
			throw new ExcepcionArgumentosIncorrectos();
		if(s=="")
			throw new ExcepcionLectura("ERROR: La cadena pasada está vacía");		
		int tam_fila=new Integer(0);
		int tam_new_fila=new Integer(0);
		int num_fila=new Integer(0);

		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)!='\n'&&s.charAt(i)!='*'&&s.charAt(i)!=' ')
				throw new ExcepcionLectura("ERROR: Carácteres introducidos erróneos"); 
			if(s.charAt(i)=='\n'&&i!=(s.length()-1)) {
				if(tam_fila!=tam_new_fila&&num_fila>0)
					throw new ExcepcionLectura("ERROR: Tamaños de fila diferentes");
				num_fila++;
			}
			else {
				if(num_fila==0)
					tam_fila++;
				else 
					tam_new_fila++;
			}	
		}
		TableroCeldasCuadradas tab;
		try {
			tab= new TableroCeldasCuadradas(tam_fila,num_fila);
			int fila=new Integer(0);
			int columna=new Integer(0);
			for(int i=0;i<s.length();i++) {
				if(s.charAt(i)=='\n') {
					columna++;
					fila=0;
				}
				else if(s.charAt(i)=='*') {
					tab.setCelda(new Coordenada2D(fila,columna),EstadoCelda.VIVA);
					fila++;
				}
				else if(s.charAt(i)==' ') {
					tab.setCelda(new Coordenada2D(fila,columna),EstadoCelda.MUERTA);
					fila++;
				}
			}
		} catch (ExcepcionCoordenadaIncorrecta e) {
			throw new ExcepcionEjecucion("ERROR de programacion en ParserTablero1D");
		}catch (ExcepcionPosicionFueraTablero e) {
			throw new ExcepcionEjecucion("ERROR de programacion en ParserTablero1D");
		}
		
		return tab;
	}
	
	
}
