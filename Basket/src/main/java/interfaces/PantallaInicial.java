package interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Font;
import java.awt.Image;
import java.awt.Cursor;
import javax.swing.border.MatteBorder;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.EmptyBorder;

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
		this.setSize(450, 650);



		// -------------------------------- COMPONENTES J
		// -------------------------------------

		JPanel panelCentral = new JPanel();
		panelCentral.setBackground(new Color(241, 69, 15));
		add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(null);
		ImageIcon imagen = new ImageIcon(
				"src/main/java/imagenes/ic.png");
		ImageIcon imagen2 = new ImageIcon(
				"src/main/java/imagenes/fondo.jpg");
		JButton btnNewButton_1 = new JButton("¿No tienes cuenta? Regístrate Aquí!");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBounds(102, 534, 234, 35);
		panelCentral.add(btnNewButton_1);
		btnNewButton_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 13));
		btnNewButton_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setBackground(new Color(0, 0, 0, 0));
		btnNewButton_1.setBorder(null);
		JLabel lblNewLabel = new javax.swing.JLabel("");
		lblNewLabel.setBounds(146, 96, 161, 128);
		Icon icono2 = new ImageIcon(imagen.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(),
				Image.SCALE_DEFAULT));
		lblNewLabel.setIcon(icono2);
		panelCentral.add(lblNewLabel);
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(89, 234, 269, 189);
		panelCentral.add(panel);
		panel.setLayout(null);
		nombreUsuRec = new JTextField();
		nombreUsuRec.setBounds(27, 35, 207, 20);
		panel.add(nombreUsuRec);
		nombreUsuRec.setForeground(Color.DARK_GRAY);
		nombreUsuRec.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		JLabel lblPass = new JLabel("Contraseña:");
		lblPass.setBounds(27, 52, 103, 35);
		panel.add(lblPass);
		lblPass.setForeground(new Color(241, 69, 15));
		lblPass.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		contrasenaUsuRec = new JPasswordField();
		contrasenaUsuRec.setBounds(27, 86, 207, 20);
		panel.add(contrasenaUsuRec);
		contrasenaUsuRec.setForeground(Color.DARK_GRAY);
		((JPasswordField) contrasenaUsuRec).setEchoChar('*');
		contrasenaUsuRec.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setBounds(27, 129, 207, 32);
		panel.add(btnNewButton);
		btnNewButton.setBackground((Color) new Color(241, 69, 15));
		btnNewButton.setForeground(SystemColor.controlLtHighlight);
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 10));
		btnNewButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		JLabel lblName = new JLabel("Nombre:");
		lblName.setBounds(27, 0, 103, 35);
		panel.add(lblName);
		lblName.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		lblName.setForeground(new Color(241, 69, 15));
		JLabel fondo = new javax.swing.JLabel("");
		fondo.setBounds(0, 0, 450, 650);
		panelCentral.add(fondo);
		Icon icono3 = new ImageIcon(
				imagen2.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_DEFAULT));
		fondo.setIcon(icono3);

		// -------------------------------- FIN COMPONENTES J
		// -------------------------------------

		/*
		 * Funcion onClick - Login
		 */
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Recuperamos los campos de Login
				nombreUsu = nombreUsuRec.getText();
				contrasenaUsu = contrasenaUsuRec.getText();
				// En caso de que no exista en la BDD, mostramos la siguiente ventana
				if (comp()) {
					ventana.showConsultarEquipos();
				}
			}
		});

		/*
		 * Funcion onClick - Registrar
		 */
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.showRegistrar();
			}
		});
	}

	/**
	 * Funcion que comprueba si el usuario introducido en el login existe en la BDD
	 * 
	 * @return true - Si existe
	 */
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
				// Lanzamos Error, seteamos texto del form a vacio y sus bordes en rojo
				JOptionPane.showMessageDialog(ventana, "Usuario o Contraseña Incorrecta", "Login fallido",
						JOptionPane.ERROR_MESSAGE);
				nombreUsuRec.setText(null);
				contrasenaUsuRec.setText(null);
				nombreUsuRec.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(241, 69, 15)));
				contrasenaUsuRec.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(241, 69, 15)));

				return false;
			}
			smt.close();
			conexion.close();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(ventana, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		//En caso de que exista, lanzamos un sonido
		Ventana.player
				.play("src/main/java/sonidos/login.wav");
		return true;
	}

}