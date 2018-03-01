public class TestTableroBuscaMinas {
	
	public static void main (String[] args) {
		
		//Constructores
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
		System.out.println(" ");
		
		tablero1.PintarTablero();
		
	}
}

