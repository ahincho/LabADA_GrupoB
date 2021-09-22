
/* 
 * Autor: Hincho Jove, Angel Eduardo
 * 
 * Descripcion del problema: Se nos pide ordenar un arreglo estandar de
 * elementos, en este caso numeros enteros, usando el algoritmo de ordenacion
 * por insercion asi como mostrar el antes y despues de estar ordenado
 * Para esta version, tambien se guardaran los tiempos requeridos para ordenar
 * cierta cantidad de elementos en una matriz bidimensional mostrada por consola
 * 
 */

public class Ejercicio3_Timer {
	
	public static void main(String[] args) {
		
		// Metodo main del programa
				
		// Haremos la medicion de tiempo para 10^6 elementos
		double[][] matriz = testearInsertionSort(6);
		System.out.println();
		imprimirMatriz(matriz);
		
	}
	
	public static double[][] testearInsertionSort(int n) {
		
		// El metodo 'testearInsertionSort' recibe un entero como argumentos que
		// sera el numero de iteraciones que se haran, empezaremos con 10 elementos
		// y luego esta cantidad ira subiendo en potencias de 10. O sea 10, 100,
		// 1000, 10000, ... Tambien se almacenaran cuanto tiempo tomo ordenar 'n'
		// elementos en una arreglo bidimensional que sera devuelto
		
		// Finalmente, devuelve la matriz o arreglo bidimensional donde se
		// guardaron las mediciones de tiempos para cada cantidad de elementos
		
		double[][] tiempos = new double[n][2]; 
		// Los elementos seran potencias de 10 y dependen del argumento 'n'
		int elementos = 10;
		double tiempoRequerido = 0;
		for(int i = 0; i < n; i++) {
			tiempoRequerido = medirTiempo(elementos);
			// Guardando la cantidad de elementos en el arreglo
			tiempos[i][0] = elementos;
			// Guardando el tiempo que se tomo para buscar un elemento
			tiempos[i][1] = tiempoRequerido;
			// Finalmente multiplicar por 10 la cantidad de elementos
			elementos = elementos * 10;
		}
				
		return tiempos;
		
		
	}
	
	public static double medirTiempo(int cantidad) {
		
		// El metodo 'medirTiempo' crea un arreglo de 'n' elementos y
		// ordena sus elementos. Tambien mide el tiempo que toma solo
		// el ordenar los elementos en el arreglo. Finalmente, se 
		// devuelve el tiempo que se necesito para lo anterior
		
		int[] array = crearArray(cantidad);
		System.out.println("Evaluando para " + cantidad + " elementos");
		double inicioTime = System.currentTimeMillis();
		insertionSort(array);
		double finTime = System.currentTimeMillis();
		
		return (finTime - inicioTime);
		
	}
	
	public static void insertionSort(int[] array) {
		
		// Metodo 'ordenarArray' el cual recibe un arreglo estandar de
		// enteros, haciendo uso del algoritmo de Ordenacion por Insercion
		// se ordena este arreglo de manera interna, no devuelve nada ya que
		// el arreglo queda ordenado sin tener que crear un arreglo auxiliar
		
		int pos, temp;
		for(int i = 0; i < array.length; i++) {
			pos = i;
			temp = array[i];
			while((pos > 0) && (array[pos - 1] > temp)) {
				array[pos] = array[pos - 1];
				pos--;
			}
			array[pos] = temp;
		}
		
	}
	
	public static int[] crearArray(int n) {
		
		// Metodo auxiliar para crear un arreglo estandar de enteros de
		// 'n' enteros. Se llena de forma descendente, estando 'n' en la
		// primera posicion y '0' en la ultima posicion
		
		int[] array = new int[n];
		for(int i = 0; i < n; i++) {
			array[i] = (n - i);
		}
		
		return array;
		
	}
	
	public static void imprimirMatriz(double[][] a) {
		
		// Metodo auxiliar para imprimir el contenido del arreglo
		// bidimensional donde se guardaron las mediciones de tiempos
		// y cantidades de elementos que se realizaron anteriomente
		
		System.out.println("Imprimiendo el arreglo: ");
		for(int i = 0; i < a.length; i++) {
			System.out.println("Iteracion N°" + (i + 1));
			// Como sabemos que el arreglo bidimensional tiene 2 columnas
			// una para 'cantidad de elementos' y otra para 'tiempo tomado'
			// no es necesario iterar sobre las columnas
			System.out.println("\tCantidad de Elementos: " + a[i][0]);
			System.out.println("\tTiempo: " + a[i][1] + " MiliSegs.");
			System.out.println();
		}
		
	}
	
}
