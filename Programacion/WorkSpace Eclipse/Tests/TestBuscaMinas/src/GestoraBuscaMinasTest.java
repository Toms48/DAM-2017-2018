import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GestoraBuscaMinasTest {

	@Test
	void testCrearTablero() {
		
		GestoraBuscaMinas gestora = new GestoraBuscaMinas();
		
		casilla [][] tablero1 = gestora.CrearTablero();
		
		casilla [][] tablero2 = gestora.CrearTablero();
		
		assertArrayEquals(tablero1, tablero2);
	}
	
	/*@Test
	void testContadorMinas() {
		
		GestoraBuscaMinas gestora = new GestoraBuscaMinas();
		
		casilla [][] tablero1 = gestora.CrearTablero();
		casilla [][] tablero2 = gestora.CrearTablero();
		
		int cmTablero1 = 0;
		int cmTablero2 = 0;
		
		for(int i=0; i<tablero1.length; i++) {
			for(int j=0; j<tablero1.length; j++) {
				cmTablero1 = gestora.ContadorMinas(tablero1, i, j);
			}
			
		}
		
		for(int i=0; i<tablero1.length; i++) {
			for(int j=0; j<tablero1.length; j++) {
				cmTablero2 = gestora.ContadorMinas(tablero2, i, j);
			}
			
		}
			
		assertEquals(10, cmTablero1, "Que no da 10 y tendría que dar 10.");
		
		assertEquals(10, cmTablero2, "Que no da 10 y tendría que dar 10.");
	}*/

}
