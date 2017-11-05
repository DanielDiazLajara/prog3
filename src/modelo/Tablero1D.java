package modelo;

import java.util.ArrayList;
import java.util.Collection;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

public class Tablero1D extends Tablero{
	public Tablero1D(int ancho) throws ExcepcionArgumentosIncorrectos, ExcepcionCoordenadaIncorrecta {
		super(new Coordenada1D(ancho));
		for(int i=0;i<ancho;i++) {
			try {
				celdas.put(new Coordenada1D(i),
				       EstadoCelda.MUERTA);
			}catch(ExcepcionCoordenadaIncorrecta e){
				throw new ExcepcionEjecucion(e);	
			}
		}
	}
	
	public ArrayList<Coordenada> getPosicionesVecinasCCW (Coordenada coord)throws ExcepcionPosicionFueraTablero, ExcepcionArgumentosIncorrectos,ExcepcionEjecucion{
		int x=new Integer(0);

		if(coord==null||!(coord instanceof Coordenada2D))
			throw new ExcepcionArgumentosIncorrectos();
		Coordenada1D p=(Coordenada1D)coord;
		ArrayList<Coordenada> lista =new ArrayList<Coordenada>();
		Collection<Coordenada> coordenadas=this.getPosiciones();
		if (contiene(p)) {
			try {
				x=p.getX()-1;
				if(x>=0)
					if(coordenadas.contains(new Coordenada1D(x)))
						lista.add(new Coordenada1D(x));
				x=p.getX()+1;
				if(x>=0)
					if(coordenadas.contains(new Coordenada1D(x)))
						lista.add(new Coordenada1D(x));
			}catch(ExcepcionCoordenadaIncorrecta e) {
				throw new ExcepcionEjecucion(e);
			}
		}
		else
			throw new ExcepcionPosicionFueraTablero(p,dimensiones);
		return(lista);
	}
	public String toString() throws ExcepcionEjecucion{
		EstadoCelda estado_viva= EstadoCelda.VIVA;
		Collection<Coordenada> coords=getPosiciones();
		StringBuilder cadena=new StringBuilder();
		int x=new Integer(0);
		for(Coordenada coord : coords) {
			Coordenada1D coord2=(Coordenada1D)coord;
			if(coord2.getX()>x)
				x=coord2.getX();
		}
		for(int i=0;i<(x+3);i++) {
			if(i==0||i==x+2) {
				cadena.append("|");
			}
			else {
				try {
					if(getCelda(new Coordenada1D(i))==estado_viva)
						cadena.append("*");
					else
						cadena.append(" ");
				}catch (ExcepcionPosicionFueraTablero | ExcepcionCoordenadaIncorrecta e) {
						throw new ExcepcionEjecucion(e);
				}
			}
		}
		cadena.append("\n");
		return cadena.toString();
	}
		
	
}

