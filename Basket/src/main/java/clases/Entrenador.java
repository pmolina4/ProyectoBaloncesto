/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;
import java.util.Random;

import Exceptions.EmptyNameException;
import interfaces.Ventana;

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

	public void setEquipo(String equipo){
		this.equipo = equipo;
	}

	// Funcion que genera de manera automatica los entrenadores ("No Hardcored")
	public void generarEntrenadores() {
		String[] nombre = { "Perico Conde", "Yuseppe Pedrerol", "Julio Iglesias", "El Bicho", "Mariano Rajoy",
				"Echenique aka RayoMcQueen", "Pablo Iglesias", "Salvador Cinta de Lomo", "Edu Chope", "Perri lol" };
		String[] nacionalidades = { "Español", "Africano", "Americano", "Aleman", "Frances", "Ruso", "Belga",
				"Brasileño", "Neocelandes", "Noruego" };

		for (int i = 0; i < Ventana.equipos.size(); i++) {
			Entrenador a = new Entrenador(nombre[i], nacionalidades[i], (byte) Math.floor(Math.random() * 100 + 1),
					Ventana.equipos.get(i));
			Ventana.Entrenadores.add(a);
		}

	}

	// Constructor sin Parametros para crear instancia general
	public Entrenador() {

	}

	@Override
	public String toString() {
		return "Entrenador{" + "nacionalidad=" + nacionalidad + ", calidad=" + calidad + ", equipo=" + equipo + '}';
	}

}
