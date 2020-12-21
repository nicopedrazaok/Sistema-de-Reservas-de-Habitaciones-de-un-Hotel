package Logica;

import Datos.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GestorBDCliente {

    Conexion conexionSQL = new Conexion();
    Connection conn = conexionSQL.Conectar();
    private String consultaSQL = "";
    private String consultaSQL2 = "";
    public Integer totalRegistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;
        String[] titulos = {"ID", "Nombre", "Apellido Paterno", "Apellido Materno", "Tipo de Documento", "Numero de Documento", "Direccion", "Telefono", "Email", "Codigo de Cliente"};
        String[] registro = new String[10];

        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        consultaSQL = "SELECT p.idPersona,p.nombre,p.apellidoPaterno,p.apellidoMaterno,p.tipoDocumento,p.numDocumento,p.direccion,p.telefono,p.email,c.codigoCliente FROM Persona p JOIN Cliente c ON p.idPersona = c.idPersona WHERE p.numDocumento LIKE '%" + buscar + "%' ORDER BY p.idPersona";
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
                registro[9] = rs.getString("codigoCliente");

                totalRegistros = totalRegistros + 1;
                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public boolean insertar(Cliente cliente) {
        consultaSQL = "INSERT INTO Persona (nombre,apellidoPaterno,apellidoMaterno,tipoDocumento,numDocumento,direccion,telefono,email) VALUES (?,?,?,?,?,?,?,?)";
        consultaSQL2 = "INSERT INTO Cliente (idPersona,codigoCliente) VALUES ((SELECT TOP 1 idPersona FROM Persona ORDER BY idPersona desc), ?)";
        try {
            PreparedStatement pst = conn.prepareStatement(consultaSQL);
            PreparedStatement pst2 = conn.prepareStatement(consultaSQL2);
            pst.setString(1, cliente.getNombre());
            pst.setString(2, cliente.getApellidoPaterno());
            pst.setString(3, cliente.getApellidoMaterno());
            pst.setString(4, cliente.getTipoDocumento());
            pst.setString(5, cliente.getNumDocumento());
            pst.setString(6, cliente.getDireccion());
            pst.setString(7, cliente.getTelefono());
            pst.setString(8, cliente.getEmail());

            pst2.setString(1, cliente.getCodigoCliente());

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

    public boolean editar(Cliente cliente) {
        consultaSQL = "UPDATE Persona SET nombre = ?,apellidoPaterno = ?, apellidoMaterno = ?,tipoDocumento = ?,numDocumento = ?,direccion = ?, telefono = ?,email = ? WHERE idPersona = ?";
        consultaSQL2 = "UPDATE Cliente SET codigoCliente = ? WHERE idPersona = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(consultaSQL);
            PreparedStatement pst2 = conn.prepareStatement(consultaSQL2);
            pst.setString(1, cliente.getNombre());
            pst.setString(2, cliente.getApellidoPaterno());
            pst.setString(3, cliente.getApellidoMaterno());
            pst.setString(4, cliente.getTipoDocumento());
            pst.setString(5, cliente.getNumDocumento());
            pst.setString(6, cliente.getDireccion());
            pst.setString(7, cliente.getTelefono());
            pst.setString(8, cliente.getEmail());
            pst.setInt(9, cliente.getIdPersona());

            pst2.setString(1, cliente.getCodigoCliente());
            pst2.setInt(2, cliente.getIdPersona());

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

    public boolean eliminar(Cliente cliente) {

        consultaSQL = "DELETE FROM Cliente WHERE idPersona = ?";
        consultaSQL2 = "DELETE FROM Persona WHERE idPersona = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(consultaSQL);
            PreparedStatement pst2 = conn.prepareStatement(consultaSQL2);

            pst.setInt(1, cliente.getIdPersona());

            pst2.setInt(1, cliente.getIdPersona());

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
}
