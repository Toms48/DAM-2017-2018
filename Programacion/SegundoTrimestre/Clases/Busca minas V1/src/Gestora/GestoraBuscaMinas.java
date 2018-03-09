package Gestora;


import Clases.Casilla;
import Excepciones.ExcepcionCasilla;

import java.util.Random;

public class GestoraBuscaMinas {

/**************************************************************************
 Interfaz
 Comentario: Creará un tablero de 8 por 8 con objetos casillas
 Cabecera: Casilla[][] CrearTablero()
 Precondiciones: No tiene
 Entrada: No hay
 Salida: Un array bidimensional 8x8
 E/S: No hay
 Postcondiciones: El array tendrá un tamaño de 8x8 con diez minas (cargadas aleatoriamente)
 **************************************************************************/
    public Casilla[][] CrearTablero(){

        Casilla[][] tablero = new Casilla[8][8];

        //Casilla casillaVacia = new Casilla();   Al crear un solo objeto[...]

        Random random = new Random();

        int aleatorioI;
        int aleatorioJ;

        for(int i=0; i<tablero.length; i++){
            for(int j=0; j<tablero.length; j++){
                //tablero[i][j] = casillaVacia;   [...]e introducirlo cada vez en todas las casillas, al cambiarlo se cambian todos.
                tablero[i][j] = new Casilla(false, false, false, 0, '■');
            }
        }

        for(int contadorMinas=0; contadorMinas!=10; contadorMinas++){

            aleatorioI = random.nextInt(8);
            aleatorioJ = random.nextInt(8);

            if(tablero[aleatorioI][aleatorioJ].getMina() == false){
                tablero[aleatorioI][aleatorioJ].setMina(true);
                try{
                    tablero[aleatorioI][aleatorioJ].setDibujo('*');
                }
                catch(ExcepcionCasilla mensaje){
                    System.out.println(mensaje);
                }

            }
            else{
                contadorMinas--;
            }
        }



        return tablero;
    }

/**************************************************************************
 Interfaz
 Comentario: Pintará por pantalla un tablero, si una casilla no está descubierta pinta un cuadrado
 Cabecera: void PintarTableroJugador(Casilla[][] tablero)
 Precondiciones: No tiene
 Entrada: Un array bidimensional de casillas
 Salida: No hay
 E/S: No hay
 Postcondiciones: No tiene
 **************************************************************************/
    public void PintarTableroJugador(Casilla[][] tablero){
        for(int i=0; i<tablero.length; i++){
            if(i!=0) {
                System.out.print("\n");
            }
            for(int j=0; j<tablero.length; j++){

                if(tablero[i][j].getDescubierto()==true){
                    if(tablero[i][j].getMina()==true){
                        System.out.print("[" +tablero[i][j].getDibujo() +"]");
                    }
                    else{
                        if(tablero[i][j].getNumero() == 0){

                            try{
                                tablero[i][j].setDibujo(' ');
                            }
                            catch(ExcepcionCasilla mensaje){
                                System.out.println(mensaje);
                            }

                            System.out.print("[" +tablero[i][j].getDibujo() +"]");
                        }
                        else{
                            System.out.print("[" +tablero[i][j].getNumero() +"]");
                        }

                    }
                }
                else{
                    System.out.print("[■]");
                }
            }
        }
    }

/**************************************************************************
 Interfaz
 Comentario: Pintará el tablero, pero mostrando todas las minas
 Cabecera: void PintarTableroPerdedor(Casilla[][] tablero)
 Precondiciones: No tiene
 Entrada: Un array bidimensional de casillas
 Salida: No hay
 E/S: No hay
 Postcondiciones: No tiene
 **************************************************************************/
    public void PintarTableroPerdedor(Casilla[][] tablero){
        for(int i=0; i<tablero.length; i++){
            if(i!=0) {
                System.out.print("\n");
            }
            for(int j=0; j<tablero.length; j++){

                if(tablero[i][j].getMina()==true){
                    System.out.print("[" +tablero[i][j].getDibujo() +"]");
                }
                else{
                    if(tablero[i][j].getNumero() == 0){
                        System.out.print("[" +tablero[i][j].getDibujo() +"]");
                    }
                    else{
                        System.out.print("[" +tablero[i][j].getNumero() +"]");
                    }

                }

            }
        }
    }

/**************************************************************************
 Interfaz
 Comentario: Pintará el tablero
 Cabecera: void PintarTablero(Casilla[][] tablero)
 Precondiciones: No tiene
 Entrada: Un array bidimensional de casillas
 Salida: No hay
 E/S: No hay
 Postcondiciones: No tiene
 **************************************************************************/
    public void PintarTablero(Casilla[][] tablero){
        if(DescubrirCasilla(tablero,1,1) == -1){
            PintarTableroPerdedor(tablero);
        }
        else {
            PintarTableroJugador(tablero);
        }
    }

/**************************************************************************
 Interfaz
 Comentario: Pintará el tablero entrto descubierto y donde no hay dibujo nos imprime su número de minas
 Cabecera: void PintarTableroAdmin(Casilla[][] tablero)
 Precondiciones: No tiene
 Entrada: Un array bidimensional de casillas
 Salida: No hay
 E/S: No hay
 Postcondiciones: No tiene
 **************************************************************************/
    public void PintarTableroAdmin(Casilla[][] tablero){
        for(int i=0; i<tablero.length; i++){
            if(i!=0) {
                System.out.print("\n");
            }
            for(int j=0; j<tablero.length; j++){

                if(tablero[i][j].getMina()==true){
                    System.out.print("[" +tablero[i][j].getDibujo() +"]");
                }
                else{
                    System.out.print("[" +tablero[i][j].getNumero() +"]");
                }

            }
        }
    }

/**************************************************************************
 Interfaz
 Comentario: Según una posicion del tablero contará cuantas minas tiene a su alrededor
 Cabecera: int ContadorMinas(Casilla[][] tablero, int i, int j)
 Precondiciones: No tiene
 Entrada:
    - Un array bidimensional de casillas
    - Un int, indica la fila del tablero
    - Un int, indica la columna del tablero
 Salida: Un int
 E/S: No hay
 Postcondiciones: Será 0 o mayor
 **************************************************************************/
    public int ContadorMinas(Casilla[][] tablero, int i, int j){

        int cm = 0;

            for(int ii=i-1 ; ii<((i-1)+3); ii++){
                for(int jj=j-1; jj<((j-1)+3); jj++){

                    if((ii>=0 && ii<=7) && (jj>=0 && jj<=7)) {
                        if (tablero[ii][jj].getMina() == true) {
                            cm++;
                        }
                    }

                }
            }

        return cm;
    }

/**************************************************************************
 Interfaz
 Comentario: Descubrirá la casilla que se le indique
 Cabecera: int DescubrirCasilla(Casilla[][] tablero, int i, int j)
 Precondiciones:
    - Ni i ni j pueden ser menores que cero ni tampoco mayores que 7
 Entrada:
     - Un array bidimensional de casillas
     - Un int, indica la fila del tablero
     - Un int, indica la columna del tablero
 Salida: Un int
 E/S: No hay
 Postcondiciones:
    -   0 cuando el numero es cero y no hay mina
    -   1 cuadno el numero es mayor que cero y no hay mina
    -  -1 cuando hay una mina
 **************************************************************************/
    public int DescubrirCasilla(Casilla[][] tablero, int i, int j){


        boolean hayMina = tablero[i][j].getMina();
        int hayNumero = tablero[i][j].getNumero();

        int ret;

        if(hayMina == false){
            if(hayNumero == 0){
                ret = 0;//0 porque no hay numero ni mina

                for(int ii=i-1 ; ii<((i-1)+3); ii++){
                    for(int jj=j-1; jj<((j-1)+3); jj++){

                        if((ii>=0 && ii<=7) && (jj>=0 && jj<=7)) {
                            if (ii != i || jj != j) {

                                if(tablero[ii][jj].getDescubierto() == false){
                                    tablero[ii][jj].setDescubierto(true);

                                    DescubrirCasilla(tablero,ii,jj); //Llamada recursiva
                                }

                            }
                            else{
                                tablero[ii][jj].setDescubierto(true);
                            }
                        }

                    }
                }
            }
            else{
                ret = 1;//1 porque hay un numero pero no una mina

                tablero[i][j].setDescubierto(true);

                //PintarTablero(tablero);
            }
        }else{
            ret = -1;//-1 porque hay una mina

            tablero[i][j].setDescubierto(true);

            //PintarTableroDescubierto(tablero);
        }
        return ret;
    }

}