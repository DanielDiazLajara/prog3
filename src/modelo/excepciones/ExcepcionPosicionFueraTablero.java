package modelo.excepciones;
import modelo.Coordenada;

@SuppressWarnings("serial")
public class ExcepcionPosicionFueraTablero extends Exception{
	private Coordenada dimensiones;
	private Coordenada coordenada;
	
	
	public ExcepcionPosicionFueraTablero(Coordenada d,Coordenada c) {
		super();
		dimensiones=new Coordenada(d);
		coordenada=new Coordenada(c);
	}
	public String getMessage() {return("hola");}
	//por implementar
	
	public Coordenada getDimensiones() {return(dimensiones);}
	public Coordenada getCoordenada() {return(coordenada);}
}
