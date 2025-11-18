package Vista;

import Modelo.DetalleTicket;
import Modelo.Pelicula;
import Modelo.Proyeccion;
import Modelo.Ticket;
import Persistencia.AsientoData;
import Persistencia.DetalleTicketData;
import Persistencia.PeliculaData;
import Persistencia.ProyeccionData;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class verTicketsAdmin extends javax.swing.JInternalFrame {

    public verTicketsAdmin() throws SQLException {
        initComponents();
        tablaTickets();
        rellenarComboBoxPeliculas();
        jComboBox1.setSelectedIndex(-1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        segundaFecha = new com.toedter.calendar.JDateChooser();
        primerFecha = new com.toedter.calendar.JDateChooser();
        btnImprimir = new javax.swing.JButton();
        btnAnular = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();

        jLabel1.setText("Desde");

        jLabel2.setText("Hasta");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "codTicket", "Titulo", "DNI", "FechaCompra", "FechaFuncion", "Monto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Buscar Tickets por Fecha");

        jLabel4.setText("Titulo");

        jButton2.setText("Volver");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        btnAnular.setText("Anular");
        btnAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnularActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(segundaFecha, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(primerFecha, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnImprimir, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnAnular, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnBuscar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jComboBox1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDesktopPane1Layout.createSequentialGroup()
                        .addGap(257, 257, 257)
                        .addComponent(jLabel3))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDesktopPane1Layout.createSequentialGroup()
                            .addGap(47, 47, 47)
                            .addComponent(btnImprimir)
                            .addGap(18, 18, 18)
                            .addComponent(btnAnular)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDesktopPane1Layout.createSequentialGroup()
                            .addGap(39, 39, 39)
                            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(primerFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(39, 39, 39)
                                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(segundaFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(57, 57, 57)
                                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnBuscar))))))))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addGap(26, 26, 26)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(segundaFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnBuscar)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(primerFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(btnImprimir)
                    .addComponent(btnAnular))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        JOptionPane.showMessageDialog(null, "Datos impresos en consola.");

        if (jTable1.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "No hay datos para imprimir.");
            return;
        }

        for (int i = 0; i < jTable1.getRowCount(); i++) {
            System.out.println("- Codigo Detalle Ticket: " + jTable1.getValueAt(i, 0));
            System.out.println("- Titulo: " + jTable1.getValueAt(i, 1));
            System.out.println("- DNI comprador: " + jTable1.getValueAt(i, 2));
            System.out.println("- Fecha Compra: " + jTable1.getValueAt(i, 3));
            System.out.println("- Fecha Funcion: " + jTable1.getValueAt(i, 4));
            System.out.println("- Precio Total: " + jTable1.getValueAt(i, 5));
            System.out.println("-------------------------------\n");
        }
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void btnAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnularActionPerformed
        DetalleTicketData dt = null;
        Integer asientos[] = new Integer[2];
        AsientoData ad = null;
        try {
            ad = new AsientoData();
        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());
        }
        
        try {
            dt = new DetalleTicketData();
        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());
        }
        int fila = jTable1.getSelectedRow();
        if(fila != -1){
            asientos = dt.deshabilitarDetalleTicket((int)jTable1.getValueAt(fila, 0));
            try {
                tablaTickets();
            } catch (Exception e) {
                System.out.println("ERROR " + e.getMessage());
            }
            for (Integer a : asientos) {
                ad.habilitarAsiento(a);
            }
        }else{
            JOptionPane.showMessageDialog(null,"Seleccione un ticket para anular.");
        }
    }//GEN-LAST:event_btnAnularActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setRowCount(0);

        modelo.addColumn("codTicket");
        modelo.addColumn("Titulo");
        modelo.addColumn("DNI");
        modelo.addColumn("FechaCompra");
        modelo.addColumn("FechaFuncion");
        modelo.addColumn("Monto");

        jTable1.setModel(modelo);

        ProyeccionData pd = null;
        DetalleTicketData dt = null;
        List<DetalleTicket> lisTickets = null;
        try {
            lisTickets = new DetalleTicketData().listarTickets();
            pd = new ProyeccionData();
            dt = new DetalleTicketData();
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        Proyeccion proy = new Proyeccion();
        Ticket ticki = new Ticket();

        if (primerFecha.getDate() != null && segundaFecha.getDate() != null) {
            for (DetalleTicket lT : lisTickets) {
                proy = pd.getTitulo(lT.getIdProyeccion());
                ticki = dt.conseguirTicket(lT.getIdTicket());
                if (primerFecha.getDate().before(segundaFecha.getDate())) {
                    if (primerFecha.getDate().before(ticki.getFechaCompra()) && segundaFecha.getDate().after(ticki.getFechaCompra())) {
                        modelo.addRow(new Object[]{
                            lT.getCodD(), proy.getTitulo(), ticki.getDniComprador(),
                            ticki.getFechaCompra(), proy.getFechaFuncion(), lT.getTotal()
                        });
                    }
                }
            }

        } else if (primerFecha.getDate() != null && segundaFecha.getDate() != null && jComboBox1.getSelectedIndex() != -1) {
            String tituloElegido = jComboBox1.getSelectedItem().toString();
            for (DetalleTicket lT : lisTickets) {
                proy = pd.getTitulo(lT.getIdProyeccion());
                ticki = dt.conseguirTicket(lT.getIdTicket());
                if (proy.getTitulo().equalsIgnoreCase(tituloElegido)) {
                    if (primerFecha.getDate().before(ticki.getFechaCompra()) && segundaFecha.getDate().after(ticki.getFechaCompra())) {
                        modelo.addRow(new Object[]{
                            lT.getCodD(), proy.getTitulo(), ticki.getDniComprador(), ticki.getFechaCompra(), proy.getFechaFuncion(), lT.getTotal()
                        });
                    }
                }
            }
        } else if (jComboBox1.getSelectedIndex() != -1) {
            String tituloElegido = jComboBox1.getSelectedItem().toString();
            String tituloElegidos = tituloElegido.split(" - ")[1];
            for (DetalleTicket lT : lisTickets) {
                proy = pd.getTitulo(lT.getIdProyeccion());
                ticki = dt.conseguirTicket(lT.getIdTicket());
                if (proy.getTitulo().equals(tituloElegidos)) {
                    modelo.addRow(new Object[]{
                        lT.getCodD(), proy.getTitulo(), ticki.getDniComprador(), ticki.getFechaCompra(), proy.getFechaFuncion(), lT.getTotal()
                    });
                }
            }
        } else {
            JOptionPane.showMessageDialog(null,"Tiene las siguientes opciones:\n- Solo por fechas.\n- Solo por el título.\n- Por ambas.");
        }

    }//GEN-LAST:event_btnBuscarActionPerformed

    public void tablaTickets() throws SQLException {
        ProyeccionData pd = null;
        DetalleTicketData dt = null;

        try {
            pd = new ProyeccionData();
            dt = new DetalleTicketData();
        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());
        }

        List<DetalleTicket> listaTickets = new DetalleTicketData().listarTickets();
        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("codTicket");
        modelo.addColumn("Titulo");
        modelo.addColumn("DNI");
        modelo.addColumn("FechaCompra");
        modelo.addColumn("FechaFuncion");
        modelo.addColumn("Monto");

        Proyeccion proy = new Proyeccion();
        Ticket ticki = new Ticket();

        for (DetalleTicket t : listaTickets) {
            if (t.getEstado()) {
                proy = pd.getTitulo(t.getIdProyeccion());
                ticki = dt.conseguirTicket(t.getIdTicket());
                modelo.addRow(new Object[]{
                    t.getCodD(), proy.getTitulo(), ticki.getDniComprador(), ticki.getFechaCompra(), proy.getFechaFuncion(), t.getTotal()
                });
            } else {
                JOptionPane.showMessageDialog(null, "Todavia no has comprado ningún ticket.");
            }
        }
        jTable1.setModel(modelo);
    }

    public void rellenarComboBoxPeliculas() throws SQLException {
        List<Pelicula> pelis = new PeliculaData().listarPeliculas();

        for (Pelicula p : pelis) {
            jComboBox1.addItem(p.getIdPelicula() + " - " + p.getTitulo());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnular;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private com.toedter.calendar.JDateChooser primerFecha;
    private com.toedter.calendar.JDateChooser segundaFecha;
    // End of variables declaration//GEN-END:variables
}
