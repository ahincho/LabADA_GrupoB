
/* 
 * Autor: Hincho Jove, Angel Eduardo
 * 
 * Descripcion del problema: Implementar el codigo visto en laboratorio
 * hallar su complejidad. Un metodo que realice una accion 'statement'
 * 
 * PREGUNTA! 
 * Cual es la complejidad de este codigo?
 * 		La complejidad es de O(n)
 * 
 */

public class Lineal_Time_Increase {
	
	public static void main(String[] args) {
		
		// Repaso de Complejidad en Tiempo
		
		linealTimeIncrease(5);
		linealTimeIncrease(25);
		linealTimeIncrease(50);
		
	}
	
	public static void linealTimeIncrease(int n) {
		
		// Q1: Cual es la Complejidad en Tiempo de:
		
		System.out.println("Prueba con un valor n = " + n);
		
		int repeats = 0;
		
		for(int i = 0; i < n; i++) { // Ciclo for de 'n' veces
			
			// Parte Statement del codigo
			
			repeats++;	// Acumular en la variable 'repeats' O(1)
			
		}
		
		System.out.println("Repeticiones: " + repeats);
		System.out.println();
		
		/*
		 * Explicacion:
		 * i = 0 | Incrementa i++
		 * i = 1 | Incrementa i++
		 * 		    ...
		 * i = n - 1 | Incrementa i++
		 * i = n | Ya no se ejecuta, no se cumple 'i < n'
		 * 
		 * Entonces:
		 * El numero de iteraciones incrementa segun la cantidad
		 * de datos enviados al metodo, por ello es O(n)
		 * 
		 */
		
	}
	
}
