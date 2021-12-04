
/* 
 * Autor: Hincho Jove, Angel Eduardo
 * 
 * Descripcion del Problema:
 * 
 * Se nos entrega una grilla o tablero de dimensiones m * n que contiene
 * caracteres, especificamente 0's y 1's. El 0 representa que la grilla
 * o celda no esta pintada mientras que el 1 indica que esta pintada. De
 * esta manera se pide hallar el area del cuadrado mas grande de grilla
 * 
 * Implementar el codigo para el problema usando Prog. Dinamica.
 * 
 */

public class MaximalSquare {
	
	public static void main(String[] args) {
		
		// Metodo main del programa
		
		// Recibimos la matriz con los caracteres 0's y 1's
		
		char[][] matrix = { { '1', '0', '1', '0', '0' },
				    { '1', '0', '1', '1', '1' },
				    { '1', '1', '1', '1', '1' },
				    { '1', '0', '0', '1', '0' } };
		
		System.out.println(maximalSquare(matrix));
		
	}
	
	public static int maximalSquare(char[][] matrix) {
		
		// Metodo maximalSquare, recibe una matriz de 0's y 1's
		// Utiliza programacion dinamica para encontrar el cuadrado
		// mas grande de la matriz. Finalmente devuelve el area que
		// el cuadrado mas grande ocupa en la matriz (Lado * lado)
		
		/*
		 * Relacion de Recurrencia! ... Matriz auxiliar length[a + 1][b + 1]
		 * 
		 * Iteraremos por todas las posiciones de la grilla (filas y columnas)
		 * 
		 * Siendo: i = filas y j = columnas
		 * 
		 * Caso Base: Cuando las posiciones son iguales a 0 (Agregadas extra)
		 * 
		 * 		T[i][j] = 0 Si: i == j
		 * 
		 * Caso Recurrente: Cuando es PARTE de la grilla original, evaluar
		 * 					alrededores como si se tratara de un DFS
		 * 		
		 * 		Si ... Esta pintado ('1')
		 * 			T[i][j] = 1 + min(T[i - 1][j], min(T[i][j - 1], T[i - 1][j - 1]));
		 * 
		 *     
		 */
		
		// Verificamos el numero de filas de la matriz
		
		int rows = matrix.length;
		
		if(rows == 0) {
			
			// Si es igual a 0 entonces es vacia. Devolver 0
			
			return 0;
			
		}
		
		// Guardamos el numero de columnas que posee la matriz
		
		int cols = matrix[0].length;
		
		// Matriz auxiliar de dimensiones rows + 1 * cols + 1
		
		int[][] board = new int[rows + 1][cols + 1];
		
		// Var Auxiliar que guarda el lado mas grande en la matriz
		
		int biggest = 0;
		
		// Iteraremos por todas las posiciones de la matriz dada
		
		for(int i = 1; i < rows + 1; i++) {
			
			for (int j = 1; j < cols + 1; j++) {
				
				// Si la celda en revision se encuentra pintada '1'
				
				if(matrix[i - 1][j - 1] == '1') {
					
					// Verificaremos por las otras 3 posiciones que se encuentran
					// a su alrededor, como si se tratara de un recorrido DFS
					
					// Rescatamos los valores minimos de sus alrededores y sumamos 1
					
					board[i][j] = 1 + Math.min(board[i - 1][j], Math.min(board[i][j - 1], board[i - 1][j - 1]));
                    
					// Si el valor de la celda supera al 'maximo actual', actualizar maximo actual
					
					if(biggest < board[i][j]) {
						
						// Actualizando el valor del lado mas grande de nuestra grilla
						
						biggest = board[i][j];
						
					}
					
				}
				
			}
			
		}
		
		// Finalmente devolvemos (biggest * biggest) ya que es el area del cuadrado mas grande en la grilla
		
		return biggest * biggest;
		
	}
	
}
