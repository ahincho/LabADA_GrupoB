package busquedaBinaria;

/* 
 * Autor: Hincho Jove, Angel Eduardo
 * 
 * Descripcion del problema: Implementar la Busqueda en un arreglo
 * del numero 'inmediatamente superior' o mayor de un numero ingresado
 * basandose en la estructura o algoritmo base de 'Busqueda Binaria'
 * 
 */

public class BiggerSearch {
	
	public static void main(String[] args) {
		
		int[] a = { 1, 5, 7, 9, 11, 14, 20, 21};
		System.out.println("Mayor a 10: " + biggerSearch(a, 10) + "\n");
		System.out.println("Mayor a 21: " + biggerSearch(a, 21) + "\n");
		System.out.println("Mayor a 7: " + biggerSearch(a, 7) + "\n");
		System.out.println("Mayor a 0: " + biggerSearch(a, 0) + "\n");
		
	}
	
	public static int biggerSearch(int[] a, int search) {
		
		// Metodo Bigger Search, tiene la misma funcionalidad
		// original de la 'Busqueda Binaria', pero devuelve el
		// 'inmediato superior' o el numero mayor al que se esta
		// buscando, por ejemplo si ingresamo 10 devuelve 11
		
		int left = 0;
		int right = a.length - 1;
		int mid = 0, answer = 0;
		
		while(left <= right) {
			
			// Estableciendo el punto 'medio' del array
			
			mid = left + (right - left)/2;			
			
			if(a[mid] == search) {
				
				// Si el valor contenido en el indice del 'medio'
				// es igual al que se esta buscando, se encontro.
				
				System.out.println("Se encontro el numero " + search);
				
				if(mid + 1 <= a.length - 1) {
					
					// Verificar si el indice siguiente 'mid + 1' no
					// supera al maximo de elementos o indice mayor
					
					answer = a[mid + 1];
					
				} else {
					
					// Si excede al valor maximo (indice maximo)
					// mencionarlo y devolver una respuesta -1
					
					// EL CASO DE BUSCAR UN MAYOR A 21!
					
					System.out.println("No existe un numero mayor a "
							+ search + " dentro del arreglo");
					
				}
				
				break;
				
			} else if (a[mid] < search) {
				
				// Si el valor del indice 'medio' es menor
				// entonces buscar en la mitad superior
				
				left = mid + 1;
				
			} else {
				
				// Si el valor del indice 'medio' es mayor
				// entonces buscar en la mitad inferior
				
				right = mid - 1;
				
			}
			
			// Si no se encontro el numero dentro del array
			// devolver el valor de -1 para indicarlo
			
			answer = -1;
			
		}
		
		if(answer == -1 && mid + 1 < a.length) {
			
			// Este caso es cuando el numero no existe dentro del
			// arreglo, pero existe un 'siguiente mayor' dentro del
			// arreglo. EL CASO DE BUSCAR EL MAYOR DE 10!
			
			System.out.println("El numero " + search
				+ " no se encuentra dentro del arreglo");
			answer = a[mid + 1];
			
		}
		
		return answer;
		
	}
	
}
