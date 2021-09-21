package ejercicios;

import java.util.Scanner;

public class Ejercicio2 {
	
	public static void main(String[] args) {
		
		int[] array = ingresarArray();
		imprimirArray(array);
		imprimirArrayReves(array);
		
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
		
		System.out.print("Array Ingresado: [ ");
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("]");
		
	}
	
	public static void imprimirArrayReves(int[] array) {
		
		System.out.print("Array Ingresado al Reves: [ ");
		int longitud = array.length;
		for(int i = 0; i < longitud; i++) {
			System.out.print(array[longitud - i - 1] + " ");
		}
		System.out.println("]");
		
	}
	
}
