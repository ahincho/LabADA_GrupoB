
/* 
 * Autor: Hincho Jove, Angel Eduardo
 * 
 * Descripcion del problema: Implementar el codigo visto en laboratorio
 * hallar su complejidad. Un metodo que realice una accion 'statement'
 * 
 * PREGUNTA! 
 * Cual es la complejidad de este codigo?
 * 		La complejidad es de O(n/2)
 * 
 */

public class Lineal_Half_Time {
	
	public static void main(String[] args) {
		
		// Repaso de Complejidad en Tiempo
		
		linealHalfTime(5);
		linealHalfTime(25);
		linealHalfTime(50);
		
	}
	
	public static void linealHalfTime(int n) {
		
		// Q3: Cual es la Complejidad en Tiempo de:
		
		System.out.println("Prueba con un valor n = " + n);
		
		int repeats = 0;
		
		for(int i = 0; i < n; i = i + 2) { // Ciclo for de 'n/2' veces
			
			// Parte Statement del codigo
			
			repeats++;	// Acumular en la variable 'repeats' O(1)
			
		}
		
		System.out.println("Repeticiones: " + repeats);
		System.out.println();
		
		/*
		 * Explicacion:
		 * i = 0 | Incrementa i += 2
		 * i = 2 | Incrementa i += 2
		 * 		    ...
		 * i = n - 2 | Incrementa i += 2
		 * i = n | Ya no se ejecuta, no se cumple 'i < n'
		 * 
		 * Calculo:
		 * Tenemos: i = 2k
		 * Condicion: i < n
		 * Reemplazo: 2k < n
		 * Resultado: k < n/2
		 * 
		 * Entonces:
		 * El numero de iteraciones incrementa segun la cantidad
		 * de datos enviados al metodo divido entre 2, es O(n/2)
		 * 
		 */
		
	}
	
}
