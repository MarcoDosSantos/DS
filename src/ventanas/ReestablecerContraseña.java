
package ventanas;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import clases.Conexion;
import java.sql.*;

public class ReestablecerContraseña extends javax.swing.JFrame {
    private String usuario1 = new Login().usuario;

    public ReestablecerContraseña() {
        initComponents();
        setSize(400,300); // Asigna (confirma) el tamaño del formulario.
        setResizable(false); // Impide que el usuario modifique las dimensiones del formulario.
        setLocationRelativeTo(null); // Hace que el formulario aparezca en el centro de la pantalla cuando se inicia la aplicación.
        setTitle("Registrar de usuario - Sesion de " + usuario1); // Cambia el texto de la barra de arriba por el que establecemos.
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
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png"));
        return retValue;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_escriba_una_contraseña = new javax.swing.JLabel();
        jLabel_confirme_contraseña = new javax.swing.JLabel();
        jPasswordField_contraseña1 = new javax.swing.JPasswordField();
        jPasswordField_contraseña2 = new javax.swing.JPasswordField();
        jButton_cambiar_contraseña = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel_wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_escriba_una_contraseña.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_escriba_una_contraseña.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_escriba_una_contraseña.setText("Escriba una contraseña: ");
        getContentPane().add(jLabel_escriba_una_contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 150, 20));

        jLabel_confirme_contraseña.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_confirme_contraseña.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_confirme_contraseña.setText("Confirme la contraseña:");
        getContentPane().add(jLabel_confirme_contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 150, -1));

        jPasswordField_contraseña1.setBackground(new java.awt.Color(153, 153, 255));
        jPasswordField_contraseña1.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jPasswordField_contraseña1.setForeground(new java.awt.Color(255, 255, 255));
        jPasswordField_contraseña1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPasswordField_contraseña1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jPasswordField_contraseña1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 230, 30));

        jPasswordField_contraseña2.setBackground(new java.awt.Color(153, 153, 255));
        jPasswordField_contraseña2.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jPasswordField_contraseña2.setForeground(new java.awt.Color(255, 255, 255));
        jPasswordField_contraseña2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPasswordField_contraseña2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jPasswordField_contraseña2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 230, 30));

        jButton_cambiar_contraseña.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton_cambiar_contraseña.setText("Reestablecer contraseña");
        jButton_cambiar_contraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cambiar_contraseñaActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_cambiar_contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 190, 30));

        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Creado por Marco Dos Santos");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, -1, -1));
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_cambiar_contraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cambiar_contraseñaActionPerformed
        String contrasenia1 = jPasswordField_contraseña1.getText().trim();
        String contrasenia2 = jPasswordField_contraseña2.getText().trim();
        
        if(contrasenia1.equals("") || contrasenia2.equals("")){
            if(contrasenia1.equals("")){jPasswordField_contraseña1.setBackground(Color.red);}
            if(contrasenia2.equals("")){jPasswordField_contraseña2.setBackground(Color.red);}            
            JOptionPane.showMessageDialog(null, "Debes completar ambos campos.");
        } else if (contrasenia1.equals(contrasenia2)){
            try{
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement("update usuarios"
                        + " set password = ?, registrado_por = ? where id_usuario = " 
                        + UsuariosRegistrados.ID);
                pst.setString(1, contrasenia1);
                pst.setString(2, usuario1);
                pst.executeUpdate();
                
                jPasswordField_contraseña1.setText("");
                jPasswordField_contraseña2.setText("");
                jPasswordField_contraseña1.setBackground(new Color(38, 176, 55));
                jPasswordField_contraseña2.setBackground(new Color(38, 176, 55));
                JOptionPane.showMessageDialog(null, "La contraseña ha sido reestablecida exitosamente.");
                dispose();
            
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error al actualizar contraseña. "
                        + "Por favor comuníquese con el Administrador y reporte el siguiente error: " + e);
            }
            
        } else if(!contrasenia1.equals(contrasenia2)){
            jPasswordField_contraseña1.setBackground(Color.red);
            jPasswordField_contraseña2.setBackground(Color.red);
            JOptionPane.showMessageDialog(null, "Las contraseñas son diferentes. "
                    + "Para confirmar, debes ingresar dos veces la misma contraseña.");        
        }
    }//GEN-LAST:event_jButton_cambiar_contraseñaActionPerformed

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
            java.util.logging.Logger.getLogger(ReestablecerContraseña.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReestablecerContraseña.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReestablecerContraseña.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReestablecerContraseña.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReestablecerContraseña().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_cambiar_contraseña;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel_confirme_contraseña;
    private javax.swing.JLabel jLabel_escriba_una_contraseña;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JPasswordField jPasswordField_contraseña1;
    private javax.swing.JPasswordField jPasswordField_contraseña2;
    // End of variables declaration//GEN-END:variables
}
