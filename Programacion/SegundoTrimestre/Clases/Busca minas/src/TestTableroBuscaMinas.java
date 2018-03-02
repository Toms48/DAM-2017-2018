public class TestTableroBuscaMinas {
	
	public static void main (String[] args) {
		
		/*//Constructores
		System.out.println(" ");
		System.out.println("*---------- Constructores ----------*");
		System.out.println(" ");
		
		//Constructor por defecto
		TableroBuscaMinas tableroPorDefecto = new TableroBuscaMinas();
		
		//Constructor con parámetros
		casilla casillaBlanco = new casilla();
		TableroBuscaMinas tablero1 = new TableroBuscaMinas(casillaBlanco);
		
		//Constructor copia
		TableroBuscaMinas tableroCopia = new TableroBuscaMinas(tablero1);
		
		//Gets
		System.out.println(" ");
		System.out.println("*---------- Gets ----------*");
		System.out.println(" ");
		
		System.out.println(tablero1.getTablero());
		
		//Métodos añadidos
		System.out.println(" ");
		System.out.println("*---------- Metodos aniadidos ----------*");
		System.out.println(" ");*/

		GestoraBuscaMinas gestoraBuscaMinas = new GestoraBuscaMinas();

		casilla [][] tablero = gestoraBuscaMinas.CrearTablero();

		for(int i=0; i<tablero.length; i++){
			System.out.print("Hola");
			for(int j=0; j<tablero.length; j++){
				System.out.println("[" +tablero[i][j].getDibujo() +"]");
			}
		}

	}
}

