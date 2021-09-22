
/* 
 * Autor: Hincho Jove, Angel Eduardo
 * 
 * Descripcion del problema: Se nos pide buscar un elemento dentro de un
 * arreglo de enteros estandar. Usando el metodo de Busqueda Lineal. Ademas
 * se debe guardar los tiempos de ejecuciones para diferentes cantidades de
 * elementos y armar una gráfica de su crecimiento correspondiente
 * 
 */

public class Ejercicio2_Timer {
	
	public static void main(String[] args) {
		
		// Metodo main para el programa
		
		// Haremos la medicion de tiempo para 10^10 elementos
		double[][] matriz = testearBusqLineal(10);
		System.out.println();
		imprimirMatriz(matriz);
		
	}
	
	public static double[][] testearBusqLineal(int n) {
		
		// El metodo 'testearBusqLineal' recibe un entero que sera las
		// veces que iteraremos para testear el tiempo. Se medirá los tiempos
		// cuando se quiere buscar un elemento dentro de un arreglo
		// de manera lineal para luego almacenarlos en un arreglo
		// estandar bidimensional que guardara cuantos elementos se
		// tomaron en cuenta y cuanto tiempo en milisegs tomo el proceso
		
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
		// buscar el numero '15' dentro del mismo. Tambien mide el tiempo
		// que toma solo el buscar el elemento '15' en el arreglo.
		// Finalmente, se devuele el tiempo que se necesito para lo anterior
		
		int[] array = crearArray(cantidad);
		System.out.println("Evaluando para " + cantidad + " elementos");
		double inicioTime = System.currentTimeMillis();
		busquedaLineal(array, 15);
		double finTime = System.currentTimeMillis();
		
		return (finTime - inicioTime);
		
	}
	
	public static boolean busquedaLineal(int[] array, int buscar) {
		
		// Metodo 'busquedaLineal' recibe como argumentos un arreglo
		// estandar de enteros y un entero que se quiere buscar dentro
		// de dicho arreglo estandar, devuelve verdadero si se encuentra
		// dentro del arreglo y falso si no se encuentra
		
		boolean respuesta = false;
		for(int i = 0; i < array.length - 1; i++) {
			if(array[i] == buscar) {
				respuesta = true;
				break;
			}
		}
		
		return respuesta;
		
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
