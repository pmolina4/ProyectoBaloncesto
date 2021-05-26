package interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Panel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JPanel;
import clases.Jugador;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ConsultarEquipos extends JPanel {
	// Vistas
	private static Ventana ventana;
	// Variables Aux
	private String liga;
	private String temporada;

	public ConsultarEquipos(Ventana v) {
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

		Panel panel = new Panel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 10, 480, 163);
		panelCentral.add(panel);
		panel.setLayout(null);

		JLabel textoLigas = new JLabel("Ligas");
		textoLigas.setBounds(10, 10, 58, 39);
		panel.add(textoLigas);

		JLabel textoTemporadas = new JLabel("Temporadas");
		textoTemporadas.setBounds(10, 50, 102, 46);
		panel.add(textoTemporadas);

		JComboBox comboBoxLigas = new JComboBox();
		comboBoxLigas.setBounds(113, 19, 193, 21);
		panel.add(comboBoxLigas);
		comboBoxLigas.addItem("-- Selecciona una Liga --");

		JComboBox comboBoxTemporadas = new JComboBox();
		comboBoxTemporadas.setBounds(113, 63, 193, 21);
		panel.add(comboBoxTemporadas);
		comboBoxTemporadas.addItem("-- Selecciona una Temporada --");

		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.setBounds(135, 108, 97, 31);
		panel.add(btnBuscar);

		JList list = new JList();
		list.setBackground(Color.LIGHT_GRAY);
		list.setBounds(328, 10, 142, 143);
		panel.add(list);
		list.setVisible(false);

		JPanel panel_jugadores = new JPanel();
		panel_jugadores.setBackground(Color.LIGHT_GRAY);
		panel_jugadores.setBounds(10, 185, 480, 229);
		panelCentral.add(panel_jugadores);
		panel_jugadores.setLayout(null);

		JList text_jugadores = new JList();

		text_jugadores.setBackground(Color.LIGHT_GRAY);
		text_jugadores.setBounds(26, 10, 143, 110);
		panel_jugadores.add(text_jugadores);

		JList estadisticas_jugadores = new JList();
		estadisticas_jugadores.setBackground(Color.LIGHT_GRAY);
		estadisticas_jugadores.setBounds(203, 10, 267, 191);
		estadisticas_jugadores.setVisible(false);
		panel_jugadores.add(estadisticas_jugadores);
		text_jugadores.setVisible(false);
		panel_jugadores.setVisible(false);

		JButton btnShowSimulacion = new JButton("SIMULAR");
		btnShowSimulacion.setBounds(197, 424, 85, 21);
		panelCentral.add(btnShowSimulacion);

		// -------------------------------- FIN COMPONENTES J
		// -------------------------------------

		// Rellenamos los JCombo de Temporadas y Ligas
		fillComboBox(comboBoxTemporadas, comboBoxLigas);

		// Funcion OnClick BUSCAR - Muestra la lista de Temporadas y Liga
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fillJList(list, comboBoxTemporadas, comboBoxLigas);
			}
		});

		// Funcion DoubleClick LISTA EQUIPOS - Muestra la lista de Jugadores del Equipo
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					panel_jugadores.setVisible(true);
					showJugadores(text_jugadores, (String) list.getSelectedValue());
					text_jugadores.setVisible(true);
					estadisticas_jugadores.setVisible(false);
				}
			}
		});

		//Funcion onClick SIMULAR - Abre la ventana de Simulacion de Partidos
		btnShowSimulacion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.showSimulacion();
			}
		});

		// Funcion DoubleClick LISTA STATS JUGADORES - Muestra las Estadisticas del
		// Jugador Seleccionado
		text_jugadores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					String jugadorSelec = (String) text_jugadores.getSelectedValue();
					String jugadorSelecSpl = jugadorSelec.replaceAll("[|:|0|1|2|3|4|5|6|7|8|9]", "").substring(2);
					showStats(estadisticas_jugadores, jugadorSelecSpl);
				}
			}

		});
	}

	// Función para Rellenar ComboBox de Ligas y Temporadas
	public void fillComboBox(JComboBox comboBoxLigas, JComboBox comboBoxTemporadas) {
		try {
			Connection conexion = DriverManager.getConnection(
					"jdbc:mysql://localhost/basket?useUnicode=true&useJDBCcompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", "root");
			Statement smt = conexion.createStatement();
			ResultSet resultadosLiga = smt.executeQuery("SELECT nombre FROM liga ");
			while (resultadosLiga.next()) {
				comboBoxLigas.addItem(resultadosLiga.getString("nombre"));
			}
			ResultSet resultadosTemp = smt.executeQuery("SELECT temporada FROM liga ");
			while (resultadosTemp.next()) {
				comboBoxTemporadas.addItem(resultadosTemp.getString("temporada"));
			}
			smt.close();
			conexion.close();
			// Lanzamos Error y Seteamos los campos a vacio
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(ventana, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	// Función para Rellenar JList de Equipos
	public void fillJList(JList list, JComboBox comboBoxLigas, JComboBox comboBoxTemporadas) {
		int iter = 0;
		liga = (String) comboBoxLigas.getSelectedItem();
		temporada = (String) comboBoxTemporadas.getSelectedItem();
		DefaultListModel modelo = new DefaultListModel();
		try {
			Connection conexion = DriverManager.getConnection(
					"jdbc:mysql://localhost/basket?useUnicode=true&useJDBCcompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", "root");
			Statement smt = conexion.createStatement();
			ResultSet resultadosEquipos = smt.executeQuery(
					"SELECT equipo FROM liga_equipo WHERE liga='" + liga + "' AND temporada='" + temporada + "'");
			while (resultadosEquipos.next()) {
				iter++;
				modelo.addElement(resultadosEquipos.getString("equipo"));
			}
			// En caso de que la BDD no devuelva ningún equipo
			if (iter == 0) {
				JOptionPane.showMessageDialog(ventana, "No se han encontrado equipos con tal combinacion",
						"Login fallido", JOptionPane.ERROR_MESSAGE);
			} else {
				list.setModel(modelo);
				list.setVisible(true);
			}
			smt.close();
			conexion.close();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(ventana, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	// Funcion que genera de manera aleatoria los jugadores de un equipo
	public static ArrayList<Jugador> generarEquipo() {
		ArrayList<Jugador> Jugadores = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			Jugador a = new Jugador();
			Jugadores.add(a);
		}
		return Jugadores;
	}

	// Funcion que devuelve la lista de Jugadores de un Equipo
	public static void showJugadores(JList list, String valor) {
		DefaultListModel modelo = new DefaultListModel();
		try {
			Connection conexion = DriverManager.getConnection(
					"jdbc:mysql://localhost/basket?useUnicode=true&useJDBCcompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", "root");
			Statement smt = conexion.createStatement();
			ResultSet resultadosEquipos = smt
					.executeQuery("SELECT nombre,numero FROM jugador WHERE equipo='" + valor + "'");
			while (resultadosEquipos.next()) {
				modelo.addElement(
						resultadosEquipos.getString("numero") + " : " + resultadosEquipos.getString("nombre"));
			}
			list.setModel(modelo);
			smt.close();
			conexion.close();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(ventana, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	// Funcion para Mostrar las Stats de los Jugadores y Guardarlos en un ArrayList
	public void showStats(JList list, String valor) {
		DefaultListModel modelo = new DefaultListModel();
		try {
			Connection conexion = DriverManager.getConnection(
					"jdbc:mysql://localhost/basket?useUnicode=true&useJDBCcompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", "root");
			Statement smt = conexion.createStatement();
			ResultSet resultadosEquipos = smt.executeQuery(
					"SELECT posicion, manoDominante, fuerza, velocidad, inteligencia, tecnica, numero, mediaAtaque, mediaDefensa, equipo FROM jugador WHERE nombre = '"
							+ valor + "'");
			while (resultadosEquipos.next()) {
				modelo.addElement(
						"<html>Estadisticas de " + valor + "<br>" + "Numero: " + resultadosEquipos.getString("numero")
								+ "<br>Mano Dominante: " + resultadosEquipos.getString("manoDominante") + "<br>Fuerza: "
								+ resultadosEquipos.getString("fuerza") + "<br>Velocidad: "
								+ resultadosEquipos.getString("velocidad") + "<br>Inteligencia: "
								+ resultadosEquipos.getString("inteligencia") + "<br>Tecnica: "
								+ resultadosEquipos.getString("tecnica") + "<br>Numero: "
								+ resultadosEquipos.getString("numero") + "<br> Media Ataque: "
								+ resultadosEquipos.getString("mediaAtaque") + "<br>Media Defensa: "
								+ resultadosEquipos.getString("mediaDefensa") + "</html>");

				Jugador a = new Jugador(valor, resultadosEquipos.getString("equipo"),
						resultadosEquipos.getString("posicion"), resultadosEquipos.getString("manoDominante"),
						resultadosEquipos.getByte("fuerza"), resultadosEquipos.getByte("velocidad"),
						resultadosEquipos.getByte("inteligencia"), resultadosEquipos.getByte("tecnica"),
						resultadosEquipos.getByte("numero"), resultadosEquipos.getByte("mediaAtaque"),
						resultadosEquipos.getByte("mediaDefensa"));
				Ventana.Jugadores.add(a);
			}
			list.setModel(modelo);
			list.setVisible(true);
			smt.close();
			conexion.close();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(ventana, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	/*
	 * ESTA FUNCION LA UTILIZAMOS UNICAMENTE PARA NO CREAR DE MANERA MANUAL LOS
	 * JUGADORES EN LA BDD ConsultaCreacion() Funcion que crea de manera automatica
	 * en la BDD jugadores. Para obtener su equipo, realizamos consulta, y para
	 * insertarlos accedemos a nuestro arrayList de la clase Jugadores
	 */
	public void consultaCreacion() {
		try {
			Connection conexion = DriverManager.getConnection(
					"jdbc:mysql://localhost/basket?useUnicode=true&useJDBCcompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", "root");
			Statement smt = conexion.createStatement();
			ResultSet resultadosEquipos = smt.executeQuery("SELECT nombre FROM equipo;");
			while (resultadosEquipos.next()) {

				Ventana.equipos.add(resultadosEquipos.getString("nombre"));
			}
			for (int i = 0; i < Ventana.equipos.size(); i++) {
				Ventana.Jugadores = generarEquipo();
				smt.executeUpdate("INSERT INTO jugador VALUES('" + Ventana.Jugadores.get(i).getNombre() + "','"
						+ Ventana.Jugadores.get(i).getPosicion() + "','" + Ventana.Jugadores.get(i).getManoDominante()
						+ "'," + Ventana.Jugadores.get(i).getFuerza() + "," + Ventana.Jugadores.get(i).getVelocidad()
						+ ", " + Ventana.Jugadores.get(i).getInteligencia() + ","
						+ Ventana.Jugadores.get(i).getTecnica() + "," + Ventana.Jugadores.get(i).getNumero() + ",'"
						+ Ventana.equipos.get(i) + "')");
			}

			smt.close();
			conexion.close();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(ventana, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
