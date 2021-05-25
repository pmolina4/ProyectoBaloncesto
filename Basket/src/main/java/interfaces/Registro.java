package interfaces;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
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

	// Variables Aux
	String nombre;
	String apellidos;
	String email;
	String nickname;
	String pass;

	public Registro(Ventana v) {
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

		JButton btnVolver = new JButton("VOLVER");

		btnVolver.setBounds(277, 373, 85, 21);
		panelCentral.add(btnVolver);

		JButton btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setBounds(111, 373, 85, 21);
		panelCentral.add(btnRegistrar);

		txtNombre = new JTextField();
		txtNombre.setBounds(182, 74, 96, 19);
		panelCentral.add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(201, 51, 45, 13);
		panelCentral.add(lblNombre);

		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(201, 103, 45, 13);
		panelCentral.add(lblApellidos);

		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(182, 126, 96, 19);
		panelCentral.add(txtApellidos);

		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setBounds(201, 168, 45, 13);
		panelCentral.add(lblNickname);

		txtNickname = new JTextField();
		txtNickname.setColumns(10);
		txtNickname.setBounds(182, 193, 96, 19);
		panelCentral.add(txtNickname);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(201, 229, 45, 13);
		panelCentral.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(182, 254, 96, 19);
		panelCentral.add(txtEmail);

		JLabel lblPassword = new JLabel("Contraseña");
		lblPassword.setBounds(201, 293, 45, 13);
		panelCentral.add(lblPassword);

		JPasswordField contrasenaUsuRec = new JPasswordField();
		((JPasswordField) contrasenaUsuRec).setEchoChar('*');
		contrasenaUsuRec.setBounds(160, 316, 132, 20);
		panelCentral.add(contrasenaUsuRec);

		// -------------------------------- FIN COMPONENTES J
		// -------------------------------------

		// Funcion onClick btnVolver - Retornamos a la PantallaInicial
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.showPantallaInicial();
			}
		});

		// Funcion onClick btnRegistrar - Registrar Usuario
		btnRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nombre = txtNombre.getText();
				apellidos = txtApellidos.getText();
				email = txtEmail.getText();
				nickname = txtNickname.getText();
				pass = new String(contrasenaUsuRec.getPassword());
				clearForm();
				//En caso de que el usuario no exista en la BDD, procedemos a crearlo
				if (checkUser()) {
					if (createUser()) {
						JOptionPane.showMessageDialog(ventana, "Usuario creado de manera exitosa!", "Login fallido",
								JOptionPane.ERROR_MESSAGE);
						ventana.showPantallaInicial();
					}
				} else {
					JOptionPane.showMessageDialog(ventana,
							"El Nickname o el Email ya se encuentran registrados en la BDD. Intentalo de nuevo!",
							"Login fallido", JOptionPane.ERROR_MESSAGE);
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
	}

	// Funcion para comprobar que ni el email ni el nickname existan en la BDD
	public boolean checkUser() {
		try {
			Connection conexion = DriverManager.getConnection(
					"jdbc:mysql://localhost/basket?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", "root");
			Statement smt = conexion.createStatement();
			ResultSet resultados = smt.executeQuery("SELECT  nickname , email FROM usuario WHERE nickname='"
					+ this.nickname + "' AND email='" + this.email + "'");
			if (resultados.next()) {
				if (resultados.getString("nickname").equals(this.nickname)
						|| resultados.getString("email").equals(this.email)) {
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
			smt.executeUpdate("INSERT INTO usuario VALUES ('" + this.nombre + "','" + this.apellidos + "','"
					+ this.nickname + "','" + this.email + "','" + this.pass + "')");
			smt.close();
			conexion.close();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(ventana, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;

	}

}
