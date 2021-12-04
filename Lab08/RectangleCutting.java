
/* 
 * Autor: Hincho Jove, Angel Eduardo
 * 
 * Descripcion del Problema:
 * 
 * Tenemos un rectangulo de dimensiones a * b y queremos cortarlo de
 * tal manera que en cada corte tengamos cuadrados. Solo podemos
 * cortar de manera que los lados sean enteros.
 * 
 * Queremos saber la minima cantidad de cortes que necesitamos realizar.
 * Implementar el codigo para el problema usando Prog. Dinamica.
 * 
 */

import java.util.Scanner;

public class RectangleCutting {
	
	public static void main(String[] args) {
		
		// Metodo main del programa
		
		Scanner scan = new Scanner(System.in);
		
		// Recibimos las entradas a y b, dimensiones
		
		int a = scan.nextInt();
		
		int b = scan.nextInt();
		
		scan.close();
		
		cutting(a, b);
		
	}
	
	public static void cutting(int a, int b) {
		
		// Metodo cutting, recibe la cantidad de filas y columnas del
		// rectangulo que queremos dividir en cuadrados mediante cortes
		
		// Creamos un arreglo bidimensional auxiliar donde trabajaremos
		// este arreglo auxiliar tendra las dimensiones a + 1 * b + 1
		
		int[][] cut = new int[a + 1][b + 1];
		
		/*
		 * Relacion de Recurrencia! ... Matriz auxiliar length[a + 1][b + 1]
		 * 
		 * Iteraremos por todas las posiciones del rectangulo (filas y columnas)
		 * 
		 * Siendo: i = filas y j = columnas
		 * 
		 * Caso Base: Cuando ya es un cuadrado y no necesitamos hacer un corte!
		 * 
		 * 		T[i][j] = 0 Si: i == j
		 * 
		 * Caso Recurrente: Cuando NO es un cuadrado y necesitamos cortarlo!
		 * 
		 * 		T[i][j] = min(corteHorizontal, corteVertical)
		 * 
		 * 		Debemos tener en cuenta que podemos cortar tanto en vertical
		 * 		como en horizontal, es por eso que debemos revisar ambos ...
		 * 
		 * 		CorteHorizontal ...
		 * 		
		 * 		Iterar en k mientras k < b - 1
		 * 			T[i][j] = 1 + T[i, j - k] + T[i, k]
		 * 		
		 * 		CorteVertical ...
		 * 		
		 * 		Iterar en k mientras k < a - 1
		 * 			T[i][j] = 1 + T[i - k, j] + T[k, j]
		 *     
		 */
		
		// Empezamos iterando por todas las posiciones del 'rectangulo'
		
		for (int rows = 1; rows < a + 1; rows++) {
			
			for (int cols = 1; cols < b + 1; cols++) {
				
				if(rows == cols) {
					
					// Caso Base cuando i == j
					
					cut[rows][cols] = 0;
					
				} else {
					
					// Establecemos una variable auxiliar para comparar con el
					// minimo de cortes, en un inicio esta variable es 'infinito'
					
					int ans = Integer.MAX_VALUE;
					
					// Revisamos por los posibles cortes en horizontal
					
					for (int i = 1; i < cols; i++) {
						
						// Guardamos los cortes en horizontal en la variable auxiliar
						
						ans = Math.min(ans, 1 + cut[rows][cols - i] + cut[rows][i]); 
						
					}
					
					// Revisamos por los posibles cortes en vertical
					
					for (int i = 1; i < rows; i++) {
						
						// Guardamos los cortes en verticales en la variable auxiliar
						
						// En esta parte evaluaremos cual 'tipo' tiene menor cantidad
						// de cortes, si tenemos menos cortes en 'vertical' u 'horizontal'
						
						ans = Math.min(ans, 1 + cut[rows - i][cols] + cut[i][cols]);
						
					}
					
					// Una vez evaluadas las posibles formas de cortar, devolver la
					// 'ultima' posicion de nuestro rectangulo con el minimo de cortes
					
					cut[rows][cols] = ans;
					
				}
				
			}
			
		}
		
		System.out.println(cut[a][b]);
		
	}
	
}
