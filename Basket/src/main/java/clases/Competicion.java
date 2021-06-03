/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import interfaces.Ventana;

/**
 *
 * Clase Competicion - Extiende de CosaConNombre
 */
public class Competicion extends CosaConNombre {
    private short temporada;

    //Constructor + Getters + Setters
    public Competicion(String nombre, short temporada) {
        super(nombre);
        this.temporada = temporada;
    }

    public short getTemporada() {
        return temporada;
    }

    public void setTemporada(short temporada) {
        this.temporada = temporada;
    }

    //Funcion para generar nuevas competiciones y agregarlas a un ArrayList<Competiciones>
    public static void generar() {
    	Competicion comp = new Competicion("Senior Masculino", (short)21);
    	Ventana.Competiciones.add(comp);
    }
    
    //Constructor vacio para instancias generales
    public Competicion() {
    	
    }
    
}
