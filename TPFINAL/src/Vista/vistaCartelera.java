package Vista;

import Modelo.Asiento;
import Modelo.DetalleTicket;
import Modelo.Proyeccion;
import Modelo.Ticket;
import Persistencia.AsientoData;
import Persistencia.DetalleTicketData;
import Persistencia.ProyeccionData;
import Persistencia.TicketData;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

public class vistaCartelera extends javax.swing.JInternalFrame {

    public vistaCartelera() throws SQLException {
        initComponents();
        tablaCartelera();
        despintarAsientos();
        descontarLugaresOcupados();
        JOptionPane.showMessageDialog(null, "Seleccione una pelicula en la tabla para ver los lugares disponibles.");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        comboA1 = new javax.swing.JCheckBox();
        comboA2 = new javax.swing.JCheckBox();
        comboA3 = new javax.swing.JCheckBox();
        comboA4 = new javax.swing.JCheckBox();
        comboA5 = new javax.swing.JCheckBox();
        comboB1 = new javax.swing.JCheckBox();
        comboB2 = new javax.swing.JCheckBox();
        comboB3 = new javax.swing.JCheckBox();
        comboB5 = new javax.swing.JCheckBox();
        comboB4 = new javax.swing.JCheckBox();
        comboC1 = new javax.swing.JCheckBox();
        comboC2 = new javax.swing.JCheckBox();
        comboC3 = new javax.swing.JCheckBox();
        comboC4 = new javax.swing.JCheckBox();
        comboC5 = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Titulo", "3D", "Subtitulada", "Duración", "Lugares disp", "Precio", "ID Proyeccion", "Fecha funcion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
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
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(15);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(15);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(20);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(10);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(20);
            jTable1.getColumnModel().getColumn(6).setResizable(false);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(10);
            jTable1.getColumnModel().getColumn(7).setResizable(false);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(50);
        }

        jButton5.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 14)); // NOI18N
        jButton5.setText("Comprar Tickets");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cartelera");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton7.setBackground(new java.awt.Color(215, 0, 0));
        jButton7.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(0, 0, 0));
        jButton7.setText("Volver");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        comboA1.setText("A-1");
        comboA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboA1ActionPerformed(evt);
            }
        });

        comboA2.setText("A-2");
        comboA2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboA2ActionPerformed(evt);
            }
        });

        comboA3.setText("A-3");
        comboA3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboA3ActionPerformed(evt);
            }
        });

        comboA4.setText("A-4");
        comboA4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboA4ActionPerformed(evt);
            }
        });

        comboA5.setText("A-5");
        comboA5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboA5ActionPerformed(evt);
            }
        });

        comboB1.setText("B-1");
        comboB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboB1ActionPerformed(evt);
            }
        });

        comboB2.setText("B-2");
        comboB2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboB2ActionPerformed(evt);
            }
        });

        comboB3.setText("B-3");
        comboB3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboB3ActionPerformed(evt);
            }
        });

        comboB5.setText("B-5");
        comboB5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboB5ActionPerformed(evt);
            }
        });

        comboB4.setText("B-4");
        comboB4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboB4ActionPerformed(evt);
            }
        });

        comboC1.setText("C-1");
        comboC1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboC1ActionPerformed(evt);
            }
        });

        comboC2.setText("C-2");
        comboC2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboC2ActionPerformed(evt);
            }
        });

        comboC3.setText("C-3");
        comboC3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboC3ActionPerformed(evt);
            }
        });

        comboC4.setText("C-4");
        comboC4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboC4ActionPerformed(evt);
            }
        });

        comboC5.setText("C-5");
        comboC5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboC5ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Seleccione MÍNIMO uno, MÁXIMO dos asientos:");

        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("PANTALLA");

        jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(comboA1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(comboA2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(comboA3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(comboA4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(comboA5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(comboB1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(comboB2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(comboB3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(comboB5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(comboB4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(comboC1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(comboC2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(comboC3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(comboC4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(comboC5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(280, 280, 280)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 754, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(356, 356, 356)
                        .addComponent(jLabel3))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(comboA1)
                        .addGap(18, 18, 18)
                        .addComponent(comboA2)
                        .addGap(18, 18, 18)
                        .addComponent(comboA3)
                        .addGap(18, 18, 18)
                        .addComponent(comboA4)
                        .addGap(18, 18, 18)
                        .addComponent(comboA5)
                        .addGap(82, 82, 82)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(247, 247, 247)
                        .addComponent(comboB1)
                        .addGap(19, 19, 19)
                        .addComponent(comboB2)
                        .addGap(18, 18, 18)
                        .addComponent(comboB3)
                        .addGap(18, 18, 18)
                        .addComponent(comboB4)
                        .addGap(21, 21, 21)
                        .addComponent(comboB5))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(247, 247, 247)
                        .addComponent(comboC1)
                        .addGap(18, 18, 18)
                        .addComponent(comboC2)
                        .addGap(18, 18, 18)
                        .addComponent(comboC3)
                        .addGap(18, 18, 18)
                        .addComponent(comboC4)
                        .addGap(18, 18, 18)
                        .addComponent(comboC5)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel3)
                .addGap(1, 1, 1)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboA1)
                            .addComponent(comboA2)
                            .addComponent(comboA3)
                            .addComponent(comboA4)
                            .addComponent(comboA5))))
                .addGap(6, 6, 6)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboB1)
                    .addComponent(comboB2)
                    .addComponent(comboB3)
                    .addComponent(comboB4)
                    .addComponent(comboB5))
                .addGap(6, 6, 6)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboC1)
                    .addComponent(comboC2)
                    .addComponent(comboC3)
                    .addComponent(comboC4)
                    .addComponent(comboC5))
                .addContainerGap(37, Short.MAX_VALUE))
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

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int fila = -1;
        fila = jTable1.getSelectedRow();
        JCheckBox[] checks = {comboA1, comboA2, comboA3, comboA4, comboA5,
            comboB1, comboB2, comboB3, comboB4, comboB5,
            comboC1, comboC2, comboC3, comboC4, comboC5};
        List<Integer> chSel = new ArrayList<>();
        Asiento asientito = null;
        Asiento[] asientote = null;
        if (fila != -1) {

            for (int i = 0; i < checks.length; i++) {
                if (checks[i].isSelected()) {
                    chSel.add(i);
                }
            }

            if (chSel.size() == 1) {
                asientote = new Asiento[2];
                AsientoData ad = null;
                DetalleTicket dT = new DetalleTicket();

                try {
                    ad = new AsientoData();
                } catch (Exception e) {
                    System.out.println("ERROR " + e.getMessage());
                }

                for (int t = 0; t < chSel.size(); t++) {
                    asientote[t] = new Asiento();

                    asientote[t].setCodProyeccion((int) jTable1.getValueAt(fila, 6));
                    asientote[t].setEstado(false);

                    switch (chSel.get(t)) {
                        case 0:
                            asientote[t].setFila('A');
                            asientote[t].setNumero(1);
                            break;
                        case 1:
                            asientote[t].setFila('A');
                            asientote[t].setNumero(2);
                            break;
                        case 2:
                            asientote[t].setFila('A');
                            asientote[t].setNumero(3);

                            break;
                        case 3:
                            asientote[t].setFila('A');
                            asientote[t].setNumero(4);
                            break;
                        case 4:
                            asientote[t].setFila('A');
                            asientote[t].setNumero(5);
                            break;

                        case 5:
                            asientote[t].setFila('B');
                            asientote[t].setNumero(1);
                            break;
                        case 6:
                            asientote[t].setFila('B');
                            asientote[t].setNumero(2);
                            break;
                        case 7:
                            asientote[t].setFila('B');
                            asientote[t].setNumero(3);
                            break;
                        case 8:
                            asientote[t].setFila('B');
                            asientote[t].setNumero(4);
                            break;
                        case 9:
                            asientote[t].setFila('B');
                            asientote[t].setNumero(5);
                            break;

                        case 10:
                            asientote[t].setFila('C');
                            asientote[t].setNumero(1);
                            break;
                        case 11:
                            asientote[t].setFila('C');
                            asientote[t].setNumero(2);
                            break;
                        case 12:
                            asientote[t].setFila('C');
                            asientote[t].setNumero(3);
                            break;
                        case 13:
                            asientote[t].setFila('C');
                            asientote[t].setNumero(4);
                            break;
                        case 14:
                            asientote[t].setFila('C');
                            asientote[t].setNumero(5);
                            break;
                    }
                    int idAsientote = ad.crearAsiento(asientote[t]);
                    TicketData td = null;
                    try {
                        td = new TicketData();
                    } catch (Exception e) {
                        System.out.println("ERROR " + e.getMessage());
                    }

                    Ticket[] tick = new Ticket[2];
                    tick[t] = new Ticket();
                    tick[t].setCodProyeccion((int) jTable1.getValueAt(fila, 6));
                    tick[t].setMonto((double) jTable1.getValueAt(fila, 5));
                    tick[t].setEstado(true);
                    java.sql.Date fechaSQL = java.sql.Date.valueOf(LocalDate.now());
                    tick[t].setFechaCompra(fechaSQL);
                    tick[t].setDniComprador(vistaLogin.user);
                    int idTic = td.crearTicket(tick[t]);
                    System.out.println(idTic + " SOY EL ID DE TICKET");
                    
                    dT.setIdProyeccion((int) jTable1.getValueAt(fila, 6));
                    dT.setTotal((double) jTable1.getValueAt(fila, 5));
                    dT.setEstado(true);
                    dT.setCodAsiento(idAsientote);
                    dT.setCodAsiento2(-1);
                    dT.setIdTicket(idTic);
                    
                    DetalleTicketData dtd = null;
                    try {
                        dtd = new DetalleTicketData();
                    } catch (Exception e) {
                        System.out.println("ERROR " + e.getMessage());
                    }
                    
                    dtd.crearDetalleTicketP1(dT);
                    
                }
                JOptionPane.showMessageDialog(null, "Ticket comprado con éxito.\n\n¡Disfrute la pelicula!");
                this.dispose();

            } else if (chSel.size() == 2) {
                AsientoData ad = null;
                DetalleTicket dT = new DetalleTicket();
                try {
                    ad = new AsientoData();
                } catch (Exception e) {
                    System.out.println("ERROR " + e.getMessage());
                }

                for (int t = 0; t < chSel.size(); t++) {

                    asientito = new Asiento();
                    asientito.setCodProyeccion((int) jTable1.getValueAt(fila, 6));
                    asientito.setEstado(false);

                    switch (chSel.get(t)) {
                        case 0:
                            asientito.setFila('A');
                            asientito.setNumero(1);
                            break;
                        case 1:
                            asientito.setFila('A');
                            asientito.setNumero(2);
                            break;
                        case 2:
                            asientito.setFila('A');
                            asientito.setNumero(3);

                            break;
                        case 3:
                            asientito.setFila('A');
                            asientito.setNumero(4);
                            break;
                        case 4:
                            asientito.setFila('A');
                            asientito.setNumero(5);
                            break;

                        case 5:
                            asientito.setFila('B');
                            asientito.setNumero(1);
                            break;
                        case 6:
                            asientito.setFila('B');
                            asientito.setNumero(2);
                            break;
                        case 7:
                            asientito.setFila('B');
                            asientito.setNumero(3);
                            break;
                        case 8:
                            asientito.setFila('B');
                            asientito.setNumero(4);
                            break;
                        case 9:
                            asientito.setFila('B');
                            asientito.setNumero(5);
                            break;

                        case 10:
                            asientito.setFila('C');
                            asientito.setNumero(1);
                            break;
                        case 11:
                            asientito.setFila('C');
                            asientito.setNumero(2);
                            break;
                        case 12:
                            asientito.setFila('C');
                            asientito.setNumero(3);
                            break;
                        case 13:
                            asientito.setFila('C');
                            asientito.setNumero(4);
                            break;
                        case 14:
                            asientito.setFila('C');
                            asientito.setNumero(5);
                            break;
                    }
                    int idAsientito = ad.crearAsiento(asientito);
                    TicketData td = null;
                    try {
                        td = new TicketData();
                    } catch (Exception e) {
                        System.out.println("ERROR " + e.getMessage());
                    }

                    Ticket tic = new Ticket();
                    tic.setCodProyeccion((int) jTable1.getValueAt(fila, 6));
                    tic.setMonto((double) jTable1.getValueAt(fila, 5));
                    tic.setEstado(true);
                    java.sql.Date fechaSQL = java.sql.Date.valueOf(LocalDate.now());
                    tic.setFechaCompra(fechaSQL);
                    tic.setDniComprador(vistaLogin.user);
                    int idTicki = td.crearTicket(tic);
                    
                    if (t == 0) {
                        dT.setCodAsiento(idAsientito);
                    } else if (t == 1) {
                        dT.setIdProyeccion((int) jTable1.getValueAt(fila, 6));
                        dT.setTotal((double) jTable1.getValueAt(fila, 5) * 2);
                        dT.setIdTicket(idTicki);
                        dT.setEstado(true);
                        dT.setCodAsiento2(idAsientito);

                        DetalleTicketData dtd = null;
                        try {
                            dtd = new DetalleTicketData();
                        } catch (Exception e) {
                            System.out.println("ERROR " + e.getMessage());
                        }

                        dtd.crearDetalleTicket(dT);
                    }
                    

                }
                JOptionPane.showMessageDialog(null, "Tickets comprados con éxito.\n\n¡Disfruten la pelicula!");
                this.dispose();
                
            } else{
                JOptionPane.showMessageDialog(null, "Mínimo UN asiento, máximo DOS asientos.");
            }
        }


    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void comboA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboA1ActionPerformed

    }//GEN-LAST:event_comboA1ActionPerformed

    private void comboA2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboA2ActionPerformed

    }//GEN-LAST:event_comboA2ActionPerformed

    private void comboA3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboA3ActionPerformed

    }//GEN-LAST:event_comboA3ActionPerformed

    private void comboA4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboA4ActionPerformed

    }//GEN-LAST:event_comboA4ActionPerformed

    private void comboA5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboA5ActionPerformed

    }//GEN-LAST:event_comboA5ActionPerformed

    private void comboB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboB1ActionPerformed

    }//GEN-LAST:event_comboB1ActionPerformed

    private void comboB2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboB2ActionPerformed

    }//GEN-LAST:event_comboB2ActionPerformed

    private void comboB3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboB3ActionPerformed

    }//GEN-LAST:event_comboB3ActionPerformed

    private void comboB5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboB5ActionPerformed

    }//GEN-LAST:event_comboB5ActionPerformed

    private void comboB4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboB4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboB4ActionPerformed

    private void comboC1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboC1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboC1ActionPerformed

    private void comboC2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboC2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboC2ActionPerformed

    private void comboC3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboC3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboC3ActionPerformed

    private void comboC4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboC4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboC4ActionPerformed

    private void comboC5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboC5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboC5ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        pintarAsientos();
        int fila = jTable1.getSelectedRow();
        List<Asiento> asientoOcup = null;
        int idProy = (int) jTable1.getValueAt(fila, 6);

        try {
            asientoOcup = new AsientoData().asientosOcupados(idProy);
        } catch (SQLException ex) {
            System.out.println("Error " + ex.getMessage());
        }

        for (Asiento a : asientoOcup) {
            String filaNumero = a.getFila() + String.valueOf(a.getNumero());
            if (!a.isEstado()) {
                switch (filaNumero) {
                    case "A1":
                        comboA1.setVisible(false);
                        break;
                    case "A2":
                        comboA2.setVisible(false);
                        break;
                    case "A3":
                        comboA3.setVisible(false);
                        break;
                    case "A4":
                        comboA4.setVisible(false);
                        break;
                    case "A5":
                        comboA5.setVisible(false);
                        break;

                    case "B1":
                        comboB1.setVisible(false);
                        break;
                    case "B2":
                        comboB2.setVisible(false);
                        break;
                    case "B3":
                        comboB3.setVisible(false);
                        break;
                    case "B4":
                        comboB4.setVisible(false);
                        break;
                    case "B5":
                        comboB5.setVisible(false);
                        break;

                    case "C1":
                        comboC1.setVisible(false);
                        break;
                    case "C2":
                        comboC2.setVisible(false);
                        break;
                    case "C3":
                        comboC3.setVisible(false);
                        break;
                    case "C4":
                        comboC4.setVisible(false);
                        break;
                    case "C5":
                        comboC5.setVisible(false);
                        break;
                }
            }
        }


    }//GEN-LAST:event_jTable1MouseClicked

    public void tablaCartelera() throws SQLException {
        List<Proyeccion> cartelera = new ProyeccionData().listarCartelera();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Titulo");
        modelo.addColumn("3D");
        modelo.addColumn("Subtitulada");
        modelo.addColumn("Duracion");
        modelo.addColumn("Lugares disp");
        modelo.addColumn("Precio");
        modelo.addColumn("ID Proyeccion");
        modelo.addColumn("Fecha funcion");

        for (Proyeccion p : cartelera) {
            int horaInicio = Integer.parseInt(p.getHoraInicio().split(":")[0]);
            int minutoInicio = Integer.parseInt(p.getHoraInicio().split(":")[1]);

            int horaFin = Integer.parseInt(p.getHoraFin().split(":")[0]);
            int minutoFin = Integer.parseInt(p.getHoraFin().split(":")[1]);

            int minutosDuracion = ((horaFin * 60) + minutoFin) - ((horaInicio * 60) + minutoInicio);

            if (p.getEstado()) {
                modelo.addRow(new Object[]{
                    p.getTitulo(), p.isEs3D(), p.isSubtitulada(), minutosDuracion, p.getLugaresDisponibles(), p.getPrecioDelLugar(), p.getCodProyeccion(), p.getFechaFuncion()
                });
            }
        }
        jTable1.setModel(modelo);
    }

    public void pintarAsientos() {
        jLabel2.setVisible(true);
        jLabel3.setVisible(true);
        comboA1.setVisible(true);
        comboA2.setVisible(true);
        comboA3.setVisible(true);
        comboA4.setVisible(true);
        comboA5.setVisible(true);

        comboB1.setVisible(true);
        comboB2.setVisible(true);
        comboB3.setVisible(true);
        comboB4.setVisible(true);
        comboB5.setVisible(true);

        comboC1.setVisible(true);
        comboC2.setVisible(true);
        comboC3.setVisible(true);
        comboC4.setVisible(true);
        comboC5.setVisible(true);
    }

    public void despintarAsientos() {
        jLabel2.setVisible(false);
        jLabel3.setVisible(false);
        comboA1.setVisible(false);
        comboA2.setVisible(false);
        comboA3.setVisible(false);
        comboA4.setVisible(false);
        comboA5.setVisible(false);

        comboB1.setVisible(false);
        comboB2.setVisible(false);
        comboB3.setVisible(false);
        comboB4.setVisible(false);
        comboB5.setVisible(false);

        comboC1.setVisible(false);
        comboC2.setVisible(false);
        comboC3.setVisible(false);
        comboC4.setVisible(false);
        comboC5.setVisible(false);
    }

    public void descontarLugaresOcupados() {
        ProyeccionData pd = null;
        try {
            pd = new ProyeccionData();
        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());
        }
        List<Proyeccion> lo = pd.modificarLugaresDisponibles();

        for (int i = 0; i < jTable1.getRowCount(); i++) {
            int codProy = (int) jTable1.getValueAt(i, 6);

            for (Proyeccion p : lo) {
                if (p.getCodProyeccion() == codProy) {
                    jTable1.setValueAt(15 - p.getLugaresDisponibles(), i, 4);
                }
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox comboA1;
    private javax.swing.JCheckBox comboA2;
    private javax.swing.JCheckBox comboA3;
    private javax.swing.JCheckBox comboA4;
    private javax.swing.JCheckBox comboA5;
    private javax.swing.JCheckBox comboB1;
    private javax.swing.JCheckBox comboB2;
    private javax.swing.JCheckBox comboB3;
    private javax.swing.JCheckBox comboB4;
    private javax.swing.JCheckBox comboB5;
    private javax.swing.JCheckBox comboC1;
    private javax.swing.JCheckBox comboC2;
    private javax.swing.JCheckBox comboC3;
    private javax.swing.JCheckBox comboC4;
    private javax.swing.JCheckBox comboC5;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
