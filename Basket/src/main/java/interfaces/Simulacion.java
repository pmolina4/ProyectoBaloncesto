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

		// -------------------------------- FIN COMPONENTES J
		// -------------------------------------

		// Funciones para la Generacion de Distintos Componentes
		Ventana.ent.generarEntrenadores();
		Ventana.estad.generarEstadios();
		Ventana.equi.generarEquipos();
		Ventana.part.generarPartidos();
		generarJornadas();
		Ventana.jorn.simularPartidosRonda();
	}

	// Funcion para generar las Jornadas
	public static void generarJornadas() {
		int nJornadas = 0;
		// Controlamos que los equipos sean pares para poder jugar
		if (Ventana.Equipos.size() % 2 == 0) {
			nJornadas = Ventana.Equipos.size();
		} else {
			Ventana.Equipos.remove(Ventana.Equipos.size() - 1);
			nJornadas = Ventana.Equipos.size();
		}
		String nombre = "";
		for (int i = 0; i < nJornadas; i++) {
			nombre = "Jornada Nº " + (i + 1);
			JornadaRonda j = new JornadaRonda(nombre, Ventana.Partidos);
			j.simularPartidosRonda();
		}
	}

}
