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
public class Jugador extends CosaConNombre {
    private tipo posicion;
    private mano manoDominante;
    private ArrayList<Contrato> contratos;
    private byte fuerza;
    private byte velocidad;
    private byte inteligencia;
    private byte tecnica;

    public Jugador(tipo posicion, mano manoDominante, ArrayList<Contrato> contratos, byte fuerza, byte velocidad, byte inteligencia, byte tecnica, String nombre) {
        super(nombre);
        this.posicion = posicion;
        this.manoDominante = manoDominante;
        this.contratos = contratos;
        this.fuerza = fuerza;
        this.velocidad = velocidad;
        this.inteligencia = inteligencia;
        this.tecnica = tecnica;
    }

    public tipo getPosicion() {
        return posicion;
    }

    public void setPosicion(tipo posicion) {
        this.posicion = posicion;
    }

    public mano getManoDominante() {
        return manoDominante;
    }

    public void setManoDominante(mano manoDominante) {
        this.manoDominante = manoDominante;
    }

    public ArrayList<Contrato> getContratos() {
        return contratos;
    }

    public void setContratos(ArrayList<Contrato> contratos) {
        this.contratos = contratos;
    }

    public byte getFuerza() {
        return fuerza;
    }

    public void setFuerza(byte fuerza) {
        this.fuerza = fuerza;
    }

    public byte getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(byte velocidad) {
        this.velocidad = velocidad;
    }

    public byte getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(byte inteligencia) {
        this.inteligencia = inteligencia;
    }

    public byte getTecnica() {
        return tecnica;
    }

    public void setTecnica(byte tecnica) {
        this.tecnica = tecnica;
    }

    @Override
    public String toString() {
        return "Jugador{" + "posicion=" + posicion + ", manoDominante=" + manoDominante + ", contratos=" + contratos + ", fuerza=" + fuerza + ", velocidad=" + velocidad + ", inteligencia=" + inteligencia + ", tecnica=" + tecnica + '}';
    }

    
    
}
