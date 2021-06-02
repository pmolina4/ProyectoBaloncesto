package interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
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
import java.awt.Insets;
import java.awt.Cursor;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.UIManager;
import java.awt.SystemColor;

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
		Border roundedBorder = new LineBorder(new Color(210, 210, 210), 1, true);

		JPanel panelCentral = new JPanel();
		panelCentral.setBackground(new Color(241, 69, 15));
		add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(null);

		contrasenaUsuRec = new JPasswordField();
		contrasenaUsuRec.setForeground(Color.DARK_GRAY);
		((JPasswordField) contrasenaUsuRec).setEchoChar('*');
		contrasenaUsuRec.setBounds(116, 297, 207, 20);
		contrasenaUsuRec.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelCentral.add(contrasenaUsuRec);

		nombreUsuRec = new JTextField();
		nombreUsuRec.setForeground(Color.DARK_GRAY);
		nombreUsuRec.setBounds(116, 241, 207, 20);
		nombreUsuRec.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelCentral.add(nombreUsuRec);

		JLabel lblName = new JLabel("Nombre:");
		lblName.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		lblName.setForeground(new Color(241, 69, 15));
		lblName.setBounds(116, 196, 103, 35);
		panelCentral.add(lblName);

		JLabel lblPass = new JLabel("Contraseña:");
		lblPass.setForeground(new Color(241, 69, 15));
		lblPass.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		lblPass.setBounds(116, 263, 103, 35);
		panelCentral.add(lblPass);

		JLabel lblNewLabel = new javax.swing.JLabel("");
		lblNewLabel.setBounds(177, 50, 103, 96);

		ImageIcon imagen = new ImageIcon(
				"C:\\Users\\pablo\\Documents\\GitHub\\ProyectoBaloncesto\\Basket\\assets\\BasketUrban.png");
		Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(),
				Image.SCALE_DEFAULT));
		lblNewLabel.setIcon(icono);

		panelCentral.add(lblNewLabel);


		
		
		JPanel panel = new JPanel();
		panel.setBounds(89, 177, 277, 231);
		panelCentral.add(panel);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setBackground((Color) new Color(241, 69, 15));
		btnNewButton.setForeground(SystemColor.controlLtHighlight);
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 10));
		btnNewButton.setBounds(96, 168, 84, 32);
		btnNewButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel.add(btnNewButton);
		btnNewButton.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));


		JButton btnNewButton_1 = new JButton("¿No tienes cuenta? Regístrate Aquí!");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBounds(101, 555, 234, 35);
		panelCentral.add(btnNewButton_1);
		btnNewButton_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 13));
		btnNewButton_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setOpaque(true);
		btnNewButton_1.setBackground(new Color(0, 0, 0, 0));
		btnNewButton_1.setBorder(null);

		// -------------------------------- FIN COMPONENTES J
		// -------------------------------------

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

		// Funcion onClick REGISTRO
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.showRegistrar();
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
				nombreUsuRec.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(241, 69, 15)));
				contrasenaUsuRec.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(241, 69, 15)));
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