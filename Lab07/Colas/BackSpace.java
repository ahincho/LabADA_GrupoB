
/* 
 * Autor: Hincho Jove, Angel Eduardo
 * 
 * Descripcion del Problema: Implementar el funcionamiento de
 * la tecla 'Delete' o 'Backspace' del teclado para un input.
 * Considerar que simbolo '#' indica que se presiono 'Backspace'
 * 
 */

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class BackSpace {
	
	public static void main(String[] args) {
		
		// Metodo main del programa
		
		String input1 = "abc#de##f#ghi#jklmn#op#";
		
		System.out.println("Primer Input!\n");
		System.out.println(backSpace(input1));
		
	}
	
	public static String backSpace(String s) {
		
		// Metodo 'backSpace', recibe un String de input del
		// cual guardaremos sus caracteres en una Cola Doble
		
		Deque<Character> deque = new LinkedList<Character>();
				
		System.out.println("COLA: " + deque + "\n");
		
		// Iteraremos por cada caracter del input
		
		for(Character c : s.toCharArray()) {
			
			// Una vez tenemos el caracter del input debemos
			// evaluar si es un backspace '#' o una 'letra'
			
			System.out.println("Caracter: " + c);
			
			// Si el caracter es un backspace '#' entonces
			// debemos desencolar el elemento anterior
			
			if(c == '#') {
				
				System.out.println("BackSpace!");
				
				if(!deque.isEmpty()) {
					
					// Si la Cola aun no esta vacia, desencolar
					
					deque.removeLast();
					
				} else {
					
					// Cuando la Cola esta vacia, indicarlo y no
					// realizar otra operacion. Esto es como
					// cuando presionamos 'Backspace' cuando no
					// tenemos un texto o caracter en pantalla
					
					System.out.println("La Cola esta vacia");
					
				}
				
			} else {
				
				// En caso de no ser un backspace, encolar
				
				deque.add(c);
				
			}
			
			System.out.println("COLA: " + deque + "\n");
			
		}
		
		System.out.print("RESULTADO: ");
		
		return dequeToString(deque);
		
	}
	
	public static <E> String dequeToString(Deque<E> d) {
		
		// Metodo 'dequetoString' recibe una Cola Doble, crea
		// un iterador sobre el contenido de la Cola Doble para
		// poder unirlo o 'devolverlo' en una variable String
		
		Iterator<E> it = d.iterator();
		
		String result = "";
		
		while(it.hasNext()) {
			
			result += it.next();
			
		}
		
		return result;
		
	}
	
}
