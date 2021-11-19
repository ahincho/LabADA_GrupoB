
import java.util.Stack;

public class AddParentheses {
	
	public static void main(String[] args) {
		
		// Metodo main del programa
		
		String input = "())";
		String input2 = "(()))(";
		String input3 = "(((";
		String input4 = "()))((";
		String input5 = "(())()(()())";
		
		System.out.println("Revisando Ingreso 1");
		checkParentheses(input);
		
		System.out.println("Revisando Ingreso 2");
		checkParentheses(input2);
		
		System.out.println("Revisando Ingreso 3");
		checkParentheses(input3);
		
		System.out.println("Revisando Ingreso 4");
		checkParentheses(input4);
		
		System.out.println("Revisando Ingreso 5");
		checkParentheses(input5);
		
	}
	
	public static void checkParentheses(String input) {
		
		// Creando una Pila para ingresar los simbolos de
		// apertura '(' de la variable tipo String 'input'
		
		Stack<Character> stack = new Stack<Character>();
		
		// Para evitar crear otra Pila para errores en simbolos
		// de cierre, usaremos la variable entera closureMistakes
		
		int closureMistakes = 0;
		
		// Ciclo for-each que llenara el array con los caracteres
		
		for(char c : input.toCharArray()) {
			
			if(c == '(') {
				
				// Si es un simbolo de apertura, apilarlo
				
				stack.add(c);
				
				System.out.println("APERTURA");
				
				System.out.println("Stack: " + stack);
				
				
			} else {
				
				System.out.println("CIERRE");
				
				// En caso de ser un simbolo de cierre, evaluar
				// si la Pila se encuentra con elementos o no
				
				if(stack.isEmpty()) {
					
					// Si ingresamos un simbolo de cierre y la Pila
					// se encuentra vacia, es un error en los cierres
					
					closureMistakes++;
					
				} else {
					
					// En caso de tener simbolos de apertura en la Pila
					// entonces tomamos el ultimo elemento en la Pila y
					// verificamos si es un simbolo de apertura
					
					// Esto representaria un error en el 'orden' de los
					// simbolos. EJM: ())((), ()(()(, (()((), etc ..
					
					char top = stack.peek();
					
					if(c == ')' && top == '(') {
						
						// En caso ser una 'pareja' de simbolos, desapilar
						
						stack.pop();
						
					} else {
						
						// En caso contrario aumentar los errores de cierre
						
						closureMistakes++;
						
					}
					
				}
				
				System.out.println("Stack: " + stack);
				
			}
			
		}
		
		// Tambien puede existir errores con los simbolos de apertura, ejm al
		// no tener una pareja con la cual complementarse o en el orden
		
		// Los errores de simbolos de apertura sera el tamano final de la Pila
		
		int openMistakes = stack.size();
		
		// El total de errores en el String = errores de cierre y apertura
		
		int totalMistakes = openMistakes + closureMistakes;
				
		if(totalMistakes == 0) {
			
			// Si no existen errores entonces es una cadena o ingreso correcto
			
			System.out.println("El Ingreso es Correcto!");
			
		} else {
			
			// Si existen errores entonces es una cadena o ingreso incorrecto
			
			System.out.println("El Ingreso es Incorrecto!");
			
		}
		
		// Imprimir la cantidad de errores o parentesis que se necesitan anadir
		
		System.out.println("Usted debe agregar: " + totalMistakes + " parentesis");
		System.out.println();
		
	}
	
}
