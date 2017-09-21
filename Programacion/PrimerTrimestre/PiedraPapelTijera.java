/*  Nombre: PiedraPapelTijera
 * 
 *  Análisis:
 * 		El clásico juego de piedra, papel o tijera, llevará una cuenta de las partidas ganadas y perdidas de la maquina
 * 		y del jugador, así como los empates, podremos elejir el numero de partidas a jugar.
 * 			(EN OTRA VERSION ESTARÁ QUE SOLO PUEDAS ELEGIR UNA CANTIDAD IMPAR DE PARTIDAS)
 * 
 * 		-Entradas: Opcion de para jugar, opcion para salir, opcion para repetir (el juego), opcionUsuario
 * 		-Salidas: Mensaje de partida ganada o perdida por el jugador y mensaje de empate
 * 
 * 	PG:
 * 		Inicio
 * 			Hacer
 * 				MostrarMenu
 * 				LeerOpcionMenu
 * 			Mientras OpcionMenu sea 0, 1 o 2
 * 
 * 			Si OpcionMenu es 1
 * 				Hacer
 * 					PreguntarPartidas
 * 				Mientras NumeroPartidas=<0
 * 				Hacer
 * 					Hacer
 * 						MostrarMenuPPT
 * 						LeerOpcionJugador
 * 					Mientras OpcionJugador no sea 1, 2 o 3
 * 
 * 					GenerarAleatorio
 * 
 * 					Si OpcionJugador es igual a OpcionPc
 * 						ContadorEmpate aumenta
 * 						PartidasJugadas aumenta
 * 					Fin_Si
 * 
 * 					Sino
 * 						Si OpcionJugador==1 y OpcionPc==2 o OpcionJugador==2 y OpcionPc==3 o OpcionJugador==3 y OpcionPc==1
 * 							ContadorGanarPc aumenta
 * 							ContadorPerderJugador aumenta (Esto no se lo meteré al final)
 * 							PartidasJugadas aumenta
 * 						Fin_Si
 * 						
 * 						Sino
 * 							ContadorGanarJugador aumenta
 * 							ContadorPerderPc aumenta (Esto no se lo meteré al final)
 * 							PartidasJugadas aumenta
 * 						Fin_Sino
 * 					Fin_Sino
 * 				Mientras PartidasJugadas != NumeroPartidas
 * 			Fin_Si
 * 		Fin 
 * 
 */

import java.util.*;

public class PiedraPapelTijera {
	
	public static void main (String[] args) {
		
//Inicio
	//Hacer
	do{
		
	}
		Hacer
			MostrarMenu
			LeerOpcionMenu
		Mientras OpcionMenu sea 0, 1 o 2
 
		Si OpcionMenu es 1
			Hacer
				PreguntarPartidas
			Mientras NumeroPartidas=<0
			Hacer
				Hacer
					MostrarMenuPPT
					LeerOpcionJugador
				Mientras OpcionJugador no sea 1, 2 o 3
 
				GenerarAleatorio
 
				Si OpcionJugador es igual a OpcionPc
					ContadorEmpate aumenta
					PartidasJugadas aumenta
				Fin_Si
 
				Sino
 				Si OpcionJugador==1 y OpcionPc==2 o OpcionJugador==2 y OpcionPc==3 o OpcionJugador==3 y OpcionPc==1
 					ContadorGanarPc aumenta
					ContadorPerderJugador aumenta (Esto no se lo meteré al final)
 					PartidasJugadas aumenta
 				Fin_Si
 						
 				Sino
 					ContadorGanarJugador aumenta
 					ContadorPerderPc aumenta (Esto no se lo meteré al final)
 					PartidasJugadas aumenta
 				Fin_Sino
			Fin_Sino
 			Mientras PartidasJugadas != NumeroPartidas
 		Fin_Si
 	
 Fin 
		
	}
}

