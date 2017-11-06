/**
 * @author Daniel Díaz Lajara 77634861V
 */
package modelo;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
/**
 * La clase Coordenada es abstracta
 * A partir de ella se crean otras clases hijas por herencia
 * Se trata de nuevas Coordenadas con diferentes dimensiones
 */
public abstract class Coordenada {
	/**
	 * Constructor por defecto de Coordenada
	 */
	public Coordenada() {}
	/**
	 * Método abstracto para sumar 2 coordenadas
	 * @param c coordenada que pasamos para sumar
	 * @return nueva coordenada resutado de la suma
	 * @throws ExcepcionArgumentosIncorrectos
	 * @throws ExcepcionCoordenadaIncorrecta
	 */
	public abstract Coordenada suma (Coordenada c) throws ExcepcionArgumentosIncorrectos, ExcepcionCoordenadaIncorrecta;
}
