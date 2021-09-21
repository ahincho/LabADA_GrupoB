
import java.util.Scanner;

/* 
 * Autor: Hincho Jove, Angel Eduardo
 * 
 * Descripcion del problema: El presente problema pide ingresar un array estandar
 * por teclado, luego este arreglo estandar sera ordenado e imprimido por consola
 * 
 */

public class Ejercicio4 {
	
	public static void main(String[] args) {
		
		// Metodo main del programa
		
		int[] array = ingresarArray();
		System.out.print("Array Ingresado: ");
		imprimirArray(array);
		ordenarArray(array);
		System.out.print("Imprimiendo Array ordenado: ");
		imprimirArray(array);
		
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
		
		System.out.print("[ ");
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("]");
		
	}
	
	public static void ordenarArray(int[] array) {
		
		// Metodo 'ordenarArray' el cual recibe un arreglo estandar de
		// enteros, haciendo uso del algoritmo de ordenacion por insercion
		// se ordena este arreglo de manera interna, no devuelve nada ya que
		// el arreglo queda ordenado sin tener que crear otra copia
		
		int pos, temp;
		for(int i = 0; i < array.length; i++) {
			pos = i;
			temp = array[i];
			while((pos > 0) && (array[pos - 1] > temp)) {
				array[pos] = array[pos - 1];
				pos--;
			}
			array[pos] = temp;
		}
		
	}
	
}
