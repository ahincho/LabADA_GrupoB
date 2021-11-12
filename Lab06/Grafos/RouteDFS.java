
/* 
 * Autor: Hincho Jove, Angel Eduardo
 * 
 * Descripcion del Problema: Se nos pide implementar
 * el recorrido DFS en un Grafo. Esto se debe hacer
 * tanto de manera recursiva como iterativa
 * 
 */

public class RouteDFS {
	
	public static void main(String[] args) {
		
		// Metodo main del programa
		
		// Declarando los Nodos del Arbol
		
		Node<Integer> node1 = new Node<Integer>(1);
		Node<Integer> node2 = new Node<Integer>(2);
		Node<Integer> node3 = new Node<Integer>(3);
		Node<Integer> node4 = new Node<Integer>(4);
		Node<Integer> node5 = new Node<Integer>(5);
		
		// La representacion del Arbol:
		//
		//          1
		//         / \
		//        2   3
		//       / \
		//      4   5
		//
		
		// Construyendo el Arbol y sus listas de Hijos
		
		node1.addSon(node2);
		node1.addSon(node3);
		node2.addSon(node4);
		node2.addSon(node5);
				
		// Usando el metodo recursiveDFS veremos el
		// recorrido desde el nodo inicial o raiz
		
		node1.recursiveDFS();
		
		// Refrescamos el estado de los Nodos, usando el
		// metodo markAsNotVisited, estado = No Visitado
		
		System.out.println("\nMarcando los Nodos como No Visitados ...\n");
		node1.markAsNotVisited();
		
		// Usando el metodo iterativeDFS veremos el
		// recorrido desde el nodo inicial o raiz
		
		node1.iterativeDFS();
		
	}
	
}
