/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author pablo
 */
public class Contrato {
    private Equipo equipo;
    private short temporada;

    public Contrato(Equipo equipo, short temporada) {
        this.equipo = equipo;
        this.temporada = temporada;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public short getTemporada() {
        return temporada;
    }

    public void setTemporada(short temporada) {
        this.temporada = temporada;
    }

    @Override
    public String toString() {
        return "Contrato{" + "equipo=" + equipo + ", temporada=" + temporada + '}';
    }
    
}
