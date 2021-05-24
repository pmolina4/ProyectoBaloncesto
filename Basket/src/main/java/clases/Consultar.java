package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Consultar extends Conexion {

    public boolean consulta(String consultaSql) throws SQLException {
        PreparedStatement stmt = null;
        Connection con = getConexion();

        try {
            stmt = con.prepareStatement(consultaSql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
          
            }
            rs.close();
            stmt.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}

