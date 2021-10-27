
/* 
 * Autor: Hincho Jove, Angel Eduardo
 * 
 * PREGUNTA! 
 * Cual es la complejidad de este codigo?
 * 		La complejidad es de O(Log2(n))
 *		 
 */

public class Pick_Resume {
	
	public static void main(String[] args) {
		
		String palabra = "anything";
		pick_resume(palabra);
		
	}
	
	public static void pick_resume(String resumes) {
		
		String eliminate = "top";
		
		while(resumes.length() > 1) {
			
			// Iterar mientras que la palabra a resumir tenga mas de 1 caracter
			
			System.out.println("Palabra a resumir: " + resumes);
			
			if (eliminate.equals("top")) {
				
				// Si la bandera 'eliminate' es igual a 'top' entonces nos quedamos
				// con la mitad superior de la palabra a resumir. Quedando (n/2) ... (1)
				
				resumes = resumes.substring(resumes.length() / 2, resumes.length());
				System.out.println("\tSe quedo lo de arriba: " + resumes);
				eliminate = "bottom";
				
			}
			
			else if (eliminate.equals("bottom")) {
				
				// Si la bandera 'eliminate' es igual a 'bottom' entonces nos quedamos
				// con la mitad inferior de la palabra a resumir. Quedando (n/2) ... (2)
				
				resumes = resumes.substring(0, resumes.length() / 2);
				System.out.println("\tSe quedo lo de abajo: " + resumes);
				eliminate = "top";
				
			}
			
		}
		
		System.out.println("Resultado del resumen: " + resumes);
		
	}
	
	/*
	 * Explicacion:
	 * 
	 * De los eventos (1) y (2) que son acciones que se realizaran de acuerdo a una condicion
	 * if. Podemos ver como la cantidad de caracteres de una palabra se reduce a su mitad.
	 * 
	 * Calculo:
	 * 
	 * 	resumes.length
	 * ----------------
	 * 	  n / 2 ^ 1	   	
	 * ----------------
	 * 	  n / 2 ^ 2	      
	 * ----------------
	 *    n / 2 ^ 3
	 * ----------------
	 *    n / 2 ^ 4	   
	 * ----------------
	 * 		 ...
	 * ----------------
	 *    n / 2 ^ k
	 * 
	 * Reemplazando en condicion: resumes.length > 1
	 * 
	 *    n / 2 ^ k > 1
	 *    		  n > 2 ^ k
	 *    	Log2(n) > k
	 *    
	 * Entonces es O(Log2(n))
	 * 
	 */
	
}
