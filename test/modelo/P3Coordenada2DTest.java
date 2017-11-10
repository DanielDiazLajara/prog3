package modelo;

import static org.junit.Assert.*;
import org.junit.Test;

import modelo.excepciones.ExcepcionCoordenadaIncorrecta;

public class P3Coordenada2DTest {

	
	@Test
	//TEST CONSTRUCTOR INT INT
	public void test() {
		try {
		Coordenada2D c1=new Coordenada2D(1,4);
		System.out.println(c1.toString()+" creada correctamente");
			}catch(ExcepcionCoordenadaIncorrecta e){
			System.out.println(e.getMessage());
			}
		try {
			Coordenada2D c1=new Coordenada2D(0,0);
			System.out.println(c1.toString()+" creada correctamente");
			}catch(ExcepcionCoordenadaIncorrecta e){
				System.out.println(e.getMessage());
			}
		try {
			Coordenada2D c1=new Coordenada2D(-1,4);
			System.out.println(c1.toString()+" creada correctamente");
			}catch(ExcepcionCoordenadaIncorrecta e){
				System.out.println(e.getMessage());
			}
		try {
			Coordenada2D c1=new Coordenada2D(1,-4);
			System.out.println(c1.toString()+" creada correctamente");
			}catch(ExcepcionCoordenadaIncorrecta e){
				System.out.println(e.getMessage());
			}
		try {
			Coordenada2D c1=new Coordenada2D(-1,-4);
			System.out.println(c1.toString()+" creada correctamente");
			}catch(ExcepcionCoordenadaIncorrecta e){
				System.out.println(e.getMessage());
			}
		
	}
	@Test
	//TEST CONSTRUCTOR DE COPIA
	public void test1() throws ExcepcionCoordenadaIncorrecta {
		
		Coordenada2D c1=new Coordenada2D(1,4);
		Coordenada2D c2=new Coordenada2D(c1);
		Coordenada2D c3=new Coordenada2D(null);	
	}

	@Test
	//TEST SUMA
	public void test2() {
		try {
		Coordenada2D c1=new Coordenada2D(1,2);
		Coordenada2D c4=new Coordenada2D(1,2);
		Coordenada2D c3=new Coordenada2D(c1.suma(c4));
		System.out.println(c1.toString()+"+"+c4.toString()+"="+c3.toString());
		Coordenada c5=new Coordenada2D(c1.suma(null));
		}catch(ExcepcionCoordenadaIncorrecta e) {
		}
		

		
		
		
	}
}
