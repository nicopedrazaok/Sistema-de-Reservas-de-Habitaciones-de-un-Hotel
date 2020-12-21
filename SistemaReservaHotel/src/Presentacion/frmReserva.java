package Presentacion;

import Datos.Habitacion;
import Datos.Reserva;
import Logica.GestorBDHabitacion;
import Logica.GestorBDReserva;
import java.sql.Date;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frmReserva extends javax.swing.JInternalFrame {

    public frmReserva() {
        initComponents();
        mostrar("");
        inhabilitar();
    }
    private String accion = "Guardar";
    public static int idTrabajador;

    private void ocultar_columnas() {
        tblListado.getColumnModel().getColumn(0).setMaxWidth(0);
        tblListado.getColumnModel().getColumn(0).setMinWidth(0);
        tblListado.getColumnModel().getColumn(0).setPreferredWidth(0);

        tblListado.getColumnModel().getColumn(1).setMaxWidth(0);
        tblListado.getColumnModel().getColumn(1).setMinWidth(0);
        tblListado.getColumnModel().getColumn(1).setPreferredWidth(0);

        tblListado.getColumnModel().getColumn(3).setMaxWidth(0);
        tblListado.getColumnModel().getColumn(3).setMinWidth(0);
        tblListado.getColumnModel().getColumn(3).setPreferredWidth(0);

        tblListado.getColumnModel().getColumn(5).setMaxWidth(0);
        tblListado.getColumnModel().getColumn(5).setMinWidth(0);
        tblListado.getColumnModel().getColumn(5).setPreferredWidth(0);
    }

    private void inhabilitar() {
        txtIdReserva.setVisible(false);
        txtIdHabitacion.setVisible(false);
        txtNumeroHabitacion.setEnabled(false);
        txtIdCliente.setVisible(false);
        txtCliente.setEnabled(false);
        txtIdTrabajador.setVisible(false);
        txtTrabajador.setEnabled(false);
        cboTipoReserva.setEnabled(false);
        dcFechaReserva.setEnabled(false);
        dcFechaIngreso.setEnabled(false);
        dcFechaSalida.setEnabled(false);
        txtCostoAlojamiento.setEnabled(false);
        cboEstado.setEnabled(false);

        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnBuscarHabitacion.setEnabled(false);
        btnBuscarCliente.setEnabled(false);

        txtIdReserva.setText("");
        txtIdHabitacion.setText("");
        txtNumeroHabitacion.setText("");
        txtIdCliente.setText("");
        txtCliente.setText("");  

    }

    private void habilitar() {
        txtIdReserva.setVisible(false);
        txtIdHabitacion.setVisible(false);
        txtNumeroHabitacion.setEnabled(true);
        txtIdCliente.setVisible(false);
        txtCliente.setEnabled(true);
        txtIdTrabajador.setVisible(false);
        txtTrabajador.setEnabled(true);
        cboTipoReserva.setEnabled(true);
        dcFechaReserva.setEnabled(true);
        dcFechaIngreso.setEnabled(true);
        dcFechaSalida.setEnabled(true);
        txtCostoAlojamiento.setEnabled(true);
        cboEstado.setEnabled(true);

        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnBuscarHabitacion.setEnabled(true);
        btnBuscarCliente.setEnabled(true);

        txtIdReserva.setText("");
        txtIdHabitacion.setText("");
        txtNumeroHabitacion.setText("");
        txtIdCliente.setText("");
        txtCliente.setText("");

    }

    private void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;
            GestorBDReserva gestor = new GestorBDReserva();
            modelo = gestor.mostrar(buscar);
            tblListado.setModel(modelo);
            ocultar_columnas();
            lblTotalRegistros.setText("Total de Registros: " + Integer.toString(gestor.totalRegistros));
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtIdReserva = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtIdHabitacion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtCostoAlojamiento = new javax.swing.JTextField();
        cboTipoReserva = new javax.swing.JComboBox<>();
        txtNumeroHabitacion = new javax.swing.JTextField();
        txtIdCliente = new javax.swing.JTextField();
        txtCliente = new javax.swing.JTextField();
        txtIdTrabajador = new javax.swing.JTextField();
        txtTrabajador = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        dcFechaReserva = new com.toedter.calendar.JDateChooser();
        dcFechaIngreso = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        dcFechaSalida = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        cboEstado = new javax.swing.JComboBox<>();
        btnBuscarHabitacion = new javax.swing.JButton();
        btnBuscarCliente = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblListado = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        lblTotalRegistros = new javax.swing.JLabel();
        btnConsumo = new javax.swing.JButton();
        btnPagos = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Registro de Reservas"));

        jLabel2.setText("Habitacion: ");

        txtIdHabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdHabitacionActionPerformed(evt);
            }
        });

        jLabel4.setText("Cliente: ");

        jLabel6.setText("Tipo de Reserva: ");

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

        jLabel3.setText("Costo de Alojamiento:");

        txtCostoAlojamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCostoAlojamientoActionPerformed(evt);
            }
        });

        cboTipoReserva.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Reserva", "Alquiler" }));

        txtNumeroHabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroHabitacionActionPerformed(evt);
            }
        });

        txtIdCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdClienteActionPerformed(evt);
            }
        });

        txtCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClienteActionPerformed(evt);
            }
        });

        txtIdTrabajador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdTrabajadorActionPerformed(evt);
            }
        });

        txtTrabajador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTrabajadorActionPerformed(evt);
            }
        });

        jLabel5.setText("Trabajador: ");

        jLabel7.setText("Fecha de Reserva: ");

        jLabel8.setText("Fecha de Ingreso: ");

        jLabel10.setText("Fecha de Salida: ");

        jLabel11.setText("Estado de la Reserva:");

        cboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alquiler", "Pagada", "Anulada" }));

        btnBuscarHabitacion.setText("...");
        btnBuscarHabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarHabitacionActionPerformed(evt);
            }
        });

        btnBuscarCliente.setText("...");
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtIdTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cboTipoReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtIdHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNumeroHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtCostoAlojamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dcFechaReserva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dcFechaIngreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dcFechaSalida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscarHabitacion)
                            .addComponent(btnBuscarCliente)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(txtIdReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(btnNuevo)
                        .addGap(52, 52, 52)
                        .addComponent(btnGuardar)
                        .addGap(61, 61, 61)
                        .addComponent(btnCancelar)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtIdReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnBuscarHabitacion)
                    .addComponent(txtNumeroHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(btnBuscarCliente)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtIdTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cboTipoReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dcFechaReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addComponent(dcFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dcFechaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCostoAlojamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Reserva");

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de Reservas"));

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

        jLabel9.setText("Buscar Reserva Por Fecha:");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

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

        btnConsumo.setText("Consumos");
        btnConsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsumoActionPerformed(evt);
            }
        });

        btnPagos.setText("Realizar Pagos");
        btnPagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagosActionPerformed(evt);
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
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBuscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 12, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnConsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPagos, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTotalRegistros)
                        .addGap(53, 53, 53))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnEliminar)
                    .addComponent(btnSalir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalRegistros)
                    .addComponent(btnConsumo)
                    .addComponent(btnPagos))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdHabitacionActionPerformed
        txtIdHabitacion.transferFocus();
    }//GEN-LAST:event_txtIdHabitacionActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        habilitar();
        btnGuardar.setText("Guardar");
        accion = "guardar";
    }//GEN-LAST:event_btnNuevoActionPerformed

    @SuppressWarnings("deprecation")
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (txtIdHabitacion.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el numero de la habitacion");
            txtIdHabitacion.requestFocus();
        }
        if (txtIdCliente.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el Cliente");
            txtIdCliente.requestFocus();
            return;
        }
        if (txtCostoAlojamiento.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el costo del Alojamiento");
            txtCostoAlojamiento.requestFocus();
            return;
        }

        Reserva reserva = new Reserva();
        GestorBDReserva gestor = new GestorBDReserva();
        Calendar calendario;
        int dia, mes, año;

        reserva.setIdHabitacion(Integer.parseInt(txtIdHabitacion.getText()));
        reserva.setIdCliente(Integer.parseInt(txtIdCliente.getText()));
        reserva.setIdTrabajador(idTrabajador);
        int tipoReserva = cboTipoReserva.getSelectedIndex();
        reserva.setTipoReserva(cboTipoReserva.getItemAt(tipoReserva));

        calendario = dcFechaReserva.getCalendar();
        dia = calendario.get(Calendar.DAY_OF_MONTH);
        mes = calendario.get(Calendar.MONTH);
        año = calendario.get(Calendar.YEAR) - 1900;
        reserva.setFechaReserva(new Date(año, mes, dia));

        calendario = dcFechaIngreso.getCalendar();
        dia = calendario.get(Calendar.DAY_OF_MONTH);
        mes = calendario.get(Calendar.MONTH);
        año = calendario.get(Calendar.YEAR) - 1900;
        reserva.setFechaIngreso(new Date(año, mes, dia));

        calendario = dcFechaSalida.getCalendar();
        dia = calendario.get(Calendar.DAY_OF_MONTH);
        mes = calendario.get(Calendar.MONTH);
        año = calendario.get(Calendar.YEAR) - 1900;
        reserva.setFechaSalida(new Date(año, mes, dia));

        reserva.setCostoAlojamiento(Double.parseDouble(txtCostoAlojamiento.getText()));
        int estado = cboEstado.getSelectedIndex();
        reserva.setEstado(cboEstado.getItemAt(estado));

        if (accion.equals("guardar")) {
            if (gestor.insertar(reserva)) {
                JOptionPane.showMessageDialog(rootPane, "La Reserva fue resgistrada correctamente");
                mostrar("");
                inhabilitar();
                
                GestorBDHabitacion gestorHabitacion = new GestorBDHabitacion();
                Habitacion habitacion = new Habitacion();
                
                habitacion.setIdHabitacion(Integer.parseInt(txtIdHabitacion.getText()));
                gestorHabitacion.ocupar(habitacion);
            }
        } else if (accion.equals("editar")) {
            reserva.setIdReserva(Integer.parseInt(txtIdReserva.getText()));
            if (gestor.editar(reserva)) {
                JOptionPane.showMessageDialog(rootPane, "La Reserva fue modificada correctamente");
                mostrar("");
                inhabilitar();
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtCostoAlojamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCostoAlojamientoActionPerformed
        txtCostoAlojamiento.transferFocus();
    }//GEN-LAST:event_txtCostoAlojamientoActionPerformed

    private void tblListadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListadoMouseClicked
        btnGuardar.setText("Editar");
        habilitar();
        btnEliminar.setEnabled(true);
        accion = "editar";

        int fila = tblListado.rowAtPoint(evt.getPoint());

        txtIdReserva.setText(tblListado.getValueAt(fila, 0).toString());
        txtIdHabitacion.setText(tblListado.getValueAt(fila, 1).toString());
        txtNumeroHabitacion.setText(tblListado.getValueAt(fila, 2).toString());
        txtIdCliente.setText(tblListado.getValueAt(fila, 3).toString());
        txtCliente.setText(tblListado.getValueAt(fila, 4).toString());
        txtIdTrabajador.setText(tblListado.getValueAt(fila, 5).toString());
        txtTrabajador.setText(tblListado.getValueAt(fila, 6).toString());
        cboTipoReserva.setSelectedItem(tblListado.getValueAt(fila, 7).toString());
        dcFechaReserva.setDate(Date.valueOf(tblListado.getValueAt(fila, 8).toString()));
        dcFechaIngreso.setDate(Date.valueOf(tblListado.getValueAt(fila, 9).toString()));
        dcFechaSalida.setDate(Date.valueOf(tblListado.getValueAt(fila, 10).toString()));
        txtCostoAlojamiento.setText(tblListado.getValueAt(fila, 11).toString());
        cboEstado.setSelectedItem(tblListado.getValueAt(fila, 12).toString());
    }//GEN-LAST:event_tblListadoMouseClicked

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        mostrar(txtBuscar.getText());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (!txtIdReserva.getText().equals("")) {
            int confirmar = JOptionPane.showConfirmDialog(rootPane, "Estas seguro de eliminar?", "Confirmar", 2);
            if (confirmar == 0) {
                GestorBDReserva gestor = new GestorBDReserva();
                Reserva reserva = new Reserva();
                reserva.setIdReserva(Integer.parseInt(txtIdReserva.getText()));
                gestor.eliminar(reserva);
                mostrar("");
                inhabilitar();
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtNumeroHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroHabitacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroHabitacionActionPerformed

    private void txtIdClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdClienteActionPerformed

    private void txtClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClienteActionPerformed

    private void txtIdTrabajadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdTrabajadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdTrabajadorActionPerformed

    private void txtTrabajadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTrabajadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTrabajadorActionPerformed

    private void btnBuscarHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarHabitacionActionPerformed
        frmVistaHabitacion frmVH = new frmVistaHabitacion();
        frmVH.toFront();
        frmVH.setVisible(true);
    }//GEN-LAST:event_btnBuscarHabitacionActionPerformed

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        frmVistaCliente frmVC = new frmVistaCliente();
        frmVC.toFront();
        frmVC.setVisible(true);
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void btnConsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsumoActionPerformed
        int fila = tblListado.getSelectedRow();
        try {
            frmConsumo.idReserva = tblListado.getValueAt(fila, 0).toString();
            frmConsumo.cliente = tblListado.getValueAt(fila, 4).toString();

            frmConsumo frmC = new frmConsumo();
            frmInicio.dtpEscritorio.add(frmC);
            frmC.toFront();
            frmC.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(rootPane, "Debes seleccionar la Reserva");
        }
    }//GEN-LAST:event_btnConsumoActionPerformed

    private void btnPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagosActionPerformed
        int fila = tblListado.getSelectedRow();
        try {
                frmPago.idReserva = tblListado.getValueAt(fila,0).toString();
                frmPago.cliente = tblListado.getValueAt(fila,4).toString();
                frmPago.totalReserva = Double.parseDouble(tblListado.getValueAt(fila,11).toString());
                
                frmPago.idHabitacion = tblListado.getValueAt(fila,1).toString();
                frmPago.habitacion = tblListado.getValueAt(fila,2).toString();
                
                frmPago frmP = new frmPago();
                frmInicio.dtpEscritorio.add(frmP);
                frmP.toFront();
                frmP.setVisible(true);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnPagosActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmReserva().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnBuscarHabitacion;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConsumo;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnPagos;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cboEstado;
    private javax.swing.JComboBox<String> cboTipoReserva;
    private com.toedter.calendar.JDateChooser dcFechaIngreso;
    private com.toedter.calendar.JDateChooser dcFechaReserva;
    private com.toedter.calendar.JDateChooser dcFechaSalida;
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
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblTotalRegistros;
    private javax.swing.JTable tblListado;
    private javax.swing.JTextField txtBuscar;
    public static javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtCostoAlojamiento;
    public static javax.swing.JTextField txtIdCliente;
    public static javax.swing.JTextField txtIdHabitacion;
    private javax.swing.JTextField txtIdReserva;
    public static javax.swing.JTextField txtIdTrabajador;
    public static javax.swing.JTextField txtNumeroHabitacion;
    public static javax.swing.JTextField txtTrabajador;
    // End of variables declaration//GEN-END:variables
}
