/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complexity_measure_tool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Programmer
 */
public class genarateIDS {
    
   static Connection con;
   static String id;
   public static String getGenaratedID(String table,String type, String colName)
   {
       
        String query = "SELECT MAX("+colName+"), COUNT(*) FROM "+table+" ";
       
       try {
            con = DbConnection.getDbConnection();
            
             Statement state = con.createStatement();
             ResultSet rslt = state.executeQuery(query);
             
             while(rslt.next())
             {
                int getCount = rslt.getInt(2);
                
                if(getCount == 0)
                {
                       int next = getCount;
                       
                     if(next >= 9 )
                    {
                        id = type + "00";
                        next++;
                        id = id + next;
                    }
                     
                    else if(next >= 99)
                    {
                        id = type + "0";
                        next++;
                        id = id + next;
                    }
                    else
                    {
                        id = type + "000";
                        next++;
                        id = id + next;
                    }
                }
                else{
                
                    String TransID = rslt.getString(1);
                
                    char ch = type.charAt(0);
                    String getLast = TransID.replace( ch , '0');
                
                    // int next = rslt.getInt(1);
               
                    int next = Integer.valueOf(getLast);
                
                    if(next >= 9 )
                    {
                        id = type + "00";
                        next++;
                        id = id + next;
                    }
                    else if(next >= 99)
                    {
                        id = type + "0";
                        next++;
                        id = id + next;
                    }
                    else
                    {
                        id = type + "000";
                        next++;
                        id = id + next;
                    }
                }
             }
       } catch (Exception e) {
       }
       return id;
   }
       
   
   
   
//    private static ArrayList<String> getIDs(String table,String column){
//		
//		ArrayList<String> VehicalList = new ArrayList<String>();
//                            ArrayList<String> BookedList = new ArrayList<String>();
//		/*
//		 * List of employee IDs will be retrieved from EmployeeQuery.xml
//		 */
//		try {
//			con = dbConnection.getDbConnection();
//			
//			String query = "SELECT "+column+" FROM "+table+" ";
//			
//			Statement st = con.createStatement();
//			ResultSet resultSet = st.executeQuery(query);
//			while (resultSet.next()) {
//                            
//                                                        if(table.equals("bokkedvehical"))
//                                                        {
//                                                            BookedList.add(resultSet.getString("BookingID"));
//                                                        }
//                                                        else if(table.equals("Vehical"))
//                                                        {
//                                                            VehicalList.add(resultSet.getString("VehicalID"));
//                                                        }
//				
//			}
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		} 
//		 if(table.equals("bokkedvehical"))
//                              {
//                                     return BookedList;
//                              }
//                             else 
//                             
//                                    return VehicalList;
//                             
//    }
    
}


