/* Nombre: TableroBuscaMinas
 * 
 * Básicas:
 * 		- tablero => array bidimensional de casillas => Consultable
 * 
 * Derivadas: No tiene
 * 
 * Compartidas: No tiene
 * 
 * Restricciones:
 * 		- tablero será un array de 8 por 8
 * 
 * Métodos añadidos:
 * 
 * 
 * GETTERS y SETTERS
 * 
 * casilla[][] tablero
 * 		- casilla[][] getTablero();
 */


public class TableroBuscaMinas {
	
	//Atributos
	private casilla[][] tablero = new casilla[8][8];
	
	//Constructor por defecto
	public tablero(){
		for(int i=0; i<tablero.length; i++){
			for(int j=0; j<tablero.length; j++){
				tablero[i][j] = new casilla();
			}
		}
		return tablero;
	}
	
	//Constructor con parámetros
	public tablero(){
		
	}
	
	//Constructor copia
	/*public{
		
	}*/
	
	
}

