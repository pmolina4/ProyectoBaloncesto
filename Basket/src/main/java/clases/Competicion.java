/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import interfaces.Ventana;

/**
 *@author pablo
 * Clase Competicion - Extiende de CosaConNombre
 */
public class Competicion extends CosaConNombre {
    private short temporada;

    /**
     * constructor de la clase competicion
     * @param nombre de la competicion
     * @param temporada de la competicion
     */
    public Competicion(String nombre, short temporada) {
        super(nombre);
        this.temporada = temporada;
    }
    /**
     * devuelve las temporadas
     * @return temporadas
     */
    public short getTemporada() {
        return temporada;
    }
    /**
     * establece las temporadas
     * @param temporada de la liga
     */
    public void setTemporada(short temporada) {
        this.temporada = temporada;
    }

    /**
     *Funcion para generar nuevas competiciones y agregarlas a un ArrayList<Competiciones>
     */
    public static void generar() {
    	Competicion comp = new Competicion("Senior Masculino", (short)21);
    	Ventana.Competiciones.add(comp);
    }
    /**
     * Constructor vacio para instancias generales
     */
    public Competicion() {

    }
    
}
