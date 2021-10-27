
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

public class Lineal_Time_2Loops {
	
	public static void main(String[] args) {
		
		// Repaso de Complejidad en Tiempo
		
		linealTime2Loops(5);
		linealTime2Loops(25);
		linealTime2Loops(50);
		
	}
	
	public static void linealTime2Loops(int n) {
		
		// Q10: Cual es la Complejidad en Tiempo de:
		
		System.out.println("Prueba con un valor n = " + n);
		
		int repeats = 0;
		
		for(int i = 0; i < n; i++) { // Ciclo for de 'n' veces
			
			// Parte Statement del codigo
			
			repeats++;	// Acumular en la variable 'repeats' O(1)
			
		}
		
		for(int j = 0; j < n; j++) { // Ciclo for de 'n' veces
			
			// Parte Statement del codigo
			
			repeats++;	// Acumular en la variable 'repeats' O(1)
			
		}
		
		System.out.println("Repeticiones: " + repeats);
		System.out.println();
		
		/*
		 * Explicacion: for(i = 0; i < n; i++)
		 * 
		 * i = 0 | Incrementa i++
		 * i = 1 | Incrementa i++
		 * 		    ...
		 * i = n - 1 | Incrementa i++
		 * i = n | Ya no se ejecuta, no se cumple 'i < n'
		 * 
		 * Entonces: Un unico ciclo for es O(n)
		 * 
		 * Tenemos:
		 * 	    2 ciclos for: 2 * O(n) = O(2n) = O(n)
		 * 
		 */
		
	}
	
}
