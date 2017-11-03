package modelo;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;

public abstract class Coordenada {
	public Coordenada() {}
	
	public abstract Coordenada suma (Coordenada c) throws ExcepcionArgumentosIncorrectos, ExcepcionCoordenadaIncorrecta;
}
