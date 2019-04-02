
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



public class InformacionDeEquipo extends javax.swing.JFrame {
    private String usuario1 = new Login().usuario;
    private String tipoNivel;
    private String identificadorEquipo;
        

    public InformacionDeEquipo() {
        initComponents();
        setSize(650, 450); 
        setResizable(false); 
        setLocationRelativeTo(null); 
        setTitle("Información de equipo - Sesion de " + usuario1); 
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
        establecerIdentificadorEquipo();
        completarDatos();
        establecerEditabilidad();
    }
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png"));
        return retValue;
    }
    
    public void establecerIdentificadorEquipo(){
        try{
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select tipo_nivel from usuarios where id_usuario = " + Login.id_usuario);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                tipoNivel = rs.getString("tipo_nivel");
                if(tipoNivel.equals("Capturista")){
                    identificadorEquipo= InformacionDelCliente.ID_EQUIPO;
                }
                else if(tipoNivel.equals("Técnico" )){
                    identificadorEquipo= GestionEquipos.ID_EQUIPO;
                } else if (tipoNivel.equals("Administrador")){
                    if(InformacionDelCliente.ID_EQUIPO != null)identificadorEquipo= InformacionDelCliente.ID_EQUIPO;
                    else {identificadorEquipo= GestionEquipos.ID_EQUIPO;}
                }
            }else{
            JOptionPane.showMessageDialog(null, "No se encontró el nivel de acceso del usuario."); }
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, "Error al determinar nivel de acceso del usuario: " + e);        
        }    
    }
    
    public void completarDatos(){
        try{
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select * from equipos, clientes where "
                            + "clientes.id_cliente = equipos.id_cliente and id_equipo = " 
                            + identificadorEquipo);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                jTextField_nombreCliente.setText(rs.getString("clientes.nombre_cliente"));
                jTextField_modeloEquipo.setText(rs.getString("equipos.modelo"));
                jTextField_numeroSerie.setText(rs.getString("equipos.num_serie"));
                jTextField_ultimaMod.setText(rs.getString("equipos.ultima_modificacion"));
                jTextArea_observaciones.setText(rs.getString("equipos.observaciones"));
                jTextArea_comentarios.setText(rs.getString("equipos.comentarios_tecnicos"));
                jTextField_fechaIngreso.setText(rs.getString("equipos.dia_ingreso") 
                        + "/" + rs.getString("equipos.mes_ingreso")+ "/" + rs.getString("equipos.annio_ingreso"));
                
                String tipoEquipo = rs.getString("equipos.tipo_equipo").trim();
                jComboBox_tipoEquipo.setSelectedItem(tipoEquipo);
                
                
                String marcaEquipo = rs.getString("equipos.marca").trim();
                jComboBox_marcaEquipo.setSelectedItem(marcaEquipo);
                
                
                String estado = rs.getString("equipos.estado").trim();
                jComboBox_estado.setSelectedItem(estado);
                
            
            }else{
                JOptionPane.showMessageDialog(null, "No se encontró el registro solicitado.");                
            }
        
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos.\n Por favor,"
                    + "comuníquese con el Administrador y reporte el siguiente error: " + e);
        
        }
    }
    
    public void establecerEditabilidad(){        
        try{
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select tipo_nivel from usuarios where id_usuario = " + Login.id_usuario);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                tipoNivel = rs.getString("tipo_nivel");
                if(tipoNivel.equals("Capturista")){
                    jTextArea_comentarios.setEditable(false);
                }
                else if(tipoNivel.equals("Técnico")){
                    jTextArea_observaciones.setEditable(false);
                    jTextField_nombreCliente.setText("");
                }
            }else{
            JOptionPane.showMessageDialog(null, "No se encontró el nivel de acceso del usuario."); }
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, "Error al determinar nivel de acceso del usuario: " + e);
        
        }
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_informacion_equipo = new javax.swing.JLabel();
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
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_observaciones = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea_comentarios = new javax.swing.JTextArea();
        jLabel_footer = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField_ultimaMod = new javax.swing.JTextField();
        jButton_actualizar = new javax.swing.JButton();
        jLabel_fechaIngreso = new javax.swing.JLabel();
        jLabel_estado = new javax.swing.JLabel();
        jTextField_fechaIngreso = new javax.swing.JTextField();
        jComboBox_estado = new javax.swing.JComboBox<>();
        jLabel_wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_informacion_equipo.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel_informacion_equipo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_informacion_equipo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_informacion_equipo.setText("Información de equipo");
        getContentPane().add(jLabel_informacion_equipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 600, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre del cliente:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tipo de equipo");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Marca");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Modelo ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Daño reportado y observaciones");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, -1, 20));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Última modificación");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, -1, 20));

        jTextField_nombreCliente.setEditable(false);
        jTextField_nombreCliente.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jTextField_nombreCliente.setForeground(new java.awt.Color(109, 109, 109));
        jTextField_nombreCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_nombreCliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jTextField_nombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 280, 30));

        jComboBox_tipoEquipo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jComboBox_tipoEquipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Notebook", "Netbook", "Desktop", "Impresora", "Multifunción" }));
        getContentPane().add(jComboBox_tipoEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        jComboBox_marcaEquipo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jComboBox_marcaEquipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Acer", "Apple", "Asus", "Banghó", "Brother", "Commodore", "Compaq", "Dell", "Epson", "Hewlett Packard", "Lexmark", "LG", "Sony Vaio", "Xerox", "Otra" }));
        getContentPane().add(jComboBox_marcaEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        jTextField_modeloEquipo.setBackground(new java.awt.Color(153, 153, 255));
        jTextField_modeloEquipo.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jTextField_modeloEquipo.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_modeloEquipo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_modeloEquipo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jTextField_modeloEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 280, 30));

        jTextField_numeroSerie.setBackground(new java.awt.Color(153, 153, 255));
        jTextField_numeroSerie.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jTextField_numeroSerie.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_numeroSerie.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_numeroSerie.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jTextField_numeroSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 280, 30));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Observaciones técnicas");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, -1, 20));

        jTextArea_observaciones.setColumns(20);
        jTextArea_observaciones.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextArea_observaciones.setRows(5);
        jScrollPane1.setViewportView(jTextArea_observaciones);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 230, 120));

        jTextArea_comentarios.setColumns(20);
        jTextArea_comentarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextArea_comentarios.setRows(5);
        jScrollPane2.setViewportView(jTextArea_comentarios);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 240, 230, 120));

        jLabel_footer.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_footer.setText("Creado por Marco Dos Santos");
        getContentPane().add(jLabel_footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 400, -1, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Número de serie");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, -1, 20));

        jTextField_ultimaMod.setEditable(false);
        jTextField_ultimaMod.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jTextField_ultimaMod.setForeground(new java.awt.Color(153, 153, 153));
        jTextField_ultimaMod.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_ultimaMod.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jTextField_ultimaMod, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 280, 30));

        jButton_actualizar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton_actualizar.setText("Actualizar datos de equipo");
        jButton_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_actualizarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(443, 370, 190, 30));

        jLabel_fechaIngreso.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_fechaIngreso.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_fechaIngreso.setText("Fecha de ingreso");
        getContentPane().add(jLabel_fechaIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, -1, -1));

        jLabel_estado.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_estado.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_estado.setText("Estado");
        getContentPane().add(jLabel_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, -1, -1));

        jTextField_fechaIngreso.setEditable(false);
        jTextField_fechaIngreso.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jTextField_fechaIngreso.setForeground(new java.awt.Color(102, 102, 102));
        jTextField_fechaIngreso.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_fechaIngreso.setText("dia, mes, año");
        getContentPane().add(jTextField_fechaIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 130, 30));

        jComboBox_estado.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jComboBox_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nuevo ingreso", "No reparado", "En revisión", "Reparado", "Entregado", " " }));
        getContentPane().add(jComboBox_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, -1, -1));

        jLabel_wallpaper.setForeground(new java.awt.Color(109, 109, 109));
        jLabel_wallpaper.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_actualizarActionPerformed
        try{
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("update equipos set "
                    + "tipo_equipo = ?, marca = ?, modelo = ?, num_serie = ?, observaciones = ?, "
                    + "ultima_modificacion = ?, comentarios_tecnicos = ?, revision_tecnica_de = ?, "
                    + "estado = ? where id_equipo = " + identificadorEquipo);
            
            String tipoEquipo = jComboBox_tipoEquipo.getSelectedItem().toString();
            String marca = jComboBox_marcaEquipo.getSelectedItem().toString();
            String modelo = jTextField_modeloEquipo.getText();
            String numSerie = jTextField_numeroSerie.getText();
            String observaciones = jTextArea_observaciones.getText();
            String ultimaModificacion = usuario1;
            String comentariosTecnicos = jTextArea_comentarios.getText();
            String revision = "";
            if(tipoNivel.equals("Técnico")){revision = usuario1;}
            String estado = jComboBox_estado.getSelectedItem().toString();
            
            pst.setString(1, tipoEquipo);
            pst.setString(2, marca);
            pst.setString(3, modelo);
            pst.setString(4, numSerie);
            pst.setString(5, observaciones);
            pst.setString(6, ultimaModificacion);
            pst.setString(7, comentariosTecnicos);
            pst.setString(8, revision);
            pst.setString(9, estado);
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Actualización exitosa.");
        
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }//GEN-LAST:event_jButton_actualizarActionPerformed

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
            java.util.logging.Logger.getLogger(InformacionDeEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformacionDeEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformacionDeEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformacionDeEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformacionDeEquipo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_actualizar;
    private javax.swing.JComboBox<String> jComboBox_estado;
    private javax.swing.JComboBox<String> jComboBox_marcaEquipo;
    private javax.swing.JComboBox<String> jComboBox_tipoEquipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel_estado;
    private javax.swing.JLabel jLabel_fechaIngreso;
    private javax.swing.JLabel jLabel_footer;
    private javax.swing.JLabel jLabel_informacion_equipo;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea_comentarios;
    private javax.swing.JTextArea jTextArea_observaciones;
    private javax.swing.JTextField jTextField_fechaIngreso;
    private javax.swing.JTextField jTextField_modeloEquipo;
    private javax.swing.JTextField jTextField_nombreCliente;
    private javax.swing.JTextField jTextField_numeroSerie;
    private javax.swing.JTextField jTextField_ultimaMod;
    // End of variables declaration//GEN-END:variables
}
