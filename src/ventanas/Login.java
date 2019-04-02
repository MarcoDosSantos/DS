
package ventanas;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import clases.Conexion;
import java.sql.*;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {
    public static String usuario;
    public static String id_usuario; // Esta variable me va a servir en la interfaz 
    // InformacionDeEquipo, establecerEditabilidad();
    private String contrasenia;

    public Login() {
        initComponents();
        setSize(400,550); // Asigna (confirma) el tamaño del formulario.
        setResizable(false); // Impide que el usuario modifique las dimensiones del formulario.
        setLocationRelativeTo(null); // Hace que el formulario aparezca en el centro de la pantalla cuando se inicia la aplicación.
        setTitle("Acceso al sistema."); // Cambia el texto de la barra de arriba por el que establecemos.
        
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
        
        ImageIcon logo = new ImageIcon("src/images/ds.png");
        Icon icono_logo = new ImageIcon(logo.getImage().getScaledInstance(jLabel_logo.getWidth(), 
                jLabel_logo.getHeight(), Image.SCALE_DEFAULT));
        jLabel_logo.setIcon(icono_logo);
        this.repaint();
    }
    
    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png"));
        return retValue;                   
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField_usuario = new javax.swing.JTextField();
        jPassword_contrasenia = new javax.swing.JPasswordField();
        jLabel_logo = new javax.swing.JLabel();
        jButton_acceder = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel_wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField_usuario.setBackground(new java.awt.Color(153, 153, 255));
        jTextField_usuario.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTextField_usuario.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_usuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_usuario.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jTextField_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 330, 210, -1));

        jPassword_contrasenia.setBackground(new java.awt.Color(153, 153, 255));
        jPassword_contrasenia.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jPassword_contrasenia.setForeground(new java.awt.Color(255, 255, 255));
        jPassword_contrasenia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPassword_contrasenia.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jPassword_contrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 370, 210, -1));
        getContentPane().add(jLabel_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 270, 270));

        jButton_acceder.setBackground(new java.awt.Color(153, 153, 255));
        jButton_acceder.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jButton_acceder.setForeground(new java.awt.Color(255, 255, 255));
        jButton_acceder.setText("Acceder");
        jButton_acceder.setBorder(null);
        jButton_acceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_accederActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_acceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 420, 210, 35));

        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Creado por Marco Dos Santos");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 500, -1, 20));
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_accederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_accederActionPerformed
        usuario = jTextField_usuario.getText().trim();
        contrasenia = jPassword_contrasenia.getText().trim();
        if(!usuario.equals("")|| !contrasenia.equals("")){            
        try{
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
            "select id_usuario, tipo_nivel, estatus from usuarios where username = '" + usuario + 
                    "' and password = '" + contrasenia + "'");
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                id_usuario= rs.getString("id_usuario");
                String tipo_nivel = rs.getString("tipo_nivel"), estado = rs.getString("estatus");
                
                if(tipo_nivel.equalsIgnoreCase("Administrador") && estado.equalsIgnoreCase("Activo")){
                    dispose(); // Este método destruye la interfaz actual.
                    new Administrador().setVisible(true); // Abreviatura de método más largo, nos envía a Formulario Administrador..
                    
                } else if(tipo_nivel.equalsIgnoreCase("Capturista") && estado.equalsIgnoreCase("Activo")){
                    dispose(); // Este método destruye la interfaz actual.
                    new Capturista().setVisible(true); // Abreviatura de método más largo...
                    
                } else if(tipo_nivel.equalsIgnoreCase("Técnico") && estado.equalsIgnoreCase("Activo")){
                    dispose(); // Este método destruye la interfaz actual.
                    new Tecnico().setVisible(true); // Abreviatura de método más largo...
                }
            
            }else{
                JOptionPane.showMessageDialog(null, "Datos de acceso incorrectos.");
                jTextField_usuario.setText("");
                jPassword_contrasenia.setText("");
            }
        
        } catch(SQLException e){
            System.err.println("Error de sistema: " + e); // Abre un mensaje rojo indicando error de sistema.
            JOptionPane.showMessageDialog(null,"Error al iniciar sesión. Contacte al Administrador.");
        }
        }else{
            JOptionPane.showMessageDialog(null,"Debes completar todos los campos.");
        }
    }//GEN-LAST:event_jButton_accederActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_acceder;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel_logo;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JPasswordField jPassword_contrasenia;
    private javax.swing.JTextField jTextField_usuario;
    // End of variables declaration//GEN-END:variables
}
