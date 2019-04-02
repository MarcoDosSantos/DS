package ventanas;

import clases.Conexion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.sql.*;
import javax.swing.JOptionPane;

public class InformacionDelUsuario extends javax.swing.JFrame {

    private String usuario1 = new Login().usuario;

    public InformacionDelUsuario() {
        initComponents();
        setSize(650, 430); // Asigna (confirma) el tamaño del formulario.
        setResizable(false); // Impide que el usuario modifique las dimensiones del formulario.
        setLocationRelativeTo(null); // Hace que el formulario aparezca en el centro de la pantalla cuando se inicia la aplicación.
        setTitle("Información de usuario - Sesion de " + usuario1); // Cambia el texto de la barra de arriba por el que establecemos.
        //La siguiente línea de código sirve para agregar la imagen al JLabel_wallpaper.
        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperprincipal.png");
        // Creamos la instancia de ImageIcon, vinculándola a la imagen que queremos utilizar como fondo.
        // En el próximo bloque de código, vamos a crear una instancia de la clase Icon, porque nos va a servir
        // para indicarle al programa, que queremos que distribuya y escale el wallpaper al tamaño entero del JLabel_wallpaper.
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_wallpaper.getWidth(),
                jLabel_wallpaper.getHeight(), Image.SCALE_DEFAULT));
        // Ahora le indicamos a jLaber_wallpaper, que incorpore el icono.
        jLabel_wallpaper.setIcon(icono);
        this.repaint(); // *Opcional*  Sirve para que ejecute las líneas anteriores y establezca la imagen de fondo. 
        completarDatos();
        jLabel_info_usuario.setText("Información del usuario " + jTextField_nombre_usuario.getText());
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png"));
        return retValue;
    }

    public void completarDatos() {
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select * from usuarios where id_usuario = " + UsuariosRegistrados.ID);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                jTextField_nombre_apellido.setText(rs.getString("nombre_usuario"));
                jTextField_email.setText(rs.getString("email"));
                jTextField_telefono.setText(rs.getString("telefono"));
                jTextField_nombre_usuario.setText(rs.getString("username"));
                jTextField_registrado_por.setText(rs.getString("registrado_por"));
                String estado = rs.getString("tipo_nivel");
                if (estado.equals("Administrador")) {
                    jComboBox_permisoDe.setSelectedItem("Administrador");
                } else if (estado.equals("Capturista")) {
                    jComboBox_permisoDe.setSelectedItem("Capturista");
                } else if (estado.equals("Técnico")) {
                    jComboBox_permisoDe.setSelectedItem("Técnico");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Error al traer los datos del usuario.");

            }

        } catch (SQLException e) {

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_info_usuario = new javax.swing.JLabel();
        jTextField_nombre_apellido = new javax.swing.JTextField();
        jTextField_email = new javax.swing.JTextField();
        jTextField_telefono = new javax.swing.JTextField();
        jTextField_nombre_usuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox_permisoDe = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox_estado = new javax.swing.JComboBox<>();
        jLabel_registrado_por = new javax.swing.JLabel();
        jTextField_registrado_por = new javax.swing.JTextField();
        jButton_actualizar_datos = new javax.swing.JButton();
        jButton_reestablecer_contraseña = new javax.swing.JButton();
        jLabel_wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_info_usuario.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel_info_usuario.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_info_usuario.setText("Informacion del usuario");
        getContentPane().add(jLabel_info_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 330, -1));

        jTextField_nombre_apellido.setBackground(new java.awt.Color(153, 153, 255));
        jTextField_nombre_apellido.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTextField_nombre_apellido.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_nombre_apellido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_nombre_apellido.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jTextField_nombre_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 250, -1));

        jTextField_email.setBackground(new java.awt.Color(153, 153, 255));
        jTextField_email.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTextField_email.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_email.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_email.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextField_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_emailActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 250, -1));

        jTextField_telefono.setBackground(new java.awt.Color(153, 153, 255));
        jTextField_telefono.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTextField_telefono.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_telefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_telefono.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jTextField_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 250, -1));

        jTextField_nombre_usuario.setBackground(new java.awt.Color(153, 153, 255));
        jTextField_nombre_usuario.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTextField_nombre_usuario.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_nombre_usuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_nombre_usuario.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jTextField_nombre_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 70, 250, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre de usuario:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Estado:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, 60, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nombre y Apellido(s)");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Teléfono");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Permiso de:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre de usuario:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, -1, -1));

        jComboBox_permisoDe.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jComboBox_permisoDe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Capturista", "Técnico" }));
        getContentPane().add(jComboBox_permisoDe, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("em@il:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Creado por Marco Dos Santos");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 380, -1, -1));

        jComboBox_estado.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jComboBox_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        getContentPane().add(jComboBox_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, -1, -1));

        jLabel_registrado_por.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_registrado_por.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_registrado_por.setText("Registrado por: ");
        getContentPane().add(jLabel_registrado_por, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, -1, -1));

        jTextField_registrado_por.setEditable(false);
        jTextField_registrado_por.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jTextField_registrado_por.setForeground(new java.awt.Color(102, 102, 102));
        jTextField_registrado_por.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(jTextField_registrado_por, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 210, 130, 30));

        jButton_actualizar_datos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton_actualizar_datos.setText("Actualizar datos");
        jButton_actualizar_datos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton_actualizar_datos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_actualizar_datosActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_actualizar_datos, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 270, 240, 30));

        jButton_reestablecer_contraseña.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton_reestablecer_contraseña.setText("Reestablecer contraseña");
        jButton_reestablecer_contraseña.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton_reestablecer_contraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_reestablecer_contraseñaActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_reestablecer_contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 320, 240, 30));

        jLabel_wallpaper.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_emailActionPerformed

    private void jButton_actualizar_datosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_actualizar_datosActionPerformed
        String textoEstado = jComboBox_estado.getSelectedItem().toString();
        String textoPermiso = jComboBox_permisoDe.getSelectedItem().toString();
        String nombreApellido = jTextField_nombre_apellido.getText().trim();
        String email = jTextField_email.getText().trim();
        String telefono = jTextField_telefono.getText().trim();
        String nombreUsuario = jTextField_nombre_usuario.getText().trim();
        

        if (nombreApellido.equals("") || email.equals("") || telefono.equals("")
                || nombreUsuario.equals("")) {
            if (nombreApellido.equals("")) {
                jTextField_nombre_apellido.setBackground(Color.red);
            }
            if (email.equals("")) {
                jTextField_email.setBackground(Color.red);
            }
            if (telefono.equals("")) {
                jTextField_telefono.setBackground(Color.red);
            }
            if (nombreUsuario.equals("")) {
                jTextField_nombre_usuario.setBackground(Color.red);
            }
            
            JOptionPane.showMessageDialog(null, "Debes completar todos los campos.");

        } else if (!nombreApellido.equals("") && !email.equals("") && !telefono.equals("")
                && !nombreUsuario.equals("")) {
            int hayArroba = 0;
            int posicionArroba = 0;
            int hayPunto = 0;

            for (int i = 0; i < email.length(); i++) {
                if (email.charAt(i) == '@') {
                    hayArroba++;
                }
            }

            if (hayArroba != 1) {
                jTextField_email.setBackground(Color.red);
                JOptionPane.showMessageDialog(null, "Debes introducir un mail válido.");
                hayArroba = 0;
                posicionArroba = 0;
                hayPunto = 0;
                email = "";

            } else {
                posicionArroba = email.indexOf('@');
                String extracto = email.substring(posicionArroba);
                
                for (int j = 0; j < extracto.length(); j++) {
                    if (extracto.charAt(j) == '.') {
                        hayPunto++;
                    }
                }

                if (hayPunto == 1 || hayPunto == 2) {
                    //System.out.println("El mail es válido.");

                    try {
                        Connection cn = Conexion.conectar();
                        PreparedStatement pst = cn.prepareStatement(
                                "update usuarios "
                                + "set "
                                + "nombre_usuario = ?, "//1
                                + "email = ?, "//2
                                + "telefono = ?, "//3
                                + "username = ?, "//4
                                + "tipo_nivel = ?, "//5
                                + "estatus = ?, "//6
                                + "registrado_por = ? where id_usuario = " //7
                                        + UsuariosRegistrados.ID);

                        pst.setString(1, nombreApellido);
                        pst.setString(2, email);
                        pst.setString(3, telefono);
                        pst.setString(4, nombreUsuario);
                        pst.setString(5, textoPermiso);
                        pst.setString(6, textoEstado);
                        pst.setString(7, usuario1);                        
                        pst.executeUpdate();

                        jTextField_nombre_apellido.setText("");
                        jTextField_email.setText("");
                        jTextField_telefono.setText("");
                        jTextField_nombre_usuario.setText("");
                        

                        jTextField_nombre_apellido.setBackground(new Color(38, 176, 55));
                        jTextField_email.setBackground(new Color(38, 176, 55));
                        jTextField_telefono.setBackground(new Color(38, 176, 55));
                        jTextField_nombre_usuario.setBackground(new Color(38, 176, 55));
                        

                        JOptionPane.showMessageDialog(null, "Actualización exitosa.");
                        dispose();

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Error al actualizar datos del usuario: " + e);
                    }

                } else {
                    jTextField_email.setBackground(Color.red);
                    JOptionPane.showMessageDialog(null, "Debes introducir un mail válido.");
                    hayArroba = 0;
                    posicionArroba = 0;
                    hayPunto = 0;
                    email = "";
                    extracto = "";
                }
            }
        }
    }//GEN-LAST:event_jButton_actualizar_datosActionPerformed

    private void jButton_reestablecer_contraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_reestablecer_contraseñaActionPerformed
        new ReestablecerContraseña().setVisible(true);
    }//GEN-LAST:event_jButton_reestablecer_contraseñaActionPerformed

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
            java.util.logging.Logger.getLogger(InformacionDelUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformacionDelUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformacionDelUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformacionDelUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformacionDelUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_actualizar_datos;
    private javax.swing.JButton jButton_reestablecer_contraseña;
    private javax.swing.JComboBox<String> jComboBox_estado;
    private javax.swing.JComboBox<String> jComboBox_permisoDe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel_info_usuario;
    private javax.swing.JLabel jLabel_registrado_por;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JTextField jTextField_email;
    private javax.swing.JTextField jTextField_nombre_apellido;
    private javax.swing.JTextField jTextField_nombre_usuario;
    private javax.swing.JTextField jTextField_registrado_por;
    private javax.swing.JTextField jTextField_telefono;
    // End of variables declaration//GEN-END:variables
}
