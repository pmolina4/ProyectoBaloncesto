/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;
import java.util.Collections;

import interfaces.Ventana;

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

	// Funcion que simula los partidos de sus correspondientes rondas, e imprime la
	// informacion
	public void simularPartidosRonda() {
		boolean ganadLocal = false;
		// Comprobamos que no este vacio
		if (getPartidos() != null) {
			String local = "";
			int n = 0, y = 0;

			System.out.println("\n--------" + this.getNombre() + "---------\n");
			for (int i = 0; i < getPartidos().size(); i++) {
				local = getPartidos().get(i).getLocal().getNombre();
				System.out.println(getPartidos().get(i).getLocal().getNombre() + " VS "
						+ getPartidos().get(i).getVisitante().getNombre() + " - " + getPartidos().get(i).getFecha());
				System.out.println("Puntos Locales: " + getPartidos().get(i).getPuntosLocal() + " Puntos Visitantes: "
						+ getPartidos().get(i).getPuntosVisitante());

				if (getPartidos().get(i).getPuntosLocal() > getPartidos().get(i).getPuntosVisitante()) {
					System.out.println("GANADOR: " + getPartidos().get(i).getLocal().getNombre());
					n = buscarEquipo(getPartidos().get(i).getLocal().getNombre());
					Ventana.Equipos.get(n).setPuntosLiga((byte) (Ventana.Equipos.get(y).getPuntosLiga() + 2));

				} else if (getPartidos().get(i).getPuntosVisitante() > getPartidos().get(i).getPuntosLocal()) {
					System.out.println("GANADOR: " + getPartidos().get(i).getVisitante().getNombre());
					y = buscarEquipo(getPartidos().get(i).getVisitante().getNombre());
					Ventana.Equipos.get(y).setPuntosLiga((byte) (Ventana.Equipos.get(y).getPuntosLiga() + 2));

				} else {
					System.out.println("Empate xd");
				}
			}
			impr();
		}
	}

	public void impr() {
		for (int i = 0; i < Ventana.Equipos.size(); i++) {
			System.out.println(Ventana.Equipos.get(i));

		}
	}

	public int buscarEquipo(String r) {
		int index = -1;
		int bound = Ventana.Equipos.size();
		for (int i = 0; i < bound; i++) {
			if (Ventana.Equipos.get(i).getNombre().equals(r)) {
				index = i;
				break;
			}
		}
		return index;
	}

	// Constructor vacio para Instancia General
	public JornadaRonda() {

	}

	public String toString() {
		return "JornadaRonda{" + getNombre() + "partidos=" + partidos + '}';
	}

}
