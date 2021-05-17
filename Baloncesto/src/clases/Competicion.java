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
public class Competicion extends CosaConNombre {
    private short temporada;

    public Competicion(short temporada, String nombre) {
        super(nombre);
        this.temporada = temporada;
    }

    public short getTemporada() {
        return temporada;
    }

    public void setTemporada(short temporada) {
        this.temporada = temporada;
    }

    @Override
    public String toString() {
        return "Competicion{" + "temporada=" + temporada + '}';
    }
    
    
    
}
