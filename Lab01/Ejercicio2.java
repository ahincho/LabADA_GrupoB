
import java.util.Scanner;

/* 
 * Autor: Hincho Jove, Angel Eduardo
 * 
 * Descripcion del problema: El presente problema pide ingresar un array estandar
 * por teclado y luego imprimir por consola los elementos del array al reves.
 * 
 */

public class Ejercicio2 {
	
	public static void main(String[] args) {
		
		// Metodo main del programa
		
		int[] array = ingresarArray();
		imprimirArray(array);
		imprimirArrayReves(array);
		
	}
	
	public static int[] ingresarArray() {
		
		// Metodo auxiliar para ingresar un array por entrada estandar, pide
		// el ingreso de enteros y luego devuelve un array estandar de enteros
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Ingrese la cantidad de numeros a ingresar: ");
		int cantidad = sc.nextInt();
		int[] array = new int[cantidad];
		for(int i = 0; i < cantidad; i++) {
			System.out.print("Ingrese un numero: ");
			int ingreso = sc.nextInt();
			array[i] = ingreso;
		}
		sc.close();
		return array;
		
	}
	
	public static void imprimirArray(int[] array) {
		
		// Metodo auxiliar para imprimir el contenido de un array,
		// recibe un array estandar de enteros como argumento
		
		System.out.print("Array Ingresado: [ ");
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("]");
		
	}
	
	public static void imprimirArrayReves(int[] array) {
		
		// El metodo 'imprimirArrayReves' recibe como argumentos un arreglo
		// estandar de enteros, itera sobre cada uno de estos empezando desde
		// el ultimo elemento hasta el primero mientras lo imprime por consola
		
		System.out.print("Array Ingresado al Reves: [ ");
		int longitud = array.length;
		for(int i = 0; i < longitud; i++) {
			System.out.print(array[longitud - i - 1] + " ");
		}
		System.out.println("]");
		
	}
	
}
