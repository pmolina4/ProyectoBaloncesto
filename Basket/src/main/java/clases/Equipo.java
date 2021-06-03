/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;

import interfaces.Ventana;

/**
 * Clase Equipo extiende de CosaConNombre - Clase que utilizaremos para
 * instanciar los distintos equipos
 */
public class Equipo extends CosaConNombre {
	private String nacionalidad;
	private ArrayList<Jugador> jugadores;
	private Estadio estadio;
	private Entrenador entrenador;
	// Inicializamos en 0 ya que calcularemos su valor de manera interna
	private int mediaDefensa = 0;
	private int mediaAtaque = 0;
	private byte puntosLiga = 0;
	// Variable Auxiliar
	ArrayList<Jugador> jugadoresEquipo = new ArrayList<>();

	// Constructor + Getters + Setters
	public Equipo(String nombre, String nacionalidad, ArrayList<Jugador> jugadores, Estadio estadio,
			Entrenador entrenador) {
		super(nombre);
		this.nacionalidad = nacionalidad;
		this.jugadores = setJugadores(jugadores);
		this.estadio = estadio;
		this.entrenador = entrenador;
		this.mediaAtaque = setMediaAtaque();
		this.mediaDefensa = setMediaDefensa();
		this.puntosLiga = 0;
	}

	public byte getPuntosLiga() {
		return puntosLiga;
	}

	public void setPuntosLiga(byte puntosLiga) {
		this.puntosLiga = puntosLiga;
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

	public int getMediaDefensa() {
		return mediaDefensa;
	}

	public int getMediaAtaque() {
		return mediaAtaque;
	}

	/**
	 * SetMediaAtaque - Media ponderada de todas las medias de ataque de los
	 * jugadores del equipo
	 * 
	 * @return mediaAtaque del equipo
	 */
	public int setMediaAtaque() {
		for (int i = 0; i < jugadoresEquipo.size() - 1; i++) {
			mediaAtaque += jugadoresEquipo.get(i).getMediaAtaque();
		}
		mediaAtaque = (mediaAtaque / jugadoresEquipo.size());
		return mediaAtaque;
	}

	/**
	 * SetMediaDefensa - Media ponderada de todas las medias de defensa de los
	 * jugadores del equipo
	 * 
	 * @return mediaDefensa del equipo
	 */
	public int setMediaDefensa() {
		for (int i = 0; i < jugadoresEquipo.size() - 1; i++) {
			mediaDefensa += jugadoresEquipo.get(i).getMediaDefensa();
		}
		mediaDefensa = (mediaDefensa / jugadoresEquipo.size());
		return mediaDefensa;
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

	/**
	 * Funcion para generar los equipos, accediendo a sus correspondientes elementos
	 * (estadio, jugadores, entrenador..)
	 */
	public void generarEquipos() {
		for (int i = 0; i < Ventana.equipos.size(); i++) {
			Equipo e = new Equipo(Ventana.equipos.get(i), Ventana.Entrenadores.get(i).getNacionalidad(),
					Ventana.Jugadores, Ventana.Estadios.get(i), Ventana.Entrenadores.get(i));
			Ventana.Equipos.add(e);
		}
	}

	/**
	 * Funcion setJugadores, en la que introducimos los Jugadores del mismo Equipo
	 * en su Correspondiente Equipo
	 * 
	 * @param jugadores - ArrayList de todos los Jugadores
	 * @return jugadoresEquipo - Devolvemos un array con los jugadores insertados en
	 *         sus equipos
	 */
	public ArrayList<Jugador> setJugadores(ArrayList<Jugador> jugadores) {
		for (int i = 0; i < jugadores.size(); i++) {
			if (jugadores.get(i).getEquipo().equals(this.getNombre())) {
				jugadoresEquipo.add(jugadores.get(i));
			}
		}
		return jugadoresEquipo;
	}

	// Constructor Vacio para Instancia General
	public Equipo() {
	}

}
