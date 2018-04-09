package Tests;

import Clases.Casilla;
import Excepciones.ExcepcionCasilla;

public class TestCasilla {
	
	public static void main (String[] args) {
		
		//Tests constructores
		System.out.println(" ");
		System.out.println("*----------- Constructores -----------*");
		System.out.println(" ");
		
		//Constructor por defecto
		Casilla casillaPorDefecto = new Casilla();
		
		//Constructor con parámetros
		Casilla casilla1 = new Casilla(true, false, true, 0, '*');
		
		//Constructor copia
		Casilla casilla1Copia = new Casilla(casilla1);
		
		//Tests constructores
		System.out.println(" ");
		System.out.println("*----------- Gets -----------*");
		System.out.println(" ");
		
		System.out.println("Hay mina en PorDefecto: " +casillaPorDefecto.getMina());
		System.out.println("Hay bandera en PorDefecto: " +casillaPorDefecto.getBandera());
		System.out.println("Descubierto en PorDefecto: " +casillaPorDefecto.getDescubierto());
		System.out.println("Numero: " +casillaPorDefecto.getNumero());
		System.out.println("Dibujo: " +casillaPorDefecto.getDibujo());
		
		System.out.println(" ");
		
		System.out.println("Hay mina en 1: " +casilla1.getMina());
		System.out.println("Hay bandera en 1: " +casilla1.getBandera());
		System.out.println("Descubierto en 1: " +casilla1.getDescubierto());
		System.out.println("Numero de la Casilla 1: " +casilla1.getNumero());
		System.out.println("Dibujo de la Casilla 1: " +casilla1.getDibujo());
		
		//Tests Sets
		System.out.println(" ");
		System.out.println("*----------- Sets -----------*");
		System.out.println(" ");
		
		try{
			casilla1.setNumero(1);
			System.out.println("Nuevo numero de casilla1: " +casilla1.getNumero());
		}
		catch(ExcepcionCasilla mensaje){
			System.out.println(mensaje);
		}
		
		System.out.println(" ");
		
		try{
			casillaPorDefecto.setNumero(-1);
			System.out.println("Nuevo numero de casilla1: " +casilla1.getNumero());
		}
		catch(ExcepcionCasilla mensaje){
			System.out.println(mensaje);
		}
		
		//Tests toString
		System.out.println(" ");
		System.out.println("*----------- toString -----------*");
		System.out.println(" ");
		
		System.out.println(casillaPorDefecto.toString());
		System.out.println(" ");
		System.out.println(casilla1.toString());
		System.out.println(" ");
		System.out.println(casilla1Copia.toString());
		
		//Tests Clone
		System.out.println(" ");
		System.out.println("*----------- Clone -----------*");
		System.out.println(" ");
		
		System.out.println(casilla1.clone());
		
		//Tests Equals
		System.out.println(" ");
		System.out.println("*----------- Equals -----------*");
		System.out.println(" ");
		
		System.out.println(casilla1.equals(casilla1Copia));
		
	}
}