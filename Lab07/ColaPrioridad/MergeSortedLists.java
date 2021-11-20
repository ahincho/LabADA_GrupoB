
/* 
 * Autor: Hincho Jove, Angel Eduardo
 * 
 * Descripcion del Problema: Se pide ingresar los elementos de una
 * Lista de Listas a una Cola de Prioridad para luego ser estos
 * elementos desencolados acorde a su grado o nivel de prioridad
 * 
 */

import java.util.PriorityQueue;

public class MergeSortedLists {
	
	public static void main(String[] args) {
		
		// Metodo main del programa
		
		int[][] lists = { { 1, 4, 5 },
						  { 1, 3, 4 },
						  { 2, 6 }  };
		printLists(lists);
		
		mergeLists(lists);
		
	}
	
	public static void mergeLists(int[][] list) {
		
		// Metodo 'mergeLists' recibe un array bidimensional que
		// es la representacion de nuestra Lista de Lista. Agrega
		// todos los elementos de la Lista de Listas a un Cola de
		// Prioridad. Esta se encarga de desencolar los elementos
		// de manera que se prioricen aquellos con mayor prioridad
		
		PriorityQueue<Integer> pq =
				new PriorityQueue<Integer>();
		
		// Agregando los elementos que se encuentran dentro
		// del arreglo bidimensional a la Cola de Prioridad
		
		for(int i = 0; i < list.length; i++) {
			
			for(int j = 0; j < list[i].length; j++) {
				
				pq.add(list[i][j]);
				
			}
			
		}
		
		// Imprimimos el contenido de nuestra Cola de Prioridad
		
		System.out.println("COLA DE PRIORIDAD: " + pq);
		
		// Con ayuda del metodo 'dequeLists' empezamos a
		// desencolar los elementos de la Cola Prioridad
		
		System.out.println("ORDEN FINAL: " + dequeLists(pq));
		
	}
	
	public static String dequeLists(PriorityQueue<Integer> pq) {
		
		// Metodo 'dequeLists' recibe una Cola de Prioridad e
		// itera sobre esta mientras no este vacia, en cada
		// iteracion desencola el elemento de mayor prioridad
		
		String result = "[ ";
		
		while(!pq.isEmpty()) {
			
			result += pq.poll();
			
			if(!pq.isEmpty()) {
				
				result += ", ";
				
			}
			
		}
		
		result += " ]";
		
		return result;
		
	}
	
	public static void printLists(int[][] a) {
		
		// Metodo 'printLists' recibe un arreglo bidimensional
		// que representa nuestra 'Lista de Listas' e imprime
		// el contenido de cada lista, separadas con corchetes
		
		System.out.print("LISTAS INGRESADAS: [ ");
		
		for(int i = 0; i < a.length; i++) {
			
			for(int j = 0; j < a[i].length; j++) {
				
				if (j == a[i].length) {
					
					System.out.println(" ]");
					
				} else if (j == a[i].length - 1) {
					
					System.out.print(a[i][j]);
					
				} else {
					
					if(j == 0) {
						
						System.out.print("[ ");
						
					}
					
					System.out.print(a[i][j] + ", ");
					
				}
				
			}
			
			if(i == a.length - 1) {
				
				System.out.print(" ] ]");
				
			} else {
				
				System.out.print(" ], ");
				
			}
			
		}
		
		System.out.println();
		
	}
	
}
