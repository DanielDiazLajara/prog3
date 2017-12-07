package entradasalida;

import entradasalida.excepciones.ExcepcionGeneracion;
import entradasalida.imagen.GeneradorGIFTablero1D;
import entradasalida.imagen.GeneradorGifAnimadoTablero2D;
import entradasalida.textoplano.GeneradorFicheroPlano;
import modelo.Coordenada;
import modelo.Coordenada1D;
import modelo.Coordenada2D;
import modelo.Regla;
import modelo.Regla30;
import modelo.ReglaConway;
import modelo.Tablero;
import modelo.Tablero1D;
import modelo.Tablero2D;
import modelo.TableroCeldasCuadradas;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;

public class Factory {
	
	public Factory() {}
	
	public IGeneradorFichero creaGeneradorFichero(Tablero tablero, String extension) throws ExcepcionGeneracion {
		if(tablero==null||extension==null)
			throw new ExcepcionArgumentosIncorrectos();
		if(extension=="txt")
			return(new GeneradorFicheroPlano());
		else if(extension=="gif") {
			if(tablero instanceof Tablero1D)
				return(new GeneradorGIFTablero1D());
			else if(tablero instanceof Tablero2D)
				return(new GeneradorGifAnimadoTablero2D());
		}	
		else
			throw new ExcepcionGeneracion("ERROR: extensión de archivo incorrecta");
		return(null);
	}
	
	public Regla creaRegla(Tablero tab) {
		if(tab==null)
			throw new ExcepcionArgumentosIncorrectos();
		if(tab instanceof Tablero1D)
			return(new Regla30());
		else if(tab instanceof Tablero2D)
			return(new ReglaConway());
		else
			throw new ExcepcionEjecucion("ERROR: tablero introducido incorrecto.");
	}
	
	public Tablero creaTablero(Coordenada coord) throws ExcepcionArgumentosIncorrectos, ExcepcionCoordenadaIncorrecta {
		if(coord==null)
			throw new ExcepcionArgumentosIncorrectos();
		if(coord instanceof Coordenada1D) {
			int x=new Integer(((Coordenada1D)coord).getX());
			return(new Tablero1D(x));
		}else if(coord instanceof Coordenada2D) {
			int x=new Integer(((Coordenada2D)coord).getX());
			int y=new Integer(((Coordenada2D)coord).getY());
			return(new TableroCeldasCuadradas(x,y));
		}else
			throw new ExcepcionEjecucion("ERROR: coordenada para crear tablero incorrecta.");	
	}
}
