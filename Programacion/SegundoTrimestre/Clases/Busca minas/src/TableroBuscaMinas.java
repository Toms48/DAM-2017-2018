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
 * 		- PintarTablero
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
	public TableroBuscaMinas(){
		for(int i=0; i<tablero.length; i++){
			for(int j=0; j<tablero.length; j++){
				tablero[i][j] = new casilla();
			}
		}
	}
	
	//Constructor con parámetros
	public TableroBuscaMinas(casilla c){
		for(int i=0; i<tablero.length; i++){
			for(int j=0; j<tablero.length; j++){
				tablero[i][j] = c;
			}
		}
	}
	
	//Constructor copia
	public TableroBuscaMinas(TableroBuscaMinas tableroCopia){
		this.tablero = tableroCopia.getTablero();
	}
	
	//Gets
	public casilla[][] getTablero(){
		return tablero;
	}
	
	//Métodos sobrescritos
	
	//Métodos añadidos
	public void PintarTablero(){
		
		for(int i=0; i<getTablero().length; i++){
			
			if(i != 0){
				System.out.print("\n");
			}
			
			for(int j=0; j<getTablero().length; j++){
				System.out.print("[ ]");
			}
		}
		
	}
	
}

