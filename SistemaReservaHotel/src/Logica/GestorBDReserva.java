package Logica;

import Datos.Reserva;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GestorBDReserva {

    Conexion conexionSQL = new Conexion();
    Connection conn = conexionSQL.Conectar();
    private String consultaSQL = "";
    public Integer totalRegistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;
        String[] titulos = {"ID", "idHabitacion", "Numero de Habitacion", "idCliente", "Cliente", "idTrabajador", "Trabajador", "Tipo de Reserva", "Fecha de reserva", "Fecha de Ingreso", "Fecha de Salida", "Costo de Alojamiento", "Estado"};
        String[] registro = new String[13];

        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        consultaSQL = "SELECT r.idReserva,r.idHabitacion,h.numero,r.idCliente,(SELECT nombre FROM Persona WHERE idPersona = r.idCliente) AS NombreCliente,"
                + "(SELECT apellidoPaterno FROM Persona WHERE idPersona = r.idCliente) 'Apellido del cliente',r.idTrabajador,(SELECT nombre FROM Persona WHERE idPersona = r.idTrabajador) 'Nombre del Trabajador',\n"
                + "(SELECT apellidoPaterno FROM Persona WHERE idPersona = r.idTrabajador) 'Apellido del Trabajador',r.tipoReserva,r.fechaReserva,r.fechaIngreso,r.fechaSalida, r.costoAlojamiento, r.estado \n"
                + "FROM Reserva r JOIN Habitacion h ON r.idHabitacion = h.idHabitacion WHERE fechaReserva LIKE '%" + buscar + "%' ORDER BY idReserva";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(consultaSQL);
            while (rs.next()) {
                registro[0] = rs.getString("idReserva");
                registro[1] = rs.getString("idHabitacion");
                registro[2] = rs.getString("numero");
                registro[3] = rs.getString("idCliente");
                registro[4] = rs.getString("NombreCliente")  + " " + rs.getString("Apellido del cliente");
                registro[5] = rs.getString("idTrabajador");
                registro[6] = rs.getString("Nombre del Trabajador") + ", " + rs.getString("Apellido del Trabajador");
                registro[7] = rs.getString("tipoReserva");
                registro[8] = rs.getString("fechaReserva");
                registro[9] = rs.getString("fechaIngreso");
                registro[10] = rs.getString("fechaSalida");
                registro[11] = rs.getString("costoAlojamiento");
                registro[12] = rs.getString("estado");

                totalRegistros = totalRegistros + 1;
                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public boolean insertar(Reserva reserva) {
        consultaSQL = "INSERT INTO Reserva (idHabitacion,idCliente,idTrabajador,tipoReserva,fechaReserva,fechaIngreso,fechaSalida,costoAlojamiento,estado) VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = conn.prepareStatement(consultaSQL);
            pst.setInt(1, reserva.getIdHabitacion());
            pst.setInt(2, reserva.getIdCliente());
            pst.setInt(3, reserva.getIdTrabajador());
            pst.setString(4, reserva.getTipoReserva());
            pst.setDate(5, reserva.getFechaReserva());
            pst.setDate(6, reserva.getFechaIngreso());
            pst.setDate(7, reserva.getFechaSalida());
            pst.setDouble(8, reserva.getCostoAlojamiento());
            pst.setString(9, reserva.getEstado());

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

    public boolean editar(Reserva reserva) {
        consultaSQL = "UPDATE Reserva SET idHabitacion = ?,idCliente = ?, idTrabajador = ?,tipoReserva = ?, fechaReserva = ?,fechaIngreso = ?, fechaSalida = ?,costoAlojamiento = ?,estado = ? WHERE idReserva = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(consultaSQL);
            pst.setInt(1, reserva.getIdHabitacion());
            pst.setInt(2, reserva.getIdCliente());
            pst.setInt(3, reserva.getIdTrabajador());
            pst.setString(4, reserva.getTipoReserva());
            pst.setDate(5, reserva.getFechaReserva());
            pst.setDate(6, reserva.getFechaIngreso());
            pst.setDate(7, reserva.getFechaSalida());
            pst.setDouble(8, reserva.getCostoAlojamiento());
            pst.setString(9, reserva.getEstado());
            pst.setInt(10, reserva.getIdReserva());

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

    public boolean eliminar(Reserva reserva) {
        consultaSQL = "DELETE FROM Reserva WHERE idReserva = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(consultaSQL);

            pst.setInt(1, reserva.getIdReserva());
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
    public boolean pagar (Reserva reserva) {
        consultaSQL = "UPDATE Reserva SET estado = 'Pagada' WHERE idReserva = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(consultaSQL);

            pst.setInt(1, reserva.getIdReserva());

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
