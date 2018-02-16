/*	NEC: número, caracter.
	DEV: no hay.
	NEC/DEV: no hay.
	Restricciones: numero > 0, solo admite caracteres imprimibles.
Interfaz:
	Nombre: pintarPiramide
	Cabecera: pintarPiramide (int numero, char caracter)
	Precondiciones: numero > 0, solo admite caracteres imprimibles
	Entrada: número, carácter.
	Salida: ninguna.
	E/S: no hay.
	Postcondiciones: solo pinta en pantalla
*/

public class funcionalidades{
	public static void pintarPiramide(int numeroFilas, char caracter){
	   int contador=0,letraMostrada=0, espacios=0;
	   
        for(contador=0; contador<numeroFilas; contador++){
            for(espacios = numeroFilas - 1; espacios >=contador; espacios-- ){
                System.out.print(" ");
            }
            for(letraMostrada=0; letraMostrada<= contador+contador; letraMostrada++){
                System.out.print(caracter);
            }
            System.out.println();
        }
	}
}

