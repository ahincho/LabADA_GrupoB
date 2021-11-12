
import java.util.ArrayList;
import java.util.Stack;

/* 
 * Autor: Hincho Jove, Angel Eduardo
 * 
 * Descripcion: Clase Generica que es la representacion
 * de un Nodo de un Arbol, tiene dos atributos los cuales
 * son: data (el dato que guarda el nodo) y sonList que
 * es la lista enlazada de los hijos del Nodo actual
 * 
 */

public class Node<E> {
	
	// Atributos de la Clase Node
	
	private E data;
	private ArrayList<Node<E>> sonsList = new ArrayList<Node<E>>();
	private boolean visited;
	
	// Constructores para la Clase Node
	
	public Node() {
		
		this(null);
		
	}
	
	public Node(E data) {
		
		setData(data);
		setVisited(false);
		
	}
	
	// Setters y getters de los atributos
	
	public E getData() {
		
		return data;
		
	}
	
	public void setData(E data) {
		
		this.data = data;
		
	}
	
	public ArrayList<Node<E>> getSons() {
		
		return sonsList;
		
	}
	
	public void addSon(Node<E> son) {
		
		this.sonsList.add(son);
		
	}
	
	public void setVisited(boolean visited) {
		
		this.visited = visited;
		
	}
	
	public boolean isVisited() {
		
		return this.visited;
		
	}
	
	// Metodo recursivo para imprimir el recorrido DFS
	
	public void recursiveDFS() {
		
		System.out.println("Recorrido DFS Recursivo ...");
		System.out.println("Desde el Nodo Raiz ...");
		auxRDFS(this);
		
	}
	
	// Metodo auxiliar para el recorrido DFS recursivo
	// desde un Node, en este caso usaremos el nodo raiz
	
	protected void auxRDFS(Node<E> root) {
		
		// Imprimir el contenido del Nodo y llamar al metodo
		// recursivamente sobre todos sus hijos o vecinos
		
		System.out.println(root);
		root.setVisited(true);
		ArrayList<Node<E>> sons = root.getSons();
		
		for(int i = 0; i < sons.size(); i++) {
			
			if(!sons.get(i).isVisited()) {
				
				auxRDFS(sons.get(i));
				
			}
						
		}
		
	}
	
	// Metodo iterativo para imprimir el recorrido DFS
	
	public void iterativeDFS() {
		
		System.out.println("Recorrido DFS Iterativo ...");
		System.out.println("Desde el Nodo Raiz ...");
		auxIDFS(this);
		
	}
	
	// Metodo auxiliar para el recorrido DFS iterativo
	// desde un Node, en este caso usaremos el nodo raiz
	
	protected void auxIDFS(Node<E> root) {
		
		Stack<Node<E>> order = new Stack<Node<E>>();
		order.push(root);
		root.setVisited(true);
				
		while(!order.isEmpty()) {
			
			// Desapilar un Nodo de la Pila para visitar otro
						
			Node<E> v = order.peek();
			System.out.println(order.pop());
			
			// Apilar todos los hijos de 'v' en la Pila
			// que no hayan sido visitados anteriormente
			
			ArrayList<Node<E>> sons = v.getSons();
			
			for(int i = sons.size() - 1; i >= 0; i--) {
								
				if(!sons.get(i).isVisited()) {
					
					order.push(sons.get(i));
					sons.get(i).setVisited(true);
					
				}
								
			}
			
		}
		
	}
	
	// Metodo para 'reiniciar' los estados de los nodos
	// empezando desde la raiz, Visitado = false
	
	public void markAsNotVisited() {
		
		auxNotVisited(this);
		
	}
	
	// Metodo auxiliar para el metodo markAsNotVisited
	// reinicia el estado de los nodos desde la raiz
	
	protected void auxNotVisited(Node<E> root) {
		
		if(root.isVisited()) {
			
			root.setVisited(false);
			
			ArrayList<Node<E>> sons = root.getSons();
			
			for(int i = 0; i < sons.size(); i++) {
				
				if(sons.get(i).isVisited()) {
					
					auxNotVisited(sons.get(i));
					
				}
							
			}
			
		}
		
	}
	
	// Metodo toString de la Clase Node
	
	public String toString() {
		
		return this.getData().toString();
		
	}
	
}
