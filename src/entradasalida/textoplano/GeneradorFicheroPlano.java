package entradasalida.textoplano;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import entradasalida.excepciones.ExcepcionGeneracion;
import modelo.Imprimible;
import modelo.Juego;
import modelo.Tablero;
import modelo.Tablero1D;
import modelo.TableroCeldasCuadradas;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;

public class GeneradorFicheroPlano {

	public GeneradorFicheroPlano() {}
	
	public void generaFichero(File f, Juego j, int num) throws ExcepcionGeneracion, FileNotFoundException {
		if(f==null||j==null)
			throw new ExcepcionArgumentosIncorrectos();
		if(num<=0)
			throw new ExcepcionGeneracion("ERROR: num iteraciones incorrecto");
		for(int i=0;i<num;i++) {
			j.actualiza();
			Tablero tablero=j.getTablero();
			String cadena="";
			if(tablero instanceof Imprimible) {
				if(tablero instanceof Tablero1D) {
					cadena=((Tablero1D) tablero).generaCadena();
				}
				else if (tablero instanceof TableroCeldasCuadradas) {
					cadena=((TableroCeldasCuadradas) tablero).generaCadena();
				}
			}
			else
				throw new ExcepcionGeneracion("ERROR: El tablero del juego no es imprimible");
			PrintWriter pw;
			pw=new PrintWriter(f);
			pw.println(cadena);
			//CUIDADO
			pw.close();
		}
	}
}
