package modelo;

import java.util.ArrayList;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

public class Regla30 extends Regla{
	
	public EstadoCelda calculaSiguienteEstadoCelda(Tablero tab, Coordenada coord)
			throws ExcepcionPosicionFueraTablero, ExcepcionArgumentosIncorrectos {
		if(coord==null||tab==null)
			throw new ExcepcionArgumentosIncorrectos();
		ArrayList<Coordenada> lista=tab.getPosicionesVecinasCCW(coord);
		EstadoCelda viva=EstadoCelda.VIVA;
		EstadoCelda muerta= EstadoCelda.MUERTA;
		EstadoCelda estado=EstadoCelda.VIVA;

		if(lista.size()==1)
			estado=muerta;
		else {
			EstadoCelda A=tab.getCelda(lista.get(0));
			EstadoCelda B=tab.getCelda(coord);
			EstadoCelda C=tab.getCelda(lista.get(1));
			if(A==viva&&B==viva&&C==viva)
				estado=muerta;
			else if(A==viva&&B==muerta&&C==viva)
				estado=muerta;
			else if(A==viva&&B==viva&&C==muerta)
				estado=muerta;
			else if(A==muerta&&B==muerta&&C==muerta)
				estado=muerta;
		}
			
		return(estado);
	}
}

	


