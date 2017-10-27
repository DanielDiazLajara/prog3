package modelo.excepciones;

@SuppressWarnings("serial")
public class ExcepcionCoordenada2DIncorrecta extends ExcepcionCoordenadaIncorrecta{
	private int x;
	private int y;
	
	public ExcepcionCoordenada2DIncorrecta(int x, int y) {
		super();
		this.x=new Integer(x);
		this.y=new Integer(y);
	}
	
	public String getMessage() {return("hola que tal");}
	//POR IMPLEMENTAR
	
	public int getX() {return(x);}
	public int getY() {return(y);}

}
