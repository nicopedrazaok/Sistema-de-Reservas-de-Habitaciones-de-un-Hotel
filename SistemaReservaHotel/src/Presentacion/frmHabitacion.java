package Presentacion;

import Datos.Habitacion;
import Logica.Conexion;
import Logica.GestorBDHabitacion;
import java.io.File;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class frmHabitacion extends javax.swing.JInternalFrame {

    public frmHabitacion() {
        initComponents();
        mostrar("");
        inhabilitar();
        this.setClosable(true);
        this.setIconifiable(true);
        this.setMaximizable(true);

    }
    private String accion = "Guardar";

    private void ocultar_columnas() {
        tblListado.getColumnModel().getColumn(0).setMaxWidth(0);
        tblListado.getColumnModel().getColumn(0).setMinWidth(0);
        tblListado.getColumnModel().getColumn(0).setPreferredWidth(0);
    }

    private void inhabilitar() {
        txtIdHabitacion.setVisible(false);
        cboPiso.setEnabled(false);
        txtNumero.setEnabled(false);
        txtDescripcion.setEnabled(false);
        txtCarateristica.setEnabled(false);
        txtPrecioDiario.setEnabled(false);
        cboEstado.setEnabled(false);
        cboTipoHabitacion.setEnabled(false);

        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnEliminar.setEnabled(false);

        txtIdHabitacion.setText("");
        txtPrecioDiario.setText("");
        txtCarateristica.setText("");
        txtDescripcion.setText("");
    }

    private void habilitar() {
        txtIdHabitacion.setVisible(false);
        cboPiso.setEnabled(true);
        txtNumero.setEnabled(true);
        txtDescripcion.setEnabled(true);
        txtCarateristica.setEnabled(true);
        txtPrecioDiario.setEnabled(true);
        cboEstado.setEnabled(true);
        cboTipoHabitacion.setEnabled(true);

        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnEliminar.setEnabled(true);

        txtIdHabitacion.setText("");
        txtNumero.setText("");
        txtDescripcion.setText("");
        txtCarateristica.setText("");
        txtPrecioDiario.setText("");

    }

    private void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;
            GestorBDHabitacion gestor = new GestorBDHabitacion();
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

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtIdHabitacion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cboPiso = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtCarateristica = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        txtPrecioDiario = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cboEstado = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cboTipoHabitacion = new javax.swing.JComboBox<>();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblListado = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        lblTotalRegistros = new javax.swing.JLabel();
        btnReporte = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Habitacion");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Habitación");

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Registro de Habitaciones"));

        jLabel2.setText("Numero: ");

        txtNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroActionPerformed(evt);
            }
        });

        jLabel3.setText("Piso: ");

        cboPiso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        cboPiso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboPisoActionPerformed(evt);
            }
        });

        jLabel4.setText("Descripción: ");

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        jLabel5.setText("Carateristica: ");

        txtCarateristica.setColumns(20);
        txtCarateristica.setRows(5);
        jScrollPane2.setViewportView(txtCarateristica);

        jLabel6.setText("Precio Diario:");

        txtPrecioDiario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioDiarioActionPerformed(evt);
            }
        });

        jLabel7.setText("Estado: ");

        cboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Disponible", "Ocupado", "Mantenimiento" }));
        cboEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboEstadoActionPerformed(evt);
            }
        });

        jLabel8.setText("Tipo de Habitacion: ");

        cboTipoHabitacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Individual", "Matrimonial", "Familiar", "Presidencial" }));
        cboTipoHabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTipoHabitacionActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(txtIdHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(btnNuevo))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cboPiso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtNumero)
                                    .addComponent(jScrollPane2)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPrecioDiario)
                                    .addComponent(cboTipoHabitacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(btnGuardar)
                                .addGap(61, 61, 61)
                                .addComponent(btnCancelar)))))
                .addContainerGap(122, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtIdHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cboPiso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPrecioDiario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cboTipoHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de Habitaciones"));

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

        jLabel9.setText("Buscar Habitacion: ");

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

        btnReporte.setText("Reporte");
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnReporte)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTotalRegistros)
                .addGap(53, 53, 53))
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
                    .addComponent(btnSalir)
                    .addComponent(btnReporte))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTotalRegistros)
                .addGap(12, 12, 12))
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
                        .addGap(43, 43, 43)
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

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        habilitar();
        btnGuardar.setText("Guardar");
        accion = "guardar";
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (txtNumero.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar un numero de Habitacion");
            txtNumero.requestFocus();
            return;
        }
        if (txtDescripcion.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar una descripcion para la Habitacion");
            txtDescripcion.requestFocus();
            return;
        }
        if (txtCarateristica.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar una Carateristica para la Habitacion");
            txtCarateristica.requestFocus();
            return;
        }
        if (txtPrecioDiario.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar un precio diario para la Habitacion");
            txtPrecioDiario.requestFocus();
            return;
        }
        Habitacion hab = new Habitacion();
        GestorBDHabitacion gestor = new GestorBDHabitacion();

        hab.setNumero(txtNumero.getText());
        int piso = cboPiso.getSelectedIndex();
        hab.setPiso(cboPiso.getItemAt(piso));
        hab.setDescripcion(txtDescripcion.getText());
        hab.setCarateristica(txtCarateristica.getText());
        hab.setPrecioDiario(Double.parseDouble(txtPrecioDiario.getText()));
        int estado = cboEstado.getSelectedIndex();
        hab.setEstado(cboEstado.getItemAt(estado));
        int tipoHabitacion = cboTipoHabitacion.getSelectedIndex();
        hab.setTipoHabitacion(cboTipoHabitacion.getItemAt(tipoHabitacion));

        if (accion.equals("guardar")) {
            if (gestor.insertar(hab)) {
                JOptionPane.showMessageDialog(rootPane, "La Habitacion fue resgistrada correctamente");
                mostrar("");
                inhabilitar();
            }
        } else if (accion.equals("editar")) {
            hab.setIdHabitacion(Integer.parseInt(txtIdHabitacion.getText()));
            if (gestor.editar(hab)) {
                JOptionPane.showMessageDialog(rootPane, "La Habitacion fue modificada correctamente");
                mostrar("");
                inhabilitar();
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (!txtIdHabitacion.getText().equals("")) {
            int confirmar = JOptionPane.showConfirmDialog(rootPane, "Estas seguro de eliminar?", "Confirmar", 2);
            if (confirmar == 0) {
                GestorBDHabitacion gestor = new GestorBDHabitacion();
                Habitacion hab = new Habitacion();
                hab.setIdHabitacion(Integer.parseInt(txtIdHabitacion.getText()));
                gestor.eliminar(hab);
                mostrar("");
                inhabilitar();
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        mostrar(txtBuscar.getText());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroActionPerformed
        txtNumero.transferFocus();
    }//GEN-LAST:event_txtNumeroActionPerformed

    private void cboPisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboPisoActionPerformed
        cboPiso.transferFocus();
    }//GEN-LAST:event_cboPisoActionPerformed

    private void txtPrecioDiarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioDiarioActionPerformed
        txtPrecioDiario.transferFocus();
    }//GEN-LAST:event_txtPrecioDiarioActionPerformed

    private void cboEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboEstadoActionPerformed
        cboEstado.transferFocus();
    }//GEN-LAST:event_cboEstadoActionPerformed

    private void cboTipoHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTipoHabitacionActionPerformed
        cboTipoHabitacion.transferFocus();
    }//GEN-LAST:event_cboTipoHabitacionActionPerformed

    private void tblListadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListadoMouseClicked
        btnGuardar.setText("Editar");
        habilitar();
        btnEliminar.setEnabled(true);
        accion = "editar";
        int fila = tblListado.rowAtPoint(evt.getPoint());
        txtIdHabitacion.setText(tblListado.getValueAt(fila, 0).toString());
        txtNumero.setText(tblListado.getValueAt(fila, 1).toString());
        cboPiso.setSelectedItem(tblListado.getValueAt(fila, 2).toString());
        txtDescripcion.setText(tblListado.getValueAt(fila, 3).toString());
        txtCarateristica.setText(tblListado.getValueAt(fila, 4).toString());
        txtPrecioDiario.setText(tblListado.getValueAt(fila, 5).toString());
        cboEstado.setSelectedItem(tblListado.getValueAt(fila, 6).toString());
        cboTipoHabitacion.setSelectedItem(tblListado.getValueAt(fila, 7).toString());
    }//GEN-LAST:event_tblListadoMouseClicked

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed
    private Connection connection = new Conexion().Conectar();

    @SuppressWarnings("unchecked")
    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        Map p = new HashMap();
        JasperReport report;
        JasperPrint print;
        try {
            report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                    + "/src/Reportes/rpHabitaciones.jrxml");
            print = JasperFillManager.fillReport(report, p, connection);
            JasperViewer view = new JasperViewer(print, false);
            view.setTitle("Reporte de habitaciones");
            view.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnReporteActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmHabitacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnReporte;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cboEstado;
    private javax.swing.JComboBox<String> cboPiso;
    private javax.swing.JComboBox<String> cboTipoHabitacion;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblTotalRegistros;
    private javax.swing.JTable tblListado;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextArea txtCarateristica;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtIdHabitacion;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtPrecioDiario;
    // End of variables declaration//GEN-END:variables
}
