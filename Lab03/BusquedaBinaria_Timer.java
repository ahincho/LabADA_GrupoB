
/* 
 * Autor: Hincho Jove, Angel Eduardo
 * 
 * Descripcion del problema: Se pide implementar una busqueda binaria, donde
 * el valor a buscar es comparado con el termino medio de una lista ordenada.
 * Dependiendo de esta comparacion procederemos a comparar del inicio (n = 0)
 * hasta el medio o, en caso de ser mayor, del medio hasta el final (n = a.length)
 * UN EXTRA, para este ejercicio es que tambien se miden los tiempos en picosegundos
 * que demora realizar o buscar el elemento '2' en diferentes arreglos estandar
 * 
 */

public class BusquedaBinaria_Timer {
	
	public static void main(String[] args) {
		
		// Metodo main del programa
		
		System.out.println("Tiempo : " + medirTiempo(10, 2));
		System.out.println("Tiempo : " + medirTiempo(100, 2));
		System.out.println("Tiempo : " + medirTiempo(1000, 2));
		System.out.println("Tiempo : " + medirTiempo(10000, 2));
		System.out.println("Tiempo : " + medirTiempo(100000, 2));
		System.out.println("Tiempo : " + medirTiempo(1000000, 2));
		System.out.println("Tiempo : " + medirTiempo(10000000, 2));
		System.out.println("Tiempo : " + medirTiempo(100000000, 2));
		
	}
	
	public static double medirTiempo(int cantidad, int buscar) {
		
		// Metodo que recibe una cantidad de datos con las que se trabajara
		// el arreglo y el numero que se va a buscar, en este caso sera '2'
		
		// Variables auxiliares para poder medir el tiempo
		double tic = 0, toc = 0;
		// Creando un arreglo estandar de la cantidad especifica de numeros
		int[] array = crearArray(cantidad);
		System.out.println("Evaluando para " + cantidad + " elementos");
		// Estableciendo el inicio de busqueda del elemento en el array
		tic = System.currentTimeMillis();
		busquedaBinaria(array, buscar);
		// Estableciendo el final de busqueda del elemento en el array
		toc = System.currentTimeMillis();
		// Devolver el tiempo que se demoro en hacer la operacion en picosegs
		return ((toc - tic) * Math.pow(10, 9));
		
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
	
	public static int[] crearArray(int n) {
		
		// Metodo auxiliar que crea un arreglo de 'n' elementos enteros impares
		int[] array = new int[n];
		for(int i = 0; i < n; i++) {
			array[i] = ((2 * i) + 1);
		}
		
		return array;
		
	}
	
}
