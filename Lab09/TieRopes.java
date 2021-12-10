
/* 
 * Autor: Hincho Jove, Angel Eduardo
 * 
 * Descripcion del Problema:
 * 
 * Se nos entrega un arreglo estandar de enteros que representan
 * las diferentes longitudes de pedazos de cuerda. Estos pedazos
 * de cuerda pueden ser unidos en caso de ser adyacente (uno al
 * lado del otro). Tambien se nos entrega un numero 'k' el cual
 * es la longitud 'minima' que se quiere obtener al amarrar todos
 * los pedazos de cuerda.
 * 
 * Se nos pide devolver la cantidad de cuerdas amarradas que sean
 * mayores o iguales a la longitud brindada en el valor de 'k'
 * 
 */

public class TieRopes {
	
	public static void main(String[] args) {
		
		// Metodo main del programa
		
		// Creando un arreglo estandar de enteros, longitudes
		int[] a = { 1, 2, 3, 4, 1, 1, 3 };
		
		// Imprimir por consola cantidad de cuerdas 'correctas'
		System.out.println("Cuerdas: " + ropesAmount(4, a));
		
	}
	
	// Para comprobar este metodo en la pagina web se cambio
	// su nombre en la pagina de 'ropesAmount' a 'solution'
	
	// Explicacion de la Solucion:
	
	// En este caso, solo debemos 'amarrar' las cuerdas hasta
	// que cumplan con la longitud minima requerida que es 'k'
	// Como las cuerdas solo pueden ser amarradas si son adya-
	// centes, nos ayuda mucho ya que solo debemos iterar en
	// orden secuencial y 'amarrar' hasta que se cumpla con 'k'
	
	public static int ropesAmount(int k, int[] a) {
	
		// Metodo 'ropesAmount' recibe la longitud minima de
		// aceptacion para una cuerda amarrada. Recibe un
		// arreglo estandar que contiene las longitud de los
		// pedazos de cuerda a amarrar (solo adyacente).
		
		// Variable auxiliar 'tiedRopes', cantidad de cuerdas
		// amarradas que seran aceptadas con respecto a 'k'
		int tiedRopes = 0;
		
		// Variable 'currentLength', variable auxiliar para
		// guardar la longitud de la cuerda amarrada actual
		int currentLength = 0;
		
		// Iteraremos sobre todas las cuerdas
		for(int i = 0; i < a.length; i++) {
			
			// Agregamos la longitud de la cuerda actual
			currentLength += a[i];
			
			// Si la longitud es mayor o igual al valor de 'k'
			if(currentLength >= k) {
				
				// Reiniciamos la variable auxiliar
				currentLength = 0;
				
				// Agregamos una cuerda que cumple la condicion
				tiedRopes++;
				
			}
			
		}
		
		// Finalmente devolvemos el total de cuerdas 'correctas'
		return tiedRopes;
		
	}
	
}
