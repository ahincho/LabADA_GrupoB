package pilas;

import java.util.Stack;

public class PolishNotation {
	
	public static void main(String[] args) {
		
		// Metodo main del programa
		
		System.out.println("Primer Input!\n");
		toPolishNotation("2 1 + 3 *");
		
		System.out.println();
		
		System.out.println("Segundo Input!\n");
		toPolishNotation("4 13 5 / +");
		
		System.out.println();
		
		System.out.println("Tercer Input!\n");
		toPolishNotation("10 6 9 3 + -11 * / * 17 + 5 +");
		
	}
	
	public static void toPolishNotation(String input) {
		
		// Metodo 'toPolishNotation' recibe un String que sera
		// nuestra entrada con la cual empezaremos a iterar
		
		Stack<String> stack = new Stack<String>();
		
		if(input == null) {
			
			System.out.println("Cadena no valida ...");
			
		}
		
		// Dividimos el String 'input' cada vez que encontramos
		// un espacio en blanco o 'espacio' con ayuda de 'split'
		
		for(String e: input.split(" ")) { 
			
			// Una vez obtenido el numero u operacion
			// agregamos / apilamos en nuestra Pila
			
			stack.add(e);
			
			System.out.println("Pila: " + stack);
			
			// Si el String representa un simbolo
			// es necesario ejecutar una operacion
			
			if(isSymbol(e)) {
				
				operate(stack);
				System.out.println("Pila: " + stack);
				
			}
			
		}
		
		System.out.println("Resultado: " + stack.pop());
		
	}
	
	public static void operate(Stack<String> stack) {
		
		// Metodo 'operate', se ejecuta cuando el elemento
		// ingresado es una de las 4 operaciones conocidas
		
		int num1 = 0, num2 = 0, result = 0;
		
		// Desapila 3 elementos de la Pila siendo estos res-
		// pectivamente: 'operador', 'numero 1' y 'numero 2'
		
		String anOp = stack.pop();
		num1 = Integer.parseInt(stack.pop());
		num2 = Integer.parseInt(stack.pop());
		
		// Dependiendo del simbolo, se ejecutan las operaciones
		// ligadas o vinculadas al simbolo desapilado de la Pila
		
		if(anOp.equals("+")) {
			
			System.out.println("SUMA");
			
			result = num2 + num1;
						
		} else if(anOp.equals("-")) {
			
			System.out.println("RESTA");
			
			result = num2 - num1;
			
		} else if(anOp.equals("/")) {
						
			System.out.println("DIVISION");
			
			result = num2 / num1;
			
		} else if(anOp.equals("*")) {
			
			System.out.println("MULTIPLICACION");
			
			result = num2 * num1;
			
		}
		
		// Finalmente, apilamos el resultado en la Pila
		
		stack.add(String.valueOf(result));
		
	}
	
	public static boolean isSymbol(String str) {
		
		// Metodo 'isSymbol' verifica que un String represente
		// a alguna de las 4 operaciones matematicas conocidas
		
		return (str.equals("+") || str.equals("-")
				|| str.equals("/") || str.equals("*"));
		
	}
	
}
