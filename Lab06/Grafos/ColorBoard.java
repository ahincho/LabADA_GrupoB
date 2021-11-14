
/* 
 * Autor: Hincho Jove, Angel Eduardo
 * 
 * Descripcion del Problema: Se nos pide implementar
 * el recorrido DFS para pintar un tablero delimitado
 * por paredes (1). Los lugares o piezas no pintadas
 * se representan con (0) y las pintadas con (2)
 * 
 */

public class ColorBoard {
	
	public static void main(String[] args) {
		
		// Metodo main del programa
		
		int[][] board = { { 1, 1, 1, 1, 1, 1, 1 },
		                  { 1, 0, 0, 0, 0, 0, 1 },
		                  { 1, 0, 0, 0, 0, 0, 1 },
		                  { 1, 0, 0, 0, 0, 0, 1 },
		                  { 1, 0, 0, 0, 0, 1, 0 },
		                  { 1, 1, 1, 1, 1, 0, 0 } };
		
		printBoard(board);
		
		colorBoard(board, 5, 5);
		
	}
	
	public static void colorBoard(int[][] board, int row, int column) {
		
		// Metodo colorBoard, 'colorea' el tablero empezando
		// en un punto especifico y pintando sus alrededores
		
		// Arreglos con los 'movimientos' que se realizaran
		// dentro de la matriz o el tablero de fichas
		
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		
		if(isValid(board, row, column)) {
			
			colorSquare(board, row, column);
			printBoard(board);
			
			for(int i = 0; i < 4; i++) {
				
				// Antes de llamar recursivamente, verificar si
				// es una posicion dentro del tablero valida
				
				if(isValid(board, row + dx[i], column + dy[i])) {
					
					if(!isWall(board[row + dx[i]][column + dy[i]])
							&& !isColored(board[row + dx[i]][column + dy[i]])) {
						
						colorBoard(board, row + dx[i], column + dy[i]);
						
					}
					
				}
				
			}
			
		}
		
	}
	
	public static void colorSquare(int[][] board, int row, int column) {
		
		// Metodo que recibe el tablero, fila y columna. Verifica que
		// la fila y columna sean validas y esten dentro del tablero
		// para finalmente pintar el cuadrado o la pieza del tablero
		
		if(!isWall(board[row][column])
				&& !isColored(board[row][column])) {
			
			board[row][column] = 2;
				
		}
		
	}
	
	public static boolean isColored(int color) {
		
		// Verifica si un cuadrado o pieza esta pintada
		
		return color == 2;
		
	}
	
	public static boolean isWall(int color) {
		
		// Verifica si un cuadrado o pieza es una pared
		
		return color == 1;
		
	}
	
	// Posicion minima = 0, maxima = board.length - 1
	
	public static boolean isValid(int[][] board, int row, int column) {
		
		// Verifica si la fila y columna se encuentra
		// dentro del tablero o arreglo bidimensional
		
		return (row > -1 && row <= board.length - 1) &&
			(column > -1 && column <= board[row].length - 1);
		
	}
	
	public static void printBoard(int[][] board) {
		
		// Metodo auxiliar para imprimir el tablero
		// junto con su contenido o 'coloreado'
		
		System.out.println("Imprimiendo el Tablero");
		
		for(int i = 0; i < board.length; i++) {
			
			for(int j = 0; j < board[i].length; j++) {
				
				System.out.print(board[i][j] + " ");
				
			}
			
			System.out.println();
			
		}
		
	}
	
}
