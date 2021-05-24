package interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import interfaces.Ventana;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import clases.Jugador;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import java.awt.ScrollPane;
import java.awt.Panel;
import java.awt.Button;
import javax.swing.JTextField;

public class ConsultarEquipos extends JPanel {
	// Componentes
	private Ventana ventana;
	// Variables Aux
	private String liga;
	private String temporada;
	private JTextField text_jugadores;

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
		list.setBounds(328, 10, 142, 134);
		panel.add(list);
		list.setVisible(false);
		
		
		JPanel panel_jugadores = new JPanel();
		panel_jugadores.setBackground(Color.LIGHT_GRAY);
		panel_jugadores.setBounds(10, 185, 480, 135);
		panelCentral.add(panel_jugadores);
		panel_jugadores.setLayout(null);
		
		text_jugadores = new JTextField();
		text_jugadores.setBackground(Color.LIGHT_GRAY);
		text_jugadores.setBounds(10, 10, 460, 115);
		panel_jugadores.add(text_jugadores);
		text_jugadores.setColumns(10);
		panel_jugadores.setVisible(false);


		// -------------------------------- FIN COMPONENTES J
		// -------------------------------------

		// Rellenamos los JCombo de Temporadas y Ligas
		fillComboBox(comboBoxTemporadas, comboBoxLigas);


		// Funcion OnClick BUSCAR
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fillJList(list, comboBoxTemporadas, comboBoxLigas);
			}
		});
		
		//Funcion DoubleClick Lista Equipos
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {
					panel_jugadores.setVisible(true);
					generarEquipo();
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
			//En caso de que la BDD no devuelva ningún equipo
			if (iter == 0) {
				JOptionPane.showMessageDialog(ventana, "No se han encontrado equipos con tal combinacion",
						"Login fallido", JOptionPane.ERROR_MESSAGE);
			} else {
				list.setModel(modelo);
				list.setVisible(true);

			}
			smt.close();
			conexion.close();
			// Lanzamos Error y Seteamos los campos a vacio
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(ventana, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	//Funcion que genera de manera aleatoria los jugadores de un equipo
	public static void generarEquipo() {
		ArrayList<Jugador> Jugadores = new ArrayList<>();
		Jugador j = new Jugador("");
		int iter=0;
		while(iter>8) {		
		Jugador a = j.generRandomPlayer();
		System.out.println(a);
		}
	}
	
	//Funcion que imprime nuestro ArrayList de Jugadores
	public static String  imprimirArrayList(ArrayList<Jugador> Jugadores) {
		String aux="";
		 for(int i = 0; i < Jugadores.size(); i++) {
			 aux="Nombre: "+Jugadores.get(i).getNombre();
	        }
		 System.out.println(aux);
		return aux;
		
	}
}

