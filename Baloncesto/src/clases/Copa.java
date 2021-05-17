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
public class Copa extends Competicion{
    private ArrayList<Equipo> equipos;
    private ArrayList<JornadaRonda> jornadas;

    public Copa(ArrayList<Equipo> equipos, ArrayList<JornadaRonda> jornadas, short temporada, String nombre) {
        super(temporada, nombre);
        this.equipos = equipos;
        this.jornadas = jornadas;
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }

    public ArrayList<JornadaRonda> getJornadas() {
        return jornadas;
    }

    public void setJornadas(ArrayList<JornadaRonda> jornadas) {
        this.jornadas = jornadas;
    }

    @Override
    public String toString() {
        return "Copa{" + "equipos=" + equipos + ", jornadas=" + jornadas + '}';
    }
    
    
}
