package Vista;

import Modelo.Pelicula;
import Persistencia.PeliculaData;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jeremias
 */
public class crearPelicula extends javax.swing.JInternalFrame {

    public crearPelicula() throws SQLException {

        initComponents();
        tablaPeliculas();
        jDateChooser1.setDate(new Date());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        comboEstado3 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        usuarioNombre3 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        usuarioNombre4 = new javax.swing.JTextField();
        usuarioNombre5 = new javax.swing.JTextField();
        usuarioNombre6 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jDesktopPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 14)); // NOI18N
        jButton1.setText("Confirmar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jDesktopPane1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 501, -1, 36));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Titulo", "Director", "Actores", "Origen", "Genero", "Estreno", "En cartelera"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
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
        }

        jDesktopPane1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 386, 619, 103));

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Actores:");
        jDesktopPane1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 106, 24));

        jLabel5.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Director:");
        jDesktopPane1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 106, 24));

        jButton4.setBackground(new java.awt.Color(215, 0, 0));
        jButton4.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 0, 0));
        jButton4.setText("Volver");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jDesktopPane1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(564, 501, 83, 36));

        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Título:");
        jDesktopPane1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 106, 24));

        comboEstado3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));
        comboEstado3.setSelectedIndex(-1);
        comboEstado3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboEstado3ActionPerformed(evt);
            }
        });
        jDesktopPane1.add(comboEstado3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 227, -1));

        jLabel7.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Género:");
        jDesktopPane1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 106, 24));

        jLabel8.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Origen:");
        jDesktopPane1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 106, 24));
        jDesktopPane1.add(usuarioNombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 227, -1));

        jLabel9.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Crear Película");
        jLabel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jDesktopPane1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 190, 52));
        jDesktopPane1.add(usuarioNombre4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 227, -1));
        jDesktopPane1.add(usuarioNombre5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 227, -1));
        jDesktopPane1.add(usuarioNombre6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 227, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Infantil", "Terror", "Comedia", "Drama", "Suspenso", "Acción" }));
        jComboBox1.setSelectedIndex(-1);
        jComboBox1.setToolTipText("");
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jDesktopPane1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 227, -1));
        jDesktopPane1.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 227, -1));

        jLabel11.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("En cartelera:");
        jDesktopPane1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 106, 24));

        jLabel12.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Estreno:");
        jDesktopPane1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 106, 24));

        jLabel13.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Películas:");
        jDesktopPane1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 356, -1, 24));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/crear_pelicula200-200.png"))); // NOI18N
        jDesktopPane1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, 200, 200));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int i = 0;
        while (!usuarioNombre4.getText().equals("") && !usuarioNombre5.getText().equals("") && !usuarioNombre6.getText().equals("") && !usuarioNombre3.getText().equals("")
                && jComboBox1.getSelectedIndex() != -1 && comboEstado3.getSelectedIndex() != -1) {

            String titulo = usuarioNombre4.getText();
            String director = usuarioNombre5.getText();
            String actores = usuarioNombre6.getText();
            String origen = usuarioNombre3.getText();
            int genero = jComboBox1.getSelectedIndex(); // Acá hay que convertir
            String generoSt = "";

            switch (genero) {
                case 0:
                    generoSt = "Infantil";
                    break;
                case 1:
                    generoSt = "Terror";
                    break;
                case 2:
                    generoSt = "Comedia";
                    break;
                case 3:
                    generoSt = "Drama";
                    break;
                case 4:
                    generoSt = "Suspenso";
                    break;
                case 5:
                    generoSt = "Acción";
                    break;
            }
            Date fechin = null;
            try {
                fechin = jDateChooser1.getDate();
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(this, "No puede no seleccionar una fecha.");
            }

            int enCartelera = comboEstado3.getSelectedIndex();
            Boolean enCarteleraBo = true;
            switch (enCartelera) {
                case 0:
                    enCarteleraBo = true;
                    break;
                case 1:
                    enCarteleraBo = false;
                    break;
            }

            // String titulo, String director, String actores, String origen, String genero, LocalDate estreno, boolean enCartelera
            Pelicula nuevaPeli = new Pelicula(titulo, director, actores, origen, generoSt, fechin, enCarteleraBo);
            PeliculaData pd = null;
            try {
                pd = new PeliculaData();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "No se pudo acceder a la base de datos.");
            }

            pd.crearPelicula(nuevaPeli);

            try {
                tablaPeliculas();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "No se pudo acceder a la base de datos.");
            }

            // limpiamos todos los campos luego de crear la película
            usuarioNombre4.setText("");
            usuarioNombre5.setText("");
            usuarioNombre6.setText("");
            usuarioNombre3.setText("");
            jComboBox1.setSelectedIndex(-1);
            comboEstado3.setSelectedIndex(-1);
            jDateChooser1.setDate(new Date());
            i++;
        }
        if (i == 0) {
            JOptionPane.showMessageDialog(this, "Por favor complete todos los campos.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.dispose();
        // jDesktopPane1.removeAll();
        // jDesktopPane1.repaint();
        // vistaAdmin aux = new vistaAdmin();
        // aux.setVisible(true);
        // jDesktopPane1.add(aux);
        // jDesktopPane1.moveToFront(aux);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void comboEstado3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboEstado3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboEstado3ActionPerformed

    public void tablaPeliculas() throws SQLException {
        List<Pelicula> pelis = new PeliculaData().listarPeliculas();

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Titulo");
        modelo.addColumn("Director");
        modelo.addColumn("Actores");
        modelo.addColumn("Origen");
        modelo.addColumn("Genero");
        modelo.addColumn("Estreno");
        modelo.addColumn("En Cartelera");

        for (Pelicula p : pelis) {
            modelo.addRow(new Object[]{
                p.getTitulo(), p.getDirector(), p.getActores(), p.getOrigen(), p.getGenero(), p.getEstreno(), p.isEnCartelera()
            });
        }

        jTable1.setModel(modelo);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboEstado3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField usuarioNombre3;
    private javax.swing.JTextField usuarioNombre4;
    private javax.swing.JTextField usuarioNombre5;
    private javax.swing.JTextField usuarioNombre6;
    // End of variables declaration//GEN-END:variables
}
