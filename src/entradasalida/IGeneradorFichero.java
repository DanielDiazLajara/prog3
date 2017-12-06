package entradasalida;

import java.io.File;
import java.io.FileNotFoundException;

import entradasalida.excepciones.ExcepcionGeneracion;
import modelo.Juego;

public interface IGeneradorFichero {

	public void generaFichero (File f,Juego j,int num) throws ExcepcionGeneracion, FileNotFoundException;
}
