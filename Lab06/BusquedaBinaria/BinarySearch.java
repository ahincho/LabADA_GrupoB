
/* 
 * Autor: Hincho Jove, Angel Eduardo
 * 
 * Descripcion del problema: Implementar el algoritmo de
 * busqueda binaria en su forma 'basica' y poder encontrar
 * un numero cualquiera. E indicar si se encuentra o no.
 * 
 */

public class BinarySearch {
	
	public static void main(String[] args) {
		
		// Metodo main del programa
		
		int[] a = { 1, 5, 7, 9, 11, 14, 20, 21};
		int search1 = 20;
		int search2 = 7;
		int search3 = 50;
		
		System.out.println("Vamos a buscar el numero "
				+ search1 + " dentro del array");
		System.out.println(binarySearch(a, search1) + "\n");
		
		System.out.println("Vamos a buscar el numero "
				+ search2 + " dentro del array");
		System.out.println(binarySearch(a, search2) + "\n");
		
		System.out.println("Vamos a buscar el numero "
				+ search3 + " dentro del array");
		System.out.println(binarySearch(a, search3) + "\n");
		
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
				
				System.out.print("Encontrado ");
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
