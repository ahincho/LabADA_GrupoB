
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

public class Log_Time_Mult {
	
	public static void main(String[] args) {
		
		// Repaso de Complejidad en Tiempo
		
		log2TimeMult(5);
		log2TimeMult(10);
		log2TimeMult(20);
		log2TimeMult(30);
		log2TimeMult(40);
		log2TimeMult(65);
		log2TimeMult(80);
		
	}
	
	public static void log2TimeMult(int n) {
		
		// Q7: Cual es la Complejidad en Tiempo de:
		
		System.out.println("Prueba con un valor n = " + n);
		
		int repeats = 0;
		
		for(int i = 1; i < n; i = i * 2) { // Ciclo for mientras 'i < n'
			
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
		 * 	1     |   2 ^ 1
		 * ------------------------
		 *  	2     |   2 ^ 2
		 * ------------------------
		 *           ...
		 * ------------------------
		 *      k     |   2 ^ k  
		 * 
		 * Entonces:
		 * 
		 * 		Tenemos: i = 2 ^ k
		 * 		Condicion:
		 * 				i < n
		 * 		Reemplazando:
		 * 		    2 ^ k < n
		 * 				k < Log2(n)
		 * 
		 * Es O(Log2(n))
		 * 
		 */
		
	}
	
}
