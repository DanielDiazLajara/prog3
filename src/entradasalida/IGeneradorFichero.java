package entradasalida;



import java.io.File;

import modelo.Juego;

public interface IGeneradorFichero {

	public void generaFichero (File f,Juego j,int num);
}
