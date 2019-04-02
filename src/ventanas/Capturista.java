package ventanas;

import clases.Conexion;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import clases.GeneradorPDF;
import com.itextpdf.text.BadElementException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Capturista extends javax.swing.JFrame {

    private String usuario1 = new Login().usuario;
    private GeneradorPDF gen;

    public Capturista() {
        initComponents();
        setTitle("Capturista - Sesión de " + usuario1);
        setLocationRelativeTo(null);
        setSize(560, 260); // Asigna (confirma) el tamaño del formulario.
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

        jLabel_nombreUsuario.setText("Bienvenid@ " + averiguarNombre());
        establecerOpciones();
        gen = new GeneradorPDF();
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png"));
        return retValue;
    }

    public String averiguarNombre() {
        String nombreYApellido = "";
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select nombre_usuario from usuarios where username = '" + usuario1 + "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                nombreYApellido = (rs.getString("nombre_usuario"));
            }

        } catch (Exception e) {

        }
        return nombreYApellido;
    }

    public void establecerOpciones() { /*Este método determina que, si el usuario que accede a esta interfaz es
        un Administrador, ya no le de la bienvenida "Bienvenid@ ... ", porque ya la recibió en su respectiva vista
        de Administrador. Y por otra parte, si es un administrador, el programa no se cierra absolutamente, sino que
        queda subyacente su vista administrador. En caso de que quien acceda sea un capturista, se le da la bienvenida
        y al cierre, se cierra toda la aplicación (no queda flotando el fantasma que consume memoria)*/
        String tipoNivel;
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select tipo_nivel from usuarios where id_usuario = " + Login.id_usuario);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                tipoNivel = rs.getString("tipo_nivel");
                if (!tipoNivel.equals("Administrador")) {
                    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
                } else if (tipoNivel.equals("Administrador")) {
                    jLabel_nombreUsuario.setText("");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el nivel de acceso del usuario.");
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al determinar nivel de acceso del usuario: " + e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_nombreUsuario = new javax.swing.JLabel();
        jButton_gestionarClientes = new javax.swing.JButton();
        jButton_imprimirClientes = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton_registrarClientes = new javax.swing.JButton();
        jLabel_wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_nombreUsuario.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel_nombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_nombreUsuario.setText("Bienvenido capturista");
        getContentPane().add(jLabel_nombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 350, 30));

        jButton_gestionarClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/informationuser.png"))); // NOI18N
        jButton_gestionarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_gestionarClientesActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_gestionarClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 120, 100));

        jButton_imprimirClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/impresora.png"))); // NOI18N
        jButton_imprimirClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_imprimirClientesActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_imprimirClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 120, 100));

        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Creado por Marco Dos Santos");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, -1, 20));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gestionar clientes");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Imprimir clientes");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 170, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Registrar cliente");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        jButton_registrarClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addUser.png"))); // NOI18N
        jButton_registrarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_registrarClientesActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_registrarClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 120, 100));
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 260));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_gestionarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_gestionarClientesActionPerformed
        new ClientesRegistrados().setVisible(true);
    }//GEN-LAST:event_jButton_gestionarClientesActionPerformed

    private void jButton_imprimirClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_imprimirClientesActionPerformed
        gen.imprimirTodos();        
    }//GEN-LAST:event_jButton_imprimirClientesActionPerformed

    private void jButton_registrarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_registrarClientesActionPerformed
        new RegistrarNuevoCliente().setVisible(true);
    }//GEN-LAST:event_jButton_registrarClientesActionPerformed

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
            java.util.logging.Logger.getLogger(Capturista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Capturista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Capturista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Capturista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Capturista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_gestionarClientes;
    private javax.swing.JButton jButton_imprimirClientes;
    private javax.swing.JButton jButton_registrarClientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel_nombreUsuario;
    private javax.swing.JLabel jLabel_wallpaper;
    // End of variables declaration//GEN-END:variables
}
