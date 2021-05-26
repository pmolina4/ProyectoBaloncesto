package interfaces;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

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

	}

	public void obtenerMedias() {

	}
}
