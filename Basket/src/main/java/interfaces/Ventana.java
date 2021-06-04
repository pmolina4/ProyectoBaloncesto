package interfaces;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

import clases.Competicion;
import clases.Entrenador;
import clases.Equipo;
import clases.EquipoEnLiga;
import clases.Estadio;
import clases.JornadaRonda;
import clases.Jugador;
import clases.Partido;
import clases.Usuario;
import clases.Reproductor;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class Ventana extends JFrame {

	// Vistas
	private Registro ViewRegistro;
	private PantallaInicial ViewPantallaInicial;
	private ConsultarEquipos ViewConsultarEquipos;
	private Simulacion ViewSimulacion;
	// Variables Auxiliar
	public static ArrayList<String> equipos = new ArrayList<String>();
	public static Reproductor player = new Reproductor();
	// ArrayList de Clases
	public static ArrayList<Jugador> Jugadores = new ArrayList<>();
	public static ArrayList<Entrenador> Entrenadores = new ArrayList<>();
	public static ArrayList<Estadio> Estadios = new ArrayList<>();
	public static ArrayList<Equipo> Equipos = new ArrayList<>();
	public static ArrayList<Partido> Partidos = new ArrayList<>();
	public static ArrayList<JornadaRonda> Jornadas = new ArrayList<>();
	public static ArrayList<EquipoEnLiga> EquiposEnLigas = new ArrayList<>();
	public static ArrayList<Competicion> Competiciones = new ArrayList<>();
	public static ArrayList<String> Resultados = new ArrayList<>();
	// Instancias de Objetos
	public static Entrenador ent = new Entrenador();
	public static Equipo equi = new Equipo();
	public static Estadio estad = new Estadio();
	public static Partido part = new Partido();
	public static JornadaRonda jorn = new JornadaRonda();
	public static Usuario usu = new Usuario();
	public static EquipoEnLiga eli = new EquipoEnLiga();
	public static Competicion compet = new Competicion();
	/*
	 * Funcion ventana 
	 */
	public Ventana() {
		// Variables Iniciales
		this.setSize(450, 650);
		this.setTitle("UrbanBasket");
		this.setResizable(false);
		setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		// Inicializamos por Defecto la Pantalla Inicial
		ViewPantallaInicial = new PantallaInicial(this);
		this.setContentPane(ViewPantallaInicial);
		this.setVisible(true);
		Image icon = new ImageIcon(("src/main/java/imagenes/ic.png")).getImage();
		this.setIconImage(icon);
	}

	/*
	 * Funcion para mostrar la vista Registro
	 */
	public void showRegistrar() {
		if (this.ViewRegistro == null) {
			this.ViewRegistro = new Registro(this);
		}
		if (this.ViewPantallaInicial != null) {
			this.ViewPantallaInicial.setVisible(false);
		}
		this.setContentPane(this.ViewRegistro);
		this.ViewRegistro.setVisible(true);
	}

	/*
	 * Funcion para mostrar la vista ConsultarEquipos
	 */
	public void showConsultarEquipos() {
		if (this.ViewConsultarEquipos == null) {
			this.ViewConsultarEquipos = new ConsultarEquipos(this);
		}
		if (this.ViewPantallaInicial != null) {
			this.ViewPantallaInicial.setVisible(false);
		}
		this.setContentPane(this.ViewConsultarEquipos);
		this.ViewConsultarEquipos.setVisible(true);
	}

	/*
	 * Funcion para mostrar la vista PantallaInicial
	 */
	public void showPantallaInicial() {
		if (this.ViewPantallaInicial == null) {
			this.ViewPantallaInicial = new PantallaInicial(this);
		}
		if (this.ViewRegistro != null) {
			this.ViewRegistro.setVisible(false);
		}
		this.setContentPane(this.ViewPantallaInicial);
		this.ViewPantallaInicial.setVisible(true);
	}

	/*
	 * Funcion para mostrar la vista Simulacion
	 */
	public void showSimulacion() {
		if (this.ViewSimulacion == null) {
			this.ViewSimulacion = new Simulacion(this);
		}
		if (this.ViewConsultarEquipos != null) {
			this.ViewConsultarEquipos.setVisible(false);
		}
		this.setContentPane(this.ViewSimulacion);
		this.ViewSimulacion.setVisible(true);
	}

}
