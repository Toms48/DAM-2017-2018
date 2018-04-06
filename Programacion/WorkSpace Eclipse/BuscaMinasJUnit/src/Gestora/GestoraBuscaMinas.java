package Gestora;


import Clases.Casilla;
import Excepciones.ExcepcionCasilla;

import java.util.Random;
import java.util.Scanner;

public class GestoraBuscaMinas {

/**************************************************************************
 Interfaz
 Comentario: Creará un tablero de 8 por 8 con objetos casillas
 Cabecera: Casilla[][] CrearTableroFacil()
 Precondiciones: No tiene
 Entrada: No hay
 Salida: Un array bidimensional 8x8
 E/S: No hay
 Postcondiciones: El array tendrá un tamaño de 8x8 con 10 minas (cargadas aleatoriamente)
 **************************************************************************/
    public Casilla[][] CrearTableroFacil(){

        Casilla[][] tablero = new Casilla[8][8];

        //Casilla casillaVacia = new Casilla();   Al crear un solo objeto[...]

        Random random = new Random();

        int aleatorioI;
        int aleatorioJ;

        for(int i=0; i<tablero.length; i++){
            for(int j=0; j<tablero.length; j++){
                //tablero[i][j] = casillaVacia;   [...]e introducirlo cada vez en todas las casillas, al cambiarlo se cambian todos.
                tablero[i][j] = new Casilla(false, false, false, 0, ' ');
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

        for(int i=0; i<tablero.length; i++){
            for(int j=0; j<tablero.length; j++){
                try{
                    tablero[i][j].setNumero(ContadorMinas(tablero, i,j, 7));
                }
                catch(ExcepcionCasilla mensaje){
                    System.out.println(mensaje);
                }
            }
        }

        return tablero;
    }

/**************************************************************************
 Interfaz
 Comentario: Creará un tablero de 16 por 16 con objetos casillas
 Cabecera: Casilla[][] CrearTableroMedio()
 Precondiciones: No tiene
 Entrada: No hay
 Salida: Un array bidimensional 16x16
 E/S: No hay
 Postcondiciones: El array tendrá un tamaño de 16x16 con 40 minas (cargadas aleatoriamente)
 **************************************************************************/
    public Casilla[][] CrearTableroMedio(){

        Casilla[][] tablero = new Casilla[16][16];

        //Casilla casillaVacia = new Casilla();   Al crear un solo objeto[...]

        Random random = new Random();

        int aleatorioI;
        int aleatorioJ;

        for(int i=0; i<tablero.length; i++){
            for(int j=0; j<tablero.length; j++){
                //tablero[i][j] = casillaVacia;   [...]e introducirlo cada vez en todas las casillas, al cambiarlo se cambian todos.
                tablero[i][j] = new Casilla(false, false, false, 0, ' ');
            }
        }

        for(int contadorMinas=0; contadorMinas!=40; contadorMinas++){

            aleatorioI = random.nextInt(16);
            aleatorioJ = random.nextInt(16);

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

        for(int i=0; i<tablero.length; i++){
            for(int j=0; j<tablero.length; j++){
                try{
                    tablero[i][j].setNumero(ContadorMinas(tablero, i,j, 15));
                }
                catch(ExcepcionCasilla mensaje){
                    System.out.println(mensaje);
                }
            }
        }

        return tablero;
    }

/**************************************************************************
 Interfaz
 Comentario: Creará un tablero de 30 por 30 con objetos casillas
 Cabecera: Casilla[][] CrearTableroDificil()
 Precondiciones: No tiene
 Entrada: No hay
 Salida: Un array bidimensional 30x30
 E/S: No hay
 Postcondiciones: El array tendrá un tamaño de 16x16 con 40 minas (cargadas aleatoriamente)
 **************************************************************************/
    public Casilla[][] CrearTableroDificil(){

        Casilla[][] tablero = new Casilla[30][30];

        //Casilla casillaVacia = new Casilla();   Al crear un solo objeto[...]

        Random random = new Random();

        int aleatorioI;
        int aleatorioJ;

        for(int i=0; i<tablero.length; i++){
            for(int j=0; j<tablero.length; j++){
                //tablero[i][j] = casillaVacia;   [...]e introducirlo cada vez en todas las casillas, al cambiarlo se cambian todos.
                tablero[i][j] = new Casilla(false, false, false, 0, ' ');
            }
        }

        for(int contadorMinas=0; contadorMinas!=99; contadorMinas++){

            aleatorioI = random.nextInt(30);
            aleatorioJ = random.nextInt(30);

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

        for(int i=0; i<tablero.length; i++){
            for(int j=0; j<tablero.length; j++){
                try{
                    tablero[i][j].setNumero(ContadorMinas(tablero, i,j, 29));
                }
                catch(ExcepcionCasilla mensaje){
                    System.out.println(mensaje);
                }
            }
        }

        return tablero;
    }

/**************************************************************************
 Interfaz
 Comentario: Creará un tablero de 32 por 32 con objetos casillas
 Cabecera: Casilla[][] CrearTableroImposible()
 Precondiciones: No tiene
 Entrada: No hay
 Salida: Un array bidimensional 32x32
 E/S: No hay
 Postcondiciones: El array tendrá un tamaño de 32x32 con 666 minas (cargadas aleatoriamente)
 **************************************************************************/
    public Casilla[][] CrearTableroImposible(){

        Casilla[][] tablero = new Casilla[32][32];

        //Casilla casillaVacia = new Casilla();   Al crear un solo objeto[...]

        Random random = new Random();

        int aleatorioI;
        int aleatorioJ;

        for(int i=0; i<tablero.length; i++){
            for(int j=0; j<tablero.length; j++){
                //tablero[i][j] = casillaVacia;   [...]e introducirlo cada vez en todas las casillas, al cambiarlo se cambian todos.
                tablero[i][j] = new Casilla(false, false, false, 0, ' ');
            }
        }

        for(int contadorMinas=0; contadorMinas!=666; contadorMinas++){

            aleatorioI = random.nextInt(32);
            aleatorioJ = random.nextInt(32);

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

        for(int i=0; i<tablero.length; i++){
            for(int j=0; j<tablero.length; j++){
                try{
                    tablero[i][j].setNumero(ContadorMinas(tablero, i,j, 31));
                }
                catch(ExcepcionCasilla mensaje){
                    System.out.println(mensaje);
                }
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
            if(i>=10){
                System.out.print(i+1 +" ");
            }
            else{
                System.out.print(" " +(i+1) +" ");
            }
        }
        System.out.print("\n");

        for(int i=0; i<tablero.length; i++){
            if(i!=0) {
                System.out.print("\n");
                //System.out.println(" " +i+1);
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
            System.out.print(" " +(i+1));
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
            if(i>=10){
                System.out.print(i+1 +" ");
            }
            else{
                System.out.print(" " +(i+1) +" ");
            }
        }
        System.out.print("\n");

        for(int i=0; i<tablero.length; i++){
            if(i!=0) {
                System.out.print("\n");
            }

            for(int j=0; j<tablero.length; j++){

                if(tablero[i][j].getMina()==true){
                    System.out.print("[" +tablero[i][j].getDibujo() +"]");
                }
                else{
                    if(tablero[i][j].getDescubierto()==false){
                        System.out.print("[■]");
                    }
                    else{
                        if(tablero[i][j].getNumero()==0){
                            System.out.print("[" +tablero[i][j].getDibujo() +"]");
                        }
                        else{
                            System.out.print("[" +tablero[i][j].getNumero() +"]");
                        }

                    }
                }

            }
            System.out.print(" " +(i+1));
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
 Comentario: Pintará el tablero
 Cabecera: void PintarTablero(Casilla[][] tablero)
 Precondiciones: No tiene
 Entrada:
    - Un array bidimensional de casillas
    - Un int para la posicion de la i
    - Un int para la posicion de la j
    - Un int para el nivel de dificultad
 Salida: No hay
 E/S: No hay
 Postcondiciones: No tiene
 **************************************************************************/
    public void PintarTablero(Casilla[][] tablero, int i, int j, int nivel){
        if(DescubrirCasilla(tablero,i,j,nivel) == -1){
            PintarTableroPerdedor(tablero);
        }
        else {
            PintarTableroJugador(tablero);
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
    public int ContadorMinas(Casilla[][] tablero, int i, int j, int nivel){

        int cm = 0;

            for(int ii=i-1 ; ii<((i-1)+3); ii++){
                for(int jj=j-1; jj<((j-1)+3); jj++){

                    if((ii>=0 && ii<=nivel) && (jj>=0 && jj<=nivel)) {
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
 Comentario: Según una posicion del tablero contará cuantas minas tiene a su alrededor
 Cabecera: int ContadorNoDescubierto(Casilla[][] tablero)
 Precondiciones: No tiene
 Entrada:
 - Un array bidimensional de casillas
 Salida: Un int
 E/S: No hay
 Postcondiciones: Será mayor que 0
 **************************************************************************/
    public int ContadorNoDescubierto(Casilla[][] tablero){

        int cd = 0;

        for(int i=0 ; i<tablero.length; i++){
            for(int j=0; j<tablero.length; j++){

                if(tablero[i][j].getDescubierto()==false){
                    cd++;
                }
            }
        }
        return cd;
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
     - Un int para saber el nivel de dificultad
 Salida: Un int
 E/S: No hay
 Postcondiciones:
    -   0 cuando el numero es cero y no hay mina
    -   1 cuadno el numero es mayor que cero y no hay mina
    -  -1 cuando hay una mina
 **************************************************************************/
    public int DescubrirCasilla(Casilla[][] tablero, int i, int j, int nivel){


        boolean hayMina = tablero[i][j].getMina();
        int hayNumero = tablero[i][j].getNumero();

        int ret;

        if(hayMina == false){
            if(hayNumero == 0){
                ret = 0;//0 porque no hay numero ni mina

                for(int ii=i-1 ; ii<((i-1)+3); ii++){
                    for(int jj=j-1; jj<((j-1)+3); jj++){

                        if((ii>=0 && ii<=nivel) && (jj>=0 && jj<=nivel)) {
                            if (ii != i || jj != j) {

                                if(tablero[ii][jj].getDescubierto() == false){
                                    tablero[ii][jj].setDescubierto(true);

                                    DescubrirCasilla(tablero,ii,jj, nivel); //Llamada recursiva
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

/**************************************************************************
Interfaz
    Comentario: Ejecutará el juego en modo facil, dimensiones 8x8 y 10 minas
    Cabecera: void NivelFacil()
    Precondiciones: No tiene
    Entrada: No hay
    Salida: No hay
    E/S: No hay
    Postcondiciones: No tiene
**************************************************************************/
    public void NivelFacil(){

        Casilla[][] tableroFacil;
        int i;
        int j;

        Scanner teclado = new Scanner(System.in);
        tableroFacil = CrearTableroFacil();

        PintarTableroJugador(tableroFacil);

        do{
            do{
                System.out.print("\n\nIntroduzca la fila: ");
                i = teclado.nextInt();
                System.out.print("Introduzca la columna: ");
                j = teclado.nextInt();
            }
            while((i<1 || i>8) || (j<1 || j>8));

            PintarTablero(tableroFacil, i-1, j-1, 7);
        }
        while((DescubrirCasilla(tableroFacil, i-1, j-1, 7) != -1) && (ContadorNoDescubierto(tableroFacil) != 10));

        if(DescubrirCasilla(tableroFacil, i-1, j-1, 7) == -1){
            System.out.println("\nPa tu casa.");
        }

        if(ContadorNoDescubierto(tableroFacil) == 10){
            System.out.println("\nMieo, has ganao");
        }
    }

/**************************************************************************
 Interfaz
 Comentario: Ejecutará el juego en modo medio, dimensiones 16x16 y 40 minas
 Cabecera: void NivelMedio()
 Precondiciones: No tiene
 Entrada: No hay
 Salida: No hay
 E/S: No hay
 Postcondiciones: No tiene
 **************************************************************************/
    public void NivelMedio(){

        Casilla[][] tableroMedio;
        int i;
        int j;

        Scanner teclado = new Scanner(System.in);
        tableroMedio = CrearTableroMedio();

        PintarTableroJugador(tableroMedio);

        do{
            do{
                System.out.print("\n\nIntroduzca la fila: ");
                i = teclado.nextInt();
                System.out.print("Introduzca la columna: ");
                j = teclado.nextInt();
            }
            while((i<1 || i>16) || (j<1 || j>16));

            PintarTablero(tableroMedio, i-1, j-1, 15);
        }
        while((DescubrirCasilla(tableroMedio, i-1, j-1, 15) != -1) && (ContadorNoDescubierto(tableroMedio) != 40));

        if(DescubrirCasilla(tableroMedio, i-1, j-1, 15) == -1){
            System.out.println("\nPa tu casa.");
        }

        if(ContadorNoDescubierto(tableroMedio) == 40){
            System.out.println("\nMieo, has ganao");
        }
    }

/**************************************************************************
 Interfaz
 Comentario: Ejecutará el juego en modo dificil, dimensiones 30x30 y 99 minas
 Cabecera: void NivelDificil()
 Precondiciones: No tiene
 Entrada: No hay
 Salida: No hay
 E/S: No hay
 Postcondiciones: No tiene
 **************************************************************************/
    public void NivelDificil(){

        Casilla[][] tableroDificil;
        int i;
        int j;

        Scanner teclado = new Scanner(System.in);
        tableroDificil = CrearTableroDificil();

        PintarTableroJugador(tableroDificil);

        do{
            do{
                System.out.print("\n\nIntroduzca la fila: ");
                i = teclado.nextInt();
                System.out.print("Introduzca la columna: ");
                j = teclado.nextInt();
            }
            while((i<1 || i>30) || (j<1 || j>30));

            PintarTablero(tableroDificil, i-1, j-1, 29);
        }
        while((DescubrirCasilla(tableroDificil, i-1, j-1, 29) != -1)  && (ContadorNoDescubierto(tableroDificil) != 99));

        if(DescubrirCasilla(tableroDificil, i-1, j-1, 29) == -1){
            System.out.println("\nPa tu casa.");
        }

        if(ContadorNoDescubierto(tableroDificil) == 99){
            System.out.println("\nMieo, has ganao");
        }

    }

/**************************************************************************
 Interfaz
 Comentario: Ejecutará el juego en modo dificil, dimensiones 32x32 y 666 minas
 Cabecera: void NivelImposible()
 Precondiciones: No tiene
 Entrada: No hay
 Salida: No hay
 E/S: No hay
 Postcondiciones: No tiene
 **************************************************************************/
    public void NivelImposible(){

        Casilla[][] tableroImposible;
        int i;
        int j;

        Scanner teclado = new Scanner(System.in);
        tableroImposible = CrearTableroImposible();

        PintarTableroJugador(tableroImposible);

        do{
            do{
                System.out.print("\n\nIntroduzca la fila: ");
                i = teclado.nextInt();
                System.out.print("Introduzca la columna: ");
                j = teclado.nextInt();
            }
            while((i<1 || i>32) || (j<1 || j>32));

            PintarTablero(tableroImposible, i-1, j-1, 31);
        }
        while((DescubrirCasilla(tableroImposible, i-1, j-1, 31) != -1) && (ContadorNoDescubierto(tableroImposible) != 666));

        if(DescubrirCasilla(tableroImposible, i-1, j-1, 31) == -1){
            System.out.println("\nPa tu casa.");
        }

        if(ContadorNoDescubierto(tableroImposible) == 666){
            System.out.println("\nMieo, has ganao");
        }

    }

}