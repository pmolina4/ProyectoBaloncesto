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

	public Equipo(String nacionalidad, ArrayList<Jugador> jugadores, Estadio estadio, Entrenador entrenador,
			ArrayList<Competicion> historicoCompeticiones, ArrayList<Competicion> competicionesActuales,
			String nombre) {
		super(nombre);
		this.nacionalidad = nacionalidad;
		this.jugadores = jugadores;
		this.estadio = estadio;
		this.entrenador = entrenador;
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

	public void setJugadores(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
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
		return "Equipo{" + "nacionalidad=" + nacionalidad + ", jugadores=" + jugadores + ", estadio=" + estadio
				+ ", entrenador=" + entrenador;
	}

}
