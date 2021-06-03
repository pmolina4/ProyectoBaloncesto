/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import interfaces.Ventana;

/**
 * JornadaRonda hereda CosaConNombre - Clase en la que, mediante un
 * arrayList<Partidos>, accedemos a los equipos y a sus correspondientes
 * partidos, y emulamos dichos partidos
 * 
 * @author pablo
 *
 */
public class JornadaRonda extends CosaConNombre {
	private ArrayList<Partido> partidos;

	// Constructor + Getters + Setters
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

	/**
	 * Funcion que simula los partidos, accediendo a las variables necesarias de los
	 * equipos y partidos, y genera un resultado coherente, para posteriormente,
	 * almacenarlo en un ArrayList<String>. (Utilizamos etiquetas html ya que lo
	 * añadiremos a un JList)
	 */
	public void simularPartidosRonda() {
		boolean ganadLocal = false;
		// Comprobamos que no este vacio
		if (getPartidos() != null) {
			// Variables Auxiliares
			String local = "", resultado = "<html>";
			int n = 0, y = 0;
			int rloc=0, rvis=0;
            Random rnd = new Random();
            
			for (int i = 0; i < getPartidos().size(); i++) {
				rloc=(int)(rnd.nextDouble() *  getPartidos().size() + 0);
				rvis = (int)(rnd.nextDouble() *  getPartidos().size() + 0);
				if(rloc==rvis || Ventana.Resultados.contains(local) ) {
					rloc=(int)(rnd.nextDouble() *  getPartidos().size() + 0);
				}
				// Obtenemos datos del Partido en Cuestion
				local = getPartidos().get(rloc).getLocal().getNombre();

				resultado += "<br>"+getPartidos().get(rloc).getLocal().getNombre().toUpperCase() + " vs "
						+ getPartidos().get(rvis).getVisitante().getNombre().toUpperCase()+ " <br> Fecha: " + getPartidos().get(i).getFecha()
						+ "<br> Puntos Locales: " + getPartidos().get(rloc).getPuntosLocal() + "<br> Puntos Visitantes: "
						+ getPartidos().get(rvis).getPuntosVisitante();
				// En caso de Local Ganador
				if (getPartidos().get(rloc).getPuntosLocal() > getPartidos().get(rloc).getPuntosVisitante()) {
					resultado += "<br> GANADOR: " + getPartidos().get(rloc).getLocal().getNombre() + "<br>";
					n = buscarEquipo(getPartidos().get(rloc).getLocal().getNombre());
					Ventana.Equipos.get(n).setPuntosLiga((byte) (Ventana.Equipos.get(y).getPuntosLiga() + 2));
					// En caso de Visitante Ganador
				} else if (getPartidos().get(rvis).getPuntosVisitante() > getPartidos().get(rloc).getPuntosLocal()) {
					resultado += "<br> GANADOR: " + getPartidos().get(rvis).getVisitante().getNombre() + "<br>";
					y = buscarEquipo(getPartidos().get(rvis).getVisitante().getNombre());
					Ventana.Equipos.get(y).setPuntosLiga((byte) (Ventana.Equipos.get(y).getPuntosLiga() + 2));
					// En caso de empate
				} else {
					resultado += "<br> Empate <br>";
				}
			}
			resultado += "<br> </html>";
			Ventana.Resultados.add(resultado);
		}
	}

	/**
	 * Funcion para obtener el indice del partido ganador, y sumarle los puntos de
	 * liga
	 * 
	 * @param r - Nombre del equipo ganador (getPartidos.getNombre)
	 * @return index - Indice en el que se encuentra el equipo
	 */
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

}
