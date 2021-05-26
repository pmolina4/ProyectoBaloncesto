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
public class Estadio extends CosaConNombre{
    private short dimensiones;
    private int aforo;

    public Estadio(String nombre,short dimensiones, int aforo) {
        super(nombre);
        this.dimensiones = dimensiones;
        this.aforo = aforo;
    }

    public short getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(short dimensiones) {
        this.dimensiones = dimensiones;
    }
    
    public int getAforo() {
        return aforo;
    }

    public void setAforo(int aforo) {
        this.aforo = aforo;
    }

    @Override
    public String toString() {
        return "Estadio{" + "dimensiones=" + dimensiones + ", aforo=" + aforo + '}';
    }

    
}
