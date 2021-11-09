
/* 
 * Autor: Hincho Jove, Angel Eduardo
 * 
 * Descripcion del problema: Implementar el algoritmo de
 * busqueda binaria para encontrar los cuadrados dentro
 * de un arreglo de numeros datos.
 * 
 */

public class SquareSearch {
	
	public static void main(String[] args) {
		
		// Suponiendo que se ingresa un arreglo con numeros enteros
		// positivos, entonces se procede a buscar aquellos que son
		// numeros cuadrados o de la forma (indice*indice)
		
		int[] a = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
		System.out.println(squareSearch(a, 7) + "\n");
		System.out.println(squareSearch(a, 16) + "\n");
		System.out.println(squareSearch(a, 49) + "\n");
		System.out.println(squareSearch(a, 4) + "\n");
		System.out.println(squareSearch(a, 11) + "\n");
		
	}
	
	public static int squareSearch(int[] a, int number) {
		
		// Usamos el metodo binarySearch() para ver si el numero
		// existe o esta incluido dentro del arreglo
		
		int search = binarySearch(a, number);
		
		// Se comprobrara si es cuadrado perfecto, mediante las
		// sumas consecutivas de los numeros impares
		
		// Formula
		// n^2 = sumatoria desde 0 a 'n' de los (2n + 1)
		
		int sum = 0;
		int nValue = 0;
		
		if(search == -1) {
			
			// Si no se encuentra dentro del arreglo devolver
			// el valor de -1 (No se encontro en el arreglo)
			
			System.out.println("No se encontro " + number);
			return search;
			
		} else {
			
			while(sum <= search) {
				
				if(sum == search) {
					
					// Si el numero es igual a una de las sumas
					// devolver el numero y romper el ciclo
					
					System.out.println("El numero "
							+ number + " es cuadrado");
					break;
					
				} else {
					
					nValue++;
					sum = sum + (2 * nValue - 1);
					
				}
				
			}
			
			if(sum > search) {
				
				// Si la suma es mayor al numero buscado entonces
				// devolver -2 (Se encuentra en el array pero no
				// es un numero cuadrado) para indicarlo.
				
				System.out.println("El numero "
						+ number + " no es cuadrado");
				search = -2;
				
			}
			
		}
		
		return search;
		
	}
	
	public static int binarySearch(int[] a, int search) {
		
		// Metodo Binary Search, recibe un arreglo estandar
		// de numeros enteros y el numero entero que se desea
		// buscar dentro del arreglo.
		// Devuelve el numero si es que se encuentra dentro del
		// arreglo y devuelve el valor de -1 si no se encuentra.
		
		int left = 0;
		int right = a.length - 1;
		int mid;
		
		while(left <= right) {
			
			// Estableciendo el punto 'medio' del array
			
			mid = left + (right - left)/2;			
			
			if(a[mid] == search) {
				
				// Si el valor contenido en el indice del 'medio'
				// es igual al que se esta buscando, se encontro.
				
				System.out.println("Se encontro el numero " + search);
				return a[mid];
				
			} else if (a[mid] < search) {
				
				// Si el valor del indice 'medio' es menor
				// entonces buscar en la mitad superior
				
				left = mid + 1;
				
			} else {
				
				// Si el valor del indice 'medio' es mayor
				// entonces buscar en la mitad inferior
				
				right = mid - 1;
				
			}
			
		}
		
		// Si no se encuentra el numero que se esta buscando
		// entonces devolver un mensaje de 'no encontrado' y -1
		
		System.out.println("No se encontro el numero " + search);
		
		return -1;
		
	}
	
}
