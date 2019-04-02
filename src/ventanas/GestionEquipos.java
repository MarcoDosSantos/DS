package ventanas;

import clases.Conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GestionEquipos extends javax.swing.JFrame {

    private String usuario1 = new Login().usuario;
    private DefaultTableModel modelo = new DefaultTableModel();
    private String equipos[] = new String[4];
    public static String ID_EQUIPO;

    public GestionEquipos() {
        initComponents();
        setSize(650, 430);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Gestión de equipos - Sesion de " + usuario1);
        //La siguiente línea de código sirve para agregar la imagen al JLabel_wallpaper.
        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperprincipal.png");
        // Creamos la instancia de ImageIcon, vinculándola a la imagen que queremos utilizar como fondo.
        // En el próximo bloque de código, vamos a crear una instancia de la clase Icon, porque nos va a servir
        // para indicarle al programa, que queremos que distribuya y escale el wallpaper al tamaño entero del JLabel_wallpaper.
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_wallpaper.getWidth(),
                jLabel_wallpaper.getHeight(), Image.SCALE_DEFAULT));
        // Ahora le indicamos a jLaber_wallpaper, que incorpore el icono.
        jLabel_wallpaper.setIcon(icono);
        this.repaint();
        establecerModeloTabla();
        llenarTabla();
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png"));
        return retValue;
    }

    public void establecerModeloTabla() {
        modelo.addColumn("");
        modelo.addColumn("Tipo");
        modelo.addColumn("Marca");
        modelo.addColumn("Estado");
        jTable1.setModel(modelo);
    }

    public void llenarTabla() {
        
        String itemSeleccionado = jComboBox_estado.getSelectedItem().toString().trim();
        
        if (jComboBox_estado.getSelectedItem().equals("Todos")) {

            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement("select * from equipos");// Prueba
                ResultSet rs = pst.executeQuery();

                while(rs.next()) {
                    equipos[0] = rs.getString("id_equipo");
                    equipos[1] = rs.getString("tipo_equipo");
                    equipos[2] = rs.getString("marca");
                    equipos[3] = rs.getString("estado");
                    modelo.addRow(equipos);
                } 

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error: " + e);
            }

        } else {
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select * from equipos where estado = '" + itemSeleccionado + "'");
                
                ResultSet rs = pst.executeQuery();

                while(rs.next()) {
                    equipos[0] = rs.getString("id_equipo");
                    equipos[1] = rs.getString("tipo_equipo");
                    equipos[2] = rs.getString("marca");
                    equipos[3] = rs.getString("estado");
                    modelo.addRow(equipos);
                } 

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error: " + e);
            }        
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_gestion_equipos = new javax.swing.JLabel();
        jComboBox_estado = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel_footer = new javax.swing.JLabel();
        jButton_mostrar = new javax.swing.JButton();
        jLabel_wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_gestion_equipos.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel_gestion_equipos.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_gestion_equipos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_gestion_equipos.setText("Equipos registrados");
        getContentPane().add(jLabel_gestion_equipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 600, -1));

        jComboBox_estado.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jComboBox_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Nuevo ingreso", "No reparado", "En revisión", "Reparado", "Entregado", "" }));
        getContentPane().add(jComboBox_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "", "Tipo", "Marca", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 590, 200));

        jLabel_footer.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_footer.setText("Creado por Marco Dos Santos");
        getContentPane().add(jLabel_footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 360, -1, 20));

        jButton_mostrar.setBackground(new java.awt.Color(153, 153, 255));
        jButton_mostrar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton_mostrar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_mostrar.setText("Mostrar");
        jButton_mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_mostrarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_mostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 320, 150, 30));

        jLabel_wallpaper.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_mostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_mostrarActionPerformed
        try {
            jTable1.getModel();
            int filas = jTable1.getRowCount();
            for (int i = 0; filas > i ; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
        llenarTabla();
    }//GEN-LAST:event_jButton_mostrarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int filaSeleccionada = jTable1.getSelectedRow();        
        ID_EQUIPO = jTable1.getValueAt(filaSeleccionada, 0).toString();
        new InformacionDeEquipo().setVisible(true);
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(GestionEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionEquipos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_mostrar;
    private javax.swing.JComboBox<String> jComboBox_estado;
    private javax.swing.JLabel jLabel_footer;
    private javax.swing.JLabel jLabel_gestion_equipos;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
