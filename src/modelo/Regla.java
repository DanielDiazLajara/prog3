package modelo;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

public abstract class Regla {
	public abstract EstadoCelda calculaSiguienteEstadoCelda(Tablero tab, Coordenada coord) throws ExcepcionPosicionFueraTablero, ExcepcionArgumentosIncorrectos;
}
