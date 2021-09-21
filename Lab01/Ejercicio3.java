package ejercicios;

import java.util.Scanner;

public class Ejercicio3 {
	
	public static void main(String[] args) {
		
		int[] array = ingresarArray();
		imprimirArray(array);
		System.out.println(filtrar(array));
		
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
	
	public static String filtrar(int[] array) {
		
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
