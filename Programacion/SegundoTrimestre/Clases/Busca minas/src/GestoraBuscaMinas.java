import java.util.Random;

public class GestoraBuscaMinas {

    public casilla [][] CrearTablero(){

        casilla [][] tablero = new casilla[8][8];

        //casilla casillaVacia = new casilla();   Al crear un solo objeto[...]

        Random random = new Random();

        int aleatorioI;
        int aleatorioJ;

        for(int i=0; i<tablero.length; i++){
            for(int j=0; j<tablero.length; j++){
                //tablero[i][j] = casillaVacia;   [...]e introducirlo cada vez en todas las casillas, al cambiarlo se cambian todos.
                tablero[i][j] = new casilla(false, false, false, 0, '■');
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

    public void PintarTablero(casilla [][] tablero){
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

    public void PintarTableroDescubierto(casilla [][] tablero){
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

    public void PintarTableroAdmin(casilla [][] tablero){
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

    public int ContadorMinas(casilla [][] tablero, int i, int j){

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

    public int DescubrirCasilla(casilla [][] tablero, int i, int j){

        int ret;

        boolean hayMina = tablero[i][j].getMina();
        int hayNumero = tablero[i][j].getNumero();

        if(hayMina == false){
            if(hayNumero == 0){
                ret = 0;//0 porque no hay numero ni mina

                for(int ii=i-1 ; ii<((i-1)+3); ii++){
                    for(int jj=j-1; jj<((j-1)+3); jj++){

                        if((ii>=0 && ii<=7) && (jj>=0 && jj<=7)) {
                            if (ii != i || jj != j) {

                                if(tablero[ii][jj].getDescubierto() == false){
                                    tablero[ii][jj].setDescubierto(true);

                                    DescubrirCasilla(tablero,ii,jj);
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
