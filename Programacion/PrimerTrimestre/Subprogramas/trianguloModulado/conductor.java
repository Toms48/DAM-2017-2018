import java.io.*;
import java.util.Scanner;

public class conductor{
	public static void main(String[]args){
		
		int numeroFilas=0;
		char caracterRelleno=' ';
		
		numeroFilas = 4;
		caracterRelleno = 'A';
		funcionalidades.pintarPiramide(numeroFilas, caracterRelleno);
		
		numeroFilas = 2;
		caracterRelleno = 'h';
		funcionalidades.pintarPiramide(numeroFilas, caracterRelleno);
		
		numeroFilas = 7;
		caracterRelleno = '*';
		funcionalidades.pintarPiramide(numeroFilas, caracterRelleno);
	}
}
