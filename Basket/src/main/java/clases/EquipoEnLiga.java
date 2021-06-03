package clases;

import java.util.Collections;

import interfaces.Ventana;

//Clase EquipoEnLiga con Poliformismo Usando un Comparable<EquipoEnLiga>
public class EquipoEnLiga implements Comparable<EquipoEnLiga> {
	private Equipo equipo;
	private byte puntos;

	//Constructor + Getters  Setters
	public EquipoEnLiga(Equipo equipo, byte puntos) {
		super();
		this.equipo = equipo;
		this.puntos = puntos;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public byte getPuntos() {
		return puntos;
	}

	public void setPuntos(byte puntos) {
		this.puntos = puntos;
	}

	
	/**
	 * Funcion usada para instanciar EquiposEnLiga y ordenarlos en funcion de los puntos obtenidos en Liga
	 */
	public static void obtenerResult() {
        EquipoEnLiga aux;
        for (int i = 0; i < Ventana.Equipos.size(); i++) {
        	aux = new EquipoEnLiga(Ventana.Equipos.get(i),Ventana.Equipos.get(i).getPuntosLiga());
        	Ventana.EquiposEnLigas.add(aux);
		}
        Collections.sort(Ventana.EquiposEnLigas);
	}
	

	/*
	 * Funcion CompareTo - Usada para comprobar si un equipo tiene mas puntos que el otro
	 * param: EquipoEnLiga - Comparamos con la siguiente instancia 
	 */
	@Override
	public int compareTo(EquipoEnLiga o) {
		if(this.puntos > o.puntos) {
			return -1;
		} if(o.puntos > this.puntos) {
			return 0;
		} if(o.puntos == this.puntos) {
			return 1;
		}
		return 0;
	}

	
	//Constructor vacio que usaremos para instancias generales
	public EquipoEnLiga() {
	}
}


