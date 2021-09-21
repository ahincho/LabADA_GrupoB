
public class Ejercicio3 {
	
	public static void main(String[] args) {
		
		// Metodo main del programa
		
		int[] array = { 10, 4, 8, 9, 1, 15, 7, 5, 13, 6 };
		imprimir(array);
		insertionSort(array);
		System.out.println("\n¡Imprimiendo arreglo ordenado!\n");
		imprimir(array);
		
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
	
	public static void imprimir(int[] a) {
		
		// Metodo auxiliar para imprimir el contenido de un arreglo
		// estandar de numeros enteros que se pasa como argumento
		
		System.out.println("Imprimiendo el arreglo: ");
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ", "); 
		}
		System.out.println();
		
	}
	
}
