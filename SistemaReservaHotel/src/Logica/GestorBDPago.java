
package Logica;

import Datos.Pago;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class GestorBDPago {
    Conexion conexionSQL = new Conexion();
    Connection conn = conexionSQL.Conectar();
    private String consultaSQL = "";
    public Integer totalRegistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;
        String[] titulos = {"ID", "idReserva","Comprobante", "Numero", "IVA","Total","Fecha de Emisión","Fecha de Pago"};
        String[] registro = new String[8];

        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        consultaSQL = "SELECT * FROM Pago WHERE idReserva = " + buscar + " ORDER BY idPago";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(consultaSQL);
            while (rs.next()) {
                registro[0] = rs.getString("idPago");
                registro[1] = rs.getString("idReserva");
                registro[2] = rs.getString("tipoComprobante");
                registro[3] = rs.getString("numComprobante");
                registro[4] = rs.getString("iva");
                registro[5] = rs.getString("totalPago");
                registro[6] = rs.getString("fechaEmision");
                registro[7] = rs.getString("fechaPago");

                totalRegistros = totalRegistros + 1;
                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public boolean insertar(Pago pago) {
        consultaSQL = "INSERT INTO Pago (idReserva,tipoComprobante,numComprobante,iva,totalPago,fechaEmision,fechaPago) VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = conn.prepareStatement(consultaSQL);
            pst.setInt(1, pago.getIdReserva());
            pst.setString(2, pago.getTipoComprobante());
            pst.setString(3, pago.getNumComprobante());
            pst.setDouble(4, pago.getIva());
            pst.setDouble(5, pago.getTotalPago());
            pst.setDate(6, pago.getFechaEmision());
            pst.setDate(7, pago.getFechaPago());

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

    public boolean editar(Pago pago) {
        consultaSQL = "UPDATE Pago SET idReserva = ?,tipoComprobante = ?, numComprobante = ?,iva = ?, totalPago = ?, fechaEmision = ?,fechaPago = ? WHERE idPago = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(consultaSQL);
            pst.setInt(1, pago.getIdReserva());
            pst.setString(2, pago.getTipoComprobante());
            pst.setString(3, pago.getNumComprobante());
            pst.setDouble(4, pago.getIva());
            pst.setDouble(5, pago.getTotalPago());
            pst.setDate(6, pago.getFechaEmision());
            pst.setDate(7, pago.getFechaPago());
            pst.setInt(8, pago.getIdPago());
            
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

    public boolean eliminar(Pago pago) {
        consultaSQL = "DELETE FROM Pago WHERE idPago = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(consultaSQL);

            pst.setInt(1, pago.getIdPago());
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
