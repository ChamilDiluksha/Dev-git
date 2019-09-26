/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaClassesNew;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author User
 */
public class countInheritance {
    
    public int countInheritClasses(String code) {                      //count inherit classes in java 
        int count1 = 0;                                                // 1 java class - 2 inheritence
        int count2 = 0;                                                // 2 java class - 4 inheritence
        int finalcount;                                                // 3 java class - 5 inheritence 
                                                     
        Pattern ptrn = Pattern.compile("extends");            
        Matcher mc = ptrn.matcher(code);
        
        while(mc.find()) {
          count1++;
        }
        
        Pattern ptrn1 = Pattern.compile(":\\W+(\\w+)");                  
        Matcher mc1 = ptrn1.matcher(code);

        while(mc1.find()) {
            if(null != mc1.group(1))switch (mc1.group(1)) {
                case "public":
                    count2++;
                    break;
                case "private":
                    count2++;
                    break;
                case "protected":
                    count2++;
                    break;
                default:
                    break;
            }
        }    
            
       finalcount = count1 + count2;
       return finalcount;
    }
       
    public int calcLineInheritance(String line, int finCount) {   
       
       String foundword1 = "class";
       String foundword2 = "import";
       line = line.replaceAll("\\s+", "");    //remove spaces
                   
       
       if(line.startsWith("}") )                     //check the line strats with } 
           finCount = 0;
       else if(line.startsWith("{") )                     //check the line strats with {
           finCount = 0;
       else if(line.startsWith("\\"))               //check the line is comment
           finCount = 0;
       else if(line.startsWith("try ") | line.startsWith("try{"))   //check the line starts with try statement
           finCount = 0;
       else if(line.startsWith("else ") | line.startsWith("else{"))  //check the line starts with else statement
           finCount = 0;
       else if(line.contains(foundword1) | line.contains(foundword2))  //check the line is class or import statement
           finCount = 0;
       else if(line != null & line.length() > 0)
           finCount = finCount + 2;
       
       return finCount;
    }   
    
}
