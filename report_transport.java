/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package report;


import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfWriter;
import java.io.FileNotFoundException;
import com.itextpdf.kernel.pdf.PdfDocument; 
import com.itextpdf.kernel.pdf.PdfWriter; 
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.Document; 
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell; 
import com.itextpdf.layout.element.IBlockElement;
import com.itextpdf.layout.element.Table;  
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.draw.LineSeparator;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import com.itextpdf.io.image.ImageDataFactory; 
import com.itextpdf.layout.border.DashedBorder;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.Image;
import complexity_measure_tool.DbConnection;
import java.io.IOException;






/**
 *
 * @author Programmer
 */
public class report_transport {
     private static Connection connection;
     
       public static boolean executeQuery(String query,String message)
    {
        
        try {
            
                connection = DbConnection.getDbConnection();
                Statement st = connection.createStatement();
    
                 if( ( st.executeUpdate(query) )== 1 )
                 {
                    
                        
                      return true;
                 }
                else
                 {
                      return false;
                 }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        return true;
    }
     
    public static boolean getBookReport(String CpValue) throws FileNotFoundException, IOException
    {
        
      
        
        
       String query = "SELECT * FROM report";
        try {
            connection = DbConnection.getDbConnection();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
      
        
         // Creating a PdfDocument object   
      String dest = "C:\\Users\\Programmer\\Desktop\\pdf\\ProgramStatment.pdf";         
         
      // Creating a PdfDocument object      
      PdfDocument pdf = new PdfDocument( new PdfWriter(dest));                  
      
      // Creating a Document object       
      Document doc = new Document(pdf); 
      
      Text text1 = new Text( "\n\n****** REPORT FOR Complexity Measurement ******\n" );
      text1.setFontColor(Color.RED);
      text1.setFont(PdfFontFactory.createFont(FontConstants.HELVETICA));
      Paragraph para1 = new Paragraph(text1);
      
      float [] pointColumnWidths1 = {325F,200F};
       Table table1 = new Table(pointColumnWidths1);
        Image img = new Image(ImageDataFactory.create(
         "C:/Users/Programmer/Desktop/pdf/programming-languages.jpg")); 
       Border b1 = new SolidBorder(Color.BLUE, 3);
       
      table1.addCell(new Cell().add(para1).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.CENTER)); 
      table1.addCell(img.setAutoScale(true).setBorder(b1)); 
      doc.add(table1);
     
  
      // Creating a table       
       float [] pointColumnWidths = {90F, 300F, 80F, 80F, 80F, 80F, 80F, 80F, 80F};   
      Table table = new Table(pointColumnWidths);  
                       
                       table.addCell(new Cell().add("Line").setBackgroundColor(Color.BLUE).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.CENTER).setFontColor(Color.WHITE)); 
                       table.addCell(new Cell().add("Program Statment").setBackgroundColor(Color.BLUE).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.CENTER).setFontColor(Color.WHITE)); 
                       table.addCell(new Cell().add("Cs").setBackgroundColor(Color.BLUE).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.CENTER).setFontColor(Color.WHITE)); 
                       table.addCell(new Cell().add("Ctc").setBackgroundColor(Color.BLUE).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.CENTER).setFontColor(Color.WHITE)); 
                       table.addCell(new Cell().add("Cnc").setBackgroundColor(Color.BLUE).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.CENTER).setFontColor(Color.WHITE)); 
                       table.addCell(new Cell().add("Ci").setBackgroundColor(Color.BLUE).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.CENTER).setFontColor(Color.WHITE)); 
                       table.addCell(new Cell().add("TW").setBackgroundColor(Color.BLUE).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.CENTER).setFontColor(Color.WHITE)); 
                       table.addCell(new Cell().add("Cps").setBackgroundColor(Color.BLUE).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.CENTER).setFontColor(Color.WHITE));
                       table.addCell(new Cell().add("Cr").setBackgroundColor(Color.BLUE).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.CENTER).setFontColor(Color.WHITE)); 
                   
                     while(rs.next())
                    {
                        
                        
                        String Sline = rs.getString("LineNb");
                        String Scs =  rs.getString("Cs");
                        String Sctc =  rs.getString("Ctc");
                        String Scnc =   rs.getString("Cnc");
                        String Sci = rs.getString("Ci");
                        String Stw = rs.getString("TW");
                        String Scps =  rs.getString("Cps");
                        String Scr =   rs.getString("Cr");

                         if(Sline.equals("0")){
                             Sline = "";
                         }
                         if(Scs.equals("0")){
                             Scs = "";
                         }
                         if(Sctc.equals("0")){
                              if(Scs.equals(""))
                                 Sctc = "";
                              else
                                 Sctc = "0";
                         }
                         if(Scnc.equals("0")){
                              if(Scs.equals(""))
                                 Scnc = "";
                              else
                                 Scnc = "0";
                         }
                         if(Sci.equals("0")){
                              if(Scs.equals(""))
                                 Sci = "";
                              else
                                 Sci = "0";
                         }
                         if(Stw.equals("0")){
                              if(Scs.equals(""))
                                 Stw = "";
                              else
                                 Stw = "0";
                         }
                         if(Scps.equals("0")){
                              if(Scs.equals(""))
                                 Scps = "";
                              else
                                 Scps = "0";
                         }
                         if(Scr.equals("0")){
                              if(Scs.equals(""))
                                 Scr = "";
                              else
                                 Scr = "0";
                         }
                        

                       table.addCell(new Cell().add(Sline).setBackgroundColor(Color.WHITE).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.CENTER)); 
                       table.addCell(new Cell().add(rs.getString("ProgramStatment")).setBackgroundColor(Color.WHITE).setBorder(Border.NO_BORDER)); 
                       table.addCell(new Cell().add(Scs).setBackgroundColor(Color.WHITE).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.CENTER)); 
                       table.addCell(new Cell().add(Sctc).setBackgroundColor(Color.WHITE).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.CENTER)); 
                       table.addCell(new Cell().add(Scnc).setBackgroundColor(Color.WHITE).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.CENTER)); 
                       table.addCell(new Cell().add(Sci).setBackgroundColor(Color.WHITE).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.CENTER)); 
                       table.addCell(new Cell().add(Stw ).setBackgroundColor(Color.WHITE).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.CENTER)); 
                       table.addCell(new Cell().add(Scps).setBackgroundColor(Color.WHITE).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.CENTER)); 
                       table.addCell(new Cell().add(Scr).setBackgroundColor(Color.WHITE).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.CENTER)); 
                       
                        //records = records + rs.getString("BookingID") + "   " + rs.getString("PackageID") + "   " +  rs.getString("VehicalID") + "   " +rs.getString("CustomerID") + "   " + rs.getString("Date") +"   " +rs.getString("FLocation") + "      " +rs.getString("TLocation") +"       " + rs.getString("Distance") + "\n\n";
                    }
                     
                     
                     doc.add(table);
                     
                Text text2 = new Text( "______________________________________________________________________________\n" +"\tCP     :  \t\t\t\t\t\t\t" + CpValue +"\n______________________________________________________________________________");
                text2.setFontColor(Color.RED).setBold();
                text2.setFont(PdfFontFactory.createFont(FontConstants.HELVETICA));
                Paragraph para2 = new Paragraph(text2);
     
                doc.add(para2); 
                      doc.close();
           
      // Closing the document       
     
      
               
                
        }catch(Exception e){
              
        }
      System.out.println("Table created successfully..");  
         String DeleteQuery1 = "DELETE from report ";
         boolean ss = executeQuery(DeleteQuery1, "Deleted");
     
      
      return true;
      
      
    }
    
      
}
