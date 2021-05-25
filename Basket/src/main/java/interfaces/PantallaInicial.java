package interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PantallaInicial extends JPanel {
	// Componentes
	private Ventana ventana;
	private JTextField contrasenaUsuRec;
	private JTextField nombreUsuRec;
	// Variables Aux
	private String nombreUsu;
	private String contrasenaUsu;
	// Vistas
	private ConsultarEquipos ViewConsultarEquipos;

	// Pantalla con Opcion a Loguearte y/o Registrarte
	public PantallaInicial(Ventana v) {
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

		JLabel lblNewLabel = new JLabel("USUARIO");
		lblNewLabel.setBounds(287, 54, 119, 62);
		panelCentral.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("CONTRASEÑA");
		lblNewLabel_1.setBounds(90, 54, 119, 62);
		panelCentral.add(lblNewLabel_1);

		contrasenaUsuRec = new JPasswordField();
		((JPasswordField) contrasenaUsuRec).setEchoChar('*');
		contrasenaUsuRec.setBounds(58, 126, 132, 20);
		panelCentral.add(contrasenaUsuRec);

		nombreUsuRec = new JTextField();
		nombreUsuRec.setBounds(276, 127, 96, 19);
		panelCentral.add(nombreUsuRec);
		nombreUsuRec.setColumns(10);

		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setBounds(101, 227, 85, 21);
		panelCentral.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("REGISTRO");
		btnNewButton_1.setBounds(287, 227, 85, 21);
		panelCentral.add(btnNewButton_1);
		// -------------------------------- FIN COMPONENTES J
		// -------------------------------------

		// Funcion onClick REGISTRO
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.showRegistrar();
			}
		});

		// Funcion onClick LOGIN
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Recuperamos los campos de Login
				nombreUsu = nombreUsuRec.getText();
				contrasenaUsu = contrasenaUsuRec.getText();
				// Comprobamos en BDD
				if (comp()) {
					ventana.showConsultarEquipos();
				}
			}
		});
	}

	// Funcion que comprueba si existe en la BDD el nombre y el usuario introducidos
	// en el login
	public boolean comp() {
		// Realizamos la Consulta
		try {
			Connection conexion = DriverManager.getConnection(
					"jdbc:mysql://localhost/basket?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", "root");
			Statement smt = conexion.createStatement();
			ResultSet resultados = smt.executeQuery("SELECT nickname, contrasena FROM usuario WHERE nickname = '"
					+ nombreUsu + "' AND contrasena = '" + contrasenaUsu + "'");
			if (resultados.next()) {
				nombreUsu = resultados.getString("nickname");
				contrasenaUsu = resultados.getString("contrasena");
			} else {
				JOptionPane.showMessageDialog(ventana, "Usuario o Contraseña Incorrecta", "Login fallido",
						JOptionPane.ERROR_MESSAGE);
				nombreUsuRec.setText(null);
				contrasenaUsuRec.setText(null);
				return false;
			}
			smt.close();
			conexion.close();
			// Lanzamos Error y Seteamos los campos a vacio
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(ventana, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		return true;
	}
}