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
 * @param <TipoCoordenada> coordenada tipo que pasamos
 */
public abstract class Regla<TipoCoordenada extends Coordenada> {
/**
 * 
 * @param tab tablero que pasamos
 * @param coord coordenada para la regla
 * @return estado de la celda
 * @throws ExcepcionPosicionFueraTablero excepción posición
 * @throws ExcepcionArgumentosIncorrectos excepción argumentos
 */
	public abstract EstadoCelda calculaSiguienteEstadoCelda(Tablero<TipoCoordenada> tab, TipoCoordenada coord) throws ExcepcionPosicionFueraTablero, ExcepcionArgumentosIncorrectos;
}
