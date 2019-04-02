/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.awt.Desktop;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Marco
 */
public class AcercaDe extends javax.swing.JFrame {
    private String usuario1 = new Login().usuario; 
    public AcercaDe() {
        initComponents();
        setSize(400, 320); // Asigna (confirma) el tamaño del formulario.
        setResizable(false); // Impide que el usuario modifique las dimensiones del formulario.
        setLocationRelativeTo(null); // Hace que el formulario aparezca en el centro de la pantalla cuando se inicia la aplicación.
        setTitle("Acerca de - Sesion de " + usuario1); // Cambia el texto de la barra de arriba por el que establecemos.
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
    }
    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png"));
        return retValue;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton_linkedIn = new javax.swing.JButton();
        jButton_GitHub = new javax.swing.JButton();
        jLabel_footer = new javax.swing.JLabel();
        jLabel_wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Marco Dos Santos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 240, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("| Java & Android Developer |");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 240, 20));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("(+54) 11 6246 1601");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 150, 30));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Ir a mi LinkedIn");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 120, 20));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Ir a mi GitHub");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 110, 20));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/marco.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 80, 110));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("mds14421@gmail.com");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 150, 30));

        jButton_linkedIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/linkedin.png"))); // NOI18N
        jButton_linkedIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_linkedInActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_linkedIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 100, 90));

        jButton_GitHub.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/octocat.png"))); // NOI18N
        jButton_GitHub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_GitHubActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_GitHub, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 90, 90));

        jLabel_footer.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_footer.setText("Creado por Marco Dos Santos");
        getContentPane().add(jLabel_footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, -1, 20));

        jLabel_wallpaper.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel_wallpaper.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_linkedInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_linkedInActionPerformed
        if(java.awt.Desktop.isDesktopSupported()){
            java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
            
            if(desktop.isSupported(Desktop.Action.BROWSE)){
                try{
                    java.net.URI uri = new java.net.URI("https://www.linkedin.com/in/marco-david-dos-santos-183b74167/");
                    desktop.browse(uri);
                
                }catch(IOException e){} catch (URISyntaxException ex) {
                    Logger.getLogger(AcercaDe.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }
        }
    }//GEN-LAST:event_jButton_linkedInActionPerformed

    private void jButton_GitHubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_GitHubActionPerformed
         if(java.awt.Desktop.isDesktopSupported()){
            java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
            
            if(desktop.isSupported(Desktop.Action.BROWSE)){
                try{
                    java.net.URI uri = new java.net.URI("https://github.com/MarcoDosSantos");
                    desktop.browse(uri);
                
                }catch(IOException e){} catch (URISyntaxException ex) {
                    Logger.getLogger(AcercaDe.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }
        }
    }//GEN-LAST:event_jButton_GitHubActionPerformed

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
            java.util.logging.Logger.getLogger(AcercaDe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AcercaDe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AcercaDe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AcercaDe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AcercaDe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_GitHub;
    private javax.swing.JButton jButton_linkedIn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel_footer;
    private javax.swing.JLabel jLabel_wallpaper;
    // End of variables declaration//GEN-END:variables
}
