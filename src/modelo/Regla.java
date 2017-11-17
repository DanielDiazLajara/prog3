/**
 * @author Daniel Díaz Lajara 77634861V
 */
package modelo;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionPosicionFueraTablero;
/**
 * Clase abstracta Regla
 * De ella derivan, con herencia los diferentes tipos de reglas
 * que se pueden usar en el juego
 */
public abstract class Regla {
/**
 * 
 * @param tab tablero que pasamos
 * @param coord coordenada para la regla
 * @return estado de la celda
 * @throws ExcepcionPosicionFueraTablero
 * @throws ExcepcionArgumentosIncorrectos
 */
	public abstract EstadoCelda calculaSiguienteEstadoCelda(Tablero tab, Coordenada coord) throws ExcepcionPosicionFueraTablero, ExcepcionArgumentosIncorrectos;
}
