package interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

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
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import Exceptions.EmptyName;

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
		this.setSize(450, 650);



		// -------------------------------- COMPONENTES J
		// -------------------------------------
		Border roundedBorder = new LineBorder(new Color(210, 210, 210), 1, true);

		JPanel panelCentral = new JPanel();
		panelCentral.setBackground(new Color(241, 69, 15));
		add(panelCentral, BorderLayout.CENTER);
		
		panelCentral.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(78, 69, 303, 399);
		panelCentral.add(panel);
		panel.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(28, 50, 69, 25);
		lblNombre.setForeground(new Color(241, 69, 15));
		lblNombre.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 13));
		panel.add(lblNombre);
		

		txtNombre = new JTextField();
		txtNombre.setBounds(107, 54, 126, 19);
		panel.add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(28, 98, 83, 37);
		lblApellidos.setForeground(new Color(241, 69, 15));
		lblApellidos.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 13));
		panel.add(lblApellidos);

		txtApellidos = new JTextField();
		txtApellidos.setBounds(107, 108, 126, 19);
		panel.add(txtApellidos);
		txtApellidos.setColumns(10);

		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setBounds(28, 171, 69, 13);
		lblNickname.setForeground(new Color(241, 69, 15));
		lblNickname.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 13));
		panel.add(lblNickname);

		txtNickname = new JTextField();
		txtNickname.setBounds(107, 169, 126, 19);
		panel.add(txtNickname);
		txtNickname.setColumns(10);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(28, 228, 57, 13);
		lblEmail.setForeground(new Color(241, 69, 15));
		lblEmail.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 13));
		panel.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(107, 226, 126, 19);
		panel.add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblPassword = new JLabel("Contraseña");
		lblPassword.setBounds(28, 280, 69, 13);
		lblPassword.setForeground(new Color(241, 69, 15));
		lblPassword.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 13));
		panel.add(lblPassword);

		JPasswordField contrasenaUsuRec = new JPasswordField();
		contrasenaUsuRec.setBounds(107, 278, 132, 20);
		panel.add(contrasenaUsuRec);
		((JPasswordField) contrasenaUsuRec).setEchoChar('*');
		
				JButton btnRegistrar = new JButton("REGISTRAR");
				btnRegistrar.setBounds(28, 325, 85, 21);
				panel.add(btnRegistrar);
				btnRegistrar.setBorder(roundedBorder);
				
						JButton btnVolver = new JButton("VOLVER");
						btnVolver.setBounds(148, 325, 85, 21);
						panel.add(btnVolver);
						btnVolver.setBorder(roundedBorder);
						
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
								// En caso de que el usuario no exista en la BDD, procedemos a crearlo
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
