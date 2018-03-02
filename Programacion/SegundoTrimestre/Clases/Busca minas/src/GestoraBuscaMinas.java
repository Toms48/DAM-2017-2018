import java.util.Random;

public class GestoraBuscaMinas {

    public casilla [][] CrearTablero(){

        casilla [][] tablero = new casilla[8][8];

        casilla casillaVacia = new casilla();

        Random random = new Random();

        int aleatorioI;
        int aleatorioJ;

        aleatorioI = random.nextInt(8);
        aleatorioJ = random.nextInt(8);

        for(int i=0; i<tablero.length; i++){
            for(int j=0; j<tablero.length; j++){
                tablero[i][j] = casillaVacia;
            }
        }

        for(int contadorMinas=0; contadorMinas!=10; contadorMinas++){
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

    /*public void pintarTablero(){
        for(int i=0; i<tablero.length; i++){
            for(int j=0; j<tablero.length; j++){
                tablero[i][j] = casillaVacia;
            }
        }
    }*/

}
