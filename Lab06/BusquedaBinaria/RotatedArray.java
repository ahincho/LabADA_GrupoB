
/* 
 * Autor: Hincho Jove, Angel Eduardo
 * 
 * Descripcion del problema: Implementar la Busqueda en un
 * arreglo del menor numero o del numero mas pequeño, basandose
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
		
		System.out.println("Menor elemento del arreglo A: " 
				+ lessSearch(a));
		System.out.println("Menor elemento del arreglo B: " 
				+ lessSearch(b));
		System.out.println("Menor elemento del arreglo C: " 
				+ lessSearch(c));
		System.out.println("Menor elemento del arreglo D: " 
				+ lessSearch(d));
		
	}
	
	public static int lessSearch(int[] a) {
		
		// Metodo Less Search, buscar el menor elemento
		// dentro de un 'arreglo rotado' y lo devuelve
		
		int left = 0;
		int right = a.length - 1;
		int mid = 0;
		int answer = 0;
		
		while(left <= right) {
			
			mid = left + (right - left)/2;
			
			if(a[left] < a[mid]) {
				
				// Si la parte de la izquierda es menor que el
				// valor de la mitad entonces establecerla
				// como 'respuesta' y como nuevo 'left = mid'
				
				answer = a[left];
				left = mid;
				
			} else {
				
				// En otro caso evaluar el valor contenido en
				// el indice 'mid' con el valor de 'answer'
				
				if(a[mid] < answer) {
					
					// Si es menor entonces, establecer el valor
					// en el indice 'mid' como nueva 'answer'
					// y el indice de la derecha como 'mid'
					
					answer = a[mid];
					right = mid;
						
				} else {
					
					// Si no es el caso, continuar con el siguiente
					// valor de la izquierda 'left++'
					
					left++;
					
				}
				
			}
			
		}
		
		// Devolver el valor de la respuesta
		
		return answer;
		
	}
	
}
