/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import clases.Conexion;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.JOptionPane;
import java.util.Date;

/**
 *
 * @author Marco
 */
public class RegistroDeEquipo extends javax.swing.JFrame {

    private String usuario1 = new Login().usuario;

    public RegistroDeEquipo() {
        initComponents();
        setSize(650, 430);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Registro de equipo - Sesion de " + usuario1);
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
        averiguarNombreCliente();
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png"));
        return retValue;
    }

    public void averiguarNombreCliente() {
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select nombre_cliente from clientes where id_cliente = "
                    + ClientesRegistrados.ID);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                jTextField_nombreCliente.setText(rs.getString("nombre_cliente"));

            } else {
                JOptionPane.showMessageDialog(null, "Error al recuperar los datos del usuario.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos: " + e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_registro_equipo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField_nombreCliente = new javax.swing.JTextField();
        jComboBox_tipoEquipo = new javax.swing.JComboBox<>();
        jComboBox_marcaEquipo = new javax.swing.JComboBox<>();
        jTextField_modeloEquipo = new javax.swing.JTextField();
        jTextField_numeroSerie = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_observaciones = new javax.swing.JTextArea();
        jButton_registrarEquipo = new javax.swing.JButton();
        jLabel_wallpaper = new javax.swing.JLabel();
        jLabel_footer = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_registro_equipo.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel_registro_equipo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_registro_equipo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_registro_equipo.setText("Registro de equipo");
        getContentPane().add(jLabel_registro_equipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 600, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre del cliente:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tipo de equipo");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Marca");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Modelo ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Daño reportado y observaciones");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, -1, 20));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Número de serie");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, -1, 20));

        jTextField_nombreCliente.setEditable(false);
        jTextField_nombreCliente.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jTextField_nombreCliente.setForeground(new java.awt.Color(109, 109, 109));
        jTextField_nombreCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_nombreCliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jTextField_nombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 280, 30));

        jComboBox_tipoEquipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Notebook", "Netbook", "Desktop", "Impresora", "Multifunción" }));
        getContentPane().add(jComboBox_tipoEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        jComboBox_marcaEquipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Acer", "Apple", "Asus", "Banghó", "Brother", "Commodore", "Compaq", "Dell", "Epson", "Hewlett Packard", "Lenovo", "Lexmark", "LG", "Sony Vaio", "Xerox", "Otra" }));
        getContentPane().add(jComboBox_marcaEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        jTextField_modeloEquipo.setBackground(new java.awt.Color(153, 153, 255));
        jTextField_modeloEquipo.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jTextField_modeloEquipo.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_modeloEquipo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_modeloEquipo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jTextField_modeloEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 280, 30));

        jTextField_numeroSerie.setBackground(new java.awt.Color(153, 153, 255));
        jTextField_numeroSerie.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jTextField_numeroSerie.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_numeroSerie.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_numeroSerie.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jTextField_numeroSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 280, 30));

        jTextArea_observaciones.setColumns(20);
        jTextArea_observaciones.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextArea_observaciones.setRows(5);
        jScrollPane1.setViewportView(jTextArea_observaciones);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 260, 240));

        jButton_registrarEquipo.setText("Registrar equipo");
        jButton_registrarEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_registrarEquipoActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_registrarEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 320, 190, 30));

        jLabel_wallpaper.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 430));

        jLabel_footer.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_footer.setText("Creado por Marco Dos Santos");
        getContentPane().add(jLabel_footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 380, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_registrarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_registrarEquipoActionPerformed
        Calendar calendario = Calendar.getInstance();
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "insert into equipos values("
                    + "id_equipo = 1, ?,?,?,?,?,?,?,?,?,?,?,?,?)");
            String idCliente = ClientesRegistrados.ID;
            String tipoEquipo = jComboBox_tipoEquipo.getSelectedItem().toString();
            String marca = jComboBox_marcaEquipo.getSelectedItem().toString();
            String modelo = jTextField_modeloEquipo.getText().trim();
            String numSerie = jTextField_numeroSerie.getText().trim();
            String diaIngreso = String.valueOf(calendario.get(Calendar.DAY_OF_MONTH));
            String mesIngreso = String.valueOf(1 + calendario.get(Calendar.MONTH));
            String annioIngreso = String.valueOf(calendario.get(Calendar.YEAR));
            String observaciones = jTextArea_observaciones.getText().trim();
            String estado = "Nuevo ingreso";
            String ultimaModificacion = usuario1;
            String comentariosTecnicos = "";
            String revisionTecnicaDe = "";

            pst.setString(1, idCliente);
            pst.setString(2, tipoEquipo);
            pst.setString(3, marca);
            pst.setString(4, modelo);
            pst.setString(5, numSerie);
            pst.setString(6, diaIngreso);
            pst.setString(7, mesIngreso);
            pst.setString(8, annioIngreso);
            pst.setString(9, observaciones);
            pst.setString(10, estado);
            pst.setString(11, ultimaModificacion);
            pst.setString(12, comentariosTecnicos);
            pst.setString(13, revisionTecnicaDe);

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Registro exitoso.");
            dispose();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }//GEN-LAST:event_jButton_registrarEquipoActionPerformed

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
            java.util.logging.Logger.getLogger(RegistroDeEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroDeEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroDeEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroDeEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroDeEquipo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_registrarEquipo;
    private javax.swing.JComboBox<String> jComboBox_marcaEquipo;
    private javax.swing.JComboBox<String> jComboBox_tipoEquipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel_footer;
    private javax.swing.JLabel jLabel_registro_equipo;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea_observaciones;
    private javax.swing.JTextField jTextField_modeloEquipo;
    private javax.swing.JTextField jTextField_nombreCliente;
    private javax.swing.JTextField jTextField_numeroSerie;
    // End of variables declaration//GEN-END:variables
}
