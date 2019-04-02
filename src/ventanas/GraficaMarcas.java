
package ventanas;

import clases.Conexion;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Marco
 */
public class GraficaMarcas extends javax.swing.JFrame {
    private String usuario1 = new Login().usuario;
    
    String [] marcas = {"Acer", "Apple", "Asus", "Banghó", "Brother", "Commodore", 
            "Compaq", "Dell", "Epson", "Hewlett Packard", "Lenovo", "Lexmark","Lg", "SonyVaio", "Xerox", "Otra"};
    Integer [] cantidadesPorMarca = new Integer[16];        
    int j = 0;
    
    public GraficaMarcas() {
        initComponents();
        setSize(550, 430);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Gráfica de marcas de equipos - Sesion de " + usuario1);
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
    
    private void obtenerDatos(){
                
        try{
            Connection cn = Conexion.conectar();
            for(int i = 0; i < marcas.length; i++){
                PreparedStatement pst = cn.prepareStatement("select marca, count(*) "
                        + "from equipos where marca = '" + marcas[i] + "'" );
                ResultSet rs = pst.executeQuery();
                if(rs.next()){
                    cantidadesPorMarca [j]= Integer.valueOf(rs.getString("count(*)"));
                    //System.out.println(j + " " + marcas [i] + " " + cantidadesPorMarca [j]);
                    j++;
                }            
            }
                    
        }catch(SQLException e){
            System.out.println(e);
        }        
               
    }
    
    @Override
    public void paint(Graphics g){
        obtenerDatos();
        super.paint(g);
        
        int acer = cantidadesPorMarca[0];
        int apple = cantidadesPorMarca[1];
        int asus = cantidadesPorMarca[2];
        int bangho = cantidadesPorMarca[3];
        int brother = cantidadesPorMarca[4];
        int commodore = cantidadesPorMarca[5];
        int compaq = cantidadesPorMarca[6];
        int dell = cantidadesPorMarca[7];
        int epson = cantidadesPorMarca[8];
        int hp = cantidadesPorMarca[9];
        int lenovo = cantidadesPorMarca[10];
        int lexmark = cantidadesPorMarca[11];
        int lg = cantidadesPorMarca[12];
        int sonyVaio = cantidadesPorMarca[13];
        int xerox = cantidadesPorMarca[14];
        int otra = cantidadesPorMarca[15];
        
        int cantidadTotal = acer + apple + asus + bangho + brother+ commodore
                +compaq +dell + epson+hp +lenovo +lexmark + lg+ sonyVaio+ xerox+ otra;
        
        int gradosAcer = acer * 360 / cantidadTotal;
        int gradosApple = apple * 360 / cantidadTotal;
        int gradosAsus = asus * 360 / cantidadTotal;
        int gradosBangho = bangho * 360 / cantidadTotal;
        int gradosBrother = brother * 360 / cantidadTotal;
        int gradosCommodore = commodore * 360 / cantidadTotal;
        int gradosCompaq = compaq * 360 / cantidadTotal;
        int gradosDell = dell * 360 / cantidadTotal;
        int gradosEpson = epson * 360 / cantidadTotal;
        int gradosHp = hp * 360 / cantidadTotal;
        int gradosLenovo = lenovo * 360 / cantidadTotal;
        int gradosLexmark = lexmark * 360 / cantidadTotal;
        int gradosLg = lg * 360 / cantidadTotal;
        int gradosSonyVaio = sonyVaio * 360 / cantidadTotal;
        int gradosXerox = xerox * 360 / cantidadTotal;
        int gradosOtra = otra * 360 / cantidadTotal;
        
        g.setColor(new Color(255,0,0));
        g.fillArc(25, 80, 200, 200, 0, gradosAcer);
        g.fillRect(250, 120, 20, 20);
        g.drawString("Acer " + acer, 275, 135);
        
        g.setColor(new Color(0,255,0));
        g.fillArc(25, 80, 200, 200, gradosAcer, gradosApple);
        g.fillRect(250, 140, 20, 20);
        g.drawString("Apple " + apple, 275, 155);
        
        g.setColor(new Color(0,0,255));
        g.fillArc(25, 80, 200, 200, gradosAcer + gradosApple, gradosAsus);
        g.fillRect(250, 160, 20, 20);
        g.drawString("Asus " + asus, 275, 175);
        
        g.setColor(new Color(255,255,255));
        g.fillArc(25, 80, 200, 200, gradosAcer + gradosApple + gradosAsus, gradosBangho);
        g.fillRect(250, 180, 20, 20);
        g.drawString("Banghó " + bangho, 275, 195);
        
        g.setColor(new Color(255,255,0));
        g.fillArc(25, 80, 200, 200, gradosAcer + gradosApple + gradosAsus + gradosBangho, gradosBrother);
        g.fillRect(250, 200, 20, 20);
        g.drawString("Brother " + brother, 275, 215);
        
        g.setColor(new Color(255,0,255));
        g.fillArc(25, 80, 200, 200, gradosAcer + gradosApple + gradosAsus 
                + gradosBangho + gradosBrother, gradosCommodore);
        g.fillRect(250, 220, 20, 20);
        g.drawString("Commodore " + commodore, 275, 235);
        
        g.setColor(new Color(0,255,255));
        g.fillArc(25, 80, 200, 200, gradosAcer + gradosApple + gradosAsus 
                + gradosBangho + gradosBrother + gradosCommodore, gradosCompaq);
        g.fillRect(250, 240, 20, 20);
        g.drawString("Compaq " + compaq, 275, 255);
        
        g.setColor(new Color(0,0,0));
        g.fillArc(25, 80, 200, 200, gradosAcer + gradosApple + gradosAsus 
                + gradosBangho + gradosBrother + gradosCommodore + 
                gradosCompaq, gradosDell);
        g.fillRect(250, 260, 20, 20);
        g.drawString("Dell " + dell, 275, 275);
        
        g.setColor(new Color(150,0,0));
        g.fillArc(25, 80, 200, 200, gradosAcer + gradosApple + gradosAsus 
                + gradosBangho + gradosBrother + gradosCommodore + 
                gradosCompaq + gradosDell, gradosEpson);
        g.fillRect(250, 280, 20, 20);
        g.drawString("Epson " + epson, 275, 295);
        
        g.setColor(new Color(10,150,100));
        g.fillArc(25, 80, 200, 200, gradosAcer + gradosApple + gradosAsus 
                + gradosBangho + gradosBrother + gradosCommodore + 
                gradosCompaq + gradosDell + gradosEpson, gradosHp);
        g.fillRect(370, 120, 20, 20);
        g.drawString("Hewlett Packard " + hp, 395, 135);
    
        g.setColor(new Color(0,0,150));
        g.fillArc(25, 80, 200, 200, gradosAcer + gradosApple + gradosAsus 
                + gradosBangho + gradosBrother + gradosCommodore + 
                gradosCompaq + gradosDell + gradosEpson + gradosHp, gradosLenovo);
        g.fillRect(370, 140, 20, 20);
        g.drawString("Lenovo " + lenovo, 395, 155);
    
        g.setColor(new Color(150,150,0));
        g.fillArc(25, 80, 200, 200, gradosAcer + gradosApple + gradosAsus 
                + gradosBangho + gradosBrother + gradosCommodore + 
                gradosCompaq + gradosDell + gradosEpson + gradosHp + gradosLenovo, gradosLexmark);
        g.fillRect(370, 160, 20, 20);
        g.drawString("Lexmark " + lexmark, 395, 175);
    
        g.setColor(new Color(150,0,150));
        g.fillArc(25, 80, 200, 200, gradosAcer + gradosApple + gradosAsus 
                + gradosBangho + gradosBrother + gradosCommodore + 
                gradosCompaq + gradosDell + gradosEpson + gradosHp + 
                gradosLenovo + gradosLexmark, gradosLg);
        g.fillRect(370, 180, 20, 20);
        g.drawString("Lg " + lg, 395, 195);
        
        g.setColor(new Color(150,150,150));
        g.fillArc(25, 80, 200, 200, gradosAcer + gradosApple + gradosAsus 
                + gradosBangho + gradosBrother + gradosCommodore + 
                gradosCompaq + gradosDell + gradosEpson + gradosHp + 
                gradosLenovo + gradosLexmark + gradosLg, gradosSonyVaio);
        g.fillRect(370, 200, 20, 20);
        g.drawString("Sony Vaio " + sonyVaio, 395, 215);
        
        g.setColor(new Color(255,150,150));
        g.fillArc(25, 80, 200, 200, gradosAcer + gradosApple + gradosAsus 
                + gradosBangho + gradosBrother + gradosCommodore + 
                gradosCompaq + gradosDell + gradosEpson + gradosHp + 
                gradosLenovo + gradosLexmark + gradosLg + gradosSonyVaio, gradosXerox);
        g.fillRect(370, 220, 20, 20);
        g.drawString("Xerox " + xerox, 395, 235);
        
        g.setColor(new Color(150,255,150));
        g.fillArc(25, 80, 200, 200, gradosAcer + gradosApple + gradosAsus 
                + gradosBangho + gradosBrother + gradosCommodore + 
                gradosCompaq + gradosDell + gradosEpson + gradosHp + 
                gradosLenovo + gradosLexmark + gradosLg + gradosSonyVaio+ gradosXerox,gradosOtra);
        g.fillRect(370, 240, 20, 20);
        g.drawString("Otra " + otra, 395, 255);               
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_grafica_marcas = new javax.swing.JLabel();
        jLabel_footer = new javax.swing.JLabel();
        jLabel_wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_grafica_marcas.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel_grafica_marcas.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_grafica_marcas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_grafica_marcas.setText("Gráfica de marcas de equipos");
        getContentPane().add(jLabel_grafica_marcas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 500, -1));

        jLabel_footer.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_footer.setText("Creado por Marco Dos Santos");
        getContentPane().add(jLabel_footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 370, -1, 20));
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 430));

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
            java.util.logging.Logger.getLogger(GraficaMarcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GraficaMarcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GraficaMarcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GraficaMarcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GraficaMarcas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel_footer;
    private javax.swing.JLabel jLabel_grafica_marcas;
    private javax.swing.JLabel jLabel_wallpaper;
    // End of variables declaration//GEN-END:variables
}
