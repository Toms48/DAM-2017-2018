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
        //Repetir
            //Mostrar menu y validar opcion*
            //Si opcion no es 0
                //Segun la opcion del menu
                    //Caso 0: Salir
                    //Caso 1: Nivel Facil*
                    //Caso 2: Nivel Medio*
                    //Caso 3: Nivel Dificil*
                    //Caso 666: Nivel Imposible*
                //Fin_Segun
            //Fin_Si
            //Preguntar, leer y validar respuesta para repetir
        //Mientras respuesta para repetir sea s
    //Fin

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
        System.out.println("1 ---> Nivel Facil");
        System.out.println("2 ---> Nivel Medio");
        System.out.println("3 ---> Nivel Dificil");
        System.out.println("0 ---> Salir");
    }

    public static void main (String args[]) {

        int opcionMenu = 0;

        Scanner teclado = new Scanner(System.in);

        //Inicio
            //Repetir
            do{
                //MostrarMenu y LeerValidarOpcion*
                do{
                    MostrarMenu();

                    System.out.println(" ");
                    System.out.println("Su opcion es: ");
                    opcionMenu = teclado.nextInt();
                }
                while((opcionMenu<0 || opcionMenu >3) && opcionMenu!=666);

                if(opcionMenu!=0){
                    //Segun la opcion del menu
                    switch(){
                        
                    }
                        //Caso 0: Salir
                        //Caso 1: Nivel Facil*
                        //Caso 2: Nivel Medio*
                        //Caso 3: Nivel Dificil*
                        //Caso 666: Nivel Imposible*
                    //Fin_Segun
                }//Fin_Si

                //Preguntar, leer y validar respuesta para repetir
            }
            while(opcionMenu != 0); //Mientras opcion no es 0
        //Fin

    }
}
