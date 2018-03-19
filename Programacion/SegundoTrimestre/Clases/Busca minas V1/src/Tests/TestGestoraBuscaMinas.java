package Tests;

import Clases.Casilla;
//import Excepciones.ExcepcionCasilla;

import Gestora.GestoraBuscaMinas;

public class TestGestoraBuscaMinas {
	
	public static void main (String[] args) {

		GestoraBuscaMinas gestoraBuscaMinas = new GestoraBuscaMinas(); //Como los métodos de la gestora no son static tenemos que crear un objeto gestora

		//Tests CrearTablero
		System.out.println("\n");
		System.out.println("*----------- Test CrearTablero -----------*");

		Casilla [][] tablero = gestoraBuscaMinas.CrearTableroFacil();

		//Tests PintarTableroJugador
		System.out.println("\n");
		System.out.println("*----------- Test PintarTableroJugador -----------*");

		gestoraBuscaMinas.PintarTableroJugador(tablero);

		//Tests PintarTableroPerdedor
		System.out.println("\n");
		System.out.println("*----------- Test PintarTableroPerdedor -----------*");

		gestoraBuscaMinas.PintarTableroPerdedor(tablero);

		//Tests PintarTableroAdmin
		System.out.println("\n");
		System.out.println("*----------- Test PintarTableroAdmin -----------*");

		gestoraBuscaMinas.PintarTableroAdmin(tablero);

		//Tests ContadorMinas
		System.out.println("\n");
		System.out.println("*----------- Test ContadorMinas -----------*");

		//System.out.print("Cantidad de minas al rededor de (1,1): " +gestoraBuscaMinas.ContadorMinas(tablero,1,1));

		//Tests PintarTablero y DescubrirCasilla (aquí también estoy probando DescubrirCasilla por lo que no le hago test por separado)
		System.out.println("\n");
		System.out.println("*----------- Test PintarTablero -----------*");

		gestoraBuscaMinas.PintarTablero(tablero,1,1, 8);

		System.out.println("\n");

		gestoraBuscaMinas.PintarTablero(tablero,6,6,18);

	}
}

