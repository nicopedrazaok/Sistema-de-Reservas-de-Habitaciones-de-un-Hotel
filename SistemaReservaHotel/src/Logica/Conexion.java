package Logica;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexion {

    public String cadenaConexion = "jdbc:sqlserver://NICO\\SQLEXPRESS:1433;databaseName=DBReservaHotel";
    public String usuario = "sa";
    public String password = "nico123";

    public Conexion() {
    }
    
    public Connection Conectar(){
        Connection conexion = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conexion = DriverManager.getConnection(cadenaConexion,usuario,password);
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        return conexion;
    }
}
