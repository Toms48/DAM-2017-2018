package Clases;

public class TestUtil {
    public static void main (String[] args) {

        Util util = new Util();

       util.arrayAleatorio(5);

        for(int i=0; i < util.arrayAleatorio(5).length; i++){
            System.out.println(util.arrayAleatorio(5)[i]);
        }

    }
}
