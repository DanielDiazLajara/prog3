package entradasalida;

import entradasalida.excepciones.ExcepcionLectura;
import entradasalida.textoplano.ParserTablero1D;
import entradasalida.textoplano.ParserTablero2D;
import modelo.Tablero;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;

public class ParserTableros {

	public ParserTableros() {}
	
	public static Tablero leeTablero(String s) throws ExcepcionLectura {
		if(s=="")
			throw new ExcepcionLectura("ERROR: cadena introducida vacía");
		else if(s==null)
			throw new ExcepcionArgumentosIncorrectos();
		int contador =new Integer(0);
		for(int i=0;i<s.length();i++)
			if(s.charAt(i)=='\n'&&(i+1)<s.length())
				contador++;
		if(contador==0) {
			ParserTablero1D t=new ParserTablero1D();
			return(t.leeTablero(s));
		}
		else {
			ParserTablero2D t1=new ParserTablero2D();
			return(t1.leeTablero(s));
		}
	}
}
