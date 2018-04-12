package TestClaseHundirFlota;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Clases.HundirFlota;

class HundirFlotaTest {

	@Test
	void testHundirFlota16Unos() {
		int contadorUnos = 0;
		
		int[][] tablero ={ {1,1,1,1,1,0,0,0,0,0},
						   {0,0,0,0,0,0,0,0,0,0},
						   {1,1,1,1,0,0,0,0,0,0},
						   {0,0,0,0,0,0,0,0,0,0},
						   {1,1,1,0,0,0,0,0,0,0},
						   {0,0,0,0,0,0,0,0,0,0},
						   {1,1,0,0,0,0,0,0,0,0},
						   {0,0,0,0,0,0,0,0,0,0},
						   {1,1,0,0,0,0,0,0,0,0},
						   {0,0,0,0,0,0,0,0,0,0}
						   };
		
		for(int i=0; i<tablero.length; i++) {
			for(int j=0; j<tablero.length; j++) {
				if(tablero[i][j] == 1){
					contadorUnos++;
				}
			}
		}
		
		//Comprobamos que están los 16 unos
		assertEquals(16, contadorUnos);
	}
	
	@Test
	void testHundirFlota() {
		int[][] tablero ={ {1,1,1,1,1,0,0,0,0,0},
				   {0,0,0,0,0,0,0,0,0,0},
				   {1,1,1,1,0,0,0,0,0,0},
				   {0,0,0,0,0,0,0,0,0,0},
				   {1,1,1,0,0,0,0,0,0,0},
				   {0,0,0,0,0,0,0,0,0,0},
				   {1,1,0,0,0,0,0,0,0,0},
				   {0,0,0,0,0,0,0,0,0,0},
				   {1,1,0,0,0,0,0,0,0,0},
				   {0,0,0,0,0,0,0,0,0,0}
				   };
		
	}

}
