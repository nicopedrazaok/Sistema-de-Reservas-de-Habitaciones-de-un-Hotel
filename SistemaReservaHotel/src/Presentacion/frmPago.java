package Presentacion;

import Datos.Habitacion;
import Datos.Pago;
import Datos.Reserva;
import Logica.Conexion;
import Logica.GestorBDConsumo;
import Logica.GestorBDHabitacion;
import Logica.GestorBDPago;
import Logica.GestorBDReserva;
import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class frmPago extends javax.swing.JInternalFrame {

    public frmPago() {
        initComponents();
        mostrar(idReserva);
        inhabilitar();
        txtIdReserva.setText(idReserva);
        txtCliente.setText(cliente);
        txtHabitacion.setText(habitacion);
        txtIdHabitacion.setText(idHabitacion);
        txtTotalReserva.setText(Double.toString(totalReserva));

        GestorBDConsumo gestor = new GestorBDConsumo();
        gestor.mostrar(idReserva);

        txtTotalPago.setText(Double.toString(totalReserva + gestor.totalConsumo));
    }

    private String accion = "Guardar";
    public static String idReserva;
    public static String cliente;
    public static String idHabitacion;
    public static String habitacion;
    public static double totalReserva;

    private void ocultar_columnas() {
        tblListado.getColumnModel().getColumn(0).setMaxWidth(0);
        tblListado.getColumnModel().getColumn(0).setMinWidth(0);
        tblListado.getColumnModel().getColumn(0).setPreferredWidth(0);

        tblListado.getColumnModel().getColumn(1).setMaxWidth(0);
        tblListado.getColumnModel().getColumn(1).setMinWidth(0);
        tblListado.getColumnModel().getColumn(1).setPreferredWidth(0);

    }

    private void ocultar_columnas_Consumos() {
        tblListadoConsumos.getColumnModel().getColumn(0).setMaxWidth(0);
        tblListadoConsumos.getColumnModel().getColumn(0).setMinWidth(0);
        tblListadoConsumos.getColumnModel().getColumn(0).setPreferredWidth(0);

        tblListadoConsumos.getColumnModel().getColumn(1).setMaxWidth(0);
        tblListadoConsumos.getColumnModel().getColumn(1).setMinWidth(0);
        tblListadoConsumos.getColumnModel().getColumn(1).setPreferredWidth(0);

        tblListadoConsumos.getColumnModel().getColumn(2).setMaxWidth(0);
        tblListadoConsumos.getColumnModel().getColumn(2).setMinWidth(0);
        tblListadoConsumos.getColumnModel().getColumn(2).setPreferredWidth(0);

    }

    private void inhabilitar() {
        txtIdPago.setVisible(false);
        txtIdReserva.setVisible(false);
        txtCliente.setEnabled(false);
        cboTipoComprobante.setEnabled(false);
        txtNumeroComprobante.setEnabled(false);
        txtIva.setEnabled(false);
        txtTotalPago.setEnabled(false);
        txtTotalReserva.setEnabled(false);
        dtcFechaEmision.setEnabled(false);
        dtcFechaPago.setEnabled(false);
        txtIdHabitacion.setVisible(false);
        txtHabitacion.setEnabled(false);

        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnEliminar.setEnabled(false);

        txtIdPago.setText("");
        txtNumeroComprobante.setText("");
        txtIva.setText("");

    }

    private void habilitar() {
        txtIdPago.setVisible(false);
        txtIdReserva.setVisible(false);
        txtCliente.setEnabled(true);
        cboTipoComprobante.setEnabled(true);
        txtNumeroComprobante.setEnabled(true);
        txtIva.setEnabled(true);
        txtTotalPago.setEnabled(true);
        txtTotalReserva.setEnabled(true);
        dtcFechaEmision.setEnabled(true);
        dtcFechaPago.setEnabled(true);
        txtIdHabitacion.setVisible(false);
        txtHabitacion.setEnabled(true);

        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnEliminar.setEnabled(true);

        txtIdPago.setText("");
        txtNumeroComprobante.setText("");
        txtIva.setText("");

    }

    private void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;
            GestorBDPago gestor = new GestorBDPago();
            modelo = gestor.mostrar(buscar);
            tblListado.setModel(modelo);
            ocultar_columnas();
            lblTotalRegistros.setText("Total de Registros: " + Integer.toString(gestor.totalRegistros));

            GestorBDConsumo gestorConsumo = new GestorBDConsumo();
            modelo = gestorConsumo.mostrar(buscar);
            ocultar_columnas_Consumos();
            tblListadoConsumos.setModel(modelo);
            lblTotalRegistrosConsumos.setText("Total Consumos: " + gestorConsumo.totalRegistros);
            lblTotalConsumos.setText("Consumo Total $. : " + gestorConsumo.totalConsumo);
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblListado = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        lblTotalRegistros = new javax.swing.JLabel();
        btnImprimir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtIdPago = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtIdReserva = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtNumeroComprobante = new javax.swing.JTextField();
        cboTipoComprobante = new javax.swing.JComboBox<>();
        txtCliente = new javax.swing.JTextField();
        txtTotalReserva = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtIdHabitacion = new javax.swing.JTextField();
        txtHabitacion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtIva = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTotalPago = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        dtcFechaEmision = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        dtcFechaPago = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblListadoConsumos = new javax.swing.JTable();
        lblTotalRegistrosConsumos = new javax.swing.JLabel();
        lblTotalConsumos = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de Pagos"));

        tblListado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblListado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListadoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblListado);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        lblTotalRegistros.setText("Registros: ");

        btnImprimir.setText("Imprimir Reporte");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblTotalRegistros)
                        .addGap(53, 53, 53))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnImprimir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnSalir)
                    .addComponent(btnImprimir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(lblTotalRegistros)
                .addGap(12, 12, 12))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Pago");

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Registro de Pagos"));

        jLabel2.setText("Reserva: ");

        txtIdReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdReservaActionPerformed(evt);
            }
        });

        jLabel4.setText("Total Reserva: ");

        jLabel6.setText("Tipo de Comprobante: ");

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel3.setText("Numero de Comprobante: ");

        txtNumeroComprobante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroComprobanteActionPerformed(evt);
            }
        });

        cboTipoComprobante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Factura", "Boleta", "Ticket", "Otro..." }));

        txtCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClienteActionPerformed(evt);
            }
        });

        jLabel5.setText("Habitacion: ");

        jLabel7.setText("IVA: ");

        jLabel8.setText("Total de Pago:");

        jLabel10.setText("Fecha de Emsion:");

        jLabel11.setText("Fecha de Pago:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(txtIdPago, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(btnNuevo)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtIdReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCliente))
                                    .addComponent(txtTotalPago)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtTotalReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txtIdHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(txtNumeroComprobante, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(cboTipoComprobante, javax.swing.GroupLayout.Alignment.LEADING, 0, 159, Short.MAX_VALUE))
                                            .addComponent(txtIva, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(dtcFechaEmision, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(52, 52, 52)
                                        .addComponent(btnGuardar)
                                        .addGap(61, 61, 61)
                                        .addComponent(btnCancelar))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dtcFechaPago, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(122, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtIdPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtIdReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtTotalReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtIdHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(cboTipoComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtNumeroComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(txtIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(txtTotalPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10))
                            .addComponent(dtcFechaEmision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11))
                    .addComponent(dtcFechaPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(51, 153, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de Consumos"));

        tblListadoConsumos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblListadoConsumos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListadoConsumosMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblListadoConsumos);

        lblTotalRegistrosConsumos.setText("Registros: ");

        lblTotalConsumos.setText("Total de Consumos: ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTotalConsumos)
                .addGap(45, 45, 45)
                .addComponent(lblTotalRegistrosConsumos)
                .addGap(53, 53, 53))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalRegistrosConsumos)
                    .addComponent(lblTotalConsumos))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(28, 28, 28))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(23, 23, 23))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(22, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblListadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListadoMouseClicked
        btnGuardar.setText("Editar");
        habilitar();
        btnEliminar.setEnabled(true);
        accion = "editar";

        int fila = tblListado.rowAtPoint(evt.getPoint());

        txtIdPago.setText(tblListado.getValueAt(fila, 0).toString());
        //txtIdReserva.setText(tblListado.getValueAt(fila,1).toString());
        cboTipoComprobante.setSelectedItem(tblListado.getValueAt(fila, 2).toString());
        txtNumeroComprobante.setText(tblListado.getValueAt(fila, 3).toString());
        txtIva.setText(tblListado.getValueAt(fila, 4).toString());
        txtTotalPago.setText(tblListado.getValueAt(fila, 5).toString());
        dtcFechaEmision.setDate(Date.valueOf(tblListado.getValueAt(fila, 6).toString()));
        dtcFechaPago.setDate(Date.valueOf(tblListado.getValueAt(fila, 7).toString()));
    }//GEN-LAST:event_tblListadoMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (!txtIdPago.getText().equals("")) {
            int confirmar = JOptionPane.showConfirmDialog(rootPane, "Estas seguro de eliminar?", "Confirmar", 2);
            if (confirmar == 0) {
                GestorBDPago gestor = new GestorBDPago();
                Pago pago = new Pago();
                pago.setIdPago(Integer.parseInt(txtIdPago.getText()));
                gestor.eliminar(pago);
                mostrar("");
                inhabilitar();
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtIdReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdReservaActionPerformed
        txtIdReserva.transferFocus();
    }//GEN-LAST:event_txtIdReservaActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        habilitar();
        btnGuardar.setText("Guardar");
        accion = "guardar";
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (txtIva.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el iva del comprobante");
            txtIva.requestFocus();
            return;
        }
        if (txtTotalPago.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar total de Pago");
            txtTotalPago.requestFocus();
            return;
        }
        if (txtNumeroComprobante.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el Numero de comprobante de pago");
            txtNumeroComprobante.requestFocus();
            return;
        }

        Pago pago = new Pago();
        GestorBDPago gestor = new GestorBDPago();
        pago.setIdReserva(Integer.parseInt(txtIdReserva.getText()));
        int tipComprobante = cboTipoComprobante.getSelectedIndex();
        pago.setTipoComprobante(cboTipoComprobante.getItemAt(tipComprobante));
        pago.setNumComprobante(txtNumeroComprobante.getText());
        pago.setIva(Double.parseDouble(txtIva.getText()));
        pago.setTotalPago(Double.parseDouble(txtTotalPago.getText()));

        Calendar calendario;
        int dia, mes, año;
        calendario = dtcFechaPago.getCalendar();
        dia = calendario.get(Calendar.DAY_OF_MONTH);
        mes = calendario.get(Calendar.MONTH);
        año = calendario.get(Calendar.YEAR);
        pago.setFechaPago(new Date(año, mes, dia));

        calendario = dtcFechaEmision.getCalendar();
        dia = calendario.get(Calendar.DAY_OF_MONTH);
        mes = calendario.get(Calendar.MONTH);
        año = calendario.get(Calendar.YEAR);
        pago.setFechaEmicion(new Date(año, mes, dia));

        if (accion.equals("guardar")) {
            if (gestor.insertar(pago)) {
                JOptionPane.showMessageDialog(rootPane, "El pago por $.: " + txtTotalPago.getText() + "del Sr./Sra." + txtCliente.getText() + " Ha sido realizado con exitos");
                mostrar(idReserva);
                inhabilitar();

                GestorBDHabitacion gestorHabitacion = new GestorBDHabitacion();
                Habitacion habitacion = new Habitacion();

                habitacion.setIdHabitacion(Integer.parseInt(txtIdHabitacion.getText()));
                gestorHabitacion.desocupar(habitacion);

                GestorBDReserva gestorReserva = new GestorBDReserva();
                Reserva reserva = new Reserva();

                reserva.setIdReserva(Integer.parseInt(txtIdReserva.getText()));
                gestorReserva.pagar(reserva);
            }
        } else if (accion.equals("editar")) {
            pago.setIdPago(Integer.parseInt(txtIdPago.getText()));
            if (gestor.editar(pago)) {
                JOptionPane.showMessageDialog(rootPane, "El pago del Sr./Sra. " + txtCliente.getText() + " Ha sido modificado correctamente");
                mostrar(idReserva);
                inhabilitar();
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtNumeroComprobanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroComprobanteActionPerformed
        txtNumeroComprobante.transferFocus();
    }//GEN-LAST:event_txtNumeroComprobanteActionPerformed

    private void txtClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClienteActionPerformed

    private void tblListadoConsumosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListadoConsumosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblListadoConsumosMouseClicked
    private Connection connection = new Conexion().Conectar();

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        if (!txtIdPago.getText().equals("")) {
            Map p = new HashMap();
            p.put("idPago", txtIdPago.getText());
            JasperReport report;
            JasperPrint print;
            try {
                report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                        + "/src/Reportes/rptComprobante.jrxml");
                print = JasperFillManager.fillReport(report, p, connection);
                JasperViewer view = new JasperViewer(print, false);
                view.setTitle("Comprobante de pago");
                view.setVisible(true);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnImprimirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPago().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cboTipoComprobante;
    private com.toedter.calendar.JDateChooser dtcFechaEmision;
    private com.toedter.calendar.JDateChooser dtcFechaPago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblTotalConsumos;
    private javax.swing.JLabel lblTotalRegistros;
    private javax.swing.JLabel lblTotalRegistrosConsumos;
    private javax.swing.JTable tblListado;
    private javax.swing.JTable tblListadoConsumos;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtHabitacion;
    private javax.swing.JTextField txtIdHabitacion;
    private javax.swing.JTextField txtIdPago;
    private javax.swing.JTextField txtIdReserva;
    private javax.swing.JTextField txtIva;
    private javax.swing.JTextField txtNumeroComprobante;
    private javax.swing.JTextField txtTotalPago;
    private javax.swing.JTextField txtTotalReserva;
    // End of variables declaration//GEN-END:variables
}
