
/* 
 * Autor: Hincho Jove, Angel Eduardo
 * 
 * Descripcion del problema: Implementar la Busqueda en un Arreglo
 * Rotado del menor numero o del valor mas pequeño, basandose
 * en el codigo ya visto en laboratorio para Busqueda Binaria
 * 
 */

public class RotatedArray {
	
	public static void main(String[] args) {
		
		// Metodo main del programa
		
		int[] a = {7, 9, 11, 14, 20, 1, 4};
		int[] b = {9, 11, 14, 20, -1, 4, 5, 6, 7};
		int[] c = {5, 6, 9, 11, 14, 20, 4, 5};
		int[] d = {9, 11, 13, 14, 8};
		int[] e = {1, 3, 5, 7, 9, 11, 13, 18};
		
		System.out.println("Menor elemento del arreglo A: " 
				+ lessSearch(a, 0, a.length - 1));
		System.out.println("Menor elemento del arreglo B: " 
				+ lessSearch(b, 0, b.length - 1));
		System.out.println("Menor elemento del arreglo C: " 
				+ lessSearch(c, 0, c.length - 1));
		System.out.println("Menor elemento del arreglo D: " 
				+ lessSearch(d, 0, d.length - 1));
		System.out.println("Menor elemento del arreglo D: " 
				+ lessSearch(e, 0, e.length - 1));
		
	}
	
	public static int lessSearch(int[] a, int left, int right) {
		
		// Metodo Less Search, buscar el menor elemento
		// dentro de un 'arreglo rotado' y lo devuelve
		
		// Cuando el arreglo recibido no esta 'rotado'
		
		if(right < left) {
			
			return a[0];
			
		}
		
		// Cuando encontramos el menor elemento del arreglo
		
		if(right == left) {
			
			return a[left];
			
		}
		
		// Calcular el indice medio del arreglo
		
		int mid = left + (right - left) / 2;
		
		// Verificar si el elementos del 'medio + 1' es el menor
		
		if(mid < right && a[mid + 1] < a[mid]) {
			
			return a[mid + 1];
			
		}
		
		// Verificar si el elemento del 'medio' es el menor
		
		if(mid > left && a[mid] < a[mid - 1]) {
			
			return a[mid];
			
		}
		
		// Aqui, se encuentra la busqueda binaria, debemos
		// decidir si vamos a llamar recursivamente al metodo
		// sobre la mitad inferior o superior de acuerdo al
		// elemento contenido en el indice 'medio' del arreglo
		
		// En caso de que el elemento del medio sea menor
		
		if(a[right] > a[mid]) {
			
			return lessSearch(a, left, mid - 1);
			
		}
		
		// En caso de que el elemento del medio sea mayor
		
		return lessSearch(a, mid + 1, right);
		
	}
}
