package Logica;

import Datos.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GestorBDProducto {
    Conexion conexionSQL = new Conexion();
    Connection conn = conexionSQL.Conectar();
    private String consultaSQL = "";
    public Integer totalRegistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;
        String[] titulos = {"ID", "Nombre","Descripcion", "Unidad de Medida", "Percio de Venta"};
        String[] registro = new String[5];

        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        consultaSQL = "SELECT * FROM Producto WHERE nombre LIKE '%" + buscar + "%' ORDER BY idProducto";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(consultaSQL);
            while (rs.next()) {
                registro[0] = rs.getString("idProducto");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("descripcion");
                registro[3] = rs.getString("unidadMedida");
                registro[4] = rs.getString("precioVenta");

                totalRegistros = totalRegistros + 1;
                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public boolean insertar(Producto producto) {
        consultaSQL = "INSERT INTO Producto (nombre,descripcion,unidadMedida,precioVenta) VALUES (?,?,?,?)";
        try {
            PreparedStatement pst = conn.prepareStatement(consultaSQL);
            pst.setString(1, producto.getNombre());
            pst.setString(2, producto.getDescripcion());
            pst.setString(3, producto.getUnidadMedida());
            pst.setDouble(4, producto.getPrecioVenta());

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

    public boolean editar(Producto producto) {
        consultaSQL = "UPDATE Producto SET nombre = ?,descripcion = ?, unidadMedida = ?,precioVenta = ? WHERE idProducto = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(consultaSQL);
            pst.setString(1, producto.getNombre());
            pst.setString(2, producto.getDescripcion());
            pst.setString(3, producto.getUnidadMedida());
            pst.setDouble(4, producto.getPrecioVenta());
            pst.setInt(5, producto.getIdProducto());
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

    public boolean eliminar(Producto producto) {
        consultaSQL = "DELETE FROM Producto WHERE idProducto = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(consultaSQL);

            pst.setInt(1, producto.getIdProducto());
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
}
