package Logica;

import Datos.Consumo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GestorBDConsumo {

    Conexion conexionSQL = new Conexion();
    Connection conn = conexionSQL.Conectar();
    private String consultaSQL = "";
    public double totalConsumo;
    public Integer totalRegistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;
        String[] titulos = {"ID", "idReserva", "idProducto", "Producto", "Cantidad", "Precio de venta", "Estado"};
        String[] registro = new String[7];

        totalRegistros = 0;
        totalConsumo = 0.0;

        modelo = new DefaultTableModel(null, titulos);
        consultaSQL = "SELECT c.idConsumo, c.idReserva,c.idProducto,p.nombre AS Producto,c.cantidad,c.precioVenta, c.estado FROM Consumo c JOIN Producto p ON c.idProducto = p.idProducto WHERE c.idReserva LIKE '%" + buscar + "%' ORDER BY c.idConsumo";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(consultaSQL);
            while (rs.next()) {
                registro[0] = rs.getString("idConsumo");
                registro[1] = rs.getString("idReserva");
                registro[2] = rs.getString("idProducto");
                registro[3] = rs.getString("Producto");
                registro[4] = rs.getString("cantidad");
                registro[5] = rs.getString("precioVenta");
                registro[6] = rs.getString("estado");

                totalRegistros = totalRegistros + 1;
                totalConsumo = totalConsumo + (rs.getDouble("cantidad") * rs.getDouble("precioVenta"));
                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public boolean insertar(Consumo consumo) {
        consultaSQL = "INSERT INTO Consumo (idReserva,idProducto,cantidad,precioVenta,estado) VALUES (?,?,?,?,?)";

        try {
            PreparedStatement pst = conn.prepareStatement(consultaSQL);
            pst.setInt(1, consumo.getIdReserva());
            pst.setInt(2, consumo.getIdProducto());
            pst.setDouble(3, consumo.getCantidad());
            pst.setDouble(4, consumo.getPrecioVenta());
            pst.setString(5, consumo.getEstado());

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

    public boolean editar(Consumo consumo) {
        consultaSQL = "UPDATE Consumo SET idReserva = ?,idProducto = ?, cantidad = ?,precioVenta = ?,estado = ? WHERE idConsumo = ?";

        try {
            PreparedStatement pst = conn.prepareStatement(consultaSQL);

            pst.setInt(1, consumo.getIdReserva());
            pst.setInt(2, consumo.getIdProducto());
            pst.setDouble(3, consumo.getCantidad());
            pst.setDouble(4, consumo.getPrecioVenta());
            pst.setString(5, consumo.getEstado());
            pst.setInt(6, consumo.getIdConsumo());

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

    public boolean eliminar(Consumo consumo) {

        consultaSQL = "DELETE FROM Consumo WHERE idConsumo = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(consultaSQL);

            pst.setInt(1, consumo.getIdConsumo());

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
