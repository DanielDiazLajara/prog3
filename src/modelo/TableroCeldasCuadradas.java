package modelo;

import java.util.ArrayList;
import java.util.Collection;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

public class TableroCeldasCuadradas extends Tablero2D{

	public TableroCeldasCuadradas(int ancho, int alto) throws ExcepcionCoordenadaIncorrecta {
		super(ancho,alto);
	}
	public ArrayList<Coordenada> getPosicionesVecinasCCW (Coordenada coord)throws ExcepcionPosicionFueraTablero, ExcepcionArgumentosIncorrectos,ExcepcionEjecucion{
		int x=new Integer(0);
		int y=new Integer(0);

		if(coord==null||!(coord instanceof Coordenada2D))
			throw new ExcepcionArgumentosIncorrectos();
		Coordenada2D p=(Coordenada2D)coord;
		ArrayList<Coordenada> lista =new ArrayList<Coordenada>();
		Collection<Coordenada> coordenadas=this.getPosiciones();
		if (contiene(p)) {
			try {
				x=p.getX()-1;
				y=p.getY()-1;
				if(x>=0&&y>=0)
					if(coordenadas.contains(new Coordenada2D(x,y)))
						lista.add(new Coordenada2D(x,y));
				x=p.getX()-1;
				y=p.getY();
				if(x>=0&&y>=0)
					if(coordenadas.contains(new Coordenada2D(x,y)))
						lista.add(new Coordenada2D(x,y));
				x=p.getX()-1;
				y=p.getY()+1;
				if(x>=0&&y>=0)
					if(coordenadas.contains(new Coordenada2D(x,y)))
						lista.add(new Coordenada2D(x,y));
				x=p.getX();
				y=p.getY()+1;
				if(x>=0&&y>=0)
					if(coordenadas.contains(new Coordenada2D(x,y)))
						lista.add(new Coordenada2D(p.getX(),p.getY()+1));
				x=p.getX()+1;
				y=p.getY()+1;
				if(x>=0&&y>=0)
					if(coordenadas.contains(new Coordenada2D(x,y)))
						lista.add(new Coordenada2D(x,y));
				x=p.getX()+1;
				y=p.getY();
					if(coordenadas.contains(new Coordenada2D(x,y)))
						lista.add(new Coordenada2D(x,y));
				x=p.getX()+1;
				y=p.getY()-1;
					if(coordenadas.contains(new Coordenada2D(x,y)))
						lista.add(new Coordenada(p.getX()+1,p.getY()-1));
					if(coordenadas.contains(new Coordenada(p.getX(),p.getY()-1)))
						lista.add(new Coordenada(p.getX(),p.getY()-1));
			}catch(ExcepcionCoordenadaIncorrecta e) {
				throw new ExcepcionEjecucion(e);
			}
		}
		else
			throw new ExcepcionPosicionFueraTablero(p,dimensiones);
		return(lista);
	}
}
