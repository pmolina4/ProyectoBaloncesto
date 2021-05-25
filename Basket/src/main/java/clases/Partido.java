/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.time.LocalDateTime;

/**
 *
 * @author pablo
 */
public class Partido {
   private Equipo local;
   private Equipo visitante;
   private short puntosLocal;
   private short puntosVisitante;
   private LocalDateTime fecha;

    public Partido(Equipo local, Equipo visitante, short puntosLocal, short puntosVisitante, LocalDateTime fecha) {
        this.local = local;
        this.visitante = visitante;
        this.puntosLocal = puntosLocal;
        this.puntosVisitante = puntosVisitante;
        this.fecha = fecha;
    }

    public Equipo getLocal() {
        return local;
    }

    public void setLocal(Equipo local) {
        this.local = local;
    }

    public Equipo getVisitante() {
        return visitante;
    }

    public void setVisitante(Equipo visitante) {
        this.visitante = visitante;
    }

    public short getPuntosLocal() {
        return puntosLocal;
    }

    public void setPuntosLocal(short puntosLocal) {
        this.puntosLocal = puntosLocal;
    }

    public short getPuntosVisitante() {
        return puntosVisitante;
    }

    public void setPuntosVisitante(short puntosVisitante) {
        this.puntosVisitante = puntosVisitante;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Partido{" + "local=" + local + ", visitante=" + visitante + ", puntosLocal=" + puntosLocal + ", puntosVisitante=" + puntosVisitante + ", fecha=" + fecha + '}';
    }
   
    public void jugar() {
    	
    }
    }
   

