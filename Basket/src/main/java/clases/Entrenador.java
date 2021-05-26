/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.Random;

/**
 *
 * @author pablo
 */
public class Entrenador extends CosaConNombre {
	private String nacionalidad;
	private byte calidad;
	private String equipo;

	public Entrenador(String nombre, String nacionalidad, byte calidad, String equipo) {
		super(nombre);
		this.nacionalidad = nacionalidad;
		this.calidad = calidad;
		this.equipo = equipo;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public byte getCalidad() {
		return calidad;
	}

	public void setCalidad(byte calidad) {
		this.calidad = calidad;
	}

	public String getEquipo() {
		return equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	@Override
	public String toString() {
		return "Entrenador{" + "nacionalidad=" + nacionalidad + ", calidad=" + calidad + ", equipo=" + equipo + '}';
	}
}
