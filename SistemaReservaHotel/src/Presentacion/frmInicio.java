package Presentacion;

public class  frmInicio extends javax.swing.JFrame {

    public frmInicio() {
        initComponents();
        this.setExtendedState(frmInicio.MAXIMIZED_BOTH);
        this.setTitle("Sistema de Reservas de Habitaciones & Gestion de ventas");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dtpEscritorio = new javax.swing.JDesktopPane();
        lblIdPersona = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApellidoPaterno = new javax.swing.JLabel();
        lblApellidoMaterno = new javax.swing.JLabel();
        lblAcceso = new javax.swing.JLabel();
        lblAcceso1 = new javax.swing.JLabel();
        lblApellidoMaterno1 = new javax.swing.JLabel();
        lblApellidoPaterno1 = new javax.swing.JLabel();
        lblNombre1 = new javax.swing.JLabel();
        lblIdPersona1 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        mnuSistemaReservaHotel = new javax.swing.JMenu();
        mnuArchivo = new javax.swing.JMenu();
        mnuItemHabitacion = new javax.swing.JMenuItem();
        mnuItemProducto = new javax.swing.JMenuItem();
        mnuReserva = new javax.swing.JMenu();
        mnuItemReservas = new javax.swing.JMenuItem();
        mnuItemCliente = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        mnuConsultas = new javax.swing.JMenu();
        mnuConfiguracion = new javax.swing.JMenu();
        mnuItemTrabajador = new javax.swing.JMenuItem();
        mnuHerramienta = new javax.swing.JMenu();
        mnuAyuda = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        mnuSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        dtpEscritorio.setBackground(new java.awt.Color(51, 153, 255));

        lblIdPersona.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblIdPersona.setForeground(new java.awt.Color(255, 255, 255));
        lblIdPersona.setText("ID");
        dtpEscritorio.add(lblIdPersona);
        lblIdPersona.setBounds(20, 60, 30, 20);

        lblNombre.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setText("Nombre");
        dtpEscritorio.add(lblNombre);
        lblNombre.setBounds(70, 60, 110, 20);

        lblApellidoPaterno.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblApellidoPaterno.setForeground(new java.awt.Color(255, 255, 255));
        lblApellidoPaterno.setText("Apellido Paterno");
        dtpEscritorio.add(lblApellidoPaterno);
        lblApellidoPaterno.setBounds(210, 60, 150, 20);

        lblApellidoMaterno.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblApellidoMaterno.setForeground(new java.awt.Color(255, 255, 255));
        lblApellidoMaterno.setText("Apellido Materno");
        dtpEscritorio.add(lblApellidoMaterno);
        lblApellidoMaterno.setBounds(390, 60, 150, 20);

        lblAcceso.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblAcceso.setForeground(new java.awt.Color(255, 255, 255));
        lblAcceso.setText("Acceso");
        dtpEscritorio.add(lblAcceso);
        lblAcceso.setBounds(550, 60, 150, 20);

        lblAcceso1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblAcceso1.setForeground(new java.awt.Color(255, 255, 255));
        lblAcceso1.setText("Acceso");
        dtpEscritorio.add(lblAcceso1);
        lblAcceso1.setBounds(550, 30, 150, 20);

        lblApellidoMaterno1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblApellidoMaterno1.setForeground(new java.awt.Color(255, 255, 255));
        lblApellidoMaterno1.setText("Apellido Materno");
        dtpEscritorio.add(lblApellidoMaterno1);
        lblApellidoMaterno1.setBounds(390, 30, 150, 20);

        lblApellidoPaterno1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblApellidoPaterno1.setForeground(new java.awt.Color(255, 255, 255));
        lblApellidoPaterno1.setText("Apellido Paterno");
        dtpEscritorio.add(lblApellidoPaterno1);
        lblApellidoPaterno1.setBounds(210, 30, 150, 20);

        lblNombre1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblNombre1.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre1.setText("Nombre");
        dtpEscritorio.add(lblNombre1);
        lblNombre1.setBounds(70, 30, 110, 20);

        lblIdPersona1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblIdPersona1.setForeground(new java.awt.Color(255, 255, 255));
        lblIdPersona1.setText("ID");
        dtpEscritorio.add(lblIdPersona1);
        lblIdPersona1.setBounds(20, 30, 30, 20);

        mnuSistemaReservaHotel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/Inicio.png"))); // NOI18N
        mnuSistemaReservaHotel.setMnemonic('f');
        mnuSistemaReservaHotel.setText("Sistema de Reserva Hotel");
        menuBar.add(mnuSistemaReservaHotel);

        mnuArchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/Archivo.png"))); // NOI18N
        mnuArchivo.setMnemonic('e');
        mnuArchivo.setText("Archivos");

        mnuItemHabitacion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuItemHabitacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/habitaciones.png"))); // NOI18N
        mnuItemHabitacion.setMnemonic('p');
        mnuItemHabitacion.setText("Habitaciones");
        mnuItemHabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItemHabitacionActionPerformed(evt);
            }
        });
        mnuArchivo.add(mnuItemHabitacion);

        mnuItemProducto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuItemProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/productos.png"))); // NOI18N
        mnuItemProducto.setMnemonic('d');
        mnuItemProducto.setText("Productos");
        mnuItemProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItemProductoActionPerformed(evt);
            }
        });
        mnuArchivo.add(mnuItemProducto);

        menuBar.add(mnuArchivo);

        mnuReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/Reservas.png"))); // NOI18N
        mnuReserva.setMnemonic('h');
        mnuReserva.setText("Reserva");

        mnuItemReservas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuItemReservas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/reservas-consumos.png"))); // NOI18N
        mnuItemReservas.setMnemonic('c');
        mnuItemReservas.setText("Reservas y Consumos");
        mnuItemReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItemReservasActionPerformed(evt);
            }
        });
        mnuReserva.add(mnuItemReservas);

        mnuItemCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuItemCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/clientes.png"))); // NOI18N
        mnuItemCliente.setMnemonic('a');
        mnuItemCliente.setText("Cliente");
        mnuItemCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItemClienteActionPerformed(evt);
            }
        });
        mnuReserva.add(mnuItemCliente);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/pagos.png"))); // NOI18N
        jMenuItem1.setText("Pagos");
        mnuReserva.add(jMenuItem1);

        menuBar.add(mnuReserva);

        mnuConsultas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/Consultas.png"))); // NOI18N
        mnuConsultas.setText("Consultas");
        mnuConsultas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuConsultasMouseClicked(evt);
            }
        });
        menuBar.add(mnuConsultas);

        mnuConfiguracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/Configuraciones.png"))); // NOI18N
        mnuConfiguracion.setText("Configuracion");

        mnuItemTrabajador.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuItemTrabajador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/trabajadores.png"))); // NOI18N
        mnuItemTrabajador.setText("Usuarios y Accesos");
        mnuItemTrabajador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItemTrabajadorActionPerformed(evt);
            }
        });
        mnuConfiguracion.add(mnuItemTrabajador);

        menuBar.add(mnuConfiguracion);

        mnuHerramienta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/Herramientas.png"))); // NOI18N
        mnuHerramienta.setText("Herramienta");
        menuBar.add(mnuHerramienta);

        mnuAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/Ayuda.png"))); // NOI18N
        mnuAyuda.setText("Ayuda");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem3.setText("Acerca de...");
        mnuAyuda.add(jMenuItem3);

        jMenuItem4.setText("Ayuda");
        mnuAyuda.add(jMenuItem4);

        menuBar.add(mnuAyuda);

        mnuSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/Salir.png"))); // NOI18N
        mnuSalir.setText("Salir");
        mnuSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuSalirMouseClicked(evt);
            }
        });
        mnuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSalirActionPerformed(evt);
            }
        });
        menuBar.add(mnuSalir);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dtpEscritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 976, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dtpEscritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuItemHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemHabitacionActionPerformed
        frmHabitacion frmH = new frmHabitacion();
        dtpEscritorio.add(frmH);
        frmH.toFront();
        frmH.setVisible(true);
    }//GEN-LAST:event_mnuItemHabitacionActionPerformed

    private void mnuItemProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemProductoActionPerformed
        frmProducto frmP = new frmProducto();
        dtpEscritorio.add(frmP);
        frmP.toFront();
        frmP.setVisible(true);
    }//GEN-LAST:event_mnuItemProductoActionPerformed

    private void mnuItemClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemClienteActionPerformed
        frmCliente frmC = new frmCliente();
        dtpEscritorio.add(frmC);
        frmC.toFront();
        frmC.setVisible(true);
    }//GEN-LAST:event_mnuItemClienteActionPerformed

    private void mnuItemTrabajadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemTrabajadorActionPerformed
        frmTrabajador frmT = new frmTrabajador();
        dtpEscritorio.add(frmT);
        frmT.toFront();
        frmT.setVisible(true);
    }//GEN-LAST:event_mnuItemTrabajadorActionPerformed

    private void mnuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_mnuSalirActionPerformed

    private void mnuSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuSalirMouseClicked
       this.dispose();
    }//GEN-LAST:event_mnuSalirMouseClicked

    private void mnuItemReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemReservasActionPerformed
        frmReserva frmR = new frmReserva();
        dtpEscritorio.add(frmR);
        frmR.toFront();
        frmR.setVisible(true);
        frmReserva.txtIdTrabajador.setText(lblIdPersona.getText());
        frmReserva.txtTrabajador.setText(lblNombre.getText() + " " + lblApellidoPaterno.getText());
        frmReserva.idTrabajador = Integer.parseInt(lblIdPersona.getText());
    }//GEN-LAST:event_mnuItemReservasActionPerformed

    private void mnuConsultasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuConsultasMouseClicked

    }//GEN-LAST:event_mnuConsultasMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmInicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane dtpEscritorio;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    public static javax.swing.JLabel lblAcceso;
    public static javax.swing.JLabel lblAcceso1;
    public static javax.swing.JLabel lblApellidoMaterno;
    public static javax.swing.JLabel lblApellidoMaterno1;
    public static javax.swing.JLabel lblApellidoPaterno;
    public static javax.swing.JLabel lblApellidoPaterno1;
    public static javax.swing.JLabel lblIdPersona;
    public static javax.swing.JLabel lblIdPersona1;
    public static javax.swing.JLabel lblNombre;
    public static javax.swing.JLabel lblNombre1;
    private javax.swing.JMenuBar menuBar;
    public static javax.swing.JMenu mnuArchivo;
    private javax.swing.JMenu mnuAyuda;
    public static javax.swing.JMenu mnuConfiguracion;
    private javax.swing.JMenu mnuConsultas;
    private javax.swing.JMenu mnuHerramienta;
    private javax.swing.JMenuItem mnuItemCliente;
    private javax.swing.JMenuItem mnuItemHabitacion;
    private javax.swing.JMenuItem mnuItemProducto;
    private javax.swing.JMenuItem mnuItemReservas;
    private javax.swing.JMenuItem mnuItemTrabajador;
    private javax.swing.JMenu mnuReserva;
    private javax.swing.JMenu mnuSalir;
    private javax.swing.JMenu mnuSistemaReservaHotel;
    // End of variables declaration//GEN-END:variables

}
