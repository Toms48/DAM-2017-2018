package Main;

/**************************************************************************************************************************
 * Nombre: MainBuscaMinas
 *
 * Comentario: El juego del busca minas.
 *
 * Análisis:
 * 		-Entra: Un numero para la opcion del menu, un caracter para repetir
 * 		-Salida: pinta por pantalla
 * 		-Requisitos: La respuesta tiene que ser 's' o 'n'
 * 					 El dinero inicial tiene que ser mayor que cero
 * 					 El numero de partidas tiene que ser mayor que cero
 * 					 La apuesta del Jugador no puede ser menor o igual que cero ni mayor que el dinero que tenga
 *
 *
 **************************************************************************************************************************/

//PG:
    //Inicio
        //Mostrar logo
        //Repetir
            //Mostrar menu* y validar opcion
            //Si opcion no es 0
                //Segun la opcion del menu
                    //Caso 1: Nivel Facil*
                    //Caso 2: Nivel Medio*
                    //Caso 3: Nivel Dificil*
                    //Caso 666: Nivel Imposible*
                //Fin_Segun
            //Fin_Si
        //Mientras respuesta para repetir sea s
    //Fin

import Gestora.GestoraBuscaMinas;
import Resguardos.RBuscaMinas;

import java.util.Scanner;

public class MainBuscaMinas {

/**************************************************************************
Interfaz
    Comentario: Pintará por pantalla el menu del juego
    Cabecera: void MostrarMenu()
    Precondiciones: No tiene
    Entrada: No tiene
    Salida: No hay
    E/S: No hay
    Postcondiciones: No tiene
 **************************************************************************/
    public static void MostrarMenu(){
        System.out.println("\n");
        System.out.println("1 ---> Nivel Facil");
        System.out.println("2 ---> Nivel Medio");
        System.out.println("3 ---> Nivel Dificil");
        System.out.println("0 ---> Salir");
    }

    public static void main (String args[]) {

        int opcionMenu = 0;

        Scanner teclado = new Scanner(System.in);

        GestoraBuscaMinas gestora = new GestoraBuscaMinas();
        RBuscaMinas resguardo = new RBuscaMinas();

        //Inicio
            //Repetir
            //Mostrar logo
                System.out.println("  ____                                _____  _____ _____ _____ ");
                System.out.println(" |  _ \\                        /\\    / ____|/ ____|_   _|_   _|       ,--.!,");
                System.out.println(" | |_) |_   _ ___  ___ __ _   /  \\  | (___ | |      | |   | |      __/   -*-");
                System.out.println(" |  _ <| | | / __|/ __/ _` | / /\\ \\  \\___ \\| |      | |   | |    ,d08b.  '|`");
                System.out.println(" | |_) | |_| \\__ \\ (_| (_| |/ ____ \\ ____) | |____ _| |_ _| |_   0088MM     ");
                System.out.println(" |____/ \\__,_|___/\\___\\__,_/_/    \\_\\_____/ \\_____|_____|_____|  `9MMP'     ");
                System.out.println(" ");
            do{
                //MostrarMenu y LeerValidarOpcion*
                do{
                    MostrarMenu();

                    //System.out.println(" ");
                    System.out.print("Su opcion es: ");
                    opcionMenu = teclado.nextInt();
                }
                while((opcionMenu<0 || opcionMenu >3) && opcionMenu!=666);

                if(opcionMenu!=0){
                    //Segun la opcion del menu
                    switch(opcionMenu){
                        case 1: //Caso 1: Nivel Facil*
                            //resguardo.NivelFacil();
                            gestora.NivelFacil();
                        break;

                        case 2: //Caso 2: Nivel Medio*
                            //resguardo.NivelMedio();
                            gestora.NivelMedio();
                        break;

                        case 3: //Caso 3: Nivel Dificil*
                            //resguardo.NivelDificil();
                            gestora.NivelDificil();
                        break;

                        case 666: //Caso 666: Nivel Imposible*
                            //resguardo.NivelImposible();
                            gestora.NivelImposible();

                        break;
                    }//Fin_Segun
                }//Fin_Si
            }
            while(opcionMenu != 0); //Mientras opcion no es 0
        //Fin

    }
}
