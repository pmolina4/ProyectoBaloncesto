package interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
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

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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

		JButton btnClasif = new JButton("CLASIFICACION");
		btnClasif.setBounds(43, 556, 213, 26);
		panelCentral.add(btnClasif);
		btnClasif.setBackground((Color) new Color(241, 69, 15));
		btnClasif.setForeground(SystemColor.controlLtHighlight);
		btnClasif.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 10));
		btnClasif.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnClasif.setVisible(false);

		JButton btnVolver = new JButton("VOLVER");

		btnVolver.setBounds(75, 520, 141, 26);
		panelCentral.add(btnVolver);
		btnVolver.setBackground((Color) new Color(241, 69, 15));
		btnVolver.setForeground(SystemColor.controlLtHighlight);
		btnVolver.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 10));
		btnVolver.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnVolver.setVisible(false);

		JPanel panel2 = new JPanel();
		panel2.setBounds(277, 65, 141, 517);
		panel2.setBackground(new Color(240, 240, 240));
		panelCentral.add(panel2);
		panel2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) SystemColor.desktop));
		panel2.setLayout(null);

		JLabel textoClasificacion = new JLabel("");
		textoClasificacion.setForeground(new Color(241, 69, 15));
		textoClasificacion.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 10));
		textoClasificacion.setBounds(10, 0, 121, 517);
		panel2.add(textoClasificacion);
		panel2.setVisible(false);

		JPanel jpartidos = new JPanel();
		jpartidos.setBounds(20, 10, 398, 45);
		jpartidos.setBackground(new Color(240, 240, 240));
		jpartidos.setBorder(new MatteBorder(1, 1, 1, 1, (Color) SystemColor.desktop));
		panelCentral.add(jpartidos);
		jpartidos.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(32, 65, 235, 445);
		panel.setBackground(new Color(240, 240, 240));
		panelCentral.add(panel);
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) SystemColor.desktop));
		panel.setVisible(false);
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

		btnBuscar.setBounds(291, 7, 83, 26);
		btnBuscar.setBackground((Color) new Color(241, 69, 15));
		btnBuscar.setForeground(SystemColor.controlLtHighlight);
		btnBuscar.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 10));
		btnBuscar.setCursor(new Cursor(Cursor.HAND_CURSOR));

		btnBuscar.setBounds(291, 7, 83, 26);
		btnBuscar.setBackground((Color) new Color(241, 69, 15));
		btnBuscar.setForeground(SystemColor.controlLtHighlight);
		btnBuscar.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 10));
		btnBuscar.setCursor(new Cursor(Cursor.HAND_CURSOR));

		jpartidos.add(btnBuscar);
		panel.setLayout(null);

		JLabel fondo = new javax.swing.JLabel("");
		fondo.setBounds(0, 0, 450, 650);
		ImageIcon imagen2 = new ImageIcon(
				"C:/Users/pablo/Documents/GitHub/ProyectoBaloncesto/Basket/src/main/java/imagenes/fondo.jpg");
		panelCentral.add(fondo);
		Icon icono3 = new ImageIcon(
				imagen2.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_DEFAULT));
		fondo.setIcon(icono3);

		JLabel textoEquipos = new JLabel("");
		textoEquipos.setBounds(10, 10, 219, 425);
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

		/*
		 * Funcion onClick - Buscar
		 */
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnVolver.setVisible(true);
				btnClasif.setVisible(true);
				mostrarJornada(comboBoxLigas, textoEquipos);
				panel.setVisible(true);
			}
		});

		/*
		 * Funcion onClick - Clasificacion
		 */
		btnClasif.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel2.setVisible(true);
				textoClasificacion.setText(showClasificacion());
				btnClasif.setEnabled(false);
			}
		});

		/*
		 * Funcion onClick - Volver
		 */
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.showConsultarEquipos();
			}
		});
	}

	/*
	 * Funcion para generar de manera automatica las rondas
	 */
	public static void generarJornadas() {
		int nJornadas = 0;
		// Controlamos que los equipos sean pares para poder jugar
		Ventana.Equipos.remove(Ventana.Equipos.size() - 1);
		nJornadas = Ventana.Equipos.size();

		String nombre = "";
		// Instanciamos jornadas, simulamos los partidos, y los añadimos a
		// ArrayList<Jornadas>
		for (int i = 0; i < nJornadas; i++) {
			nombre = "Jornada Nº " + (i + 1);
			JornadaRonda j = new JornadaRonda(nombre, Ventana.Partidos);
			j.simularPartidosRonda();
			Ventana.Jornadas.add(j);
		}
	}

	/**
	 * Funcion para agregar a JList la jornada seleccionada por el usuario,
	 * recuperada de un ArrayList<String> generado en JornadaRonda
	 */
	public static void mostrarJornada(JComboBox nJornada, JLabel txt) {
		int n = ((int) nJornada.getSelectedItem()) - 1;
		txt.setText(Ventana.Resultados.get(n));
	}

	/*
	 * Funcion para concatenar en formato html las simulaciones de los partidos de
	 * las jornadas. Retorna un String con todo el texto.
	 */
	public static String showClasificacion() {
		String aux = "<html>";
		for (int i = 0; i < 9; i++) {
			aux += "<br> Puesto nº " + (i + 1) + "<br> Equipo: " + Ventana.EquiposEnLigas.get(i).getEquipo().getNombre()
					+ "<br> Puntos: " + Ventana.EquiposEnLigas.get(i).getPuntos() + "<br>";
		}
		return aux;
	}

}
