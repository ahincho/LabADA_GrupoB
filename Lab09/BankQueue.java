
/* 
 * Autor: Hincho Jove, Angel Eduardo
 * 
 * Descripcion del Problema:
 * 
 * Tenemos que ayudar a Oliver que es el duenio de un Banco. El
 * Banco esta muy cerca de su horario de cierre y hay demasiados
 * clientes esperando en cola. Oliver atendera a los clientes de
 * tal forma en la cual pueda recaudar mayor cantidad de dinero
 * de los clientes. Sin embargo los clientes tienen un tiempo de
 * espera determinado, esto debido a que tienen otros compromisos
 * 
 * Se nos hace entrega de los valores 'n' que es la cantidad de
 * personas o clientes en cola. El valor 't' que es la cantidad
 * de tiempo que falta para que el banco cierre sus puertas. Asi
 * mismo se nos hace entrega de la lista de clientes con su el
 * dinero que desean trabajar y su tiempo de espera maximo.
 * 
 * Devolver la cantidad de dinero maxima que se puede recaudar
 * 
 */

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BankQueue {
	
	public static void main(String[] args) {
		
		// Metodo main del programa
		
		Scanner sc = new Scanner(System.in);
		
		// Leemos los valores de 'n' y 'y' que corresponden a la
		// cantidad de clientes en cola y tiempo antes de cerrar
		
		int n = sc.nextInt();
		int t = sc.nextInt();
		
		// Creamos una Cola de Prioridad de los clientes en orden
		// inverso ya que queremos los clientes con mas dinero
		
		PriorityQueue<Person> people = new PriorityQueue<Person>(n, Collections.reverseOrder());
		
		// Empezamos a leer clientes y sus datos. Agregamos a la Cola
		
		for (int i = 0; i < n; i++) {
			
			people.add(new Person(sc.nextInt(), sc.nextInt()));
			
		}
		
		sc.close();
		
		// Imprimimos la cantidad maximo de dinero que podemos recaudar
		
		System.out.println(cashAmount(people, n, t));
		
	}
	
	
	// Explicacion de la Solucion:
	
	// Para el presente problema debemos crear una clase auxiliar Persona que
	// sera un 'encapsulamiento' para los datos de los clientes en Cola. Asi
	// mismo esta clase tendra implementada la interface Comparable para poder
	// usar una Cola de Prioridad segun la cantidad de dinero de los usuarios
	
	// La manera de atender a los usuarios o el tiempo en el cual seran atendidos
	// empezara con su tiempo maximo de atencion, esto con la finalidad de llegar
	// a aquellos clientes que no pueden esperar tanto en cola y tienen una buena
	// cantidad de dinero, ejemplo aquellos clientes con '0' de espera. En caso de
	// tener la posicion de tiempo ocupada empezamos a buscar en posiciones ante-
	// riores hasta encontrar una posicion de tiempo donde sera antendido. Min = 0
	
	public static int cashAmount(PriorityQueue<Person> people, int n, int t) {
		
		// Metodo 'cashAmount' recibe la Cola de Prioridad de los clientes
		// devuelve la cantidad maxima de dinero que podemos recaudar
		
		// Total de dinero que podemos recaudar antes de cerrar el banco
		int totalCash = 0;
		
		// Tiempo de espera, se rige de manera igual para todos los clientes
		int waitingTime = 0;
		
		// El arreglo 'select' nos ayudara a establecer que posiciones de tiempo estan
		// ocupadas por clientes. Eso para establecer el orden de atencion y tiempo
		// OJO: Las posiciones de tiempo se establecen segun el tiempo maximo de espera
		boolean[] select = new boolean[t];
		
		// Objeto de tipo Persona auxiliar para iterar sobre la Cola de Prioridad
		Person currentClient;
		
		// Iteraremos mientras que el tiempo de esperando sea menor a cantidad
		// de clientes y mientras haya clientes por atender en nuestra Cola
		while(waitingTime < n && !people.isEmpty()) {
			
			// Desencolamos un Cliente de nuestra Cola de Prioridad
			currentClient = people.poll();
			
			// Establecemos el tiempo de 'inicio' segun el cliente actual
			int start = currentClient.getWaitTime();
			
			// Iteraremos desde el tiempo de espera para el cliente actual
			// esto se hace para verificar que la posicion este libre y se
			// pueda atender al cliente en esa unidad de tiempo. En caso de
			// estar ocupada su posicion, pasaremos a una posicion anterior
			while(start >= 0 && select[start]) {
				
				start--;
				
			}
			
			// Una vez hallamos agregador el cliente en alguna posicion de
			// tiempo. Debemos incrementar el tiempo transcurrido en 1 y
			// establecer en que unidad de tiempo sera atendido y recaudamos
			// el dinero del cliente.
			
			// En caso de ser -1 significa que ya no hay espacio para atender
			// al cliente actual, siendo 0 la posicion de tiempo minima
			
			if(start != -1) {
				
				// Establecemos el tiempo de atencion para el cliente y recaudamos
				// su dinero. Posteriomente incrementamos la cantidad de dinero
				waitingTime++;
				select[start] = true;
				totalCash += currentClient.getCash();
				
			}
			
		}
		
		// Finalmente retornamos el monto total de dinero recaudado antes de cerrar
		return totalCash;
		
	}
	
}

// Clase Persona. Tiene la Interface Comparable para poder
// establecer una prioridad y asi usar una Cola de Prioridad

class Person implements Comparable<Person> {
	
	// Atributo 'cash', dinero de la persona
	private int cash;
	
	// Atributo 'waitTime', tiempo de espera maximo
	private int waitTime;
	
	// Constructores de la clase Persona
	
	public Person() {
		
		this(0, 0);
		
	}
	
	public Person(int cash) {
		
		this(cash, 0);
		
	}
	
	public Person(int cash, int waitTime) {
		
		setCash(cash);
		setWaitTime(waitTime);
		
	}
	
	// Metodos Getters y Setters de los atributos
	
	public int getCash() {
		
		return cash;
		
	}

	
	public void setCash(int cash) {
		
		this.cash = cash;
		
	}
	
	public int getWaitTime() {
		
		return waitTime;
		
	}
	
	public void setWaitTime(int waitTime) {
		
		this.waitTime = waitTime;
		
	}
	
	// Metodo 'compareTo' de la Interface Comparable
	// Establece un orden entre objetos tipo Persona
	
	@Override
	public int compareTo(Person p) {
		
		// Recibimos una Persona como parametro con la
		// cual compararemos a la persona Instanciada o
		// la Persona que llama al metodo 'CompareTo'
		
		// Recuperamos los atributos de la Persona a comparar
		
		int cash = p.getCash();
		
		int waitTime = p.getWaitTime();
		
		// La primera prioridad que nos menciona el enunciado
		// es la cantidad de dinero que posee el cliente o
		// persona. Este sera nuestro primer filtro
		
		if(getCash() < cash) {
			
			// La Persona recibida como parametro tiene mayor
			// cantidad de dinero que la Instanciada
			return -1;
			
		}
			
		if(getCash() > cash) {
			
			// La Persona recibida como parametro tiene menor
			// cantidad de dinero que la Instanciada
			return 1;
			
		}
		
		// En caso de tener una misma cantidad de dinero, se
		// ordenara o comparara a la Persona segun su tiempo
		// de espera maximo dentro de la cola del banco
		
		if(getWaitTime() < waitTime) {
			
			// La Persona recibida como parametro tiene mayor
			// tiempo de espera que la Instanciada
			return -1;
			
		}
		
		if(getWaitTime() > waitTime) {
			
			// La Persona recibida como parametro tiene menor
			// tiempo de espera que la Instanciada
			return 1;
			
		}
		
		// El caso '0' es cuando ambas Personas a comprar tienen
		// una misma cantidad de dinero e igual tiempo de espera
		return 0;
		
	}
	
}
