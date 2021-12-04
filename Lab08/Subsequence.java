package ejercicios;

/* 
 * Autor: Hincho Jove, Angel Eduardo
 * 
 * Descripcion del Problema:
 * 
 * Tenemos un arreglo unidimensional de numeros enteros de los
 * cuales queremos saber la subsecuencia creciente mas larga
 * 
 * ¿Que es la Subsecuencia Creciente mas Larga?
 * 
 * Ejm ... Tenemos [ 10, 9, 2, 5, 3, 7, 101, 18 ]
 * 
 * Una subsecuencia es: [ 9, 5, 3, 18 ]
 * 
 * Subsecuencia Creciente mas Larga: [ 2, 3, 7, 101 ]
 * 
 * Ojo .. Tambien se puede utilizar [ 2, 5, 7, 101 ]
 * Ojo .. Tambien se puede utilizar [ 2, 3, 7, 18 ]
 * 
 * Hallar la longitud de la subsecuencia creciente mas larga
 * Implementar el codigo para el problema usando Prog. Dinamica.
 * 
 */

import java.util.Arrays;

public class Subsequence {
	
	public static void main(String[] args) {
		
		// Metodo main del programa
		
		// Ingresamos un arreglo bidimensional y sus elementos
		
		int[] arr = { 10, 9, 2, 5, 3, 7, 101, 18 };
		
		// Calcularemos la longitud de la subsecuencia mas larga
		
		System.out.print(lengthOfLIS(arr) + "\n");
		
	}
	
	public static int lengthOfLIS(int[] nums) {
		
		// Metodo lengthOfLIS, recibe un arreglo unidimensional de
		// numeros enteros y devuelve la longitud de subsecuencia
		// mas larga creciente que existe dentro de este arreglo
		
		/*
		 * Relacion de Recurrencia! ... Matriz auxiliar length[n]
		 * 
		 * Caso Base ... Cuando creamos el arreglo auxiliar O i = 0
		 * 
		 * 	Llenamos el arreglo auxiliar con 1's
		 * 
		 * Caso Recursivo ... Cuando i > 0 y j >= 0
		 * 
		 * 	Revisar las posiciones anteriores al indice 'i'
		 * 
		 * 		Iterar sobre 'i' mientras 'i' < 'n'
		 * 			
		 * 			Iterar sobre 'j' mientras 'j' < 'n'
		 * 			
		 * 				Si la posicion 'j' es menor al de posicion 'i'
		 * 					
		 * 					Se trata de una subsecuencia
		 * 					
		 * 					Aumentar si la subsecuancia actual es mayor
		 * 					T[i] = max(T[i], T[j] + 1)
		 * 
		 */
		
		// Cantidad de elementos en el arreglo recibido
		
		int n = nums.length;
		
		// Si es cero, entonces no tiene elementos y devolvemos '0'
		
		if(n == 0) {
			
			return 0;
			
		}
		
		// Para este problema necesitaremos otro arreglo unidimensional
		// auxiliar de numeros enteros para guardar las subsecuencia
		
		int[] length = new int[n];
		
		// Ojo, debemos llenar el arreglo auxiliar con 1's inicialmente
		// Esto debido al Caso Base que se tomara en cuenta para resolver
		
		Arrays.fill(length, 1);
		
		// Variable auxiliar que guardara el tamanio o longitud de la
		// subsecuencia creciente mas larga dentro del arreglo recibido
		
		int lis = 1;
		
		// Empezaremos revisando todos los numeros de la lista (Ciclo i)
		
		for(int i = 1; i < n; i++) {
			
			// Revisaremos las posiciones anteriores a 'i' (Ciclo j)
			
			for(int j = 0; j < i; j++) {
				
				// Si el numero en posicion 'j' es mejor que el numero
				// en posicion 'i' entonces es una subsecuencia creciente
				
				// Antes de incrementar la longitud debemos estar seguros
				// o verificar que es mayor al la longitud mayor 'actual'
				
				if(nums[j] < nums[i] && length[j] + 1 > length[i]) {
					
					// Aumentamos longitud de subsecuencia ya seguros ...
					
					length[i] = length[j] + 1;
					
				}
				
			}
			
		}
		
		// Finalmente retornamos el valor de 'lis' o longitud mas grande
		
		return lis;
		
	}
	
}
