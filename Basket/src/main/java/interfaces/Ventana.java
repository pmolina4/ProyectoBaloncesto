package interfaces;

import javax.swing.JFrame;
import javax.swing.JList;

import clases.Jugador;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class Ventana extends JFrame {

	// Vistas
	private Registro ViewRegistro;
	private PantallaInicial ViewPantallaInicial;
	private ConsultarEquipos ViewConsultarEquipos;
	private Simulacion ViewSimulacion;
	//Variables Globales
	public static ArrayList<String> equipos = new ArrayList<String>();
	public static ArrayList<Jugador> Jugadores = new ArrayList<>();
	/*
	 * Crear ArrayList de Entrenador, y mediante una funcion en la view, recorremos el array list de equipos
	 * y a su vez vamos instanciando entrenadores y lo introducimos en la BDD
	 */
	
	public Ventana() {
		// Variables Iniciales
		this.setSize(500, 500);
		this.setTitle("Basket");
		this.setResizable(false);
		setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		// Inicializamos por Defecto la Pantalla Inicial
		ViewPantallaInicial = new PantallaInicial(this);
		this.setContentPane(ViewPantallaInicial);
		this.setVisible(true);
	}

	// Función para mostrar ventana ConsultarEquipos desde PantallaInicial
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

	// Función para mostrar ventana ConsultarEquipos desde PantallaInicial
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
	
	// Función para mostrar ventanaInicial desde Registro
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
	
	// Función para mostrar ventana Simulacion desde ConsultarEquipo
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
