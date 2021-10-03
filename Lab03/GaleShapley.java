
/* 
 * Autor: Hincho Jove, Angel Eduardo
 * 
 * Descripcion del problema: En este caso se nos pide implementar un metodo o
 * representacion del algoritmo de emparejamiento GaleShapley
 * 
 */

import java.util.ArrayList;

public class GaleShapley {
	
	public static void main(String[] args) {
		
		// El metodo auxiliar 'iniciarDatos' crea las personas
		// y establece sus listas de preferencias de manera interna
		// Finalmente, devuelve un arreglo de arreglos de personas
		
		ArrayList<ArrayList<Persona>> personas = iniciarListas();
		
		// Listas de personas, hombres y mujeres
		ArrayList<Persona> hombres = personas.get(0);
		ArrayList<Persona> mujeres = personas.get(1);
		
		System.out.println("Hombres con sus listas de preferencias!");
		imprimir(hombres);
		
		System.out.println();
		
		System.out.println("Mujeres con sus listas de preferencias!");
		imprimir(mujeres);
		
		galeShapley(hombres, mujeres);
		
		System.out.println("Imprimiendo las parejas!!!");
		imprimirParejas(hombres);
		
	}
	
	public static void galeShapley(ArrayList<Persona> lista1, ArrayList<Persona> lista2) {
		
		System.out.println("\nALGORITMO GALE-SHAPLEY\n");
		// Variables enteras auxiliares para poder iterar dentro de nuestros arreglos
		int pos1 = 0, pos2 = 0;
		while(!todosEmparejados(lista1)) {
			Persona persona1 = lista1.get(pos1);
			Persona persona2 = persona1.getListaPref().get(pos2);
			System.out.println("\tTrabajando con " + persona1.getNombre()
				+ " y " + persona2.getNombre());
			if(!persona2.isEmparejado()) {
				// En caso de no tener pareja
				System.out.println(persona2.getNombre() + " no tiene pareja!");
				// Estableciendo enlaces reciprocos
				persona1.setPareja(persona2);
				persona2.setPareja(persona1);
				persona1.setEmparejado(true);
				persona2.setEmparejado(true);
				System.out.println("Nueva Pareja! : " + persona1.getNombre()
					+ " y " + persona2.getNombre());
				pos1++;
			} else if(prefiereOtro(persona2, persona1)) {
				// En caso de preferir a otro
				// Estableciendo enlaces reciprocos
				System.out.println(persona2.getNombre() + " tiene pareja! "
						+ "Pero prefiere a " + persona1.getNombre());
				Persona antiguaPareja = persona2.getPareja();
				antiguaPareja.setPareja(null);
				antiguaPareja.setEmparejado(false);
				persona1.setPareja(persona2);
				persona2.setPareja(persona1);
				persona1.setEmparejado(true);
				persona2.setEmparejado(true);
				System.out.println("Nueva Pareja! : " + persona1.getNombre()
				+ " y " + persona2.getNombre());
				// Pequenio reajuste
				// Reasignar o buscar una nueva pareja a la persona reemplazada
				reasignarPareja(antiguaPareja, persona2);
				pos1++;
				pos2 = 0;
			} else {
				// En caso de tener pareja ver si estamos trabajando con
				// su pareja actual e imprimir por consola que lo rechazo
				// en caso de no ser su pareja actual o seguir iterando 
				// si es su pareja actual, esto es un pequenio detalle
				String hombreActual = persona1.getNombre();
				String parejaActual = persona2.getPareja().getNombre();
				if(!hombreActual.equals(parejaActual)) {
					System.out.println(persona2.getNombre() + " rechazo a " 
							+ persona1.getNombre() + "! Ya tiene pareja!");
					pos2++;
				} else {
					pos1++;
				}
			}
			System.out.println();
		}
		
	}
	
	public static void reasignarPareja(Persona nuevoSoltero, Persona exPareja) {
		
		// Reasignar nueva pareja a partir de la anterior o ex-pareja
		int indice = nuevoSoltero.getListaPref().indexOf(exPareja);
		System.out.println("Reasignando la pareja de : " + nuevoSoltero.getNombre());
		while(true) {
			Persona nuevaPareja = nuevoSoltero.getListaPref().get(indice + 1);
			if(!nuevaPareja.isEmparejado()) {
				// Si la nueva pareja es soltera, emparejar con el nuevoSoltero
				nuevoSoltero.setPareja(nuevaPareja);
				nuevaPareja.setPareja(nuevoSoltero);
				nuevoSoltero.setEmparejado(true);
				nuevaPareja.setEmparejado(true);
				System.out.println("Se reasigno la pareja de : " 
						+ nuevoSoltero.getNombre());
				System.out.println("Nueva pareja! " + nuevoSoltero.getNombre()
					+ " : " + nuevaPareja.getNombre());
				break;
			} else {
				// Si tiene pareja, imprimirlo y continuar con la siguiente opcion
				System.out.println("\t" + nuevaPareja.getNombre() 
					+ " ya tiene pareja!");
				indice++;
			}
		}
		
	}
	
	public static boolean prefiereOtro(Persona persona, Persona nuevaPareja) {
		
		// Preferencia de una persona frente a su nueva pareja y actual
		
		Persona parejaActual = persona.getPareja();
		// Se comparan las preferencias mediante los indices
		int posParejaActual = persona.getListaPref().indexOf(parejaActual);
		int posNuevaPareja = persona.getListaPref().indexOf(nuevaPareja);
		if(posParejaActual > posNuevaPareja) {
			// Si la nueva pareja es de indice mejor, cambiar de pareja
			System.out.println(persona.getNombre() + 
				" prefiere a " + nuevaPareja.getNombre());
			return true;
		} else {
			// Si es de indice mayor entonces quedarse con la pareja actual
			System.out.println(persona.getNombre() +
				" se queda con " + parejaActual.getNombre());
			return false;
		}
		
	}
	
	public static boolean todosEmparejados(ArrayList<Persona> personas) {
		
		// Verifica si todas las personas en un arreglo de personas tienen pareja
		
		boolean respuesta = true;
		for(int i = 0; i < personas.size(); i++) {
			respuesta = respuesta && personas.get(i).isEmparejado();
		}
		return respuesta;
		
	}
	
	public static ArrayList<ArrayList<Persona>> iniciarListas() {
		
		// Metodo para crear el entorno del primer ejemplo de las diapositivas
		
		// Creando objetos de tipo Persona
		
		Persona andy = new Persona("Andy");
		Persona beto = new Persona("Beto");
		Persona carlo = new Persona("Carlo");
		Persona denis = new Persona("Denis");
		
		Persona wendy = new Persona("Wendy");
		Persona xena = new Persona("Xena");
		Persona yvonne = new Persona("Yvonne");
		Persona zoe = new Persona("Zoe");
		
		// Estableciendo las listas de preferencia
		
		andy.setListaPref(xena);
		andy.setListaPref(wendy);
		andy.setListaPref(yvonne);
		andy.setListaPref(zoe);
		
		beto.setListaPref(yvonne);
		beto.setListaPref(zoe);
		beto.setListaPref(xena);
		beto.setListaPref(wendy);
		
		carlo.setListaPref(yvonne);
		carlo.setListaPref(xena);
		carlo.setListaPref(zoe);
		carlo.setListaPref(wendy);
		
		denis.setListaPref(wendy);
		denis.setListaPref(zoe);
		denis.setListaPref(yvonne);
		denis.setListaPref(xena);
		
		wendy.setListaPref(carlo);
		wendy.setListaPref(denis);
		wendy.setListaPref(beto);
		wendy.setListaPref(andy);
		
		xena.setListaPref(carlo);
		xena.setListaPref(beto);
		xena.setListaPref(andy);
		xena.setListaPref(denis);
		
		yvonne.setListaPref(andy);
		yvonne.setListaPref(beto);
		yvonne.setListaPref(carlo);
		yvonne.setListaPref(denis);
		
		zoe.setListaPref(denis);
		zoe.setListaPref(carlo);
		zoe.setListaPref(beto);
		zoe.setListaPref(andy);

		// Creando el arraylists de arraylists de personas
		
		ArrayList<Persona> hombres = new ArrayList<Persona>();
		hombres.add(andy);
		hombres.add(beto);
		hombres.add(carlo);
		hombres.add(denis);
		
		ArrayList<Persona> mujeres = new ArrayList<Persona>();
		mujeres.add(wendy);
		mujeres.add(xena);
		mujeres.add(yvonne);
		mujeres.add(zoe);
		
		ArrayList<ArrayList<Persona>> personas = new ArrayList<ArrayList<Persona>>();
		personas.add(hombres);
		personas.add(mujeres);
		
		return personas;
		
	}
	
	public static void imprimirParejas(ArrayList<Persona> array) {
		
		// Metodo auxiliar para imprimir las parejas de un arreglo de personas
		
		for(int i = 0; i < array.size(); i++) {
			
			Persona persona = array.get(i);
			System.out.println( "\t" + persona.getNombre() +
					" : " + persona.getPareja().getNombre());
			
		}
		
	}
	
	public static void imprimir(ArrayList<Persona> array) {
		
		// Metodo auxiliar para imprimir las personas de un arreglo de personas
		
		for(int i = 0; i < array.size(); i++) {
			
			System.out.println(array.get(i));
			
		}
		
	}
	
}
