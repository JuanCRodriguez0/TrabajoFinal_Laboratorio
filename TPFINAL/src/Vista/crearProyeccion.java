/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vista;

import Modelo.Pelicula;
import Modelo.Proyeccion;
import Modelo.Sala;
import Persistencia.PeliculaData;
import Persistencia.ProyeccionData;
import Persistencia.SalaData;
import java.sql.SQLException;
import java.util.List;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class crearProyeccion extends javax.swing.JInternalFrame {

    public crearProyeccion() throws SQLException {
        initComponents();
        tablaProyecciones();
        rellenarComboBoxPeliculas();
        jComboBox3.setSelectedIndex(-1);
        rellenarComboBoxSala();
        jComboBox4.setSelectedIndex(-1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        usuarioNombre1 = new javax.swing.JTextField();
        comboEstado2 = new javax.swing.JComboBox<>();
        comboEstado3 = new javax.swing.JComboBox<>();
        comboEstado4 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        fechaFuncion = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jDesktopPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Confirmar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jDesktopPane1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 505, 150, 35));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Idioma", "3D", "Subtitulos", "Hora Inicio", "Hora Fin", "Butacas disp", "Precio", "Estado", "Fecha funcion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
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
            jTable1.getColumnModel().getColumn(7).setResizable(false);
            jTable1.getColumnModel().getColumn(8).setResizable(false);
        }

        jDesktopPane1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 374, 755, 119));

        jButton4.setBackground(new java.awt.Color(215, 0, 0));
        jButton4.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 0, 0));
        jButton4.setText("Volver");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jDesktopPane1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(695, 505, 148, 35));

        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Idioma:");
        jDesktopPane1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 108, 106, 24));
        jDesktopPane1.add(usuarioNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 254, 333, -1));

        comboEstado2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));
        comboEstado2.setSelectedIndex(-1);
        jDesktopPane1.add(comboEstado2, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 140, 339, -1));

        comboEstado3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));
        comboEstado3.setSelectedIndex(-1);
        jDesktopPane1.add(comboEstado3, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 164, 339, -1));

        comboEstado4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Espanol", "Ingles" }));
        comboEstado4.setSelectedIndex(-1);
        jDesktopPane1.add(comboEstado4, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 106, 338, -1));

        jLabel9.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Crear Proyección");
        jLabel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jDesktopPane1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 25, 204, 54));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "16:00", "16:30", "17:00", "17:30", "18:00", "18:30" }));
        jComboBox1.setSelectedIndex(-1);
        jDesktopPane1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 198, 333, -1));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", " " }));
        jComboBox2.setSelectedIndex(-1);
        jDesktopPane1.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 226, 333, -1));

        jDesktopPane1.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 282, 333, -1));

        jDesktopPane1.add(jComboBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 140, 220, -1));
        jDesktopPane1.add(fechaFuncion, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 110, 120, -1));

        jLabel12.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Es 3D:");
        jDesktopPane1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 138, 106, 24));

        jLabel13.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Subtítulos:");
        jDesktopPane1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 162, 106, 24));

        jLabel14.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Hora de fin:");
        jDesktopPane1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 220, 106, 24));

        jLabel15.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Hora de inicio:");
        jDesktopPane1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 192, 106, 24));

        jLabel16.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Precio:");
        jDesktopPane1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 250, 106, 24));

        jLabel17.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Sala:");
        jDesktopPane1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 140, -1, 24));

        jLabel18.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("Películas:");
        jDesktopPane1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 280, 106, 24));

        jLabel19.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Proyecciones existentes:");
        jDesktopPane1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 344, -1, 24));

        jLabel20.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Fecha de la función:");
        jDesktopPane1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 110, -1, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Proyeccion200-112.jpg"))); // NOI18N
        jDesktopPane1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 190, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (comboEstado4.getSelectedIndex() != -1 && comboEstado2.getSelectedIndex() != -1 && comboEstado3.getSelectedIndex() != -1
                && jComboBox1.getSelectedIndex() != -1 && jComboBox2.getSelectedIndex() != -1 && !usuarioNombre1.getText().equals("")
                && jComboBox3.getSelectedIndex() != -1 && jComboBox4.getSelectedIndex() != -1) {
            int idioma = comboEstado4.getSelectedIndex();
            String idiomaST = "";
            switch (idioma) {
                case 0:
                    idiomaST = "Español";
                    break;
                case 1:
                    idiomaST = "Ingles";
                    break;
            }
            int tresde = comboEstado2.getSelectedIndex();
            Boolean tresDeST = true;
            switch (tresde) {
                case 0:
                    tresDeST = true;
                    break;
                case 1:
                    tresDeST = false;
                    break;
            }
            int subtitulos = comboEstado3.getSelectedIndex();
            Boolean subtitulosST = true;
            switch (subtitulos) {
                case 0:
                    subtitulosST = true;
                    break;
                case 1:
                    subtitulosST = false;
                    break;
            }
            int horaInicio = jComboBox1.getSelectedIndex();
            String horaInicioST = "";
            switch (horaInicio) {
                case 0:
                    horaInicioST = "16:00";
                    break;
                case 1:
                    horaInicioST = "16:30";
                    break;
                case 2:
                    horaInicioST = "17:00";
                    break;
                case 3:
                    horaInicioST = "17:30";
                    break;
                case 4:
                    horaInicioST = "18:00";
                    break;
                case 5:
                    horaInicioST = "18:30";
                    break;
            }
            int horaFin = jComboBox2.getSelectedIndex();
            String horaFinST = "";
            switch (horaFin) {
                case 0:
                    horaFinST = "18:00";
                    break;
                case 1:
                    horaFinST = "18:30";
                    break;
                case 2:
                    horaFinST = "19:00";
                    break;
                case 3:
                    horaFinST = "19:30";
                    break;
                case 4:
                    horaFinST = "20:00";
                    break;
                case 5:
                    horaFinST = "20:30";
                    break;
            }
            double precio = Double.parseDouble(usuarioNombre1.getText());

            String seleccionado = jComboBox3.getSelectedItem().toString();
            String soloNumero = seleccionado.split(" - ")[0];
            int peliId = Integer.parseInt(soloNumero);

            String seleccionado2 = jComboBox4.getSelectedItem().toString();
            String soloNumero2 = seleccionado2.split(" ")[1];
            int salaID = Integer.parseInt(soloNumero2);
            
            Date fecha = null;
            try {
                fecha = fechaFuncion.getDate();
            } catch (Exception e) {
                System.out.println("ERROR " + e.getMessage());
            }
            
            //int idPelicula, String titulo, String director, String actores, String origen, String genero, Date estreno, boolean enCartelera, int idSala
            Proyeccion p = new Proyeccion(idiomaST, tresDeST, subtitulosST, horaInicioST, horaFinST, precio, peliId, salaID, true,fecha);
            ProyeccionData pd = null;
            try {
                pd = new ProyeccionData();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "No se pudo acceder a la base de datos.");
            }
            pd.crearFuncion(p);

            comboEstado2.setSelectedIndex(-1);
            comboEstado3.setSelectedIndex(-1);
            comboEstado4.setSelectedIndex(-1);
            jComboBox1.setSelectedIndex(-1);
            jComboBox2.setSelectedIndex(-1);
            jComboBox3.setSelectedIndex(-1);
            jComboBox4.setSelectedIndex(-1);
            usuarioNombre1.setText("");
            try {
                tablaProyecciones();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al recargar tabla proyecciones.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor complete todos los campos.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    public void tablaProyecciones() throws SQLException {
        List<Proyeccion> proy = new ProyeccionData().listarCartelera();

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Idioma");
        modelo.addColumn("3D");
        modelo.addColumn("Subtitulos");
        modelo.addColumn("Hora Inicio");
        modelo.addColumn("Hora Fin");
        modelo.addColumn("Butacas disp");
        modelo.addColumn("Precio");
        modelo.addColumn("Fecha funcion");

        for (Proyeccion p : proy) {
            if (p.getEstado()) {
                modelo.addRow(new Object[]{
                    p.getIdioma(), p.isEs3D(), p.isSubtitulada(), p.getHoraInicio(), p.getHoraFin(), p.getLugaresDisponibles(), p.getPrecioDelLugar(), p.getFechaFuncion()
                });
            }
        }

        jTable1.setModel(modelo);

    }

    public void rellenarComboBoxPeliculas() throws SQLException {
        List<Pelicula> pelis = new PeliculaData().listarPeliculas();

        for (Pelicula p : pelis) {
            jComboBox3.addItem(p.getIdPelicula() + " - " + p.getTitulo());
        }
    }

    public void rellenarComboBoxSala() throws SQLException {
        List<Sala> salas = new SalaData().listarSalas();

        for (Sala s : salas) {
            jComboBox4.addItem("Sala " + s.getNroSala());
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboEstado2;
    private javax.swing.JComboBox<String> comboEstado3;
    private javax.swing.JComboBox<String> comboEstado4;
    private com.toedter.calendar.JDateChooser fechaFuncion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField usuarioNombre1;
    // End of variables declaration//GEN-END:variables
}
