
/* 
 * Autor: Hincho Jove, Angel Eduardo
 * 
 * Descripcion del problema: Implementar el codigo visto en laboratorio
 * hallar su complejidad. Un metodo que realice una accion 'statement'
 * 
 * PREGUNTA! 
 * Cual es la complejidad de este codigo?
 * 		La complejidad es de O(Log(Log(n)))
 * 
 */

public class LogLog_Time {
	
	public static void main(String[] args) {
		
		// Repaso de Complejidad en Tiempo
		
		logLogTime(5);
		logLogTime(10);
		logLogTime(20);
		logLogTime(30);
		logLogTime(40);
		logLogTime(65);
		logLogTime(80);
		logLogTime(160);
		logLogTime(320);
		
	}
	
	public static void logLogTime(int n) {
		
		// Q10: Cual es la Complejidad en Tiempo de:
		
		System.out.println("Prueba con un valor n = " + n);
		
		int repeats = 0;
		
		int p = 0;
		
		for(int i = 1; i < n; i = i * 2) { // Ciclo for 'log2(n)' veces
			
			p++;	// Acumular en la variable 'p' O(1)
			
		}
		
		System.out.println("Valor de p = " + p);
		
		for(int j = 1; j < p; j = j * 2) { // Ciclo for 'log2(p)' veces
			
			// Parte Statement del codigo
			
			repeats++;	// Acumular en la variable 'repeats' O(1)
			
		}
		
		System.out.println("Repeticiones: " + repeats);
		System.out.println();
		
		/*
		 * Explicacion: for(i = 0; i < n; i = i * 2)
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
		 * 		   	n / 2 ^ k = 1
		 * 					n = 2 ^ k
		 * 			  Log2(n) = k
		 * 			  Log2(n) = p
		 * 
		 * Como 'p' es el numero de repeticiones
		 * entonces podemos concluir p = Log2(n)
		 * 
		 * Valor de j | Valor de p  
		 * ------------------------	 
		 * 	1     |   j / 2 ^ 1
		 * ------------------------
		 *  	2     |   j / 2 ^ 2
		 * ------------------------
		 * 	     ...
		 * ------------------------
		 *      q     |   j / 2 ^ q  
		 * 
		 * Entonces:
		 * 
		 * 		Tenemos: j = p / 2 ^ q
		 * 		Condicion:
		 * 				j >= 1
		 * 				j = 1
		 * 		Reemplazando:
		 * 		   	p / 2 ^ q = 1
		 * 			  Log2(n) = 2 ^ q
		 * 		Log2(Log2(n)) = q
		 * 
		 * Finalmente concluimos que la complejidad
		 * en tiempo es igual a O(Log2(Log2(n)))
		 * 
		 */
		
	}
	
}
