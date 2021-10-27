
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

public class Lineal_Time_Decrease {
	
	public static void main(String[] args) {
		
		// Repaso de Complejidad en Tiempo
		
		linealTimeDecrease(5);
		linealTimeDecrease(25);
		linealTimeDecrease(50);
		
	}
	
	public static void linealTimeDecrease(int n) {
		
		// Q2: Cual es la Complejidad en Tiempo de:
		
		System.out.println("Prueba con un valor n = " + n);
		
		int repeats = 0;
		
		for(int i = n; i > 0; i--) { // Ciclo for de 'n' veces
			
			// Parte Statement del codigo
			
			repeats++;	// Acumular en la variable 'repeats' O(1)
			
		}
		
		System.out.println("Repeticiones: " + repeats);
		System.out.println();
		
		/*
		 * Explicacion:
		 * i = n | Decrementa i--
		 * i = n - 1 | Decrementa i--
		 * 		    ...
		 * i = 1 | Decrementa i--
		 * i = 0 | Ya no se ejecuta, no se cumple 'i > 0'
		 * 
		 * Entonces:
		 * El numero de iteraciones incrementa segun la cantidad
		 * de datos enviados al metodo, por ello es O(n)
		 * 
		 */
		
	}
	
}
