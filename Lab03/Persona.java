
/*
 * Autor: Hincho Jove, Angel Eduardo
 * 
 * Esta clase representa a una persona del mundo real, que tiene
 * sus gustos o preferencias hacia otras personas. Esta relacion
 * o lista de preferencias se guarda en un ArrayList interno
 * 
 */

import java.util.ArrayList;

public class Persona {
	
	// Atributos de la clase Persona
	
	// Variable de tipo String que representa el nombre de la persona
	private String nombre;
	
	// Arreglo de otras Personas que representa la Lista de Preferencia
	private ArrayList<Persona> listaPref = new ArrayList<Persona>();
	
	// Variable booleana que indica si la persona tiene pareja
	private boolean emparejado;
	
	// Variable de tipo Persona que enlaza una Persona con su pareja
	private Persona pareja;
	
	// Constructores de la clase Persona
	
	public Persona() {
		
		this("Anonimo");
		
	}
	
	public Persona(String nombre) {
		
		setNombre(nombre);
		
	}
	
	// Setters y Getters de la clase Persona
	
	public String getNombre() {
		
		return nombre;
		
	}
	
	public void setNombre(String nombre) {
		
		this.nombre = nombre;
		
	}

	public ArrayList<Persona> getListaPref() {
		
		return listaPref;
		
	}

	public void setListaPref(Persona otraPersona) {
		
		this.listaPref.add(otraPersona);
		
	}
	
	public boolean isEmparejado() {
		
		return emparejado;
		
	}

	public void setEmparejado(boolean emparejado) {
		
		this.emparejado = emparejado;
		
	}
	
	public Persona getPareja() {
		
		return pareja;
		
	}

	public void setPareja(Persona pareja) {
		
		this.pareja = pareja;
		
	}
	
	// Metodo toString de clase Persona sobreescrito
	
	@Override
	public String toString() {
		
		ArrayList<Persona> lista = getListaPref();
		String info = getNombre() + " | Preferencias: ";
		for(int i = 0; i < lista.size(); i++) {
			info += ((i + 1) + "° " + lista.get(i).getNombre() + ", ");
		}
		return info;
		
	}
	
}
