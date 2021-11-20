
/* 
 * Autor: Hincho Jove, Angel Eduardo
 * 
 * Descripcion del Problema: Estamos esperando nuestro turno en
 * una entrevista, se guarda en un arreglo estandar los tiempos
 * que demoraria entrevistar a cada persona (Nosotros tenemos 
 * una demora de -1). La manera que el entrevistador selecciona
 * a la siguiente persona es viendo los extremos del arreglo y
 * eligiendo al de menor tiempo de entrevista. Se pide hallar
 * cuanto tendriamos que esperar para ser entrevistados
 * 
 */

import java.util.LinkedList;
import java.util.Deque;

public class InterviewWait {
	
	public static void main(String[] args) {
		
		// Metodo main del programa
		
		String input1 = "4 -1 5 2 3";
		interviewVait(input1);
		
	}
	
	public static void interviewVait(String input) {
		
		// Metodo 'interviewWait', recibe un String input que
		// contiene los tiempos de demora de los entrevistados
		// (sin corchetes y separados con espacios). Los guarda
		// en una Cola Dobla y finalmente imprime cuanto tiempo
		// debemos esperar para que seamos entrevistados
		
		// Encolamos los tiempos en una Cola Doble con 'enDeque'
		
		Deque<Integer> d = enDeque(input);
		
		// Variables enteras que representan el tiempo que vamos
		// a esperar hasta ser entrevistados y la persona que se
		// eligio para cada iteracion respectivamente
		
		int timeWaiting = 0, selectedPerson;
		
		System.out.println("COLA DE ENTREVISTADOS: " + d);
		
		// Mientras nuestra Cola Doble no este vacia, iteraremos
		
		while(!d.isEmpty()) {
			
			// Imprimimos la Cola Doble
			
			System.out.println(d);
			
			// Hacemos referencia a sus extremos, inicio y fin
			
			int first = d.peekFirst();
			int last = d.peekLast();
			
			// Si 'nosotros' estamos en los extremos, seremos
			// elegidos por nuestro tiempo de entrevista -1
			
			if(first == -1 || last == -1) {
				
				System.out.println("ES NUESTRO TURNO!");
				break;
				
			}
			
			// En otro caso, es el turno de otra persona
			
			System.out.println("ES EL TURNO DE OTRA PERSONA");
			
			// Verificamos cual de estas personas demanda
			// menos tiempo para ser entrevistada
			
			if(first < last) {
				
				// Si demora menos el entrevistar al de la
				// izquerda lo desencolamos al de la izquierda
				
				selectedPerson = d.pollFirst();
				
			} else {
				
				// Si demora menos el entrevista al de la
				// derecha lo desencolamos al de la derecha
				
				selectedPerson = d.pollLast();
				
			}
			
			// Imprimos a que persona se eligio en la iteracion
			
			System.out.println("Se eligio a: " + selectedPerson);
			
			// Sumamos el tiempo que demorara entrevistar a esta
			// persona seleccionada al tiempo que esperaremos
			
			timeWaiting += selectedPerson;
			
		}
		
		// Finalmente, imprimimos el tiempo que hemos esperado o
		// esperaremos hasta poder ser entrevistados en la reunion
		
		System.out.println("TIEMPO ESPERANDO: " + timeWaiting);
		
	}
	
	public static Deque<Integer> enDeque(String s) {
		
		// Metodo 'enDeque', recibe un String input y lo divide
		// cuando encuentra un espacio en blanco ' ' con la
		// funcion auxiliar de la clase Split(). Ya dividido
		// el input se almacena en una Cola Doble de Integer
		
		Deque<Integer> deque = new LinkedList<Integer>();
		
		for(String e : s.split(" ")) {
			
			deque.add(Integer.parseInt(e));
			
		}
		
		return deque;
		
	}
	
}
