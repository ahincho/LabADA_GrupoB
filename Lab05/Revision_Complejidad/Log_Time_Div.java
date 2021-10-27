
/* 
 * Autor: Hincho Jove, Angel Eduardo
 * 
 * Descripcion del problema: Implementar el codigo visto en laboratorio
 * hallar su complejidad. Un metodo que realice una accion 'statement'
 * 
 * PREGUNTA! 
 * Cual es la complejidad de este codigo?
 * 		La complejidad es de O(Log2(n))
 * 
 */

public class Log_Time_Div {
	
	public static void main(String[] args) {
		
		// Repaso de Complejidad en Tiempo
		
		log2TimeDiv(5);
		log2TimeDiv(10);
		log2TimeDiv(20);
		log2TimeDiv(30);
		log2TimeDiv(40);
		log2TimeDiv(65);
		log2TimeDiv(80);
		
	}
	
	public static void log2TimeDiv(int n) {
		
		// Q8: Cual es la Complejidad en Tiempo de:
		
		System.out.println("Prueba con un valor n = " + n);
		
		int repeats = 0;
		
		for(int i = n; i >= 1; i = i / 2) { // Ciclo for mientras 'i >= 1'
			
			// Parte Statement del codigo
			
			repeats++;	// Acumular en la variable 'repeats' O(1)
			
		}
		
		System.out.println("Repeticiones: " + repeats);
		System.out.println();
		
		/*
		 * Explicacion:
		 * 
		 * Valor de k | Valor de i  
		 * ------------------------	 
		 * 	1     |   n / 2 ^ 1
		 * ------------------------
		 *  	2     |   n / 2 ^ 2
		 * ------------------------
		 * 	     ...
		 * ------------------------
		 *      k     |   n / 2 ^ k  
		 * 
		 * Entonces:
		 * 
		 * 		Tenemos: i = n / 2 ^ k
		 * 		Condicion:
		 * 				i >= 1
		 * 				i = 1
		 * 		Reemplazando:
		 * 		   	n / 2 ^ k < 1
		 * 					n < 2 ^ k
		 * 			  Log2(n) < k
		 * 
		 * Es O(Log2(n))
		 * 
		 */
		
	}
	
}
