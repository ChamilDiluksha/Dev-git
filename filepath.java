/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complexity_measure_tool;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Programmer
 */
public class filepath {
    
    private    String path;
    public filepath(String path)
    {
        this.path = path;
    }
    public  String readText() throws FileNotFoundException {
        
                    StringBuffer buffer = new StringBuffer();
                    
	    Scanner scan = new Scanner(new File(path));
	    while(scan.hasNextLine()){
	        String line = scan.nextLine();
	      
                       buffer.append(line + "\n");
	    }
            
                   return String.valueOf(buffer);
	}
}
