
/* 
 * Autor: Hincho Jove, Angel Eduardo
 * 
 * Descripcion del problema: Se pide implementar una busqueda binaria, donde
 * el valor a buscar es comparado con el termino medio de una lista ordenada.
 * Dependiendo de esta comparacion procederemos a comparar del inicio (n = 0)
 * hasta el medio o, en caso de ser menor, del medio hasta el final (n = a.length)
 * en caso de ser mayor al elemento que se encuentra en medio del array
 * 
 */

public class BusquedaBinaria {
	
	public static void main(String[] args) {
		
		// Metodo main del programa
		
		int[] array = { 1, 2, 3, 5, 5, 5, 7, 9, 10, 14, 15, 18, 40, 50, 50 };
		busquedaBinaria(array, 13);
		System.out.println();
		busquedaBinaria(array, 5);
		System.out.println();
		busquedaBinaria(array, 10);
		System.out.println();
		busquedaBinaria(array, 15);
		
	}
	
	public static void busquedaBinaria(int[] a, int buscar) {
		
		// Metodo busqueda binaria, recibe un arreglo estandar de enteros ordenados
		// junto con el numero que se quiere buscar dentro de este arreglo
		
		int inferior = 0, medio, superior = a.length;
		System.out.println("Empieza la busqueda de " + buscar + "!");
		// Iterar mientras que la variable auxiliar 'inferior' sea menor a 'superior'
		while(inferior <= superior) {
			// Posicion media del arreglo ordenado
			medio = (inferior + superior) / 2;
			System.out.println("\tComparando con " + a[medio]);
			// Comparaciones con respecto al elemento del medio
			if(a[medio] == buscar) {
				// Si es igual, entonces encontramos el elemento
				System.out.println(buscar + " esta en la posición: " + medio);
				break;
			}
			else if(buscar < a[medio]) {
				// Si el elemento buscado es menor al elemento del medio entonces,
				// procedemos a establecer nuestro nuevo indice 'superior' en el
				// indice medio menos uno, y volvemos a iterar
				superior = medio - 1;
			}
			else {
				// Si el elemento buscado es mayor al elemento del medio entonces,
				// procedemos a establecer nuestro nuevo indice 'inferior' en el
				// indice medio mas uno, y volvemos a iterar
				inferior = medio + 1;
			}
		}
		// Mensaje final, se imprime en caso de no encontrar el numero buscado
		System.out.println("No se encontro el numero " + buscar);
	}
	
}
