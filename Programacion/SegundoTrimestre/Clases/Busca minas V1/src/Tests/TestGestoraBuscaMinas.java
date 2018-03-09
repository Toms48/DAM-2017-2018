package Tests;

import Clases.Casilla;
//import Excepciones.ExcepcionCasilla;

import Gestora.GestoraBuscaMinas;

public class TestGestoraBuscaMinas {
	
	public static void main (String[] args) {

		GestoraBuscaMinas gestoraBuscaMinas = new GestoraBuscaMinas(); //Como los métodos de la gestora no son static tenemos que crear un objeto gestora

		//Tests CrearTablero
		System.out.println(" ");
		System.out.println("*----------- Test CrearTablero -----------*");
		System.out.println(" ");

		Casilla [][] tablero = gestoraBuscaMinas.CrearTablero();

		//Tests
		System.out.println(" ");
		System.out.println("*----------- Test PintarTablero -----------*");
		System.out.println(" ");

		//Tests PintarTableroJugador
		System.out.println(" ");
		System.out.println("*----------- Test PintarTableroJugador -----------*");
		System.out.println(" ");

		gestoraBuscaMinas.PintarTableroJugador(tablero);

		//Tests PintarTableroPerdedor
		System.out.println(" ");
		System.out.println("*----------- Test PintarTableroPerdedor -----------*");
		System.out.println(" ");

		gestoraBuscaMinas.PintarTableroPerdedor(tablero);

		//Tests PintarTablero
		System.out.println(" ");
		System.out.println("*----------- Test PintarTablero -----------*");
		System.out.println(" ");

		gestoraBuscaMinas.PintarTableroAdmin(tablero);

		/*//Tests PintarTablero
		System.out.println(" ");
		System.out.println("*----------- Test PintarTablero -----------*");
		System.out.println(" ");

		//gestoraBuscaMinas.PintarTablero(tablero);*/

		/*System.out.println("\n+----------------------+");

		//gestoraBuscaMinas.PintarTableroAdmin(tablero);

		System.out.println("\n+----------------------+");

		System.out.println("Cantidad minas: " +gestoraBuscaMinas.ContadorMinas(tablero, 0,0));

		for(int i=0; i<tablero.length; i++){
			for(int j=0; j<tablero.length; j++){
				try{
					tablero[i][j].setNumero(gestoraBuscaMinas.ContadorMinas(tablero, i,j));
				}
				catch(ExcepcionCasilla mensaje){
					System.out.println(mensaje);
				}
			}
		}

		System.out.println("\n+----------------------+");

		gestoraBuscaMinas.PintarTableroAdmin(tablero);

		System.out.println("\n+----------------------+");

		//gestoraBuscaMinas.PintarTableroDescubierto(tablero);

		System.out.println("\n+----------------------+");

		gestoraBuscaMinas.DescubrirCasilla(tablero,1,1);

		if(gestoraBuscaMinas.DescubrirCasilla(tablero,1,1) == -1){
			gestoraBuscaMinas.PintarTableroDescubierto(tablero);
		}
		else {
			gestoraBuscaMinas.PintarTablero(tablero);
		}*/

	}
}

