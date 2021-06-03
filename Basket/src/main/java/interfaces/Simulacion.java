package interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.SystemColor;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import clases.Entrenador;
import clases.Equipo;
import clases.EquipoEnLiga;
import clases.Estadio;
import clases.JornadaRonda;
import clases.Jugador;
import clases.Partido;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Simulacion extends JPanel {
	// Componentes
	private Ventana ventana;

	// Ventanas en la que mostraremos las simulaciones de los partidos
	public Simulacion(Ventana v) {
		// Instancia Ventana + Detalles Visuales
		this.ventana = v;
		setLayout(new BorderLayout(0, 0));
		this.setSize(450, 650);

		// -------------------------------- COMPONENTES J
		// -------------------------------------

		// JPanel
		JPanel panelCentral = new JPanel();
		panelCentral.setBackground(new Color(241, 69, 15));
		add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(null);

		JPanel jpartidos = new JPanel();
		jpartidos.setBackground(new Color(240, 240, 240));
		jpartidos.setBorder(new MatteBorder(1, 1, 1, 1, (Color) SystemColor.desktop));
		jpartidos.setBounds(20, 55, 398, 45);
		panelCentral.add(jpartidos);
		jpartidos.setLayout(null);
		

		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 240, 240));
		panel.setBounds(34, 147, 406, 445);
		panelCentral.add(panel);
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) SystemColor.desktop));
		panel.setVisible(false);


		JComboBox<Integer> comboBoxLigas = new JComboBox<Integer>();
		comboBoxLigas.setToolTipText("");
		comboBoxLigas.setBounds(237, 6, 32, 26);
		jpartidos.add(comboBoxLigas);
		comboBoxLigas.addItem(1);
		comboBoxLigas.addItem(2);
		comboBoxLigas.addItem(3);
		comboBoxLigas.addItem(4);
		comboBoxLigas.addItem(5);
		comboBoxLigas.addItem(6);
		comboBoxLigas.addItem(7);
		comboBoxLigas.addItem(8);
		comboBoxLigas.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		comboBoxLigas.setForeground(new Color(241, 69, 15));

		JLabel lblName = new JLabel("Introduce el Numero de la Jornada:");
		lblName.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		lblName.setForeground(new Color(241, 69, 15));
		lblName.setBounds(10, 10, 229, 18);
		jpartidos.add(lblName);

		JButton btnBuscar = new JButton("BUSCAR");

		btnBuscar.setBounds(291, 7, 83, 26);
		btnBuscar.setBackground((Color) new Color(241, 69, 15));
		btnBuscar.setForeground(SystemColor.controlLtHighlight);
		btnBuscar.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 10));
		btnBuscar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jpartidos.add(btnBuscar);
		panel.setLayout(null);
		
		JLabel textoEquipos = new JLabel("");
		textoEquipos.setBounds(10, 10, 386, 425);
		textoEquipos.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		textoEquipos.setForeground(new Color(241, 69, 15));
		panel.add(textoEquipos);

		// -------------------------------- FIN COMPONENTES J
		// -------------------------------------

		// Funciones para la Generacion de Distintos Componentes
		Ventana.ent.generarEntrenadores();
		Ventana.estad.generarEstadios();
		Ventana.equi.generarEquipos();
		Ventana.part.generarPartidos();
		generarJornadas();
		Ventana.jorn.simularPartidosRonda();
		Ventana.eli.obtenerResult();

		// Funcion onClick BUSCAR
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarJornada(comboBoxLigas, textoEquipos);
				panel.setVisible(true);
			}
		});
	}


	// Funcion para generar las Jornadas
	public static void generarJornadas() {
		int nJornadas = 0;
		// Controlamos que los equipos sean pares para poder jugar

		Ventana.Equipos.remove(Ventana.Equipos.size() - 1);
		nJornadas = Ventana.Equipos.size();

		String nombre = "";
		for (int i = 0; i < nJornadas; i++) {
			nombre = "Jornada Nº " + (i + 1);
			JornadaRonda j = new JornadaRonda(nombre, Ventana.Partidos);
			j.simularPartidosRonda();
			Ventana.Jornadas.add(j);
		}

		for (int x = 0; x < Ventana.Resultados.size(); x++) {
			System.out.println(Ventana.Resultados.get(x));
		}
	}

	/**
	 * Funcion para agregar a JList la jornada seleccionada por el usuario,
	 * recuperada de un ArrayList<String> generado en JornadaRonda
	 */
	public static void mostrarJornada(JComboBox nJornada, JLabel txt) {
		int n = ((int) nJornada.getSelectedItem())-1;
		txt.setText(Ventana.Resultados.get(n));
	}

}
