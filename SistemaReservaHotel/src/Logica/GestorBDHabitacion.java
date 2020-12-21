package Logica;

import Datos.Habitacion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GestorBDHabitacion {

    Conexion conexionSQL = new Conexion();
    Connection conn = conexionSQL.Conectar();
    private String consultaSQL = "";
    public Integer totalRegistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;
        String[] titulos = {"ID", "Numero", "Piso", "Descripcion", "Carateristicas", "Percio Diario", "Estado", "Tipo de Habitacion"};
        String[] registro = new String[8];

        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        consultaSQL = "SELECT * FROM Habitacion WHERE piso LIKE '%" + buscar + "%' ORDER BY idHabitacion";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(consultaSQL);
            while (rs.next()) {
                registro[0] = rs.getString("idHabitacion");
                registro[1] = rs.getString("numero");
                registro[2] = rs.getString("piso");
                registro[3] = rs.getString("descripcion");
                registro[4] = rs.getString("carateristica");
                registro[5] = rs.getString("precioDiario");
                registro[6] = rs.getString("estado");
                registro[7] = rs.getString("tipoHabitacion");

                totalRegistros = totalRegistros + 1;
                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public boolean insertar(Habitacion habitacion) {
        consultaSQL = "INSERT INTO Habitacion (numero,piso,descripcion,carateristica,precioDiario,estado,tipoHabitacion) VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = conn.prepareStatement(consultaSQL);
            pst.setString(1, habitacion.getNumero());
            pst.setString(2, habitacion.getPiso());
            pst.setString(3, habitacion.getDescripcion());
            pst.setString(4, habitacion.getCarateristica());
            pst.setDouble(5, habitacion.getPrecioDiario());
            pst.setString(6, habitacion.getEstado());
            pst.setString(7, habitacion.getTipoHabitacion());

            int inserto = pst.executeUpdate();
            if (inserto != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean editar(Habitacion habitacion) {
        consultaSQL = "UPDATE Habitacion SET numero = ?,piso = ?, descripcion = ?,carateristica = ?,precioDiario = ?,estado = ?, tipoHabitacion = ? WHERE idHabitacion = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(consultaSQL);
            pst.setString(1, habitacion.getNumero());
            pst.setString(2, habitacion.getPiso());
            pst.setString(3, habitacion.getDescripcion());
            pst.setString(4, habitacion.getCarateristica());
            pst.setDouble(5, habitacion.getPrecioDiario());
            pst.setString(6, habitacion.getEstado());
            pst.setString(7, habitacion.getTipoHabitacion());
            pst.setInt(8, habitacion.getIdHabitacion());
            int modifico = pst.executeUpdate();
            if (modifico != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean eliminar(Habitacion habitacion) {
        consultaSQL = "DELETE FROM Habitacion WHERE idHabitacion = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(consultaSQL);

            pst.setInt(1, habitacion.getIdHabitacion());
            int elimino = pst.executeUpdate();
            if (elimino != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    public DefaultTableModel mostrarVista(String buscar) {
        DefaultTableModel modelo;
        String[] titulos = {"ID", "Numero", "Piso", "Descripcion", "Carateristicas", "Percio Diario", "Estado", "Tipo de Habitacion"};
        String[] registro = new String[8];

        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        consultaSQL = "SELECT * FROM Habitacion WHERE piso LIKE '%" + buscar + "%' AND estado = 'Disponible' ORDER BY idHabitacion";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(consultaSQL);
            while (rs.next()) {
                registro[0] = rs.getString("idHabitacion");
                registro[1] = rs.getString("numero");
                registro[2] = rs.getString("piso");
                registro[3] = rs.getString("descripcion");
                registro[4] = rs.getString("carateristica");
                registro[5] = rs.getString("precioDiario");
                registro[6] = rs.getString("estado");
                registro[7] = rs.getString("tipoHabitacion");

                totalRegistros = totalRegistros + 1;
                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
     public boolean desocupar(Habitacion habitacion) {
        consultaSQL = "UPDATE Habitacion SET estado = 'Disponible' WHERE idHabitacion = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(consultaSQL);
          
            pst.setInt(1, habitacion.getIdHabitacion());
            
            int modifico = pst.executeUpdate();
            if (modifico != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
      public boolean ocupar (Habitacion habitacion) {
        consultaSQL = "UPDATE Habitacion SET estado = 'Ocupado' WHERE idHabitacion = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(consultaSQL);
          
            pst.setInt(1, habitacion.getIdHabitacion());
            
            int modifico = pst.executeUpdate();
            if (modifico != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
}
