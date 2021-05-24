/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author pablo
 */
public abstract class CosaConNombre {
	private String nombre;

	// Constructo res
	public CosaConNombre(String nombre) {
		this.nombre = nombre;
	}

	// Getters y setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// Tostring
	@Override
	public String toString() {
		return "CosaConNombre{" + "nombre=" + nombre + '}';
	}

}
