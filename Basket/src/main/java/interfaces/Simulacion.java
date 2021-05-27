package interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.swing.JPanel;

import clases.Entrenador;
import clases.Equipo;
import clases.Estadio;
import clases.JornadaRonda;
import clases.Jugador;
import clases.Partido;

public class Simulacion extends JPanel {
	// Componentes
	private Ventana ventana;
	// Variables Aux

	public Simulacion(Ventana v) {
		// Instancia Ventana + Detalles Visuales
		this.ventana = v;
		setLayout(new BorderLayout(0, 0));
		this.setSize(500, 500);

		// -------------------------------- COMPONENTES J
		// -------------------------------------
		JPanel panelCentral = new JPanel();
		panelCentral.setBackground(new Color(105, 105, 105));
		add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(null);

		// Quitar Despues y poner en Otra Clase
		generarEntrenadores();
		generarEstadios();
		generarEquipos();
		generarPartidos();
		getRandomDate();
		generarJornadas();

	}

	/*
	 * Funcion que utilizamos para generar entrenadores, e introducirlos en su
	 * arrayList correspondiente
	 */
	public ArrayList<Entrenador> generarEntrenadores() {
		String[] nombre = { "Perico Conde", "Yuseppe Pedrerol", "Julio Iglesias", "El Bicho", "Mariano Rajoy",
				"Echenique aka RayoMcQueen", "Pablo Iglesias", "Salvador Cinta de Lomo", "Edu Chope", "Perri lol" };
		String[] nacionalidades = { "Español", "Africano", "Americano", "Aleman", "Frances", "Ruso", "Belga",
				"Brasileño", "Neocelandes", "Noruego" };

		for (int i = 0; i < Ventana.equipos.size(); i++) {
			Entrenador a = new Entrenador(nombre[i], nacionalidades[i], (byte) Math.floor(Math.random() * 100 + 1),
					Ventana.equipos.get(i));
			Ventana.Entrenadores.add(a);
		}
		return Ventana.Entrenadores;
	}

	/*
	 * Funcion que utilizamos para generar estadios, e introducirlos en su arrayList
	 * correspondiente
	 */
	public ArrayList<Estadio> generarEstadios() {
		String[] estadios = { "Pablo de Olavide", "Alfonso VIII", "Navas de Tolosa", "Parc des Princes", "Palau Areuca",
				"Bacardi Stadium", "Estadio Nacional de Carranque", "Estadio la Palmilla", "Sabiote", "United Arena" };

		for (int i = 0; i < Ventana.equipos.size(); i++) {
			Estadio e = new Estadio(estadios[i], (short) Math.floor(Math.random() * (200 - 700 + 200) + 700),
					(int) Math.floor(Math.random() * (2000 - 8000 + 2000) + 8000));
			Ventana.Estadios.add(e);
		}
		return Ventana.Estadios;
	}

	/*
	 * Funcion que utilizamos para generar equipos, con sus respectos jugadores
	 * (Comprobar funcion SET en Clase EQUIPO)
	 */
	public ArrayList<Equipo> generarEquipos() {
		for (int i = 0; i < Ventana.equipos.size(); i++) {
			Equipo e = new Equipo(Ventana.equipos.get(i), Ventana.Entrenadores.get(i).getNacionalidad(),
					Ventana.Jugadores, Ventana.Estadios.get(i), Ventana.Entrenadores.get(i));
			Ventana.Equipos.add(e);
		}
		return Ventana.Equipos;
	}

	//Funcion para generar los partidos
	public static void generarPartidos() {
		//FUNCION AUX QUE UTILIZAREMOS PARA DESORDENAR EL ARRAY
		//public static ArrayList desordenarArrList();
		
		ArrayList<Equipo> local = new ArrayList<>(), visitante = new ArrayList<>();
		//Comprobamos cual serán los locales y los visitantes
		for (int i = 0; i < Ventana.Equipos.size(); i++) {
			if (i % 2 == 0) {
				local.add(Ventana.Equipos.get(i));
			} else {
				visitante.add(Ventana.Equipos.get(i));
			}
		}
		for (int x = 0; x < (Ventana.Equipos.size()-1)/2; x++) {
			Partido p = new Partido(local.get(x), visitante.get(x),
					(short) jugarPartido(local.get(x), visitante.get(x), false),
					(short) jugarPartido(local.get(x), visitante.get(x), true), getRandomDate());
			Ventana.Partidos.add(p);
		}
	}
	
	//Funcion para generar las Jornadas
	public static void generarJornadas() {
		int nJornadas = (Ventana.Equipos.size()-1);
		String nombre="";
		for(int i=0; i<nJornadas; i++ ) {
			nombre = "Jornada Nº "+(i+1);
			JornadaRonda j = new JornadaRonda(nombre, Ventana.Partidos);
			j.simularPartidosRonda();
		}
	}

	public static int jugarPartido(Equipo local, Equipo visit, Boolean equipoLocal) {
		int posibilidadCanasta = 0, lanzamientosCanastaLocal = 0, lanzamientosCanastaVisitante = 0, puntosLocal = 0,
				puntosVisitante = 0;
		// DEFENSA: Defensa de Equipo / 10 y /2 (Para que el numero no sea demasiado
		// grande)
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

}
