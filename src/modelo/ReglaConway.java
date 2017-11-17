/**
 * @author Daniel Díaz Lajara 77634861V
 */
package modelo;

import java.util.ArrayList;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionPosicionFueraTablero;
/**
 * Esta clase establece la regla que debemos usar
 * a la hora de alterar el estado de las celdas
 * pasando estas de vivas a muertas o viceversa
 * según convenga.
 */
public class ReglaConway extends Regla{
	/**
	 * Constructor por defecto de ReglaConway
	 */
	public ReglaConway() {}
	
	/**
	 * Devuelve el siguiente estado que debe de tener una celda en la iteración siguiente
	 * @param tab pasa el tablero en el que se encuentra la celda a calcular
	 * @param coord pasa las coordenadas de la celda que queremos calcular
	 * @return devuelve el EstadoCelda a asignar a la celda coord
	 * @throws ExcepcionArgumentosIncorrectos excepción argumentos 
	 * @throws ExcepcionPosicionFueraTablero excepción posición 
	 */
	public EstadoCelda calculaSiguienteEstadoCelda(Tablero tab, Coordenada coord) throws ExcepcionPosicionFueraTablero,ExcepcionArgumentosIncorrectos{
		if(coord==null||tab==null)
			throw new ExcepcionArgumentosIncorrectos();
		EstadoCelda estado_viva= EstadoCelda.VIVA;
		EstadoCelda estado_muerta= EstadoCelda.MUERTA;

		ArrayList<Coordenada> lista=tab.getPosicionesVecinasCCW(coord);
		//Contamos vivas y muertas
		int viva=new Integer(0);
		for (Coordenada i:lista) {
			if(tab.getCelda(i)==estado_viva)
				viva++;
		}
		if(tab.getCelda(coord)==estado_viva) {
			if(viva==2||viva==3)
				return(estado_viva);
			else
				return(estado_muerta);
		}
		else {
			if(viva==3)
				return(estado_viva);
			else
				return(estado_muerta);
		}
	}
}
