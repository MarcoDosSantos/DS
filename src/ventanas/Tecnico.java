
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
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;

public class Tecnico extends javax.swing.JFrame {
    private String usuario1 = new Login().usuario;

    public Tecnico() {
        initComponents();
        setTitle("Técnico - Sesión de " + usuario1);
        setLocationRelativeTo(null);
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
        this.repaint();
        jLabel_nombreUsuario.setText("Bienvenid@ " + averiguarNombre());
        establecerOpciones();
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

        } catch (SQLException e) {

        }
        return nombreYApellido;
    }

    public void establecerOpciones() { 
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
        jButton_graficaEstado = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton_graficaMarcas = new javax.swing.JButton();
        jButton_gestionEquipos = new javax.swing.JButton();
        jLabel_footer = new javax.swing.JLabel();
        jLabel_wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_nombreUsuario.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel_nombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_nombreUsuario.setText("Bienvenido técnico");
        getContentPane().add(jLabel_nombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 350, 30));

        jButton_graficaEstado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/grafica.png"))); // NOI18N
        jButton_graficaEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_graficaEstadoActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_graficaEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 120, 100));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gestionar equipos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Gráfica de marcas");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 170, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Gráfica de estado");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, -1, -1));

        jButton_graficaMarcas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/grafica.png"))); // NOI18N
        jButton_graficaMarcas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_graficaMarcasActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_graficaMarcas, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 120, 100));

        jButton_gestionEquipos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/apoyo-tecnico.png"))); // NOI18N
        jButton_gestionEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_gestionEquiposActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_gestionEquipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 120, 100));

        jLabel_footer.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_footer.setText("Creado por Marco Dos Santos");
        getContentPane().add(jLabel_footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, -1, 20));
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 260));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_gestionEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_gestionEquiposActionPerformed
        new GestionEquipos().setVisible(true);
    }//GEN-LAST:event_jButton_gestionEquiposActionPerformed

    private void jButton_graficaEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_graficaEstadoActionPerformed
        new GraficaEstado().setVisible(true);
    }//GEN-LAST:event_jButton_graficaEstadoActionPerformed

    private void jButton_graficaMarcasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_graficaMarcasActionPerformed
        new GraficaMarcas().setVisible(true);
    }//GEN-LAST:event_jButton_graficaMarcasActionPerformed

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
            java.util.logging.Logger.getLogger(Tecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tecnico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_gestionEquipos;
    private javax.swing.JButton jButton_graficaEstado;
    private javax.swing.JButton jButton_graficaMarcas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel_footer;
    private javax.swing.JLabel jLabel_nombreUsuario;
    private javax.swing.JLabel jLabel_wallpaper;
    // End of variables declaration//GEN-END:variables
}
