

import java.util.Random;

public class MisArrays {

    private int array[];

    /*public MisArrays(int[] array) {
        this.array = array;
    }*/
    
    /*Método para solucionar el método de arriba*/
    public void misArrays(int[] array) {
        this.array = array;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public void eliminarYSustituir (boolean sustituirPares){
        int i;
        int alea;
        
        if (sustituirPares){
            for (i=0;i<array.length;i++){
                if (array[i]%2==0){
                    alea = (int)(Math.random() * ((array[i]) + 1));
                    while (alea%2==0){
                        alea = (int)(Math.random() * ((array[i]) + 1));
                    }
                    array[i]= alea;
                }
            }
        }
        else{
            for (i=0;i<array.length-1;i++){
                if (array[i]%2!=0){
                    alea = 1 + (int)(Math.random() * ((array[i] - 1) + 1));
                    while (alea%2!=0){
                        alea = 1 + (int)(Math.random() * ((array[i] - 1) + 1));
                    }
                    array[i]= alea;
                }
            }
        }
    }
    
    public void eliminarYSustituirBIEN (boolean sustituirPares){
        //int i;
        int alea;

        Random random = new Random();
        
        if (sustituirPares){
            for (int i=0;i<array.length;i++){
                if (array[i]%2==0){
                    alea = (random.nextInt() * ((array[i]) + 1));
                    while (alea%2==0){
                        alea = (random.nextInt() * ((array[i]) + 1));
                    }
                    array[i]= alea;
                }
            }
        }
        else{
            for (int i=0;i<array.length-1;i++){
                if (array[i]%2!=0){
                    alea = 1 + (random.nextInt() * ((array[i] - 1) + 1));
                    while (alea%2!=0){
                        alea = 1 + (random.nextInt() * ((array[i] - 1) + 1));
                    }
                    array[i]= alea;
                }
            }
        }
    }

}
