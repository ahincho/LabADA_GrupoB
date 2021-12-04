
/* 
 * Autor: Hincho Jove, Angel Eduardo
 * 
 * Descripcion del Problema:
 * 
 * Un robot esta localizado en la esquina superior derecha de un 
 * grilla de m x n celdas. El robot solo puede realizar dos
 * movimientos: abajo o derecha en cualquier momento.
 * 
 * El robot quiere llegar a la parte inferior derecha de la grilla.
 * Implementar el codigo para realizar estos movimientos usando PD.
 * 
 */

public class UniquePath {
	
	public static void main(String[] args) {
		
		// Metodo main del programa
		
		// Arreglo bidimensional de numeros enteros, nuestro tablero
		
		int[][] grid =  { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		
		// Calculando las maneras o rutas para llegar al destino
		
		int paths = uniquePathsWithObstacles(grid);
		
		System.out.println("Total de caminos: " + paths);
		
	}
	
	public static int uniquePathsWithObstacles(int[][] grid) {
		
		// Metodo uniquePathsWithObstacles, recibe el tablero que es
		// el arreglo bidimensional. Empezaremos a iterar para poder
		// encontrar los posibles caminos para llegar al destino
		
		/* 
		 * Relacion de Recurrencia! ... Tenemos una matriz de T[i][j]
		 * Ojo debemos tener en cuenta si existe un obstaculo!
		 * 
		 * Caso Base: Cuando i = 0 o j = 0
		 * 	T[i][j] = 1  ... Considerar Obstaculos 'Truncado'
		 * 		
		 * Caso Recurrente: Cuando i > 0 y j > 0
		 * 	T[i][j] = T[i - 1][j] + T[i][j - 1] ... Considerar Obstaculos
		 * 
		 */
		
		int rows = grid.length, cols = grid[0].length;
		
		System.out.println("Rows: " + rows + ", Cols: " + cols);
		
		// Arreglo bidimensional para la Programacion Dinamica
		
		int[][] path = new int[rows][cols];
		
		// Bancera 'isObstacle' indicara si la celda es un obstaculo
		// Para el Caso Base: Se truncara la primera fila o columna
		// Para el Caso Recurrente: Se dejara como '0' o no accesible
		
		boolean isObstacle = false;
		
		// Debemos llenar la primera fila y columna de '1'. Teniendo
		// en cuenta los obstaculos y que si encontramos un obstaculo
		// las siguientes celdas o posiciones se 'truncan' con 0's
		
		for(int i = 0; i < cols; i++) {
			
			if(isObstacle || grid[0][i] == 1) {
				
				isObstacle = true;
				path[0][i] = 0;
				
			} else {
				
				path[0][i] = 1;
				
			}
			
		}
		
		isObstacle = false;
		
		for(int i = 0; i < rows; i++) {
			
			if(isObstacle || grid[i][0] == 1) {
				
				isObstacle = true;
				path[i][0] = 0;
				
			} else {
				
				path[i][0] = 1;
				
			}
			
		}
		
		// Ahora debemos llenar las rutas por PD
		
		// Verificamos si es un obstaculos y sus ancestros. Como
		// solo nos podemos mover hacia abajo y derecha entonces
		// los ancestros o posiciones son: arriba e izquierda
		
		for (int i = 1; i < path.length; i++) {
			
			for (int j = 1; j < path[0].length; j++) {
				
				if(grid[i][j] == 1) {
					
					path[i][j] = 0;
					
				} else {
					
					path[i][j] = path[i - 1][j] + path[i][j - 1];
					
				}
				
			}
			
		}
		
		// Finalmente devolvemos el contenido de la ultima celda 
		
		return path[rows - 1][cols - 1];
		
	}
	
}
