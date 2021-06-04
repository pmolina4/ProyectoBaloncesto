/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;

import interfaces.Ventana;

/**
 * 
 * @version 1.0
 * @author pablo
 * Clase Estadio extiende de CosaConNombre
 */
public class Estadio extends CosaConNombre {
	private short dimensiones;
	private int aforo;

	/**
	 * constructor de la clase Estadio
	 * @param nombre de el estadio
	 * @param dimensiones de el estadio
	 * @param aforo de el estadio
	 */
	public Estadio(String nombre, short dimensiones, int aforo) {
		super(nombre);
		this.dimensiones = dimensiones;
		this.aforo = aforo;
	}
	/**
	 * recoge las dimensiones de el estadio
	 * @return dimensiones
	 */
	public short getDimensiones() {
		return dimensiones;
	}
	/**
	 * asigna las dimensiones a el estadio
	 * @param dimensiones de el estadio
	 */
	public void setDimensiones(short dimensiones) {
		this.dimensiones = dimensiones;
	}
	/**
	 * recoge el aforo de el estadio
	 * @return aforo
	 */
	public int getAforo() {
		return aforo;
	}
	/**
	 * asigna el aforo a el estadio
	 * @param aforo de el estadio
	 */
	public void setAforo(int aforo) {
		this.aforo = aforo;
	}

	/**
	 * 
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

	/**
	 * 
	 * Constructor vacio para instancia general
	 */
	public Estadio() {
	}
}
