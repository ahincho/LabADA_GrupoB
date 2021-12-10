
/* 
 * Autor: Hincho Jove, Angel Eduardo
 * 
 * Descripcion del Problema: Parecido al Problema de Job Scheduling
 * 
 * Se nos entregan dos arreglos de enteros 'a' y 'b', el arreglo
 * 'a' representa la posicion en eje X donde empieza el segmento
 * mientras el arreglo 'b' representa la posicion en eje X donde
 * termina el segmento. El problema nos pide hallar la cantidad
 * de segmentos que podemos juntar o seguir sin que se sobrepongan
 * el uno sobre el otro, similiar al problema de Job Scheduling
 * 
 */

public class MaxNonoverlappingSegments {
	
	public static void main(String[] args) {
		
		// Metodo main del programa
		
		// Arreglo estandar para las posiciones iniciales
		int[] a = { 1, 3, 7, 9, 9 };
		
		// Arreglo estandar para las posiciones finales
		int[] b = { 5, 6, 8, 9, 10 };
		
		// Imprimir la cantidad de segmentos 'correctos'
		System.out.println(findSegments(a, b));
		
	}
	
	// Para comprobar este metodo en la pagina web se cambio
	// su nombre en la pagina de 'findSegments' a 'solution'
	
	// Explicacion de la Solucion:
	
	// Muy parecido al problema de Job Scheduling se nos pide hallar
	// la mayor cantidad de vertices que no se sobrepongan. Como en
	// Job Scheduling, tenemos que verificar la 'hora de inicio' que
	// en este caso seria nuestra posicion inicial, luego verificamos
	// que el segmento o actividad tenga un valor inicial mayor al de
	// de la posicion inicial, si es asi entonces actualizamos la
	// posicion inicial con el valor de la 'hora final' que en este
	// caso es la posicion final. Iteramos en todos los segmentos
	
	public static int findSegments(int[] a, int[] b) {
		
		// Metodo findSegments, recibe dos arreglos de enteros que
		// representan nuestras posiciones inciales y finales para
		// cada segmentos respectivamente. Devuelve la cantidad de
		// segmentos que podemos tomar sin superponer uno sobre otro
		
		// Variable para la posicion incial, como se trata de
		// distancias la iniciamos en '-1'.
		int startPos = -1;
		
		// Variable para la cantidad de segmentos que podemos tomar
		// sin superponer uno sobre otro. Se devolvera al final
		int segmentAmount = 0;
		
		// Iteramos sobre todos los segmentos del arreglo
		for(int i = 0; i < a.length; i++) {
			
			// Si la posicion inicial del segmento es mayor a
			// la posicion incial entonces no se superponen 
			if(a[i] > startPos) {
				
				// Actualizamos el valor de la posicion actual al
				// valor de la posicion final del segmento en revision
				startPos = b[i];
				
				// Aumentamos la cantidad de segmentos 'correctos'
				segmentAmount++;
				
			}
			
		}
		
		// Finalmente devolvemos la cantidad de segmentos 'correctos'
		return segmentAmount;
		
	}
	
}
