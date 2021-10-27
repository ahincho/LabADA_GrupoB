
/* 
 * Autor: Hincho Jove, Angel Eduardo
 * 
 * Descripcion del problema: Implementar el codigo visto en laboratorio
 * hallar su complejidad. Un metodo que realice una accion 'statement'
 * 
 * PREGUNTA! 
 * Cual es la complejidad de este codigo?
 * 		La complejidad es de O(n^(1/2))
 * 
 */

public class Square_Root_Time_Mult {
	
	public static void main(String[] args) {
		
		// Repaso de Complejidad en Tiempo
		
		squareRootTimeMult(5);
		squareRootTimeMult(10);
		squareRootTimeMult(20);
		squareRootTimeMult(40);
		squareRootTimeMult(80);
		
	}
	
	public static void squareRootTimeMult(int n) {
		
		// Q9: Cual es la Complejidad en Tiempo de:
		
		System.out.println("Prueba con un valor n = " + n);
		
		int repeats = 0;
		
		for(int i = 1; i * i < n; i++) { // Ciclo for mientras 'i * i < n'
			
			// Parte Statement del codigo
			
			repeats++;	// Acumular en la variable 'repeats' O(1)
			
		}
		
		System.out.println("Repeticiones: " + repeats);
		System.out.println();
		
		/*
		 * Explicacion:
		 * 
		 * Valor de n  |  Valor de i
		 * ---------------------------
		 * 	0	      0	 
		 * ---------------------------
		 * 	1	    1 * 1
		 * ---------------------------
		 *  	2	    2 * 2
		 * ---------------------------
		 *            ...
		 * ---------------------------
		 *      k	    k * k
		 * 
		 * Entonces:
		 * 		
		 * 		Condicion = i * i < n
		 * 		
		 * 		Reemplazando
		 * 			k * k < n
		 * 			k ^ 2 < n
		 * 			    k < sqrt(n)
		 * 
		 * Es O(n ^ (1/2))
		 * 
		 */
		
	}
	
}
