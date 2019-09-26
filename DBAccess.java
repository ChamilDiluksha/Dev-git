/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DbCrudCodes;

import complexity_measure_tool.DbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Programmer
 */
public class DBAccess {
    
    private static Connection connection;
    
         public static boolean executeQuery(String query,String message)
    {
        boolean status = false;
        
        try {
            
                connection = DbConnection.getDbConnection();
                Statement st = connection.createStatement();
    
                 if( ( st.executeUpdate(query) )== 1 )
                 {
                       status = true;
                 }
                else
                 {
                       JOptionPane.showMessageDialog(null, " Data Not " + message + " Successfully");
                      
                 }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return status;
        
    }
         
         
   public static boolean RegisterUser(String id,String name, String paswrd, String comPaswrd)
   {
            String query = "insert into user values ('"+id+"' ,'"+name+"' , '"+paswrd+"' ,  '"+comPaswrd+"' )";
            return  executeQuery(query, "Inserted");
   }
   
   
    public static String login(String userName, String password) throws ClassNotFoundException{
        String status = "fail";
        String sql = "select * from user";
        String uName;
        String pWord;
      
        try {
            
            
            connection = DbConnection.getDbConnection();
           Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                uName = rs.getString("userName");
                pWord = rs.getString("password");
                if(uName.equals(userName)){
                    if(pWord.equals(password)){
                        status = "pass";
                        break;
                    }else{
                        status = "IP";
                        break;
                    }
                }else{
                    status = "fail";
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return status;
    }
    
}
