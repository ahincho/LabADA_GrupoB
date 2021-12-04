
/* 
 * Autor: Hincho Jove, Angel Eduardo
 * 
 * Descripcion del Problema: Parecido al Problema de la Mochila
 * 
 * Se quiere comprar 'n' diferentes libros de una biblioteca. Asi
 * mismo sabemos los precios de cada libro y cantidad de paginas.
 * 
 * Queremos saber la maxima cantidad de paginas que podemos comprar.
 * Implementar el codigo para el problema usando Prog. Dinamica.
 * 
 */

import java.util.Scanner;

public class BookShop {
	
	public static void main(String[] args) {
		
		// Metodo main del programa
		
		Scanner scan = new Scanner(System.in);
		
		// Recibimos todos los datos necesarios
		
		// n = Cantidad de libros, x = Dinero que poseemos
		// prices[] = Precio * Libro, pages[] = Paginas * Libro
		
		int n = scan.nextInt();
		
		int x = scan.nextInt();
		
		int[] prices = new int[n];
		
		int[] pages = new int[n];
			
		for(int i = 0; i < n; i++) {
				
			prices[i] = scan.nextInt();
				
		}
					
		for(int i = 0; i < n; i++) {
				
			pages[i] = scan.nextInt();
				
		}
		
		scan.close();
		
		bookShop(n, x, prices, pages);
		
	}
	
	public static void bookShop(int n, int x, int[] prices, int[] pages) {
		
		// Metodo bookShop, recibe la cantidad maximo de libros 'n',
		// la cantidad maxima que se puede pagar 'x', los precios
		// y paginas * libro. Devuelve la cantidad maxima de paginas.
		
		/*
		 * Relacion de Recurrencia! ... Tenemos una matriz auxiliar maxPages[i][j]
		 * 
		 * Siendo:
		 * 		i = Indice del Libro. Iteramos sobre el
		 * 		j = Precio maximo que podemos pagar. Iteramos sobre el
		 * 		Ji = Precio del Libro actual que estamos iterando
		 * 		B = Matriz auxiliar para guardar los resultados por PD
		 * 		C = Matriz que contiene las paginas de cada Libro
		 * 
		 * Mientras i, j > 0 Iterar en i y j:
		 *   
		 *   Evaluar si tenemos 'presupuesto' para comprar otro libro
		 *   
		 *   Caso Base
		 *   
		 *   si j - Ji < 0 Entonces NO tenemos presupuesto para otro Libro ...
		 *     
		 *     B[i, j] = B[i - 1, j] ... Copiar el valor anterior
		 *   
		 *   Caso Recurrente
		 *     
		 *   sino ... Hay espacio para otro Libro! Ver las paginas ...
		 *     
		 *     ... Evaluar si tenemos mas paginas agregando otro Libro ...
		 *     
		 *     B[i, j] = max(B[i - 1, j], C[i] + B[i - 1, j - Ji]
		 *     
		 */
		
		int[][] maxPages = new int[n + 1][x + 1];
		
		// Llenar el arreglo bidimensional auxiliar segun lo visto en la Recurrencia
		
		for(int i = 0; i < n; i++) {
			
			for(int j = 0; j <= x; j++) {
				
				// Copiar el valor anterior y evaluar el presupuesto ...
				
				maxPages[i + 1][j] = maxPages[i][j];
				
				// Si tenemos presupuesto, entocnes ver las paginas ...
				
				if(prices[i] <= j) {
					
					// Elegir la mayor cantidad de paginas! Agregando o no
					// un nuevo libro a nuestra 'compra'. Y reemplazarlo!
					
					maxPages[i + 1][j] = Math.max(maxPages[i + 1][j], pages[i] + maxPages[i][j - prices[i]]);
					
				}
				
			}
			
		}
		
		// Imprimir por pantalla la cantidad maxima de hojas ...
		
		System.out.println(maxPages[n][x]);
		
	}
	
}
