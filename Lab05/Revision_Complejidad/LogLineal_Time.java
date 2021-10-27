
/* 
 * Autor: Hincho Jove, Angel Eduardo
 * 
 * Descripcion del problema: Implementar el codigo visto en laboratorio
 * hallar su complejidad. Un metodo que realice una accion 'statement'
 * 
 * PREGUNTA! 
 * Cual es la complejidad de este codigo?
 * 		La complejidad es de O(n*Log(n))
 * 
 */

public class LogLineal_Time {
	
	public static void main(String[] args) {
		
		// Repaso de Complejidad en Tiempo
		
		logLinealTime(5);
		logLinealTime(10);
		logLinealTime(20);
		logLinealTime(30);
		logLinealTime(40);
		logLinealTime(65);
		logLinealTime(80);
		
	}
	
	public static void logLinealTime(int n) {
		
		// Q10: Cual es la Complejidad en Tiempo de:
		
		System.out.println("Prueba con un valor n = " + n);
		
		int repeats = 0;
		
		for(int i = 0; i < n; i++) { // Ciclo for 'n' veces
			
			for(int j = 1; j < n; j = j * 2) { // Ciclo for 'Log2(n)' veces
				
				// Parte Statement del codigo
				
				repeats++;	// Acumular en la variable 'repeats' O(1)

				
			}
						
		}
		
		System.out.println("Repeticiones: " + repeats);
		System.out.println();
		
		/*
		 * Explicacion: for(j = 0; j < n; j = j * 2)
		 * 
		 * Valor de k |  Valor de j
		 * ------------------------	 
		 *      1     |   n / 2 ^ 1
		 * ------------------------
		 *  	2     |   n / 2 ^ 2
		 * ------------------------
		 * 	     ...
		 * ------------------------
		 *      k     |   n / 2 ^ k  
		 * 
		 * Entonces:
		 * 
		 * 		Tenemos: j = n / 2 ^ k
		 * 		Condicion:
		 * 				j >= 1
		 * 				j = 1
		 * 		Reemplazando:
		 * 		   	n / 2 ^ k = 1
		 * 					n = 2 ^ k
		 * 			  Log2(n) = k
		 * 
		 * Tenemos: Que el ciclo for interno o anidado tiene una
		 * complejidad en tiempo de O(Log2(n))
		 * 
		 * El otro ciclo for externo tiene una complejidad en tiempo
		 * de 'n'. Como son for's anidados debemos multiplicar sus
		 * complejidades. Obteniendo que es O(n * Log2(n))
		 * 
		 */
		
	}
	
}
