
/* 
 * Autor: Hincho Jove, Angel Eduardo
 * 
 * PREGUNTA! 
 * Cual es la complejidad de este codigo?
 * 		La complejidad es de O(n * m)
 * Donde:
 * 		n = haystack.length()
 * 		m = needle.lenght()
 *		 
 */

public class Find_Needle {
	
	public static void main(String[] args) {
		
		String sequence1 = "fgh";
		String sequence2 = "abcdefghi";
		System.out.println("Se encuentra " + sequence1 + " en " +
			sequence2 + " ? " + find_needle(sequence1, sequence2));
		
	}
	
	public static boolean find_needle(String needle, String haystack) {
		
		int needle_index = 0;
		int haystack_index = 0;
		
		boolean found_needle = false;
		
		while(haystack_index < haystack.length()) { // Iterar sobre la palabra completa 'n' (1)
			
			if(needle.charAt(needle_index) == haystack.charAt(haystack_index)) {
				
				// Verificar que la cantidad de caracteres que aun no han sido revisados sean
				// mayores que la cantidad de caracteres de la aguja 'needle'
				
				found_needle = true;
				
				while(needle_index < needle.length()) { // Iterar sobre la aguja completa 'm' (2)
					
					System.out.println("Haystack = " + haystack.charAt(haystack_index));
					System.out.println("Needle = " + needle.charAt(needle_index));
					
					if(needle.charAt(needle_index) != haystack.charAt(haystack_index + needle_index)) {
						
						// Si algun caracter de la aguja no coincide con la parte que estamos revisando
						// de la palabra completa 'haystack' entonces guardar 'false' y romper el while
						
						found_needle = false;
						break;
						
					}	
					
					needle_index++;
					
				}
				
				if(found_needle) {
					
					// Si se encontro la aguja dentro del pajar, entonces devolver verdadero
					// , indicar desde donde se encuentra el match y romper el ciclo while
					
					System.out.println("Posicion donde se encontro la aguja '"
						+ needle + "' en el pajar: " + haystack_index);
					return true;
					
				}
				
			}
			
			needle_index = 0;
			haystack_index++;
			
		}
		
		return false;
		
	}
	
	/*
	 * Explicacion:
	 * 
	 * Tenemos un ciclo while que iterara 'n' veces en (1) y otro ciclo
	 * while anidado que iterara 'm' veces en (2).
	 * 
	 * Entonces:
	 * 
	 * n * O(m) = O(n * m) Siendo n = haystack.length y m = needle.length
	 * 
	 */
	
}
