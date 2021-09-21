package ejercicios;

import java.util.Scanner;

public class Ejercicio4 {
	
	public static void main(String[] args) {
		
		int[] array = ingresarArray();
		System.out.print("Array Ingresado: ");
		imprimirArray(array);
		ordenarArray(array);
		System.out.print("Imprimiendo Array ordenado: ");
		imprimirArray(array);
		
	}
	
	public static int[] ingresarArray() {
		
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
		
		System.out.print("[ ");
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("]");
		
	}
	
	public static void ordenarArray(int[] array) {
		
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
