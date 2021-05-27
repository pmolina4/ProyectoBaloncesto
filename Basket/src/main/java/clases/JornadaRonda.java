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

	public JornadaRonda(String nombre, ArrayList<Partido> partidos) {
		super(nombre);
		this.partidos = partidos;
	}
	


	public ArrayList<Partido> getPartidos() {
		return partidos;
	}

	public void setPartidos(ArrayList<Partido> partidos) {
		this.partidos = partidos;
	}


	//Funcion que simula los partidos de sus correspondientes rondas, e imprime la informacion
	public void simularPartidosRonda() {
		boolean ganadLocal = false;
		System.out.println("\n-----" + this.getNombre() + "------");
		for (int i = 0; i < getPartidos().size(); i++) {
			System.out.println(getPartidos().get(i).getLocal().getNombre() + " VS "
					+ getPartidos().get(i).getVisitante().getNombre() + " - " + getPartidos().get(i).getFecha());
			System.out.println("Puntos Locales: " + getPartidos().get(i).getPuntosLocal() + " Puntos Visitantes: "
					+ getPartidos().get(i).getPuntosVisitante());
			if (getPartidos().get(i).getPuntosLocal() > getPartidos().get(i).getPuntosVisitante()) {
				System.out.println("GANADOR: " + getPartidos().get(i).getLocal().getNombre());
			} else if (getPartidos().get(i).getPuntosVisitante() > getPartidos().get(i).getPuntosLocal()) {
				System.out.println("GANADOR: " + getPartidos().get(i).getVisitante().getNombre());
			} else {
				System.out.println("Empate xd");
			}
		}
	}
	
	//Constructor vacio para Instancia General
	public JornadaRonda() {
		
	}
	
	public String toString() {
		return "JornadaRonda{" + getNombre() + "partidos=" + partidos + '}';
	}


}
