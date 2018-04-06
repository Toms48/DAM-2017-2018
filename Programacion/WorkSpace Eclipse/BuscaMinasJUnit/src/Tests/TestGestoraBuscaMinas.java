package Tests;

import Clases.Casilla;
//import Excepciones.ExcepcionCasilla;

import Gestora.GestoraBuscaMinas;

public class TestGestoraBuscaMinas {
	
	public static void main (String[] args) {

		GestoraBuscaMinas gestoraBuscaMinas = new GestoraBuscaMinas(); //Como los métodos de la gestora no son static tenemos que crear un objeto gestora

		//Tests CrearTableroFacil
		System.out.println("\n");
		System.out.println("*----------- Test CrearTableroFacil -----------*");

		Casilla [][] tableroFacil = gestoraBuscaMinas.CrearTableroFacil();

		//Tests CrearTableroMedio
		System.out.println("\n");
		System.out.println("*----------- Test CrearTableroMedio -----------*");

		Casilla [][] tableroMedio = gestoraBuscaMinas.CrearTableroMedio();

		//Tests CrearTableroDificil
		System.out.println("\n");
		System.out.println("*----------- Test CrearTableroDificil -----------*");

		Casilla [][] tableroDificil = gestoraBuscaMinas.CrearTableroDificil();

		//Tests CrearTableroImposible
		System.out.println("\n");
		System.out.println("*----------- Test CrearTableroImposible -----------*");

		Casilla [][] tableroImposible = gestoraBuscaMinas.CrearTableroImposible();

		//Tests PintarTableroJugador
		System.out.println("\n");
		System.out.println("*----------- Test PintarTableroJugador -----------*");

		gestoraBuscaMinas.PintarTableroJugador(tableroFacil);
		System.out.println(" ");
		System.out.println(" ");
		gestoraBuscaMinas.PintarTableroJugador(tableroMedio);
		System.out.println(" ");
		System.out.println(" ");
		gestoraBuscaMinas.PintarTableroJugador(tableroDificil);
		System.out.println(" ");
		System.out.println(" ");
		gestoraBuscaMinas.PintarTableroJugador(tableroImposible);

		//Tests PintarTableroPerdedor
		System.out.println("\n");
		System.out.println("*----------- Test PintarTableroPerdedor -----------*");

		gestoraBuscaMinas.PintarTableroPerdedor(tableroFacil);
		System.out.println(" ");
		System.out.println(" ");
		gestoraBuscaMinas.PintarTableroPerdedor(tableroMedio);
		System.out.println(" ");
		System.out.println(" ");
		gestoraBuscaMinas.PintarTableroPerdedor(tableroDificil);
		System.out.println(" ");
		System.out.println(" ");
		gestoraBuscaMinas.PintarTableroPerdedor(tableroImposible);

		//Tests PintarTableroAdmin
		System.out.println("\n");
		System.out.println("*----------- Test PintarTableroAdmin -----------*");

		gestoraBuscaMinas.PintarTableroAdmin(tableroFacil);
		System.out.println(" ");
		System.out.println(" ");
		gestoraBuscaMinas.PintarTableroAdmin(tableroMedio);
		System.out.println(" ");
		System.out.println(" ");
		gestoraBuscaMinas.PintarTableroAdmin(tableroDificil);
		System.out.println(" ");
		System.out.println(" ");
		gestoraBuscaMinas.PintarTableroAdmin(tableroImposible);

		//Tests PintarTablero y DescubrirCasilla (aquí también estoy probando DescubrirCasilla por lo que no le hago test por separado)
		System.out.println("\n");
		System.out.println("*----------- Test PintarTablero -----------*");

		gestoraBuscaMinas.PintarTablero(tableroFacil,1,1, 7);

		System.out.println("\n");

		gestoraBuscaMinas.PintarTablero(tableroMedio,6,6,15);

		System.out.println("\n");

		gestoraBuscaMinas.PintarTablero(tableroDificil,4,4,29);

		System.out.println("\n");

		gestoraBuscaMinas.PintarTablero(tableroImposible,31,31,31);

		//Tests ContadorMinas
		System.out.println("\n");
		System.out.println("*----------- Test ContadorMinas -----------*");

		System.out.print("Cantidad de minas al rededor de (2,2): " +gestoraBuscaMinas.ContadorMinas(tableroFacil,2,2, 7));
		System.out.println(" ");
		System.out.println(" ");
		System.out.print("Cantidad de minas al rededor de (1,1): " +gestoraBuscaMinas.ContadorMinas(tableroMedio,0,0, 15));
		System.out.println(" ");
		System.out.println(" ");
		System.out.print("Cantidad de minas al rededor de (1,1): " +gestoraBuscaMinas.ContadorMinas(tableroDificil,1,1, 29));
		System.out.println(" ");
		System.out.println(" ");
		System.out.print("Cantidad de minas al rededor de (1,1): " +gestoraBuscaMinas.ContadorMinas(tableroImposible,1,1, 31));

	}
}

