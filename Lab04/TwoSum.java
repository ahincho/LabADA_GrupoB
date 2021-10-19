
/* 
 * Autor: Hincho Jove, Angel Eduardo
 * 
 * Descripcion del problema: Se pide implementar un codigo que reciba un arreglo
 * estandar de numeros e iterar por cada uno de ellos, buscando una suma que de
 * un resultado igual a '10'. OJO: No se debe sumar un numero 'consigo mismo'.
 * 
 * PREGUNTA! Cual es la complejidad de este codigo? La complejidad es de O(n^2)
 * 
 */

public class TwoSum {
	
	public static void main(String[] args) {
		
		// Metodo Main del programa
		
		int[] array = { 2, 4, 1, 3, 11, 6, 8, 9, 5 };
		twoSum(array);
		
	}
	
	public static boolean twoSum(int[] a) {
		
		// El metodo 'twoSum' itera por cada elemento del arreglo estandar
		// de numeros y verifica si existe alguna suma de dos elementos
		// distintos dentro del arreglo que den una suma igual a 10
		
		// Recorrer todos los elementos del arreglo estandar
		for(int i = 0; i < a.length; i++) {
			
			// Sumar con los demas elementos menos 'consigo mismo'
			for(int j = 0; j < a.length; j++) {
				
				if(i != j && (a[i] + a[j] == 10)) {
					
					System.out.println("Existe una suma que da 10!");
					System.out.println("\tLa suma es: " + a[i] + " + "
						+ a[j] + " = " + (a[i] + a[j]));
					
					// Si existe alguna suma que de '10' devolver verdadero
					return true;
					
				}
				
			}
			
		}
		
		// Si no existe por lo menos una suma igual a '10' devolver falso
		return false;
		
	}
	
}
