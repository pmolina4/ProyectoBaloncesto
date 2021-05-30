/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import interfaces.Ventana;

/**
 *
 * @author pablo
 */
public class Partido {
	private Equipo local;
	private Equipo visitante;
	private short puntosLocal;
	private short puntosVisitante;
	private Date fecha;

	public Partido(Equipo local, Equipo visitante, short puntosLocal, short puntosVisitante, Date fecha) {
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	// Funcion para generar los partidos
	public static void generarPartidos() {
		// FUNCION AUX QUE UTILIZAREMOS PARA DESORDENAR EL ARRAY
		// public static ArrayList desordenarArrList();

		ArrayList<Equipo> local = new ArrayList<>(), visitante = new ArrayList<>();
		// Comprobamos cual serán los locales y los visitantes
		for (int i = 0; i < Ventana.Equipos.size(); i++) {
			if (i % 2 == 0) {
				local.add(Ventana.Equipos.get(i));
			} else {
				visitante.add(Ventana.Equipos.get(i));
			}
		}
		for (int x = 0; x < (Ventana.Equipos.size() - 1) / 2; x++) {
			Partido p = new Partido(local.get(x), visitante.get(x),
					(short) jugarPartido(local.get(x), visitante.get(x), false),
					(short) jugarPartido(local.get(x), visitante.get(x), true), getRandomDate());
			Ventana.Partidos.add(p);
		}
	}
	
	// Funcion que genera fechas aleatorias
	public static Date getRandomDate() {
		Random rand = new Random();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		Calendar cal = Calendar.getInstance();
		cal.set(2021, 0, 1);
		long start = cal.getTimeInMillis();
		cal.set(2018, 10, 1);
		long end = cal.getTimeInMillis();
		Date d = new Date(start + (long) (rand.nextDouble() * (end - start)));
		return d;
	}
	
	public static int jugarPartido(Equipo local, Equipo visit, Boolean equipoLocal) {
		int posibilidadCanasta = 0, lanzamientosCanastaLocal = 0, lanzamientosCanastaVisitante = 0, puntosLocal = 0,
				puntosVisitante = 0;
		// DEFENSA: Defensa de Equipo / 10 y /2 (Para que el numero no sea demasiado
		// grande)
		
		//lanzamientos que se le restarán en el equipo rival
		int defensaLocal = (local.getMediaDefensa() / 10) / 2;
		int defensaVisitante = (visit.getMediaDefensa() / 10) / 2;

		// LANZAMIENTOS: Lanzamientos de Canasta de Cada Equipo (Su media de ataque, *
		// 75 (canastas
		// que suelen tirar en un equipo) / 100 y le restamos la defensa del otro
		// equipo)
		lanzamientosCanastaLocal = ((local.getMediaAtaque() * 75) / 100) - defensaVisitante;
		lanzamientosCanastaVisitante = ((visit.getMediaAtaque() * 75) / 100) - defensaLocal;

		// CANASTAS: Obtenemos los puntos que ha metido cada equipo mediante
		// calcularPuntos()
		if (equipoLocal) {
			return puntosLocal = calcularPuntos(lanzamientosCanastaLocal);
		} else {
			return puntosVisitante = calcularPuntos(lanzamientosCanastaVisitante);

		}
	}
	

	// Función que calculara los tipos de canasta que han metido (nada, tiro libre,
	// dobles o triples) en funcion
	// de los lanzamientos, y por tanto, devolverá los puntos obtenidos
	public static int calcularPuntos(int lanzamientos) {
		// De 0-2, no mete, de 3-6 un punto, de 7 a 10 dos puntos, 10 a 11, triple
		int probabilidad = 0, puntos = 0;
		for (int i = 0; i <= lanzamientos; i++) {
			probabilidad = (int) Math.floor(Math.random() * (0 - 11 + 1) + 11);
			// Tiro Libre
			if (probabilidad > 2 && probabilidad <= 6) {
				puntos = puntos + 1;
				// Doble
			} else if (probabilidad > 6 && probabilidad <= 10) {
				puntos = puntos + 2;
				// Triple
			} else if (probabilidad > 10) {
				puntos = puntos + 3;
			}
		}
		return puntos;
	}
	

	//Constructor vacio para instancia general
	public Partido() {

	}

	@Override
	public String toString() {
		return "Partido{" + "local=" + local + ", visitante=" + visitante + ", puntosLocal=" + puntosLocal
				+ ", puntosVisitante=" + puntosVisitante + ", fecha=" + fecha + '}';
	}

}
