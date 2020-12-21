package Logica;

import Datos.Trabajador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GestorBDTrabajador {

    Conexion conexionSQL = new Conexion();
    Connection conn = conexionSQL.Conectar();
    private String consultaSQL = "";
    private String consultaSQL2 = "";
    public Integer totalRegistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;
        String[] titulos = {"ID", "Nombre", "Apellido Paterno", "Apellido Materno", "Tipo de Documento", "Numero de Documento", "Direccion", "Telefono", "Email", "Sueldo", "Acceso", "Login", "Password", "Estado"};
        String[] registro = new String[14];

        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        consultaSQL = "SELECT p.idPersona,p.nombre,p.apellidoPaterno,p.apellidoMaterno,p.tipoDocumento,p.numDocumento,p.direccion,p.telefono,p.email,t.sueldo,t.acceso,t.login,t.password,t.estado FROM Persona p JOIN Trabajador t ON p.idPersona = t.idPersona WHERE p.numDocumento LIKE '%" + buscar + "%' ORDER BY p.idPersona";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(consultaSQL);
            while (rs.next()) {
                registro[0] = rs.getString("idPersona");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("apellidoPaterno");
                registro[3] = rs.getString("apellidoMaterno");
                registro[4] = rs.getString("tipoDocumento");
                registro[5] = rs.getString("numDocumento");
                registro[6] = rs.getString("direccion");
                registro[7] = rs.getString("telefono");
                registro[8] = rs.getString("email");
                registro[9] = rs.getString("sueldo");
                registro[10] = rs.getString("acceso");
                registro[11] = rs.getString("login");
                registro[12] = rs.getString("password");
                registro[13] = rs.getString("estado");

                totalRegistros = totalRegistros + 1;
                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public boolean insertar(Trabajador trabajador) {
        consultaSQL = "INSERT INTO Persona (nombre,apellidoPaterno,apellidoMaterno,tipoDocumento,numDocumento,direccion,telefono,email) VALUES (?,?,?,?,?,?,?,?)";
        consultaSQL2 = "INSERT INTO Trabajador (idPersona,sueldo,acceso,login,password,estado) VALUES ((SELECT TOP 1 idPersona FROM Persona ORDER BY idPersona desc), ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pst = conn.prepareStatement(consultaSQL);
            PreparedStatement pst2 = conn.prepareStatement(consultaSQL2);
            pst.setString(1, trabajador.getNombre());
            pst.setString(2, trabajador.getApellidoPaterno());
            pst.setString(3, trabajador.getApellidoMaterno());
            pst.setString(4, trabajador.getTipoDocumento());
            pst.setString(5, trabajador.getNumDocumento());
            pst.setString(6, trabajador.getDireccion());
            pst.setString(7, trabajador.getTelefono());
            pst.setString(8, trabajador.getEmail());

            pst2.setDouble(1, trabajador.getSueldo());
            pst2.setString(2, trabajador.getAcceso());
            pst2.setString(3, trabajador.getLogin());
            pst2.setString(4, trabajador.getPassword());
            pst2.setString(5, trabajador.getEstado());

            int inserto = pst.executeUpdate();
            if (inserto != 0) {
                int inserto2 = pst2.executeUpdate();
                if (inserto2 != 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean editar(Trabajador trabajador) {
        consultaSQL = "UPDATE Persona SET nombre = ?,apellidoPaterno = ?, apellidoMaterno = ?,tipoDocumento = ?,numDocumento = ?,direccion = ?, telefono = ?,email = ? WHERE idPersona = ?";
        consultaSQL2 = "UPDATE Trabajador SET sueldo = ?, acceso = ?, login = ?, password = ?, estado = ? WHERE idPersona = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(consultaSQL);
            PreparedStatement pst2 = conn.prepareStatement(consultaSQL2);
            pst.setString(1, trabajador.getNombre());
            pst.setString(2, trabajador.getApellidoPaterno());
            pst.setString(3, trabajador.getApellidoMaterno());
            pst.setString(4, trabajador.getTipoDocumento());
            pst.setString(5, trabajador.getNumDocumento());
            pst.setString(6, trabajador.getDireccion());
            pst.setString(7, trabajador.getTelefono());
            pst.setString(8, trabajador.getEmail());
            pst.setInt(9, trabajador.getIdPersona());

            pst2.setDouble(1, trabajador.getSueldo());
            pst2.setString(2, trabajador.getAcceso());
            pst2.setString(3, trabajador.getLogin());
            pst2.setString(4, trabajador.getPassword());
            pst2.setString(5, trabajador.getEstado());
            pst2.setInt(6, trabajador.getIdPersona());

            int modifico = pst.executeUpdate();
            if (modifico != 0) {
                int modifico2 = pst2.executeUpdate();
                if (modifico2 != 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean eliminar(Trabajador trabajador) {

        consultaSQL = "DELETE FROM Trabajador WHERE idPersona = ?";
        consultaSQL2 = "DELETE FROM Persona WHERE idPersona = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(consultaSQL);
            PreparedStatement pst2 = conn.prepareStatement(consultaSQL2);

            pst.setInt(1, trabajador.getIdPersona());

            pst2.setInt(1, trabajador.getIdPersona());

            int elimino = pst.executeUpdate();
            if (elimino != 0) {
                int elimino2 = pst2.executeUpdate();
                if (elimino2 != 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    public DefaultTableModel login(String login,String password) {
        DefaultTableModel modelo;
        String[] titulos = {"ID", "Nombre", "Apellido Paterno", "Apellido Materno", "Acceso", "Login", "Password", "Estado"};
        String[] registro = new String[8];

        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        consultaSQL = "SELECT p.idPersona,p.nombre,p.apellidoPaterno,p.apellidoMaterno,t.acceso,t.login,t.password,t.estado FROM Persona p JOIN Trabajador t ON p.idPersona = t.idPersona WHERE t.login LIKE '%" + login + "%' AND t.password LIKE '%" + password + "%' AND t.estado = 'A'";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(consultaSQL);
            while (rs.next()) {
                registro[0] = rs.getString("idPersona");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("apellidoPaterno");
                registro[3] = rs.getString("apellidoMaterno");
                registro[4] = rs.getString("acceso");
                registro[5] = rs.getString("login");
                registro[6] = rs.getString("password");
                registro[7] = rs.getString("estado");

                totalRegistros = totalRegistros + 1;
                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
}
