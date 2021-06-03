/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;

import interfaces.Ventana;

/*
 * Clase Estadio extiende de CosaConNombre
 */
public class Estadio extends CosaConNombre {
	private short dimensiones;
	private int aforo;

	//Constructor + Getters + Setters
	public Estadio(String nombre, short dimensiones, int aforo) {
		super(nombre);
		this.dimensiones = dimensiones;
		this.aforo = aforo;
	}

	public short getDimensiones() {
		return dimensiones;
	}

	public void setDimensiones(short dimensiones) {
		this.dimensiones = dimensiones;
	}

	public int getAforo() {
		return aforo;
	}

	public void setAforo(int aforo) {
		this.aforo = aforo;
	}

	/*
	 * Funcion que utilizamos para generar estadios, e introducirlos en su arrayList
	 * correspondiente
	 */
	public void generarEstadios() {
		String[] estadios = { "Pablo de Olavide", "Alfonso VIII", "Navas de Tolosa", "Parc des Princes", "Palau Areuca",
				"Bacardi Stadium", "Estadio Nacional de Carranque", "Estadio la Palmilla", "Sabiote", "United Arena" };
		for (int i = 0; i < Ventana.equipos.size(); i++) {
			Estadio e = new Estadio(estadios[i], (short) Math.floor(Math.random() * (200 - 700 + 200) + 700),
					(int) Math.floor(Math.random() * (2000 - 8000 + 2000) + 8000));
			Ventana.Estadios.add(e);
		}

	}

	// Constructor vacio para instancia general
	public Estadio() {
	}
}
