
/* 
 * Autor: Hincho Jove, Angel Eduardo
 * 
 * Descripcion del problema: Se pide pasar de una complejidad O(n^2) a O(n)
 * el metodo mostrado en clase. El metodo mostrado en clase recibe un arreglo
 * estandar de numeros y devuelve el mayor de ellos en un tiempo O(n)
 * 
 * PREGUNTA! Cual es la complejidad de este codigo? La complejidad es de O(n) ya
 * que solo recorremos el arreglo de numeros una sola vez para encontra el mayor
 * 
 */

public class GreatestNumber {
	
	public static void main(String[] args) {
		
		// Metodo Main del programa
		
		int[] array = { 2, 4, 1, 3, 11, 6, 8, 9, 23 };
		System.out.println("El mayor numero del arreglo es: "+ greatestNumber(array));
		
	}
	
	public static int greatestNumber(int[] a) {
		
		// El metodo 'greatestNumber' itera sobre los elementos de un arreglo
		// de numeros estandar y devuelve el mayor de ellos
		
		// Variable auxiliar para el retorno del mayor numero
		int max = 0;
		
		// Ciclo for que itera sobre los elementos del arreglo estandar de numeros
		for(int i = 0; i < a.length; i++) {		
			
			if(max < a[i]) {
				// Si el numero en la posicion 'i' del arreglo es mayor que el maximo
				// actual, entonces debemos asignarlo como nuevo 'maximo'
				max = a[i];
			}
			
		}
		
		// Retornar el valor 'maximo' al final del ciclo for
		return max;
		
	}
	
}
