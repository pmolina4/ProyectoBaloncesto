package interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.swing.JPanel;

import clases.Entrenador;
import clases.Equipo;
import clases.Estadio;
import clases.Jugador;

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
		jugarPartido(Ventana.Equipos.get(1), Ventana.Equipos.get(2));

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

	public static void generarPartidos() {
		ArrayList<String> equiposJugados = new ArrayList<>();
		for (int i = 0; i < Ventana.Equipos.size() - 1; i++) {

			System.out.println(Ventana.Equipos.get(i).getNombre() + " VS " + Ventana.Equipos.get(i + 1).getNombre());
		}
	}

	public static void jugarPartido(Equipo local, Equipo visit) {
		int posibilidadCanasta = 0;
		int lanzamientosCanastaLocal = 0;
		int lanzamientosCanastaVisitante = 0;
		int defensaLocal = (local.getMediaDefensa() / 10) / 2;
		int defensaVisitante = (visit.getMediaDefensa() / 10) / 2;
		//De 0-3, no mete, de 4-7 un punto, de 8 a 10 dos puntos, 10 a 11, triple
		int probabilidad = (int) Math.floor(Math.random() * (0 - 11 + 1) + 11);
		// Suponiendo 90 tiros en partido, cada equipo tiene 45, y calculamos las
		// canastas en funcion de su media de ataque, y en funcion de la media de
		// defensa del equipo visitante, les restamos canastas
		lanzamientosCanastaLocal = ((local.getMediaAtaque() * 75) / 100) - defensaVisitante;
		lanzamientosCanastaVisitante = ((visit.getMediaAtaque() * 75) / 100) - defensaLocal;
		
		
	}

}
