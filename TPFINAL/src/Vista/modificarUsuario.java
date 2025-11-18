package Vista;

import Modelo.Comprador;
import Persistencia.CompradorData;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class modificarUsuario extends javax.swing.JInternalFrame {

    public modificarUsuario() throws SQLException {
        initComponents();
        tablaCompradores();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        botonConfirmar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        usuarioNombre = new javax.swing.JTextField();
        comboEstado = new javax.swing.JComboBox<>();
        botonVolver = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        jDesktopPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonConfirmar.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 14)); // NOI18N
        botonConfirmar.setText("Confirmar");
        botonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConfirmarActionPerformed(evt);
            }
        });
        jDesktopPane1.add(botonConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 110, 40));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Estado", "DNI"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
        }

        jDesktopPane1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 619, 210));

        usuarioNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioNombreActionPerformed(evt);
            }
        });
        jDesktopPane1.add(usuarioNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 160, -1));

        comboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Habilitar", "Deshabilitar" }));
        comboEstado.setSelectedIndex(-1);
        jDesktopPane1.add(comboEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 160, -1));

        botonVolver.setBackground(new java.awt.Color(215, 0, 0));
        botonVolver.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 14)); // NOI18N
        botonVolver.setForeground(new java.awt.Color(0, 0, 0));
        botonVolver.setText("Volver");
        botonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverActionPerformed(evt);
            }
        });
        jDesktopPane1.add(botonVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 430, 110, 40));

        jLabel7.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Modificar Usuario");
        jLabel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jDesktopPane1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 210, 60));

        jLabel9.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Nombre:");
        jDesktopPane1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 106, 24));

        jLabel10.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Estado:");
        jDesktopPane1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 106, 24));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConfirmarActionPerformed
        int fila = -1;
        Boolean estadoST = true;
        int estado = -1;
        fila = jTable1.getSelectedRow();
        if (fila != -1) {
            String nombre = usuarioNombre.getText();
            estado = comboEstado.getSelectedIndex();
            estadoST = true;
            switch (estado) {
                case 0:
                    estadoST = true;
                    break;
                case 1:
                    estadoST = false;
                    break;
            }
            CompradorData cd = null;
            try {
                cd = new CompradorData();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al acceder a la base de datos.");
            }
            
            cd.modificarComprador(estadoST, nombre, (int)jTable1.getValueAt(fila, 2));
            
            try {
                tablaCompradores();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Error al acceder a la tabla.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un usuario.");
        }
    }//GEN-LAST:event_botonConfirmarActionPerformed

    private void botonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonVolverActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int fila = jTable1.getSelectedRow();
        usuarioNombre.setText((String)jTable1.getValueAt(fila, 0));
        Boolean estado = (Boolean)jTable1.getValueAt(fila, 1);
        if(estado){
            comboEstado.setSelectedIndex(0);
        }else{
            comboEstado.setSelectedIndex(1);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void usuarioNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarioNombreActionPerformed

    public void tablaCompradores() throws SQLException {
        List<Comprador> compra = new CompradorData().listarCompradores();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Estado");
        modelo.addColumn("DNI");
        for (Comprador c : compra) {
            modelo.addRow(new Object[]{
                c.getNombre(), c.getEstado(), c.getDni()
            });
        }
        jTable1.setModel(modelo);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonConfirmar;
    private javax.swing.JButton botonVolver;
    private javax.swing.JComboBox<String> comboEstado;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField usuarioNombre;
    // End of variables declaration//GEN-END:variables
}
