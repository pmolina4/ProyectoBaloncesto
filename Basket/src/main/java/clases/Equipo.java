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
public class Equipo extends CosaConNombre{
    private String nacionalidad;
    private ArrayList<Jugador> jugadores;
    private Estadio estadio;
    private Entrenador entrenador;
    private ArrayList<Competicion> historicoCompeticiones;
    private ArrayList<Competicion> competicionesActuales;

    public Equipo(String nacionalidad, ArrayList<Jugador> jugadores, Estadio estadio, Entrenador entrenador, ArrayList<Competicion> historicoCompeticiones, ArrayList<Competicion> competicionesActuales, String nombre) {
        super(nombre);
        this.nacionalidad = nacionalidad;
        this.jugadores = jugadores;
        this.estadio = estadio;
        this.entrenador = entrenador;
        this.historicoCompeticiones = historicoCompeticiones;
        this.competicionesActuales = competicionesActuales;
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

    public ArrayList<Competicion> getHistoricoCompeticiones() {
        return historicoCompeticiones;
    }

    public void setHistoricoCompeticiones(ArrayList<Competicion> historicoCompeticiones) {
        this.historicoCompeticiones = historicoCompeticiones;
    }

    public ArrayList<Competicion> getCompeticionesActuales() {
        return competicionesActuales;
    }

    public void setCompeticionesActuales(ArrayList<Competicion> competicionesActuales) {
        this.competicionesActuales = competicionesActuales;
    }

    @Override
    public String toString() {
        return "Equipo{" + "nacionalidad=" + nacionalidad + ", jugadores=" + jugadores + ", estadio=" + estadio + ", entrenador=" + entrenador + ", historicoCompeticiones=" + historicoCompeticiones + ", competicionesActuales=" + competicionesActuales + '}';
    }

    
    
}
