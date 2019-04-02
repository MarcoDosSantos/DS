package clases;
import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion {
    public static Connection conectar(){
        String urlRemota = "";
        String usuarioRemoto= "";
        String contraseniaRemota = "";
        try {
        Connection cn = DriverManager.getConnection(urlRemota, usuarioRemoto, contraseniaRemota);
        return cn;
        } catch (SQLException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos.");        
        }
        return (null);
    }
}
// 