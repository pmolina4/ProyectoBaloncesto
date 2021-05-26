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
public class Equipo extends CosaConNombre {
	private String nacionalidad;
	private ArrayList<Jugador> jugadores;
	private Estadio estadio;
	private Entrenador entrenador;
	private int mediaDefensa;
	private int mediaAtaque;
	// Variable Auxiliar
	ArrayList<Jugador> jugadoresEquipo = new ArrayList<>();
	int medAta = 0;
	int medDef = 0;

	public Equipo(String nombre, String nacionalidad, ArrayList<Jugador> jugadores, Estadio estadio,
			Entrenador entrenador) {
		super(nombre);
		this.nacionalidad = nacionalidad;
		// Comprobar Funcion
		this.jugadores = setJugadores(jugadores);
		this.estadio = estadio;
		this.entrenador = entrenador;
		this.mediaAtaque = setMediaAtaque();
		this.mediaDefensa = setMediaDefensa();
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}

	/*
	 * INPUT: ArrayList<Jugador> - ArrayList de Jugadores (Ventana.Jugadores) con
	 * todos los jugadores y sus equipos desordenados OUTPUT: return jugadoresEquipo
	 * 
	 */
	public ArrayList<Jugador> setJugadores(ArrayList<Jugador> jugadores) {
		for (int i = 0; i < jugadores.size(); i++) {
			if (jugadores.get(i).getEquipo().equals(this.getNombre())) {
				jugadoresEquipo.add(jugadores.get(i));
			}
		}
		return jugadoresEquipo;
	}

	public int getMediaDefensa() {
		return mediaDefensa;
	}

	public int getMediaAtaque() {
		return mediaAtaque;
	}

	// Obtener Media Ataque accediendo al ArrayList de Jugadores Nuevo
	public int setMediaAtaque() {
		for (int i = 0; i < jugadoresEquipo.size() - 1; i++) {
			medAta += jugadoresEquipo.get(i).getMediaAtaque();
		}
		medAta = (medAta / jugadoresEquipo.size());
		return medAta;
	}

	// Obtener mediaDefensa accediendo al ArrayList de Jugadores Nuevo
	public int setMediaDefensa() {
		for (int i = 0; i < jugadoresEquipo.size() - 1; i++) {
			medDef += jugadoresEquipo.get(i).getMediaDefensa();
		}
		medDef = (medDef / jugadoresEquipo.size());
		return medDef;
	}

	public Estadio getEstadio() {
		return estadio;
	}

	public void setEstadio(Estadio estadio) {
		this.estadio = estadio;
	}

	public Entrenador getEntrenador() {
		return entrenador;
	}

	public void setEntrenador(Entrenador entrenador) {
		this.entrenador = entrenador;
	}

	@Override
	public String toString() {
		return "Equipo=" + this.getNombre() + " [nacionalidad=" + nacionalidad + ", jugadores=" + jugadores
				+ ", estadio=" + estadio + ", entrenador=" + entrenador + ", mediaDefensa=" + mediaDefensa
				+ ", mediaAtaque=" + mediaAtaque + "]";
	}

//	
}
