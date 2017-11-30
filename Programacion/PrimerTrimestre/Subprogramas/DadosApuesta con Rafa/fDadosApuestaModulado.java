/*
 * 
 * 
 */

import java.util.Random;

public class fDadosApuestaModulado {
	
/**************************************************************************	
MT
	Nec: No hay
	Dev: numero
	Nec/Dev: No hay
	Restriccion: No hay

Interfaz
	Comentario: Subprograma que genera dos numeros aleatorios simulando dos dados y suma las dos cifras de estos 
	Cabecera: numero GenerarSumarDados()
	Precondiciones: No hay
	Entrada: No hay
	Salida: numero
	E/S: No hay
	Postcondiciones: El numero debe de estar comprendido entre 2 y 12
**************************************************************************/	
	
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
	
/**************************************************************************	
MT
	Nec:
		- numero para el numero por el que se apuesta
		- numero para la suma de sus dados
	Dev: numero
	Nec/Dev: No hay
	Restriccion: No hay

Interfaz
	Comentario: Subprograma que calcula la diferencia entre el numero que se cree que saldrá y el numero que sale realmente
	Cabecera: numero CalcularDiferenciaApuesta(numero numeroElegido, numero sumaDados)
	Precondiciones: No hay
	Entrada:
		- numero para el numero por el que se apuesta
		- numero para la suma de sus dados
	Salida: numero
	E/S: No hay
	Postcondiciones: el numero siempre sera positivo
**************************************************************************/	
	
	public static int CalcularDiferenciaApuesta(int numeroElegido, int sumaDados){
		
		int diferencia = 0;
		
		diferencia = numeroElegido - sumaDados;
					
		if(diferencia < 0){
			diferencia = diferencia * -1;
		}
		
		return diferencia;
		
	}
	
}

