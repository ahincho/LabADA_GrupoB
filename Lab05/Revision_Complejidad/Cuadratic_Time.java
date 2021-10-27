
/* 
 * Autor: Hincho Jove, Angel Eduardo
 * 
 * Descripcion del problema: Implementar el codigo visto en laboratorio
 * hallar su complejidad. Un metodo que realice una accion 'statement'
 * 
 * PREGUNTA! 
 * Cual es la complejidad de este codigo?
 * 		La complejidad es de O(n^2)
 * 
 */

public class Cuadratic_Time {
	
	public static void main(String[] args) {
		
		// Repaso de Complejidad en Tiempo
		
		cuadraticTime(5);
		cuadraticTime(10);
		cuadraticTime(20);
		
	}
	
	public static void cuadraticTime(int n) {
		
		// Q4: Cual es la Complejidad en Tiempo de:
		
		System.out.println("Prueba con un valor n = " + n);
		
		int repeats = 0;
		
		for(int i = 0; i < n; i++) { // Ciclo for de 'n' veces
			
			for(int j = 0; j < n; j++) { // Ciclo for de 'n' veces
				
				// Parte Statement del codigo
				
				repeats++;	// Acumular en la variable 'repeats' O(1)
				
			}
			
		}
		
		System.out.println("Repeticiones: " + repeats);
		System.out.println();
		
		/*
		 * Explicacion:
		 * 
		 * Valor de i | Valor de j | Repeticiones
		 * --------------------------------------
		 * 		0	   0 ,..., n - 1	 n - 1
		 * --------------------------------------
		 * 		1	   0 ,..., n - 1	 n - 1
		 * --------------------------------------
		 * 				   ...
		 * --------------------------------------
		 *    n - 1	   0 ,..., n - 1	 n - 1
		 * 
		 * Entonces:
		 * 
		 * O((n - 1) * (n - 1)) = O(n^2 - 2n - 1) = O(n^2)
		 * 
		 */
		
	}
	
}
