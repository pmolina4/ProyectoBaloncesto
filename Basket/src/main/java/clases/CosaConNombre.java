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
	/**
	 * constructor vacío 
	 */
	public CosaConNombre() {
	}
	/**
	 * constructor de la clase cosa con nombre
	 * @param nombre
	 */
	public CosaConNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return  devuelve el nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * setea el nombre
	 * @param nombre asigana el nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * toString de la clase CosaConNombre 
	 */
	public String toString() {
		return "CosaConNombre{" + "nombre=" + nombre + '}';
	}

}
