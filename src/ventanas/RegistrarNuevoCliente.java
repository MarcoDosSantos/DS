/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import clases.Conexion;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class RegistrarNuevoCliente extends javax.swing.JFrame {
    private String usuario1 = new Login().usuario; 
    /**
     * Creates new form RegistrarNuevoCliente
     */
    public RegistrarNuevoCliente() {
        initComponents();
        setTitle("Registrar nuevo cliente - Sesión de " + usuario1);
        setLocationRelativeTo(null);
        setSize(530,350); // Asigna (confirma) el tamaño del formulario.
        setResizable(false); // Impide que el usuario modifique las dimensiones del formulario.
        setLocationRelativeTo(null); // Hace que el formulario aparezca en el centro de la pantalla cuando se inicia la aplicación.
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
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png"));
        return retValue;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton_registrarNuevoCliente = new javax.swing.JButton();
        jTextField_Nombre = new javax.swing.JTextField();
        jLabel_nombreUsuario = new javax.swing.JLabel();
        jTextField_email = new javax.swing.JTextField();
        jTextField_telefono = new javax.swing.JTextField();
        jTextField_direccion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel_wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton_registrarNuevoCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addUser.png"))); // NOI18N
        jButton_registrarNuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_registrarNuevoClienteActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_registrarNuevoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 120, 100));

        jTextField_Nombre.setBackground(new java.awt.Color(153, 153, 240));
        jTextField_Nombre.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jTextField_Nombre.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_Nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_Nombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jTextField_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 290, 30));

        jLabel_nombreUsuario.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel_nombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_nombreUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_nombreUsuario.setText("Registrar nuevo cliente");
        getContentPane().add(jLabel_nombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 240, 30));

        jTextField_email.setBackground(new java.awt.Color(153, 153, 240));
        jTextField_email.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jTextField_email.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_email.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_email.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jTextField_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 290, 30));

        jTextField_telefono.setBackground(new java.awt.Color(153, 153, 240));
        jTextField_telefono.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jTextField_telefono.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_telefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_telefono.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jTextField_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 290, 30));

        jTextField_direccion.setBackground(new java.awt.Color(153, 153, 240));
        jTextField_direccion.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jTextField_direccion.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_direccion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_direccion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jTextField_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 290, 30));

        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Creado por Marco Dos Santos");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, -1, 20));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("em@il");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Teléfono");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Dirección");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Registrar cliente");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nombre y Apellido");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_registrarNuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_registrarNuevoClienteActionPerformed
        String nombreCliente = jTextField_Nombre.getText();
        String emailCliente= jTextField_email.getText();
        String telefonoCliente = jTextField_telefono.getText();
        String direccionCliente = jTextField_direccion.getText();
        
        if(nombreCliente.equals("")|| emailCliente.equals("")|| 
                telefonoCliente.equals("")|| direccionCliente.equals("")){
            if(nombreCliente.equals("")) jTextField_Nombre.setBackground(Color.red);
            if(emailCliente.equals("")) jTextField_email.setBackground(Color.red);
            if(telefonoCliente.equals("")) jTextField_telefono.setBackground(Color.red);
            if(direccionCliente.equals("")) jTextField_direccion.setBackground(Color.red);
            
            JOptionPane.showMessageDialog(null, "Debes completar todos los campos.");
        }else if (!nombreCliente.equals("")&& !emailCliente.equals("") 
                && !telefonoCliente.equals("")&& !direccionCliente.equals("")){
            //Validar mail. if (es válido) try_catch, conexión else{Debes incluír un mail válido.}
            int hayArroba = 0;
            int posicionArroba = 0;
            int hayPunto = 0;

            for (int i = 0; i < emailCliente.length(); i++) {
                if (emailCliente.charAt(i) == '@') {
                    hayArroba++;
                }
            }

            if (hayArroba != 1) {
                jTextField_email.setBackground(Color.red);
                JOptionPane.showMessageDialog(null, "Debes introducir un mail válido.");
                hayArroba = 0;
                posicionArroba = 0;
                hayPunto = 0;
                emailCliente = "";

            } else {
                posicionArroba = emailCliente.indexOf('@');
                String extracto = emailCliente.substring(posicionArroba);

                for (int j = 0; j < extracto.length(); j++) {
                    if (extracto.charAt(j) == '.') {
                        hayPunto++;
                    }
                }

                if (hayPunto == 1 || hayPunto == 2) {
                    //System.out.println("El mail es válido.");

                    try {
                        Connection cn = Conexion.conectar();
                        PreparedStatement pst;
                        pst = cn.prepareStatement("insert into clientes "
                                + "values (id_cliente = 1,?,?,?,?,?)");
                        pst.setString(1, nombreCliente);
                        pst.setString(2, emailCliente);
                        pst.setString(3, telefonoCliente);
                        pst.setString(4, direccionCliente);
                        pst.setString(5, usuario1);                        
                        pst.executeUpdate();

                        jTextField_Nombre.setText("");
                        jTextField_email.setText("");
                        jTextField_telefono.setText("");
                        jTextField_direccion.setText("");
                        

                        jTextField_Nombre.setBackground(new Color(38, 176, 55));
                        jTextField_email.setBackground(new Color(38, 176, 55));
                        jTextField_telefono.setBackground(new Color(38, 176, 55));
                        jTextField_direccion.setBackground(new Color(38, 176, 55));
                        

                        JOptionPane.showMessageDialog(null, "Registro exitoso.");
                        dispose();

                    } catch (HeadlessException | SQLException e) {
                        JOptionPane.showMessageDialog(null, "Error al registrar cliente: " + e);
                    }

                } else {
                    jTextField_email.setBackground(Color.red);
                    JOptionPane.showMessageDialog(null, "Debes introducir un mail válido.");
                    hayArroba = 0;
                    posicionArroba = 0;
                    hayPunto = 0;
                    emailCliente = "";
                    extracto = "";
                }
            }
        }
        
        
    }//GEN-LAST:event_jButton_registrarNuevoClienteActionPerformed

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
            java.util.logging.Logger.getLogger(RegistrarNuevoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarNuevoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarNuevoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarNuevoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarNuevoCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_registrarNuevoCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel_nombreUsuario;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JTextField jTextField_Nombre;
    private javax.swing.JTextField jTextField_direccion;
    private javax.swing.JTextField jTextField_email;
    private javax.swing.JTextField jTextField_telefono;
    // End of variables declaration//GEN-END:variables
}
