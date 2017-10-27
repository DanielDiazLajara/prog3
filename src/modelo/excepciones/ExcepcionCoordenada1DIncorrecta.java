package modelo.excepciones;

@SuppressWarnings("serial")
public class ExcepcionCoordenada1DIncorrecta extends ExcepcionCoordenadaIncorrecta{
	private int x;
	public ExcepcionCoordenada1DIncorrecta(int x) {
		super();
		this.x=new Integer(x);
	}
	
	public String getMessage() {return("hola buenas tardes");}
	//POR IMPLEMENTAR
	
	public int getX() {return(x);}
}


