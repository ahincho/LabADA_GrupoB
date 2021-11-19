
/* 
 * Autor: Hincho Jove, Angel Eduardo
 * 
 * Descripcion del Problema: Implementar el funcionamiento de un
 * 'teclado especial' el cual tiene simbolos para 'enviar' o 'liberar'
 * el buffer asi como tambien un simbolo para activar el 'Bloq Mayus'
 * 
 */

import java.util.LinkedList;
import java.util.Queue;

public class CapsLock {
	
	public static void main(String[] args) {
		
		// Metodo main del programa
		
		String input1 = "abc$d@ef$@g$";
		System.out.println("Primer Input!\n");
		capsLock(input1);
		
	}
	
	public static void capsLock(String input) {
		
		// Metodo 'capsLock' recibe un String y se apoya en el
		// metodo 'enQueue' para crear una Cola de los caracteres
		// que estan contenidos en el String. Despues evalua:
		
		// '$' = Caracter especial que libera e imprime el buffer
		// '@' = Caracter especial que representa el 'bloqMayus'
		
		Queue<Character> q = enQueue(input);
		
		// Imprimimos la Cola y su contenido, caracteres del input
		
		System.out.println("COLA: " + q);
		
		// Variables Strings auxiliares para el resultado y el buffer
		
		String result = "", buffer = "";
		
		// Imprimimos el contenido del buffer, inicialmente vacio
		
		System.out.println("\tBuffer: " + buffer);
		
		// Variable auxiliar para indicar el estado de la tecla
		// 'BloqMayus', siendo inicialmente su estado 'false o
		// apagado' cada vez que se 'presiona' cambia al contrario
		
		boolean bloqMayus = false;
		
		// Iterar mientras la Cola contenga caracterers del input
		
		while(!q.isEmpty()) {
			
			// Desencolar un Caracter de la Cola y evaluar ...
			
			Character c = q.poll();
			
			if(c == '$') {
				
				// Si es el simbolo '$' para liberar el buffer
				
				System.out.println("LIBERANDO EL BUFFER");
				
				System.out.println("COLA: " + q);
				
				// Antes de liberar el buffer, evaluar 'bloqMayus'
				
				if(bloqMayus) {
					
					// Si esta 'presionado' entonces devolver en Mayus
					
					System.out.println("BLOQ. MAYUS ACTIVADO");
					
					buffer = buffer.toUpperCase();
					
				} else {
					
					// En otro caso devolver en Minusculas
					
					System.out.println("BLOQ. MAYUS DESACTIVADO");
					
				}
				
				// Agregar a 'result' el contenido del buffer liberado
				
				result += buffer;
				buffer = "";
				System.out.println("RESULTADO: " + result);
				System.out.println("\tBuffer: " + buffer);
				
			} else if(c == '@') { 
				
				// Si el caracter desencolado de la Cola es '@'
				// entonces cambiar el estado de 'bloqMayus'
				
				System.out.println("SE PRESIONO BLOQ. MAYUS!");
				
				bloqMayus = !bloqMayus;
				
			} else {
				
				// En otro caso agregar el caracter desencolado
				// a nuestra variable 'resultado' e imprimir
				
				buffer += c;
				System.out.println("\tBuffer: " + buffer);
				
			}
			
		}
		
		System.out.println("SE TERMINO DE PROCESAR EL TEXTO!");
		
	}
	
	public static Queue<Character> enQueue(String s) {
		
		// Metodo 'enQueue', recibe un String e itera por cada
		// uno de sus caracteres, los encola en una Cola de
		// Caracteres para devolver la Cola con caracteres
		
		Queue<Character> queue = new LinkedList<Character>();
		
		for(Character c : s.toCharArray()) {
			
			queue.add(c);
			
		}
		
		return queue;
		
	}
	
}
