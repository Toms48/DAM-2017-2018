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

		//gestoraBuscaMinas.PintarTablero(tablero);

		System.out.println("\n+----------------------+");

		//gestoraBuscaMinas.PintarTableroAdmin(tablero);

		System.out.println("\n+----------------------+");

		/*System.out.println("Cantidad minas: " +gestoraBuscaMinas.ContadorMinas(tablero, 0,0));*/

		for(int i=0; i<tablero.length; i++){
			for(int j=0; j<tablero.length; j++){
				try{
					tablero[i][j].setNumero(gestoraBuscaMinas.ContadorMinas(tablero, i,j));
				}
				catch(ExcepcionCasilla mensaje){
					System.out.println(mensaje);
				}
			}
		}

		/*try{
			tablero[0][0].setNumero(gestoraBuscaMinas.ContadorMinas(tablero, 0,0));
		}
		catch(ExcepcionCasilla mensaje){
			System.out.println(mensaje);
		}*/

		System.out.println("\n+----------------------+");

		gestoraBuscaMinas.PintarTableroAdmin(tablero);

		System.out.println("\n+----------------------+");

		//gestoraBuscaMinas.PintarTableroDescubierto(tablero);

		System.out.println("\n+----------------------+");

		gestoraBuscaMinas.DescubrirCasilla(tablero,1,1);

		if(gestoraBuscaMinas.DescubrirCasilla(tablero,1,1) == -1){
			gestoraBuscaMinas.PintarTableroDescubierto(tablero);
		}
		else {
			gestoraBuscaMinas.PintarTablero(tablero);
		}

	}
}

