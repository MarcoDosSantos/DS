package clases;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.JOptionPane;
import ventanas.ClientesRegistrados;

public class GeneradorPDF {
    private Calendar calendario = Calendar.getInstance();
    private String horaHoy = String.valueOf(calendario.get(Calendar.HOUR_OF_DAY));
    private String minutosHoy = String.valueOf(calendario.get(Calendar.MINUTE));
    private String diaHoy = String.valueOf(calendario.get(Calendar.DAY_OF_MONTH));
    private String mesHoy = String.valueOf(1 + calendario.get(Calendar.MONTH));
    private String annioHoy = String.valueOf(calendario.get(Calendar.YEAR));

    public void imprimirInformeCliente(String nombreCliente) throws BadElementException, IOException {
        Document documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento,
                    new FileOutputStream(ruta + "/Desktop/Informe Cliente " + nombreCliente + ".PDF"));

            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.setFont(FontFactory.getFont("Arial", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("\nInformación del cliente\n\n");

            Paragraph parrafo2 = new Paragraph();
            parrafo2.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo2.setFont(FontFactory.getFont("Arial", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo2.add("\nEquipos registrados\n\n");
            
            Paragraph fechaHora = new Paragraph();
            fechaHora.setAlignment(Paragraph.ALIGN_RIGHT);
            fechaHora.add("\n\n\n\n\n\n\n\n\n\n\n\nFecha: " + diaHoy + " del " + mesHoy + 
                    " de " + annioHoy + "\n Hora: " + horaHoy + ": " + minutosHoy);

            documento.open();
            Image logo = Image.getInstance("src/images/BannerPDF.jpg");
            logo.scaleToFit(560, 1000);
            logo.setAlignment(Chunk.ALIGN_TOP);

            PdfPTable tabla = new PdfPTable(5);
            tabla.addCell("ID Cliente");
            tabla.addCell("Nombre");
            tabla.addCell("Email");
            tabla.addCell("Teléfono");
            tabla.addCell("Dirección");

            PdfPTable tabla2 = new PdfPTable(4);
            tabla2.addCell("ID Equipo");
            tabla2.addCell("Tipo");
            tabla2.addCell("Marca");
            tabla2.addCell("Estado");

            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select * from clientes, equipos where "
                                + "clientes.id_cliente = equipos.id_cliente "
                                + "and clientes.id_cliente = " + ClientesRegistrados.ID);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    tabla.addCell(rs.getString("clientes.id_cliente"));
                    tabla.addCell(rs.getString("clientes.nombre_cliente"));
                    tabla.addCell(rs.getString("clientes.email_cliente"));
                    tabla.addCell(rs.getString("clientes.tel_cliente"));
                    tabla.addCell(rs.getString("clientes.dir_cliente"));

                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró el cliente indicado.");
                }
                documento.add(logo);
                documento.add(fechaHora);
                documento.add(parrafo);
                documento.add(tabla);

                do {
                    tabla2.addCell(rs.getString("equipos.id_equipo"));
                    tabla2.addCell(rs.getString("equipos.tipo_equipo"));
                    tabla2.addCell(rs.getString("equipos.marca"));
                    tabla2.addCell(rs.getString("equipos.estado"));
                } while (rs.next());
                documento.add(parrafo2);
                documento.add(tabla2);

            } catch (HeadlessException | SQLException e) {
                System.out.println(e);
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "Informe creado exitosamente");

        } catch (DocumentException | FileNotFoundException e) {
            System.out.println(e);
        }

    }

    public void imprimirTodos() {
        Document documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento,
                    new FileOutputStream(ruta + "/Desktop/Informe Clientes Data System.PDF"));

            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.setFont(FontFactory.getFont("Arial", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("\nInformación de clientes\n\n");
            
            Paragraph fechaHora = new Paragraph();
            fechaHora.setAlignment(Paragraph.ALIGN_RIGHT);
            fechaHora.add("\n\n\n\n\n\n\n\n\n\n\n\nFecha: " + diaHoy + " del " + mesHoy + 
                    " de " + annioHoy + "\n Hora: " + horaHoy + ": " + minutosHoy);

            documento.open();
            Image logo = Image.getInstance("src/images/BannerPDF.jpg");
            logo.scaleToFit(560, 1000);
            logo.setAlignment(Chunk.ALIGN_TOP);

            PdfPTable tabla = new PdfPTable(5);
            tabla.addCell("ID Cliente");
            tabla.addCell("Nombre");
            tabla.addCell("Email");
            tabla.addCell("Teléfono");
            tabla.addCell("Dirección");

            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select * from clientes");
                ResultSet rs = pst.executeQuery();
                while (rs.next()){
                    tabla.addCell(rs.getString("id_cliente"));
                    tabla.addCell(rs.getString("nombre_cliente"));
                    tabla.addCell(rs.getString("email_cliente"));
                    tabla.addCell(rs.getString("tel_cliente"));
                    tabla.addCell(rs.getString("dir_cliente"));
                } 
                documento.add(logo);
                documento.add(fechaHora);
                documento.add(parrafo);
                documento.add(tabla);

            } catch (SQLException e) {
                System.out.println(e);
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "Informe creado exitosamente");

        } catch (DocumentException | IOException e) {
            System.out.println(e);
        }
        
    }

}
