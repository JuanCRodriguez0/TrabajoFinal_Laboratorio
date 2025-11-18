
package Vista;

import Modelo.Proyeccion;
import Persistencia.ProyeccionData;
import Persistencia.SalaData;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class modificarProyeccion extends javax.swing.JInternalFrame {

    public modificarProyeccion() throws SQLException {
        initComponents();
        tablaProyecciones();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        guardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        botonDes = new javax.swing.JButton();
        precio = new javax.swing.JTextField();
        combo3D = new javax.swing.JComboBox<>();
        comboSub = new javax.swing.JComboBox<>();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jDesktopPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        guardar.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 14)); // NOI18N
        guardar.setText("Guardar Cambios");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        jDesktopPane1.add(guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 590, 160, 40));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Idioma", "3D", "Subtitulos", "Hora Inicio", "Hora Fin", "Butacas disp", "Precio", "Id Proyeccion", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
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
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
            jTable1.getColumnModel().getColumn(6).setResizable(false);
            jTable1.getColumnModel().getColumn(7).setResizable(false);
            jTable1.getColumnModel().getColumn(8).setResizable(false);
        }

        jDesktopPane1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 865, 300));

        jButton4.setBackground(new java.awt.Color(215, 0, 0));
        jButton4.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 0, 0));
        jButton4.setText("Volver");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jDesktopPane1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 590, 110, 40));

        botonDes.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 14)); // NOI18N
        botonDes.setText("Deshabilitar proyección");
        botonDes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDesActionPerformed(evt);
            }
        });
        jDesktopPane1.add(botonDes, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 430, 200, 40));
        jDesktopPane1.add(precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 540, 230, -1));

        combo3D.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));
        combo3D.setSelectedIndex(-1);
        jDesktopPane1.add(combo3D, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 480, 230, -1));

        comboSub.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));
        comboSub.setSelectedIndex(-1);
        jDesktopPane1.add(comboSub, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 510, 230, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Español", "Ingles" }));
        jComboBox1.setSelectedIndex(-1);
        jDesktopPane1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 450, 230, -1));

        jLabel6.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Modificar Proyección");
        jLabel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jDesktopPane1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, 240, 60));

        jLabel10.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Precio:");
        jDesktopPane1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 540, 106, 24));

        jLabel11.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Idioma:");
        jDesktopPane1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, 106, 24));

        jLabel12.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Es 3D:");
        jDesktopPane1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 480, 106, 24));

        jLabel13.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Subtítulos:");
        jDesktopPane1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 510, 106, 24));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Proyeccion200-112.jpg"))); // NOI18N
        jDesktopPane1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 450, -1, -1));

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

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        int fila = (int)jTable1.getSelectedRow();
        Boolean es3D = true;
        Boolean sub = true;
        int es3DI = -1;
        int subI = -1;
        if(fila != -1){
            es3DI = combo3D.getSelectedIndex();
            subI = comboSub.getSelectedIndex();
            switch (es3DI) {
                case 0:
                    es3D = true;
                    break;
                case 1:
                    es3D = false;
                    break;
            }
            switch (subI) {
                case 0:
                    sub = true;
                    break;
                case 1:
                    sub = false;
                    break;
            }
            
            int idiomaI = jComboBox1.getSelectedIndex();
            String idiomaST = "";
            if(idiomaI == 1){
                idiomaST = "Español";
            }else{
                idiomaST = "Ingles";
            }
            
            Double precioST = Double.parseDouble(precio.getText());
            
            
            ProyeccionData pd = null;
            try {
                pd = new ProyeccionData();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
            
            pd.modificarFuncion(idiomaST, es3D, sub, precioST, (int)jTable1.getValueAt(fila, 7));
            
            try {
                tablaProyecciones();
            } catch (Exception e) {
                System.out.println("ERROR " + e.getMessage());
            }
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar una proyección.");
        }
    }//GEN-LAST:event_guardarActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void botonDesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDesActionPerformed
        int fila = -1;
        fila = jTable1.getSelectedRow();
        if(fila != -1){
            Boolean estado = (Boolean)jTable1.getValueAt(fila, 8);
            if(estado){
                ProyeccionData pd = null;
                try {
                    pd = new ProyeccionData();
                } catch (Exception e) {
                    System.out.println("ERROR " + e.getMessage());
                }
                
                pd.deshabilitarFuncion((int)jTable1.getValueAt(fila, 7));
                try {
                    tablaProyecciones();
                } catch (Exception e) {
                    System.out.println("ERROR " + e.getMessage());
                }
            }
        }else{
            JOptionPane.showMessageDialog(null,"No seleccionó ninguna proyección");
        }
    }//GEN-LAST:event_botonDesActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int fila = jTable1.getSelectedRow();
        
        String idioma = (String)jTable1.getValueAt(fila, 0);
        if(idioma.equals("Español")){
            jComboBox1.setSelectedIndex(0);
        }else{
            jComboBox1.setSelectedIndex(1);
        }
        Boolean es3D = (Boolean)jTable1.getValueAt(fila, 1);
        if(es3D){
            combo3D.setSelectedIndex(0);
        }else{
            combo3D.setSelectedIndex(1);
        }
        Boolean sub = (Boolean)jTable1.getValueAt(fila, 2);
        if(sub){
            comboSub.setSelectedIndex(0);
        }else{
            comboSub.setSelectedIndex(1);
        }
        
        Double precioD = (Double)jTable1.getValueAt(fila, 6);
        
        precio.setText(String.valueOf(precioD));
    }//GEN-LAST:event_jTable1MouseClicked
    
    public void tablaProyecciones() throws SQLException {
        List<Proyeccion> proy = new ProyeccionData().listarProyecciones();

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Idioma");
        modelo.addColumn("3D");
        modelo.addColumn("Subtitulos");
        modelo.addColumn("Hora Inicio");
        modelo.addColumn("Hora Fin");
        modelo.addColumn("Butacas disp");
        modelo.addColumn("Precio");
        modelo.addColumn("id Proyeccion");
        modelo.addColumn("Estado");

        for (Proyeccion p : proy) {
            modelo.addRow(new Object[]{
                p.getIdioma(), p.isEs3D(), p.isSubtitulada(), p.getHoraInicio(), p.getHoraFin(), p.getLugaresDisponibles(), p.getPrecioDelLugar(), p.getCodProyeccion(), p.getEstado()
            });
        }
        
        jTable1.setModel(modelo);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonDes;
    private javax.swing.JComboBox<String> combo3D;
    private javax.swing.JComboBox<String> comboSub;
    private javax.swing.JButton guardar;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField precio;
    // End of variables declaration//GEN-END:variables
}
