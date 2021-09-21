
import java.util.Scanner;

/* 
 * Autor: Hincho Jove, Angel Eduardo
 * 
 * Descripcion del problema: Se nos pide buscar un elemento dentro de un
 * arreglo de enteros estandar. Usando el metodo de Busqueda Lineal
 * 
 */

public class Ejercicio2 {
	
	public static void main(String[] args) {
		
		// Metodo main del programa
		
		Scanner scan = new Scanner(System.in);
		int[] array = { 1, 4, 8, 9, 11, 15, 7, 12, 13, 6 };
		System.out.print("Ingresar un entero a buscar: ");
		int buscar = scan.nextInt();
		imprimir(array);
		System.out.println("Se encuentra " + buscar +"? "
				+ busquedaLineal(array, buscar));
		scan.close();
		
	}
	
	public static boolean busquedaLineal(int[] array, int buscar) {
		
		// Metodo 'busquedaLineal' recibe como argumentos un arreglo
		// estandar de enteros y un entero que se quiere buscar dentro
		// de dicho arreglo estandar, devuelve verdadero si se encuentra
		// dentro del arreglo y falso si no se encuentra
		
		boolean respuesta = false;
		for(int i = 0; i < array.length - 1; i++) {
			if(array[i] == buscar) {
				respuesta = true;
				break;
			}
		}
		return respuesta;
		
	}
	
	public static void imprimir(int[] a) {
		
		// Metodo auxiliar para imprimir el contenido de un arreglo
		// estandar de numeros enteros que se pasa como argumento
		
		System.out.println("Imprimiendo el arreglo: ");
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ", "); 
		}
		System.out.println();
		
	}
	
}
