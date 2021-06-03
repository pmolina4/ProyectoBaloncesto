/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 * Clase Abstracta CosaConNombre, que utilizaremos para heredar desde otras
 * clases
 */
public abstract class CosaConNombre {
	private String nombre;

	public CosaConNombre() {
	}

	public CosaConNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String toString() {
		return "CosaConNombre{" + "nombre=" + nombre + '}';
	}

}
