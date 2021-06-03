package interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import Exceptions.EmptyNameException;
import Exceptions.RegExContraseñaException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class Registro extends JPanel {
	// Componentes
	private Ventana ventana;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtNickname;
	private JTextField txtEmail;
	private String contrasenaRec;

	public Registro(Ventana v) {
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

		JButton btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setBounds(244, 415, 85, 21);
		panelCentral.add(btnRegistrar);
		btnRegistrar.setBackground((Color) new Color(241, 69, 15));
		btnRegistrar.setForeground(SystemColor.controlLtHighlight);
		btnRegistrar.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 10));
		btnRegistrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		JButton btnVolver = new JButton("VOLVER");
		btnVolver.setBounds(124, 415, 85, 21);
		panelCentral.add(btnVolver);
		btnVolver.setBackground((Color) new Color(241, 69, 15));
		btnVolver.setForeground(SystemColor.controlLtHighlight);
		btnVolver.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 10));
		btnVolver.setCursor(new Cursor(Cursor.HAND_CURSOR));

		JPanel panel = new JPanel();
		panel.setBounds(73, 149, 303, 256);
		panelCentral.add(panel);
		panel.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(28, 36, 69, 25);
		lblNombre.setForeground(new Color(241, 69, 15));
		lblNombre.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 13));
		panel.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBounds(128, 40, 126, 19);
		panel.add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(28, 71, 83, 37);
		lblApellidos.setForeground(new Color(241, 69, 15));
		lblApellidos.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 13));
		panel.add(lblApellidos);

		txtApellidos = new JTextField();
		txtApellidos.setBounds(128, 81, 126, 19);
		panel.add(txtApellidos);
		txtApellidos.setColumns(10);

		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setBounds(28, 122, 69, 13);
		lblNickname.setForeground(new Color(241, 69, 15));
		lblNickname.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 13));
		panel.add(lblNickname);

		txtNickname = new JTextField();
		txtNickname.setBounds(128, 120, 126, 19);
		panel.add(txtNickname);
		txtNickname.setColumns(10);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(28, 159, 57, 13);
		lblEmail.setForeground(new Color(241, 69, 15));
		lblEmail.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 13));
		panel.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(128, 157, 126, 19);
		panel.add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblPassword = new JLabel("Contraseña");
		lblPassword.setBounds(28, 195, 69, 13);
		lblPassword.setForeground(new Color(241, 69, 15));
		lblPassword.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 13));
		panel.add(lblPassword);

		JPasswordField contrasenaUsuRec = new JPasswordField();
		contrasenaUsuRec.setBounds(128, 193, 126, 20);
		panel.add(contrasenaUsuRec);
		((JPasswordField) contrasenaUsuRec).setEchoChar('*');

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

		// Funcion onClick btnRegistrar - Registrar Usuario
		btnRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Instanciamos un usuario con los datos recogidos en el form
				Ventana.usu.setNombre(txtNombre.getText());
				Ventana.usu.setApellidos(txtApellidos.getText());
				Ventana.usu.setEmail(txtEmail.getText());
				contrasenaRec = new String(contrasenaUsuRec.getPassword());

				// Control de Excepciones para el Nickname y la Contraseña
				try {
					Ventana.usu.setNickname(txtNickname.getText());
					Ventana.usu.setContraseña(contrasenaRec);
					// En caso de que el usuario no exista en la BDD, procedemos a crearlo
					if (checkUser()) {
						if (createUser()) {
							JOptionPane.showMessageDialog(ventana, "Usuario creado de manera exitosa!", "Login fallido",
									JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(ventana,
								"El Nickname o el Email ya se encuentran registrados en la BDD. Intentalo de nuevo!",
								"Login fallido", JOptionPane.ERROR_MESSAGE);
					}
					// Captura de Excepcion de Contraseña
				} catch (RegExContraseñaException e1) {
					JOptionPane.showMessageDialog(ventana, e1.getMessage(), "Formato Contraseña Incorrecto",
							JOptionPane.ERROR_MESSAGE);
					// Captura de Excepcion de Nickname
				} catch (EmptyNameException e1) {
					JOptionPane.showMessageDialog(ventana, e1.getMessage(), "Nickname Vacio",
							JOptionPane.ERROR_MESSAGE);
					// Clausula Finally - Volvemos al Inicio y Limpiamos el Formulario
				} finally {
					ventana.showPantallaInicial();
					clearForm();
				}
			}

			// Función para limpiar los campos del formulario
			public void clearForm() {
				txtNombre.setText(" ");
				txtApellidos.setText(" ");
				txtEmail.setText(" ");
				txtNickname.setText(" ");
				contrasenaUsuRec.setText(" ");
			}
		});

		// Funcion onClick btnVolver - Retornamos a la PantallaInicial
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.showPantallaInicial();
			}
		});

	}

	// Funcion para comprobar que ni el email ni el nickname existan en la BDD
	public boolean checkUser() {
		try {
			Connection conexion = DriverManager.getConnection(
					"jdbc:mysql://localhost/basket?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", "root");

			Statement smt = conexion.createStatement();
			ResultSet resultados = smt.executeQuery("SELECT  nickname , email FROM usuario WHERE nickname='"
					+ Ventana.usu.getNickname() + "' AND email='" + Ventana.usu.getEmail() + "'");
			if (resultados.next()) {
				if (resultados.getString("nickname").equals(Ventana.usu.getNickname())
						|| resultados.getString("email").equals(Ventana.usu.getEmail())) {
					return false;
				}
			}
			smt.close();
			conexion.close();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(ventana, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		return true;
	}

	// Funcion para crear un usuario en la BDD
	public boolean createUser() {
		try {
			Connection conexion = DriverManager.getConnection(
					"jdbc:mysql://localhost/basket?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", "root");
			Statement smt = conexion.createStatement();
			smt.executeUpdate("INSERT INTO usuario VALUES ('" + Ventana.usu.getNombre() + "','"
					+ Ventana.usu.getApellidos() + "','" + Ventana.usu.getNickname() + "','" + Ventana.usu.getEmail()
					+ "','" + Ventana.usu.getContraseña() + "')");
			smt.close();
			conexion.close();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(ventana, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
}
