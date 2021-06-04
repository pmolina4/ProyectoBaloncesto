package clases;

import java.util.Collections;

import interfaces.Ventana;

/**
 * 
 * @version 1.0
 * @author pablo
 * Clase EquipoEnLiga con Poliformismo Usando un Comparable<EquipoEnLiga>
 */
public class EquipoEnLiga implements Comparable<EquipoEnLiga> {
	private Equipo equipo;
	private byte puntos;

	/**
	 * constructor de la clase Equipo en liga
	 * @param equipo de la liga
	 * @param puntos de la liga
	 */
	public EquipoEnLiga(Equipo equipo, byte puntos) {
		super();
		this.equipo = equipo;
		this.puntos = puntos;
	}
	/**
	 * recoge el equipo
	 * @return equipo
	 */
	public Equipo getEquipo() {
		return equipo;
	}
	/**
	 * asigna el equipo 
	 * @param equipo
	 */
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	/**
	 * recoge elos puntos
	 * @return puntos
	 */
	public byte getPuntos() {
		return puntos;
	}
	/**
	 * asigna los puntos
	 * @param puntos
	 */
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
	

	/**
	 * 
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

	
	/**
	 * Constructor vacio que usaremos para instancias generales
	 */
	public EquipoEnLiga() {
	}	
}


