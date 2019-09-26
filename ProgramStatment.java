/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complexity_measure_tool;

import java.util.ArrayList;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Programmer
 */
public class ProgramStatment {
    
    String code;
    private ArrayList<String> array = new ArrayList<>();
    String temp[];
    
    public ProgramStatment(String code){
        this.code = code;
    }
    
    public ArrayList<String> breakProgramStatment()
    {
        
        for(int i = 0; i < code.length(); i++)
        {
            char chr = code.charAt(i);
            
            if(chr == ';')
            {
                    temp = code.split(String.valueOf(chr));
            }
           
         }
        
       
        for(int j = 0; j < temp.length; j++)
        {
            array.add(temp[j]);
        }
        
        
        return  array;
        }
}

  
    
    

