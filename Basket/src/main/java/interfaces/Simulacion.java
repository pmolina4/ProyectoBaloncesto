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

		generarEntrenadores();
		generarEstadios();
		generarEquipos();

	}

	// ----------------- FUNCIONES AUXILIARES-----------------
	/*
	 * Funcion que utilizamos para generar entrenadores aleatorios, e introducirlos
	 * en su arrayList correspondiente
	 */
	public void generarEntrenadores() {
		String[] nombre = { "Perico Conde", "Yuseppe Pedrerol", "Julio Iglesias", "El Bicho", "Mariano Rajoy",
				"Echenique aka RayoMcQueen", "Pablo Iglesias", "Salvador Cinta de Lomo", "Edu Chope", "Perri lol" };
		String[] nacionalidades = { "Español", "Africano", "Americano", "Aleman", "Frances", "Ruso", "Belga",
				"Brasileño", "Neocelandes", "Noruego" };

		for (int i = 0; i < Ventana.equipos.size(); i++) {
			Entrenador a = new Entrenador(nombre[i], nacionalidades[i], (byte) Math.floor(Math.random() * 100 + 1),
					Ventana.equipos.get(i));
			Ventana.Entrenadores.add(a);
		}
	}

	/*
	 * Funcion que utilizamos para generar estadios aleatorios, e introducirlos en
	 * su arrayList correspondiente
	 */
	public void generarEstadios() {
		String[] estadios = { "Pablo de Olavide", "Alfonso VIII", "Navas de Tolosa", "Parc des Princes", "Palau Areuca",
				"Bacardi Stadium", "Estadio Nacional de Carranque", "Estadio la Palmilla", "Sabiote", "United Arena" };

		for (int i = 0; i < Ventana.equipos.size(); i++) {
			Estadio e = new Estadio(estadios[i], (short) Math.floor(Math.random() * (200 - 700 + 200) + 700),
					(int) Math.floor(Math.random() * (2000 - 8000 + 2000) + 8000));
			System.out.println(e);
			Ventana.Estadios.add(e);
		}
	}

	/*
	 * Funcion que utilizamos para generar equipos, con sus respectos jugadores (Comprobar funcion SET en Clase EQUIPO)
	 */
	public void generarEquipos() {
		for (int i = 0; i < Ventana.equipos.size(); i++) {
			Equipo e = new Equipo(Ventana.equipos.get(i),Ventana.Entrenadores.get(i).getNacionalidad(), Ventana.Jugadores, Ventana.Estadios.get(i), Ventana.Entrenadores.get(i),(byte)20,(byte)30);
			Ventana.Equipos.add(e);
			System.out.println(e);
		}
		
	}

}
