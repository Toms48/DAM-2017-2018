public class TestGestoraBuscaMinas {
	
	public static void main (String[] args) {

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

