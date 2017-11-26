/*
 * 
 * 
 */

import java.util.Random;

public class fDadosApuestaModulado {
	
	public static int GenerarSumarDados () {
		
		int dado1 = 0;
		int dado2 = 0;
		
		int sumaDados = 0;
		
		Random random = new Random();
		
		dado1 = random.nextInt(6) +1; //Generar dado 1
					
		dado2 = random.nextInt(6) +1; //Generar dado 2
					
		sumaDados = dado1 + dado2; //Sumar dados
		
		return sumaDados;
		
	}
}

