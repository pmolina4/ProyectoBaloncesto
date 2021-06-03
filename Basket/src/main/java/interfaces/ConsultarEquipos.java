package interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import clases.Jugador;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import javax.swing.border.MatteBorder;

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
		this.setSize(450, 650);

		createArr();

		// -------------------------------- COMPONENTES J
		// -------------------------------------
		JPanel panel_jugadores = new JPanel();
		panel_jugadores.setBackground(Color.LIGHT_GRAY);
		panel_jugadores.setBounds(10, 210, 406, 358);
		panel_jugadores.setLayout(null);
		panel_jugadores.setVisible(false);
		panel_jugadores.setBorder(new MatteBorder(1, 1, 1, 1, (Color) SystemColor.desktop));
		JPanel panelCentral = new JPanel();
		panelCentral.setBackground(new Color(241, 69, 15));
		add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 240, 240));
		panel.setBounds(10, 37, 406, 163);
		panelCentral.add(panel);
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) SystemColor.desktop));
		panel.setLayout(null);
		JButton btnShowSimulacion = new JButton("SIMULAR");
		btnShowSimulacion.setBounds(169, 571, 103, 35);
		btnShowSimulacion.setBackground((Color) new Color(240, 240, 240));
		btnShowSimulacion.setForeground((Color) new Color(241, 69, 15));
		btnShowSimulacion.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 10));
		btnShowSimulacion.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnShowSimulacion.setVisible(false);
		panelCentral.add(btnShowSimulacion);
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.setBounds(130, 106, 97, 31);
		btnBuscar.setBackground((Color) new Color(241, 69, 15));
		btnBuscar.setForeground(SystemColor.controlLtHighlight);
		btnBuscar.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 10));
		btnBuscar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel.add(btnBuscar);
		JLabel textoLigas = new JLabel("Ligas");
		textoLigas.setBounds(10, 10, 58, 39);
		textoLigas.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		textoLigas.setForeground(new Color(241, 69, 15));
		panel.add(textoLigas);
		JLabel textoTemporadas = new JLabel("Temporadas");
		textoTemporadas.setBounds(10, 50, 102, 46);
		textoTemporadas.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		textoTemporadas.setForeground(new Color(241, 69, 15));
		panel.add(textoTemporadas);
		JLabel btnNewButton_1 = new JLabel("");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBounds(97, 10, 234, 35);
		panelCentral.add(btnNewButton_1);
		btnNewButton_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 10));
		JLabel lblStats = new JLabel("Estadisticas");
		lblStats.setBounds(244, 0, 100, 41);
		lblStats.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		lblStats.setForeground(SystemColor.desktop);
		panel_jugadores.add(lblStats);
		JLabel lblJugadores = new JLabel("Jugadores");
		lblJugadores.setBounds(38, 6, 116, 28);
		lblJugadores.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		lblJugadores.setForeground(SystemColor.desktop);
		panel_jugadores.add(lblJugadores);
		JComboBox<String> comboBoxLigas = new JComboBox<String>();
		comboBoxLigas.setBounds(91, 19, 173, 21);
		panel.add(comboBoxLigas);
		comboBoxLigas.addItem("-- Selecciona una Liga --");
		comboBoxLigas.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		comboBoxLigas.setForeground(new Color(241, 69, 15));
		JComboBox<String> comboBoxTemporadas = new JComboBox<String>();
		comboBoxTemporadas.setBounds(91, 63, 173, 21);
		panel.add(comboBoxTemporadas);
		comboBoxTemporadas.addItem("-- Selecciona una Temporada --");
		comboBoxTemporadas.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		comboBoxTemporadas.setForeground(new Color(241, 69, 15));
		JList<String> list = new JList<String>();
		list.setBackground(new Color(240, 240, 240));
		list.setBounds(284, 10, 112, 143);
		panel.add(list);
		list.setVisible(false);
		JList<String> text_jugadores = new JList<String>();
		text_jugadores.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		text_jugadores.setForeground(new Color(241, 69, 15));
		text_jugadores.setBackground(new Color(240, 240, 240));
		text_jugadores.setBounds(10, 44, 143, 167);
		panel_jugadores.add(text_jugadores);
		JList<String> estadisticas_jugadores = new JList<String>();
		panel_jugadores.setBackground(new Color(240, 240, 240));
		estadisticas_jugadores.setBounds(234, 32, 162, 187);
		estadisticas_jugadores.setBackground(new Color(240, 240, 240));
		estadisticas_jugadores.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		estadisticas_jugadores.setForeground(new Color(241, 69, 15));
		estadisticas_jugadores.setVisible(false);
		panel_jugadores.add(estadisticas_jugadores);
		text_jugadores.setVisible(false);
		panelCentral.add(panel_jugadores);
		JLabel lblEntrenador = new JLabel("");
		lblEntrenador.setBounds(10, 245, 144, 77);
		lblEntrenador.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		lblEntrenador.setForeground(new Color(241, 69, 15));
		panel_jugadores.add(lblEntrenador);
		JLabel lblEntrenadores = new JLabel("Entrenador");
		lblEntrenadores.setForeground(Color.BLACK);
		lblEntrenadores.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		lblEntrenadores.setBounds(38, 221, 116, 28);
		panel_jugadores.add(lblEntrenadores);
		JLabel lblEstadio = new JLabel("Estadio:");
		lblEstadio.setForeground(Color.BLACK);
		lblEstadio.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		lblEstadio.setBounds(244, 221, 116, 28);
		panel_jugadores.add(lblEstadio);
		JLabel lblEstadios = new JLabel("");
		lblEstadios.setBounds(223, 245, 144, 77);
		lblEstadios.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		lblEstadios.setForeground(new Color(241, 69, 15));
		panel_jugadores.add(lblEstadios);
		JLabel fondo = new javax.swing.JLabel("");
		ImageIcon imagen2 = new ImageIcon(
				"C:/Users/pablo/Documents/GitHub/ProyectoBaloncesto/Basket/src/main/java/imagenes/fondo.jpg");
		fondo.setBounds(0, 0, 450, 650);
		panelCentral.add(fondo);
		Icon icono3 = new ImageIcon(
				imagen2.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_DEFAULT));
		fondo.setIcon(icono3);

		// -------------------------------- FIN COMPONENTES J
		// -------------------------------------

		// Rellenamos los JCombo de Temporadas y Ligas
		fillComboBox(comboBoxTemporadas, comboBoxLigas);

		/*
		 * Funcion onClick - Buscar
		 */
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Mostramos la lista de jugadores del equipo seleccionado, entrenador y estadio
				JOptionPane.showMessageDialog(ventana,
						"Haz doble click en el equipo, y despues, en un jugador para ver sus stats!", "UrbanBasket",
						JOptionPane.PLAIN_MESSAGE);
				fillJList(list, comboBoxTemporadas, comboBoxLigas, btnNewButton_1);
				btnBuscar.setEnabled(false);
			}
		});

		/*
		 * Funcion DoubleClick listaEquipos
		 */
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					// Mostramos tentrenador y estadios del equipo seleccionado
					panel_jugadores.setVisible(true);
					showJugadores(text_jugadores, (String) list.getSelectedValue(), lblEntrenador, lblEstadios);
					text_jugadores.setVisible(true);
					estadisticas_jugadores.setVisible(false);

				}
			}
		});

		/*
		 * Funcion DoubleClick stats
		 * 
		 */
		text_jugadores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					//Mostramos todas las estdisticas del jugador seleccionado
					String jugadorSelec = (String) text_jugadores.getSelectedValue();
					String jugadorSelecSpl = jugadorSelec.replaceAll("[|:|0|1|2|3|4|5|6|7|8|9]", "").substring(2);
					showStats(estadisticas_jugadores, jugadorSelecSpl, btnShowSimulacion);
				}
			}
		});

		/*
		 * Funcion onClick Simular 
		 */
		btnShowSimulacion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Mostramos la vista simular
				v.showSimulacion();
			}
		});
	}

	/*
	 * Funcion para rellenar ComboBox de Ligas y Temporadas
	 */
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
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(ventana, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	/*
	 * Funcion para rellenar JList de Equipos
	 */
	public void fillJList(JList list, JComboBox comboBoxLigas, JComboBox comboBoxTemporadas, JLabel btn) {
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
				Ventana.equipos.add(resultadosEquipos.getString("equipo"));
			}
			// En caso de que la BDD no devuelva ningún equipo
			if (iter == 0) {
				JOptionPane.showMessageDialog(ventana, "No se han encontrado equipos con tal combinacion",
						"Login fallido", JOptionPane.ERROR_MESSAGE);
			} else {
				btn.setText("Haz click en un equipo para ver sus jugadores");
				list.setModel(modelo);
				list.setVisible(true);
			}
			smt.close();
			conexion.close();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(ventana, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	/*
	 * Funcion Auxiliar que devuelve la lista de jugadores de un equipo
	 */
	public static void showJugadores(JList list, String valor, JLabel lbl, JLabel lbl2) {
		DefaultListModel modelo = new DefaultListModel();
		String aux = "";

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
			Ventana.ent.generarEntrenadores();
			Ventana.estad.generarEstadios();
			Ventana.equi.generarEquipos();
			lbl.setText("<html> Nombre: " + Ventana.Entrenadores.get(buscarEntrenador(valor)).getNombre()
					+ "<br> Nacionalidad: " + Ventana.Entrenadores.get(buscarEntrenador(valor)).getNacionalidad()
					+ "<br> Calidad: " + Ventana.Entrenadores.get(buscarEntrenador(valor)).getCalidad()
					+ "/100</html>");
			lbl2.setText("<html>" + Ventana.Equipos.get(buscarEstadio(valor)).getEstadio().getNombre()
					+ "<br> Dimensiones: " + Ventana.Equipos.get(buscarEstadio(valor)).getEstadio().getAforo()
					+ "m3 <br> Aforo: " + Ventana.Equipos.get(buscarEstadio(valor)).getEstadio().getDimensiones()
					+ " personas</html>");
			list.setModel(modelo);
			smt.close();
			conexion.close();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(ventana, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Funcion para obtener el indice del entrenador correspondiente a su equipo
	 * 
	 * @param r - Nombre del equipo
	 * @return index - Indice en el que se encuentra el entrenador
	 */
	public static int buscarEntrenador(String r) {
		int index = -1;
		int bound = Ventana.Entrenadores.size();
		for (int i = 0; i < bound; i++) {
			if (Ventana.Entrenadores.get(i).getEquipo().equals(r)) {
				index = i;
				break;
			}
		}
		return index;
	}

	/**
	 * Funcion para obtener el indice del estadio correspondiente a su equipo
	 * 
	 * @param r - Nombre del equipo
	 * @return index - Indice en el que se encuentra el estadio
	 */
	public static int buscarEstadio(String r) {
		int index = -1;
		int bound = Ventana.Equipos.size();

		for (int i = 0; i < bound; i++) {
			if (Ventana.Equipos.get(i).getNombre().equals(r)) {
				index = i;
				break;
			}
		}
		return index;
	}

	/*
	 * Funcion que muestra las stats de un jugador y las almacena en un arrayList 
	 */
	public void showStats(JList list, String valor, JButton btn) {
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
				modelo.addElement("<html>Numero: " + resultadosEquipos.getString("numero") + "<br>Mano Dominante: "
						+ resultadosEquipos.getString("manoDominante") + "<br>Fuerza: "
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
			btn.setVisible(true);
			smt.close();
			conexion.close();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(ventana, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	// ---------FUNCIONES AUXILIARES PARA LA CREACION DE DATOS EN
	// LA BDD ---------------------------------------------------

	/*
	 * Funcion que recupera los jugadores del ArrayList<Jugadores> y los introduce
	 * en la BDD.
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
				// Ventana.Jugadores = generarEquipo();
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

	/*
	 * Funcion que recupera los jugadores de la BDD para insertarlos en
	 * ArrayList<Jugadores>
	 */
	public void createArr() {
		try {
			Connection conexion = DriverManager.getConnection(
					"jdbc:mysql://localhost/basket?useUnicode=true&useJDBCcompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", "root");
			Statement smt = conexion.createStatement();
			ResultSet resultadosEquipos = smt.executeQuery(
					"SELECT nombre,posicion, manoDominante, fuerza, velocidad, inteligencia, tecnica, numero, mediaAtaque, mediaDefensa, equipo FROM jugador");
			while (resultadosEquipos.next()) {
				Jugador a = new Jugador(resultadosEquipos.getString("nombre"), resultadosEquipos.getString("equipo"),
						resultadosEquipos.getString("posicion"), resultadosEquipos.getString("manoDominante"),
						resultadosEquipos.getByte("fuerza"), resultadosEquipos.getByte("velocidad"),
						resultadosEquipos.getByte("inteligencia"), resultadosEquipos.getByte("tecnica"),
						resultadosEquipos.getByte("numero"), resultadosEquipos.getByte("mediaAtaque"),
						resultadosEquipos.getByte("mediaDefensa"));
				Ventana.Jugadores.add(a);
			}
			smt.close();
			conexion.close();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(ventana, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
