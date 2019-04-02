package ventanas;

import clases.Conexion;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class GraficaEstado extends javax.swing.JFrame {

    private String usuario1 = new Login().usuario;
    String[] estados = {"Nuevo ingreso", "No reparado", "En revisión", "Reparado", "Entregado"};
    Integer[] cantidadesPorEstado = new Integer[5];
    int j = 0;

    private int nuevoIngreso;
    private int noReparado;
    private int enRevision;
    private int reparado;
    private int entregado;
    int mayorValor;

    public GraficaEstado() {
        initComponents();
        setSize(650, 430);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Gráfica de estado de equipos - Sesion de " + usuario1);
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
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png"));
        return retValue;
    }

    public void obtenerDatos() {
        try {
            Connection cn = Conexion.conectar();
            for (int i = 0; i < estados.length; i++) {
                PreparedStatement pst = cn.prepareStatement("select estado, count(*) "
                        + "from equipos where estado = '" + estados[i] + "'");
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    cantidadesPorEstado[j] = Integer.parseInt(rs.getString("count(*)"));
                    //System.out.println(j + " " + estados[i] + " = " + cantidadesPorEstado[j]);
                    j++;
                }
            }

            nuevoIngreso = cantidadesPorEstado[0];
            noReparado = cantidadesPorEstado[1];
            enRevision = cantidadesPorEstado[2];
            reparado = cantidadesPorEstado[3];
            entregado = cantidadesPorEstado[4];

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    private void asignarMayorValor() {
        obtenerDatos();
        for (int i = 0; i < cantidadesPorEstado.length; i++) {
            if (mayorValor < cantidadesPorEstado[i]) {
                mayorValor = cantidadesPorEstado[i];
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        asignarMayorValor();
        System.out.println("Mayor Valor: " + mayorValor);
        int longNuevoIngreso = nuevoIngreso * 400 / mayorValor;
        int longNoReparado = noReparado * 400 / mayorValor;
        int longEnRevision = enRevision * 400 / mayorValor;
        int longReparado = reparado * 400 / mayorValor;
        int longEntregado = entregado * 400 / mayorValor;

        g.setColor(new Color(255, 255, 0));
        g.fillRect(170, 100, longNuevoIngreso, 30);
        jLabel_nuevoIngreso.setText("NUEVO INGRESO: " + nuevoIngreso);

        g.setColor(new Color(255, 0, 0));
        g.fillRect(170, 150, longNoReparado, 30);
        jLabel_noReparado.setText("NO REPARADO: " + noReparado);

        g.setColor(new Color(0, 0, 0));
        g.fillRect(170, 200, longEnRevision, 30);
        jLabel_enRevision.setText("EN REVISIÓN: " + enRevision);

        g.setColor(new Color(255, 255, 255));
        g.fillRect(170, 250, longReparado, 30);
        jLabel_reparado.setText("REPARADO: " + reparado);

        g.setColor(new Color(0, 153, 0));
        g.fillRect(170, 300, longEntregado, 30);
        jLabel_entregado.setText("ENTREGADO: " + entregado);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_grafica_estado_equipos = new javax.swing.JLabel();
        jLabel_footer = new javax.swing.JLabel();
        jLabel_nuevoIngreso = new javax.swing.JLabel();
        jLabel_noReparado = new javax.swing.JLabel();
        jLabel_enRevision = new javax.swing.JLabel();
        jLabel_reparado = new javax.swing.JLabel();
        jLabel_entregado = new javax.swing.JLabel();
        jLabel_wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_grafica_estado_equipos.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel_grafica_estado_equipos.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_grafica_estado_equipos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_grafica_estado_equipos.setText("Gráfica de estado de equipos");
        getContentPane().add(jLabel_grafica_estado_equipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 600, -1));

        jLabel_footer.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_footer.setText("Creado por Marco Dos Santos");
        getContentPane().add(jLabel_footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 370, -1, 20));

        jLabel_nuevoIngreso.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel_nuevoIngreso.setForeground(new java.awt.Color(255, 255, 0));
        jLabel_nuevoIngreso.setText("Nuevo Ingreso");
        getContentPane().add(jLabel_nuevoIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel_noReparado.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel_noReparado.setForeground(new java.awt.Color(255, 0, 0));
        jLabel_noReparado.setText("No reparado");
        getContentPane().add(jLabel_noReparado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jLabel_enRevision.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel_enRevision.setText("En revisión");
        getContentPane().add(jLabel_enRevision, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jLabel_reparado.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel_reparado.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_reparado.setText("Reparado");
        getContentPane().add(jLabel_reparado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel_entregado.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel_entregado.setForeground(new java.awt.Color(0, 153, 0));
        jLabel_entregado.setText("Entregado");
        getContentPane().add(jLabel_entregado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(GraficaEstado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GraficaEstado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GraficaEstado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GraficaEstado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GraficaEstado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel_enRevision;
    private javax.swing.JLabel jLabel_entregado;
    private javax.swing.JLabel jLabel_footer;
    private javax.swing.JLabel jLabel_grafica_estado_equipos;
    private javax.swing.JLabel jLabel_noReparado;
    private javax.swing.JLabel jLabel_nuevoIngreso;
    private javax.swing.JLabel jLabel_reparado;
    private javax.swing.JLabel jLabel_wallpaper;
    // End of variables declaration//GEN-END:variables
}
