package modelo;

import java.util.ArrayList;

public class ReglaConway {
	public ReglaConway() {}

	public EstadoCelda calculaSiguienteEstado(Tablero tab, Coordenada coord) {
		EstadoCelda estado_viva= EstadoCelda.VIVA;
		EstadoCelda estado_muerta= EstadoCelda.MUERTA;

		ArrayList<Coordenada> lista=tab.getPosicionesVecinasCCW(coord);
		//Contamos vivas y muertas
		int viva=new Integer(0);
		int muerta=new Integer(0);
		for (Coordenada i:lista) {
			if(tab.getCelda(i)==estado_viva)
				viva++;
			else
				muerta++;
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
