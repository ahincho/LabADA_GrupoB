
/* 
 * Autor: Hincho Jove, Angel Eduardo
 * 
 * Descripcion del problema: Implementar el algoritmo de
 * busqueda binaria para encontrar los cuadrados dentro
 * de un arreglo de numeros datos.
 * 
 */

public class SquareSearch {
	
	public static void main(String[] args) {
		
		// Metodo main del programa
		
		giveAnAnswer(squareSearch(7));
		giveAnAnswer(squareSearch(16));
		giveAnAnswer(squareSearch(49));
		giveAnAnswer(squareSearch(4));
		giveAnAnswer(squareSearch(11));
		giveAnAnswer(squareSearch(13));
		giveAnAnswer(squareSearch(6));
		giveAnAnswer(squareSearch(9));
		
	}
	
	public static int squareSearch(int number) {
		
		// Metodo SquareSearch recibe un numero entero
		// y verifica si este es un numero cuadrado
		
		int left = 0;
		int right = number;
		int mid;
		
		System.out.print("El numero " + number + " es cuadrado?: ");
		
		while(left <= right) {
			
			// Estableciendo el punto 'medio' del array
			
			mid = left + (right - left)/2;			
			
			if(mid * mid == number) {
				
				// Si al multiplicar el valor de 'mid*mid' es
				// igual a 'number' entonces si es un cuadrado
				
				return number;
				
			} else if (mid * mid < number) {
				
				// Si el valor de 'mid*mid' es menor a 'number'
				// pasaremos a buscar en la parte superior
				
				left = mid + 1;
				
			} else {
				
				// Si el valor de 'mid*mid' es mayor a 'number'
				// pasaremos a buscar en la parte inferior
				
				right = mid - 1;
				
			}
			
		}
		
		// En este caso, el numero que se envio como
		// parametro al metodo no es un numero cuadrado
		
		return -1;
		
	}
	
	public static void giveAnAnswer(int answer) {
		
		// Metodo auxiliar para mostrar una respuesta segun
		// el dato devuelto por el metodo 'SquareSearch'
		
		if(answer != -1) {
			
			System.out.println("Es cuadrado!");
			
		} else {
			
			System.out.println("No es cuadrado!");
			
		}
		
	}
	
}
