package interfaces;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class Ventana extends JFrame {

	private Registro ViewRegistro;
	private PantallaInicial ViewPantallaInicial;
	private ConsultarEquipos ViewConsultarEquipos;

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
	//Función para mostrar ventana ConsultarEquipos
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
}
