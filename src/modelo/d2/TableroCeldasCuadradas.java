/**
 * @author Daniel Díaz Lajara 77634861V
 */
package modelo.d2;

import java.util.ArrayList;
import java.util.Collection;

import modelo.EstadoCelda;
import modelo.Imprimible;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;
/**
 * Esta clase que hereda de Tablero y de Tablero2D
 * nos permite crear tableros de 2 dimensiones
 * con las celdas cuadradas x*y
 */
public class TableroCeldasCuadradas extends Tablero2D implements Imprimible{

	/**
	 * Constructor del tablero
	 * @param ancho del tablero a crear
	 * @param alto del tablero a crear
	 * @throws ExcepcionCoordenadaIncorrecta excepción coordenada
	 * @throws ExcepcionEjecucion excepción ejecución
	 */
	public TableroCeldasCuadradas(int ancho, int alto) throws ExcepcionCoordenadaIncorrecta, ExcepcionEjecucion{
		super(ancho,alto);
	}
	/**
	 * halla las coordenadas vecinas a una dada
	 * @param coord coordenada cuyas vecinas queremos hallar
	 * @return lista con las vecinas halladas
	 * @throws ExcepcionPosicionFueraTablero excepción posición
	 * @throws ExcepcionEjecucion excepción ejecución
	 * @throws ExcepcionArgumentosIncorrectos excepción argumentos
	 */
	public ArrayList<Coordenada2D> getPosicionesVecinasCCW (Coordenada2D coord)throws ExcepcionPosicionFueraTablero, ExcepcionArgumentosIncorrectos,ExcepcionEjecucion{
		int x=new Integer(0);
		int y=new Integer(0);

		if(coord==null||!(coord instanceof Coordenada2D))
			throw new ExcepcionArgumentosIncorrectos();
		Coordenada2D p=(Coordenada2D)coord;
		ArrayList<Coordenada2D> lista =new ArrayList<Coordenada2D>();
		Collection<Coordenada2D> coordenadas=this.getPosiciones();
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
				if(x>=0&&y>=0)
					if(coordenadas.contains(new Coordenada2D(x,y)))
						lista.add(new Coordenada2D(x,y));
				x=p.getX()+1;
				y=p.getY()-1;
				if(x>=0&&y>=0)
					if(coordenadas.contains(new Coordenada2D(x,y)))
						lista.add(new Coordenada2D(x,y));
				x=p.getX();
				y=p.getY()-1;
				if(x>=0&&y>=0)
					if(coordenadas.contains(new Coordenada2D(x,y)))
						lista.add(new Coordenada2D(x,y));
			}catch(ExcepcionCoordenadaIncorrecta e) {
				throw new ExcepcionEjecucion(e);
			}
		}
		else
			throw new ExcepcionPosicionFueraTablero(dimensiones,p);
		return(lista);
	}
	
	@Override
	/**
	 * toString de la clase TableroCeldasCuadradas
	 * @return cadena
	 * @throws ExcepcionEjecucion excecion ejecucion
	 */
	public String toString() throws ExcepcionEjecucion{
		EstadoCelda estado_viva= EstadoCelda.VIVA;
		Collection<Coordenada2D> coords=getPosiciones();
		StringBuilder cadena=new StringBuilder();
		int x=new Integer(0);
		int y=new Integer(0);
		for(Coordenada2D coord : coords) {
			Coordenada2D coord2=(Coordenada2D)coord;
			if(coord2.getX()>x)
				x=coord2.getX();
			if(coord2.getY()>y)
				y=coord2.getY();
		}
		for(int i=0;i<(y+3);i++) {
			if(i==0||i==y+2) {
				cadena.append("+");
				for(int k=0;k<x+1;k++)
					cadena.append("-");
				cadena.append("+");
			}
			else {
				if(i==1)cadena.append("\n");	
				cadena.append("|");
				for(int j=0;j<x+1;j++) {
					try {
						if(getCelda(new Coordenada2D(j,i-1))==estado_viva)
							cadena.append("*");
						else
							cadena.append(" ");
					}catch (ExcepcionPosicionFueraTablero | ExcepcionCoordenadaIncorrecta e) {
							throw new ExcepcionEjecucion(e);
					}
				}
				cadena.append("|\n");
			}

		}
		cadena.append("\n");
		return cadena.toString();
	}
	/**
	 * genera cadena de la clase TableroCeldasCuadradas
	 * @return cadena
	 * @throws ExcepcionEjecucion excecion ejecucion
	 */
	public String generaCadena() {
		EstadoCelda estado_viva= EstadoCelda.VIVA;
		Collection<Coordenada2D> coords=getPosiciones();
		StringBuilder cadena=new StringBuilder();
		int x=new Integer(0);
		int y=new Integer(0);
		for(Coordenada2D coord : coords) {
			Coordenada2D coord2=(Coordenada2D)coord;
			if(coord2.getX()>x)
				x=coord2.getX();
			if(coord2.getY()>y)
				y=coord2.getY();
		}
		for(int i=0;i<(y+3);i++) {
			if(i==0||i==y+2) {
				cadena.append("+");
				for(int k=0;k<x+1;k++)
					cadena.append("-");
				cadena.append("+");
			}
			else {
				if(i==1)cadena.append("\n");	
				cadena.append("|");
				for(int j=0;j<x+1;j++) {
					try {
						if(getCelda(new Coordenada2D(j,i-1))==estado_viva)
							cadena.append("*");
						else
							cadena.append(" ");
					}catch (ExcepcionPosicionFueraTablero | ExcepcionCoordenadaIncorrecta e) {
							throw new ExcepcionEjecucion(e);
					}
				}
				cadena.append("|\n");
			}

		}
		return cadena.toString();
	}
}
