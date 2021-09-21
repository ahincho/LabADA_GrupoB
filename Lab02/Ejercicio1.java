package ejercicios;

import java.util.Scanner;

/* 
 * Autor: Hincho Jove, Angel Eduardo
 * 
 * Descripcion del problema: El presente problema pide 3 enteros como
 * argumentos. Siendo, 'n' = cantidad de enteros a ingresar, 'k' = el
 * divisor para todos los 'n' numeros enteros y 't' = la cantidad de 
 * 'n' enteros que son divisibles entre 'k'
 * 
 */

public class Ejercicio1 {
	
	public static void main(String[] args) {
		
		// Metodo main del programa
		
		// Lectura de los valores de 'n' y 'k'
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Ingresar el valor de 'n': ");
		int n = scan.nextInt();
		System.out.print("Ingresar el valor de 'k': ");
		int k = scan.nextInt();
		
		// Ingreso de enteros a un arreglo de enteros estandar
		
		int[] array = ingresarArray(n);
		
		// Contador 't' de los numeros divisibles entre 'k'
		
		int t = contarDivisibles(array, k);
		
		System.out.println("\nHay " + t +
			" numero(s) divisible(s) entre " + k);
		
		scan.close();
		
	}
	
	public static int[] ingresarArray(int n) {
		
		// Metodo auxiliar que crea un arreglo de enteros
		// estandar de 'n' elementos ingresados por teclado.
		
		System.out.println("\n¡Creando el arreglo estandar!\n");
		int[] array = new int[n];
		Scanner scan = new Scanner(System.in);
		for(int i = 0; i < n; i++) {
			System.out.print("Ingresar un entero: ");
			array[i] = scan.nextInt();
		}
		scan.close();
		return array;
		
	}
	
	public static int contarDivisibles(int[] arr, int k) {
		
		// Metodo 'contarDivisibles' recibe como argumentos un arreglo
		// estandar de enteros y un numero entero 'k' que sera nuestro
		// divisor. Se itera en todos los 'n' elementos del arreglo
		
		// La variable 't' representa la cantidad de numeros divisible
		// entre 'k' que se encuentran dentro de nuestro arreglo estandar
		int t = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] % k == 0) {
				t++;
			}
		}
		return t;
		
	}
	
}
