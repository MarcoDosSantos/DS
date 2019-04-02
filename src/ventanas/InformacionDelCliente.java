
package ventanas;

import clases.Conexion;
import clases.GeneradorPDF;
import com.itextpdf.text.BadElementException;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marco
 */
public class InformacionDelCliente extends javax.swing.JFrame{

    private String usuario1 = new Login().usuario;
    private DefaultTableModel modelo = new DefaultTableModel();
    private String equipos[] = new String[4];
    public static String ID_EQUIPO;
    private GeneradorPDF gen;
    private String nombreCliente;

    public InformacionDelCliente() {
        initComponents();
        setSize(690, 430); // Asigna (confirma) el tamaño del formulario.
        setResizable(false); // Impide que el usuario modifique las dimensiones del formulario.
        setLocationRelativeTo(null); // Hace que el formulario aparezca en el centro de la pantalla cuando se inicia la aplicación.
        
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
        completarDatos();
        setTitle("Información del cliente " + jTextField_nombreCliente.getText() + " - Sesion de " + usuario1); 
        jLabel_info_cliente.setText("Información del cliente " + jTextField_nombreCliente.getText());
        llenarTabla();
        gen = new GeneradorPDF();
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png"));
        return retValue;
    }
    
    public void llenarTabla(){
        modelo.addColumn("Id equipo");
        modelo.addColumn("Tipo equipo");
        modelo.addColumn("Marca equipo");
        modelo.addColumn("Estado");
        jTable1.setModel(modelo);
        
        try{
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select * from equipos where "
                    + "equipos.id_cliente = " + ClientesRegistrados.ID);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
            equipos[0]= rs.getString("id_equipo");
            equipos[1]= rs.getString("tipo_equipo");
            equipos[2]= rs.getString("marca");
            equipos[3]= rs.getString("estado");
            modelo.addRow(equipos);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos: " + e);
        
        }
    }

    public void completarDatos() {
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select * from clientes where id_cliente = " + ClientesRegistrados.ID);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                jTextField_nombreCliente.setText(rs.getString("nombre_cliente"));
                jTextField_emailCliente.setText(rs.getString("email_cliente"));
                jTextField_telCliente.setText(rs.getString("tel_cliente"));
                jTextField_direccionCliente.setText(rs.getString("dir_cliente"));
                jTextField_modificadoPor.setText(rs.getString("ultima_modificacion"));
                nombreCliente = rs.getString("nombre_cliente");

            } else {
                JOptionPane.showMessageDialog(null, "Error al recuperar los datos del usuario.");

            }

        } catch (SQLException e) {

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
   
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_info_cliente = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField_nombreCliente = new javax.swing.JTextField();
        jTextField_emailCliente = new javax.swing.JTextField();
        jTextField_telCliente = new javax.swing.JTextField();
        jTextField_direccionCliente = new javax.swing.JTextField();
        jTextField_modificadoPor = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton_registrarEquipo = new javax.swing.JButton();
        jButton_actualizarDatos = new javax.swing.JButton();
        jButton_imprimirCliente = new javax.swing.JButton();
        jLabel_wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_info_cliente.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel_info_cliente.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_info_cliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_info_cliente.setText("Informacion del cliente");
        getContentPane().add(jLabel_info_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 600, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre del cliente:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Email del cliente:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Teléfono del cliente: ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Dirección del cliente: ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Última modificación: ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, 20));

        jTextField_nombreCliente.setBackground(new java.awt.Color(153, 153, 255));
        jTextField_nombreCliente.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jTextField_nombreCliente.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_nombreCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_nombreCliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jTextField_nombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 280, 30));

        jTextField_emailCliente.setBackground(new java.awt.Color(153, 153, 255));
        jTextField_emailCliente.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jTextField_emailCliente.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_emailCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_emailCliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jTextField_emailCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 280, 30));

        jTextField_telCliente.setBackground(new java.awt.Color(153, 153, 255));
        jTextField_telCliente.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jTextField_telCliente.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_telCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_telCliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jTextField_telCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 280, 30));

        jTextField_direccionCliente.setBackground(new java.awt.Color(153, 153, 255));
        jTextField_direccionCliente.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jTextField_direccionCliente.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_direccionCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_direccionCliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jTextField_direccionCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 280, 30));

        jTextField_modificadoPor.setEditable(false);
        jTextField_modificadoPor.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jTextField_modificadoPor.setForeground(new java.awt.Color(153, 153, 153));
        jTextField_modificadoPor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_modificadoPor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jTextField_modificadoPor, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 280, 30));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, 310, 150));

        jButton_registrarEquipo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton_registrarEquipo.setText("Registrar nuevo equipo");
        jButton_registrarEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_registrarEquipoActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_registrarEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, 200, 30));

        jButton_actualizarDatos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton_actualizarDatos.setText("Actualizar datos del cliente");
        jButton_actualizarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_actualizarDatosActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_actualizarDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 310, 200, 30));

        jButton_imprimirCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/impresora.png"))); // NOI18N
        jButton_imprimirCliente.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/impresora.png"))); // NOI18N
        jButton_imprimirCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_imprimirClienteActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_imprimirCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 250, 110, 90));

        jLabel_wallpaper.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_wallpaper.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_wallpaperMouseClicked(evt);
            }
        });
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_actualizarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_actualizarDatosActionPerformed
        
        String nombreCliente = jTextField_nombreCliente.getText().trim();
        String emailCliente = jTextField_emailCliente.getText().trim();
        String telCliente = jTextField_telCliente.getText().trim();
        String dirCliente = jTextField_direccionCliente.getText().trim();

        if (nombreCliente.equals("") || emailCliente.equals("") || telCliente.equals("")
                || dirCliente.equals("")) {
            if (nombreCliente.equals("")) {
                jTextField_nombreCliente.setBackground(Color.red);
            }
            if (emailCliente.equals("")) {
                jTextField_emailCliente.setBackground(Color.red);
            }
            if (telCliente.equals("")) {
                jTextField_telCliente.setBackground(Color.red);
            }
            if (dirCliente.equals("")) {
                jTextField_direccionCliente.setBackground(Color.red);
            }

            JOptionPane.showMessageDialog(null, "Debes completar todos los campos.");

        } else if (!nombreCliente.equals("") && !emailCliente.equals("") && !telCliente.equals("")
                && !dirCliente.equals("")) {
            int hayArroba = 0;
            int posicionArroba = 0;
            int hayPunto = 0;

            for (int i = 0; i < emailCliente.length(); i++) {
                if (emailCliente.charAt(i) == '@') {
                    hayArroba++;
                }
            }

            if (hayArroba != 1) {
                jTextField_emailCliente.setBackground(Color.red);
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
                        PreparedStatement pst = cn.prepareStatement(
                                "update clientes "
                                + "set "
                                + "nombre_cliente = ?, "//1
                                + "email_cliente = ?, "//2
                                + "tel_cliente = ?, "//3
                                + "dir_cliente = ?, "//4
                                + "ultima_modificacion = ? "//5
                                + "where id_cliente = " + ClientesRegistrados.ID );

                        pst.setString(1, nombreCliente);
                        pst.setString(2, emailCliente);
                        pst.setString(3, telCliente);
                        pst.setString(4, dirCliente);
                        pst.setString(5, usuario1);
                        pst.executeUpdate();

                        jTextField_nombreCliente.setText("");
                        jTextField_emailCliente.setText("");
                        jTextField_telCliente.setText("");
                        jTextField_direccionCliente.setText("");

                        jTextField_nombreCliente.setBackground(new Color(38, 176, 55));
                        jTextField_emailCliente.setBackground(new Color(38, 176, 55));
                        jTextField_telCliente.setBackground(new Color(38, 176, 55));
                        jTextField_direccionCliente.setBackground(new Color(38, 176, 55));

                        JOptionPane.showMessageDialog(null, "Actualización exitosa.");
                        dispose();

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Error al actualizar datos del usuario: " + e);
                    }

                } else {
                    jTextField_emailCliente.setBackground(Color.red);
                    JOptionPane.showMessageDialog(null, "Debes introducir un mail válido.");
                    hayArroba = 0;
                    posicionArroba = 0;
                    hayPunto = 0;
                    emailCliente = "";
                    extracto = "";
                }
            }
        }
    }//GEN-LAST:event_jButton_actualizarDatosActionPerformed

    private void jButton_registrarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_registrarEquipoActionPerformed
        new RegistroDeEquipo().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton_registrarEquipoActionPerformed

    private void jLabel_wallpaperMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_wallpaperMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_wallpaperMouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int filaSeleccionada = jTable1.getSelectedRow();        
        ID_EQUIPO = jTable1.getValueAt(filaSeleccionada, 0).toString();
        new InformacionDeEquipo().setVisible(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton_imprimirClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_imprimirClienteActionPerformed
        try {
            gen.imprimirInformeCliente(nombreCliente);
        } catch (BadElementException ex) {
            Logger.getLogger(InformacionDelCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(InformacionDelCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
       dispose();
    }//GEN-LAST:event_jButton_imprimirClienteActionPerformed

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
            java.util.logging.Logger.getLogger(InformacionDelCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformacionDelCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformacionDelCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformacionDelCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformacionDelCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_actualizarDatos;
    private javax.swing.JButton jButton_imprimirCliente;
    private javax.swing.JButton jButton_registrarEquipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel_info_cliente;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField_direccionCliente;
    private javax.swing.JTextField jTextField_emailCliente;
    private javax.swing.JTextField jTextField_modificadoPor;
    private javax.swing.JTextField jTextField_nombreCliente;
    private javax.swing.JTextField jTextField_telCliente;
    // End of variables declaration//GEN-END:variables

   
}
