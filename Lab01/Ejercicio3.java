
import java.util.Scanner;

/* 
 * Autor: Hincho Jove, Angel Eduardo
 * 
 * Descripcion del problema: El presente problema pide ingresar un array estandar
 * por teclado y luego imprimir por consola los elementos que son pares e impares
 * por separado. Para ello se utilizara un metodo auxiliar 'filtrar'
 * 
 */

public class Ejercicio3 {
	
	public static void main(String[] args) {
		
		// Metodo main del programa
		
		int[] array = ingresarArray();
		imprimirArray(array);
		System.out.println(filtrar(array));
		
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
	
	public static String filtrar(int[] array) {
		
		// Metodo 'filtrar' recibe como argumentos un array estandar de
		// enteros e itera sobre cada uno de sus elementos. En cada iteracion
		// se verifica si el entero es impar o par, dependiendo de la respuesta
		// el elemento o entero se almacena en las variable de tipo String
		// 'Pares' o 'Impares' para finalmente ser devolver estas dos variables
		
		String pares = "Pares: ";
		String impares = "Impares: ";
		for(int i = 0; i < array.length; i++) {
			if(array[i] % 2 == 0) {
				pares += (array[i] + " ");
			} else {
				impares += (array[i] + " ");
			}
		}
		return (pares + "\n" + impares);
		
	}
	
}
