package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexion {

	Connection con = null;

	public Connection getConexion() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/basket?useTimezone=true&serverTimezone=UTC",
					"root", "root");
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
			JOptionPane.showMessageDialog(null,
					"Ha ocurrido un erro con la base de datos, por favor, comprueba tu conexion...");
		}
		return con;
	}
}