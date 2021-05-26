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
	private byte mediaDefensa;
	private byte mediaAtaque;

	public byte getMediaDefensa() {
		return mediaDefensa;
	}

	public void setMediaDefensa(byte mediaDefensa) {
		this.mediaDefensa = mediaDefensa;
	}

	public byte getMediaAtaque() {
		return mediaAtaque;
	}

	public void setMediaAtaque(byte mediaAtaque) {
		this.mediaAtaque = mediaAtaque;
	}

	public Equipo(String nombre, String nacionalidad, ArrayList<Jugador> jugadores, Estadio estadio,
			Entrenador entrenador, byte mediaDefensa, byte mediaAtaque) {
		super(nombre);
		this.nacionalidad = nacionalidad;
		//Comprobar Funcion
		this.jugadores = setJugadores(jugadores);
		this.estadio = estadio;
		this.entrenador = entrenador;
		this.mediaDefensa = mediaDefensa;
		this.mediaAtaque = mediaAtaque;
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
	 * todos los jugadores y sus equipos desordenados
	 * OUTPUT: return jugadoresEquipo - Devolvemos un ArrayList con los jugadores unicamente del equipo
	 */
	public ArrayList<Jugador> setJugadores(ArrayList<Jugador> jugadores) {
		ArrayList<Jugador> jugadoresEquipo = new ArrayList<>();
		for (int i = 0; i < jugadores.size(); i++) {
			if (jugadores.get(i).getEquipo().equals(this.getNombre())) {
				jugadoresEquipo.add(jugadores.get(i));
			}
		}
		return jugadoresEquipo;
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
