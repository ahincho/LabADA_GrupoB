
/* 
 * Autor: Hincho Jove, Angel Eduardo
 * 
 * Descripcion del problema: Se pide recibir un arreglo estandar de numeros donde
 * para cada posicion 'par' se debe sumar el elemento que esta en esa posicion
 * dentro del arreglo con los demas elementos INCLUYENDO 'el mismo'.
 * 
 * PREGUNTA! Cual es la complejidad de este codigo? La complejidad es de O(n^2)
 * 
 */

public class EveryOther {
	
	public static void main(String[] args) {
		
		// Metodo Main del programa
		
		int[] array = { 2, 4, 1, 3, 11, 6, 8, 9, 5 };
		everyOther(array);
		
	}
	
	public static void everyOther(int[] a) {
		
		// El metodo 'everyOther' recibe un arreglo estandar de numeros e itera
		// por cada uno de ellos. Si el indice del elemento es par, entonces suma
		// el elemento con indice par con los demas elementos y los imprime por la
		// consola. Imprime que se encontro una posicion par y todas sus sumas.
		
		// Iterando por todos los elementos del arreglo
		for(int i = 0; i < a.length; i++) {
			
			// Si el indice es par entonces debemos sumar con los demas
			if(i % 2 == 0) {
				
				System.out.println("Posicion par en el elemento: " + a[i]);
				
				// Se tiene que sumar el numero en posicion par
				// con los demas numeros dentro del arreglo
				
				for(int j = 0; j < a.length; j++) {
					
					System.out.println("Sumando con " + a[j] + " | "
						+ a[i] + " + " + a[j] + " = " + (a[i] + a[j]));
					
				}
				
				System.out.println();
				
			}
			
		}
		
	}
	
}
