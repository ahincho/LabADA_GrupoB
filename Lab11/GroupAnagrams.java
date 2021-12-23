
/* 
 * Autor: Hincho Jove, Angel Eduardo
 * 
 * Descripcion del Problema:
 * 
 * Tenemos un arreglo de Strings que contienen un grupo de
 * anagramas dentro del mismo. Un grupo de anagramas esta
 * conformado por aquellas palabras que poseen las mismas
 * letras pero en diferente orden ademas de tener la misma
 * cantidad de repeticiones o frecuencias de letras usadas
 * 
 * Devolver los grupos de anagramas formados
 * 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
	
	public static void main(String[] args) {
		
		// Metodo Main del programa con algunos inputs
		
		String[] input1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
		
		String[] input2 = {""};
		
		String[] input3 = {"a"};
		
		System.out.println("Primer Input");
		System.out.println(groupAnagrams(input1));
		
		System.out.println("Segundo Input");
		System.out.println(groupAnagrams(input2));
		
		System.out.println("Tercer Input");
		System.out.println(groupAnagrams(input3));		
		
	}
	
	public static List<List<String>> groupAnagrams(String[] strs) {
		
		// Metodo 'groupAnagrams'. Recibe la lista o arreglo
		// con las palabras que trabajaremos y buscaremos formar
		// los diferentes grupos con los anagramas respectivos
		
		// Si se envia una un arreglo vacio entonces enviamos
		// un grupo de anagramas vacio sin elementos dentro
		
		if(strs.length == 0) {
			
			return new ArrayList<>();
			
		}
		
		// En caso de tener elementos, usaremos un HashMap para
		// poder asignar una 'key' unica al grupo de letras que
		// formar un anagrama, luego veremos si existen mas
		// palabras que pertenecen a dicho conjunto o anagrama
		
		HashMap<String, List<String>> anagrams = new HashMap<>();
		
		// Iteraremos sobre todos los Strings o palabras recibidas
		
		for(String s : strs) {
			
			// Convertiremos la palabra a un arreglo de caracteres
			
			char[] letters = s.toCharArray();
			
			// Ordenaremos el arreglo de caracteres para poder
			// comparar posteriormente con otras palabras. Asi poder
			// encontrar su conjunto de anagramas de la palabra
			
			Arrays.sort(letters);
			
			// Al arreglo de caracteres le asignaremos una key
			// unica y lo agregaremos dentro de nuestro HashMap
			
			String key = String.valueOf(letters);
			
			// Si no existe una key para el arreglo de caracteres
			// entonces crearemos un nuevo arreglo donde guardaremos
			// los anagramas que conforman un grupo con el arreglo
			
			if(!anagrams.containsKey(key)) {
				
				anagrams.put(key, new ArrayList<>());
				
			}
			
			// En caso de ya existe la key, solo agregamos la palabra
			// anagrama que comparte los mismos caracteres o letras
			// al arreglo que pertenece esa key de nuestros caracteres
			
			anagrams.get(key).add(s);
			
		}
		
		// Retornaremos los conjuntos de anagramas formados
		
		return new ArrayList<>(anagrams.values());
		
	}
	
}
