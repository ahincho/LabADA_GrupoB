
import java.util.Scanner;

/* 
 * Autor: Hincho Jove, Angel Eduardo
 * 
 * Descripcion del problema: El presente problema nos pide crear
 * un codigo para leer un array por entrada estandar y sumar sus
 * elementos para finalmente mostrarlos por consola
 *
 */

public class Ejercicio1 {
	
	public static void main(String[] args) {
		
		// Metodo main del programa
		
		int[] array = ingresarArray();
		imprimirArray(array);
		System.out.println("Suma del Array: " + sumarArray(array));
		
	}
	
	public static int[] ingresarArray() {
		
		// Metodo auxiliar para ingresar un array por entrada estandar
		
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
	
	public static int sumarArray(int[] array) {
		
		// Metodo 'sumarArray' recibe un array estandar de enteros y
		// retornar una variable de tipo entero que es la suma de sus
		// elementos, elementos del array recibido
		
		int acumulado = 0;
		for(int i = 0; i < array.length; i++) {
			acumulado += array[i];
		}
		return acumulado;
		
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
	
}
