package repaso_complejidad;

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

public class Square_Root_Time_Sum {
	
	public static void main(String[] args) {
		
		// Repaso de Complejidad en Tiempo
		
		squareRootTimeSum(5);
		squareRootTimeSum(10);
		squareRootTimeSum(20);
		squareRootTimeSum(40);
		squareRootTimeSum(80);
		
	}
	
	public static void squareRootTimeSum(int n) {
		
		// Q6: Cual es la Complejidad en Tiempo de:
		
		System.out.println("Prueba con un valor n = " + n);
		
		int repeats = 0;
		
		int p = 0;
		
		for(int i = 1; p <= n; i++) { // Ciclo for mientras 'p < n'
			
			// Parte Statement del codigo
			
			repeats++;	// Acumular en la variable 'repeats' O(1)
			
			p = p + i;
			
		}
		
		System.out.println("Repeticiones: " + repeats);
		System.out.println();
		
		/*
		 * Explicacion:
		 * 
		 * Valor de i | Valor de p 
		 * ---------------------------
		 * 	0	   0 + 1	 
		 * ---------------------------
		 * 	1	 0 + 1 + 2	
		 * ---------------------------
		 *  	2      0 + 1 + 2 + 3	
		 * ---------------------------
		 * 	     ...
		 * ---------------------------
		 *      k    0 + 1 + 2 + ... + k
		 * 
		 * Entonces:
		 * 
		 * 		Condicion = k > n
		 * 					p > n
		 * 		Reemplazando
		 * 		k * (k + 1) / 2 > n
		 * 		k ^ 2 > n
		 * 		k > sqrt(n)
		 * 
		 * Es O(n ^ (1/2))
		 * 
		 */
		
	}
	
}
