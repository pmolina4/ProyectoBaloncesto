/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;

/**
 *
 * @author pablo
 */
public class JornadaRonda extends CosaConNombre {
	private ArrayList<Partido> partidos;

	public JornadaRonda(ArrayList<Partido> partidos, String nombre) {
		super(nombre);
		this.partidos = partidos;
	}

	public ArrayList<Partido> getPartidos() {
		return partidos;
	}

	public void setPartidos(ArrayList<Partido> partidos) {
		this.partidos = partidos;
	}

	@Override
	public String toString() {
		return "JornadaRonda{" + "partidos=" + partidos + '}';
	}

}
