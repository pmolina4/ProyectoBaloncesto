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
 * @author pablo
 */
public class Equipo extends CosaConNombre {
	private String nacionalidad;
	private ArrayList<Jugador> jugadores;
	private Estadio estadio;
	private Entrenador entrenador;
	//Inicializamos en 0 ya que calcularemos su valor de manera interna
	private int mediaDefensa=0;
	private int mediaAtaque=0;
	// Variable Auxiliar
	ArrayList<Jugador> jugadoresEquipo = new ArrayList<>();

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
			mediaAtaque += jugadoresEquipo.get(i).getMediaAtaque();
		}
		mediaAtaque = (mediaAtaque / jugadoresEquipo.size());
		return mediaAtaque;
	}

	// Obtener mediaDefensa accediendo al ArrayList de Jugadores Nuevo
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

	@Override
	public String toString() {
		return "Equipo=" + this.getNombre() + " [nacionalidad=" + nacionalidad + ", jugadores=" + jugadores
				+ ", estadio=" + estadio + ", entrenador=" + entrenador + ", mediaDefensa=" + mediaDefensa
				+ ", mediaAtaque=" + mediaAtaque + "]";
	}

	//Funcion para generar equipos, accediendo a los distintos elementos que lo componen (entrenadores, estadio...)
	public void generarEquipos() {
		for (int i = 0; i < Ventana.equipos.size(); i++) {
			Equipo e = new Equipo(Ventana.equipos.get(i), Ventana.Entrenadores.get(i).getNacionalidad(),
					Ventana.Jugadores, Ventana.Estadios.get(i), Ventana.Entrenadores.get(i));
			Ventana.Equipos.add(e);
		}
	}

	//Constructor Vacio para Instancia General
	public Equipo() {
	}


}
