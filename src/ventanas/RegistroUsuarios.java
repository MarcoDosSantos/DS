package ventanas;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import clases.Conexion;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class RegistroUsuarios extends javax.swing.JFrame {

    private String usuario1 = new Login().usuario;

    public RegistroUsuarios() {
        initComponents();
        setSize(650, 430); // Asigna (confirma) el tamaño del formulario.
        setResizable(false); // Impide que el usuario modifique las dimensiones del formulario.
        setLocationRelativeTo(null); // Hace que el formulario aparezca en el centro de la pantalla cuando se inicia la aplicación.
        setTitle("Registrar nuevo usuario - Sesion de " + usuario1); // Cambia el texto de la barra de arriba por el que establecemos.
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
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_registroUsuarios = new javax.swing.JLabel();
        jTextField_nombre_apellido = new javax.swing.JTextField();
        jTextField_email = new javax.swing.JTextField();
        jTextField_telefono = new javax.swing.JTextField();
        jTextField_nombre_usuario = new javax.swing.JTextField();
        jButton_registrarUsuario = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jComboBox_permisoDe = new javax.swing.JComboBox<>();
        jLabel_footer = new javax.swing.JLabel();
        jLabel_wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_registroUsuarios.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel_registroUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_registroUsuarios.setText("Registro de usuarios");
        getContentPane().add(jLabel_registroUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 210, -1));

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
        getContentPane().add(jTextField_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 250, -1));

        jTextField_telefono.setBackground(new java.awt.Color(153, 153, 255));
        jTextField_telefono.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTextField_telefono.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_telefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_telefono.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jTextField_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 250, -1));

        jTextField_nombre_usuario.setBackground(new java.awt.Color(153, 153, 255));
        jTextField_nombre_usuario.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTextField_nombre_usuario.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_nombre_usuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_nombre_usuario.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jTextField_nombre_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 70, 250, -1));

        jButton_registrarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addUser.png"))); // NOI18N
        jButton_registrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_registrarUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_registrarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 280, 120, 100));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre de usuario:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("em@il:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Teléfono");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Permiso de:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Contraseña:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nombre y Apellido(s)");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 50, -1, -1));

        jPasswordField1.setBackground(new java.awt.Color(153, 153, 255));
        jPasswordField1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jPasswordField1.setForeground(new java.awt.Color(255, 255, 255));
        jPasswordField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPasswordField1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 170, 250, -1));

        jComboBox_permisoDe.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jComboBox_permisoDe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Capturista", "Técnico" }));
        getContentPane().add(jComboBox_permisoDe, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, -1, -1));

        jLabel_footer.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_footer.setText("Creado por Marco Dos Santos");
        getContentPane().add(jLabel_footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 380, -1, -1));

        jLabel_wallpaper.setBackground(new java.awt.Color(153, 153, 255));
        jLabel_wallpaper.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_wallpaper.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_registrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_registrarUsuarioActionPerformed
        String textoPermiso = jComboBox_permisoDe.getSelectedItem().toString();
        String nombreApellido = jTextField_nombre_apellido.getText().trim();
        String email = jTextField_email.getText().trim();
        String telefono = jTextField_telefono.getText().trim();
        String nombreUsuario = jTextField_nombre_usuario.getText().trim();
        String contrasenia = jPasswordField1.getText().trim();

        if (nombreApellido.equals("") || email.equals("") || telefono.equals("")
                || nombreUsuario.equals("") || contrasenia.equals("")) {
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
            if (contrasenia.equals("")) {
                jPasswordField1.setBackground(Color.red);
            }

            JOptionPane.showMessageDialog(null, "Debes completar todos los campos.");

        } else if (!nombreApellido.equals("") && !email.equals("") && !telefono.equals("")
                && !nombreUsuario.equals("") && !contrasenia.equals("")) {
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
                                "insert into usuarios "
                                + "values (id_usuario = 1,?,?,?,?,?,?,?,?)");

                        pst.setString(1, nombreApellido);
                        pst.setString(2, email);
                        pst.setString(3, telefono);
                        pst.setString(4, nombreUsuario);
                        pst.setString(5, contrasenia);
                        pst.setString(6, textoPermiso);
                        pst.setString(7, "Activo");
                        pst.setString(8, usuario1);
                        pst.executeUpdate();

                        jTextField_nombre_apellido.setText("");
                        jTextField_email.setText("");
                        jTextField_telefono.setText("");
                        jTextField_nombre_usuario.setText("");
                        jPasswordField1.setText("");

                        jTextField_nombre_apellido.setBackground(new Color(38, 176, 55));
                        jTextField_email.setBackground(new Color(38, 176, 55));
                        jTextField_telefono.setBackground(new Color(38, 176, 55));
                        jTextField_nombre_usuario.setBackground(new Color(38, 176, 55));
                        jPasswordField1.setBackground(new Color(38, 176, 55));

                        JOptionPane.showMessageDialog(null, "Registro exitoso.");
                        dispose();

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Error al registrar usuario: " + e);
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
    }//GEN-LAST:event_jButton_registrarUsuarioActionPerformed

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
            java.util.logging.Logger.getLogger(RegistroUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_registrarUsuario;
    private javax.swing.JComboBox<String> jComboBox_permisoDe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel_footer;
    private javax.swing.JLabel jLabel_registroUsuarios;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField_email;
    private javax.swing.JTextField jTextField_nombre_apellido;
    private javax.swing.JTextField jTextField_nombre_usuario;
    private javax.swing.JTextField jTextField_telefono;
    // End of variables declaration//GEN-END:variables

}
