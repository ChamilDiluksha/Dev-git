/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaClassesNew;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author User
 */
public class ExceptionHandle {
    
    int count = 0;
    String afterRegex, objct;
    int catchcount = 0;
    String word = "";
    ArrayList<String> exarray = new ArrayList<>();    //to store exceptions to the array
        
    public int returnExceptionCount(String code) {
        
       int count = 0;
       
       Pattern ptrn = Pattern.compile("Exception"); 
       Matcher mc = ptrn.matcher(code.replaceAll("\".*\"", ""));
       
       while(mc.find()) {
           if(!code.contains("public") && !code.contains("class"))
               count++;
           else
               count = 0;
       }
       return count;
    }
    
    //get exception object count
    
    public ArrayList<String> getAllExceptions(String code) {
                
        if(code.contains("throws")) {
            Pattern ptrnew = Pattern.compile("throws\\W+(\\w+)"); 
            Matcher mcnew = ptrnew.matcher(code.replaceAll("\".*\"", ""));
            
            String newword;
            while(mcnew.find()) {
               newword = mcnew.group(1);
               //System.out.println("obj : " + newword);
               
               Pattern ptrne = Pattern.compile(newword + "\\W+(\\w+)"); 
               Matcher mcne = ptrne.matcher(code.replaceAll("\".*\"", ""));
               
               String xword;
               while(mcne.find()) {
                  xword = mcne.group(1);
                  System.out.println("obj : " + xword);
                  exarray.add(xword);
               }
               
            }
          }
        
        else if(code.contains("catch") && !code.contains("throws")) {
            
            
                code = code.replaceAll("\\(", " ").replaceAll("\\)", " ");
                //System.out.println(code);
            
                Pattern ptrn = Pattern.compile("catch\\W+(\\w+)"); 
                Matcher mcn = ptrn.matcher(code.replaceAll("\".*\"", ""));
            
                String exword;
                while(mcn.find()) {
                    exword = mcn.group(1);
                    //System.out.println("obj : " + exword);
                    if(exword.contains("Exception")) {
                    //System.out.println("obj : " + exword);
                   
                        Pattern ptrne = Pattern.compile(exword + "\\W+(\\w+)"); 
                        Matcher mcne = ptrne.matcher(code.replaceAll("\".*\"", ""));
               
                        String zword;
                        while(mcne.find()) {
                            zword = mcne.group(1);
                            System.out.println("obj : " + zword);
                            exarray.add(zword);
                        }
                    }
               }
        }
        return exarray;
    }
    
    public int countExObjects(String line, ArrayList<String> exob) {
        
        line = line.replaceAll("\\s+", "");  //remove spaces
        String getword = "";
        int getcount = 0;
        String w1;
        
        ArrayList<String> newarray = new ArrayList<>();    //to remove duplicates
        for(int j = 0; j < exob.size(); j++) {
            w1 = exob.get(j);
            if(j == 0)
               newarray.add(w1);
            else {
               if(!newarray.contains(w1))  {
                   newarray.add(w1);
               }
            }
        }
                
        for(int i = 0; i < newarray.size(); i++) {
           getword = newarray.get(i);
           
           if(line.contains("throw") && line.contains(getword + ";"))
                getcount++;
           else if(line.contains("(" + getword + ".")) 
                getcount++;
           else if(line.contains("Exception") && line.contains(getword + ")"))
                getcount++;            
           
           }

        //System.out.println("count: " + getcount);
        return getcount; 
    }
    
    public int countExceptionMehods(String line, ArrayList<String> exob) {
        
        int recount = 0;
        
        ArrayList<String> newa = new ArrayList<>();
        for(int j = 0; j <exob.size(); j++) {         //remove duplicates
            
            String wrd = exob.get(j);
            if(j == 0)
                newa.add(wrd);
            else {
                if(!newa.contains(wrd)) {
                    newa.add(wrd);
                }
            }
        }

        for(int i = 0; i < newa.size(); i++) {
            String x = newa.get(i);
            if(line.contains(".getMessage()") && line.contains(x)) {
                //System.out.println("ooooooooooooooo " + line);
                recount++;
            }
            else if(line.contains(".getCause()") && line.contains(x)) {
                //System.out.println("ooooooooooooooo " + line);
                recount++;
            }
        }
          return recount;
}
    
}
    
    //public ArrayList<String> getException(String code) {  
        
//        Pattern ptrn = Pattern.compile("throw\\W+(\\w+)");         
//        Matcher mc = ptrn.matcher(code);                       
//                                                               
//        while(mc.find()) {
//         afterRegex = mc.group(1);      //get excpeion keyword
//         System.out.println(afterRegex);
//         exarrayo.add(afterRegex);
//         }
//        
//       return exarrayo;
  //  }
    
//    public int countEx(String code) {
//       int counte = 0;
//        int number;
//        char c = 0;
//        String objctword = "";
//        ArrayList<String> ar = new ArrayList<>();
//       
//        ar = getExceptionObject(code);
//        
//        for(int i = 0; i < ar.size(); i++) {
//            String word = ar.get(i);
//            Pattern ptrn = Pattern.compile(word + "\\W+(\\w+)");
//            Matcher mc = ptrn.matcher(code.replaceAll("\\(.*\\)", ""));
//            while(mc.find()) {
//               objctword = mc.group(1);
//               System.out.println(objctword);
//            
//               number = mc.end();
//               c = code.charAt(number); 
//               
//               if(c == '=' | c == ';' | c == '.' | c == ' ') {
//                   counte++;
//               }
//               
//            Pattern ptrn1 = Pattern.compile(objctword);
//            Matcher mc1 = ptrn1.matcher(code.replaceAll("\\(.*\\)", ""));
//            
//            while(mc1.find()) {
//                number = mc.end();
//               c = code.charAt(number); 
//                
//               if(c == '=' | c == ';' | c == '.' | c == ' ') {
//                   counte++;
//               }
//            }
//               
//            }     
//        }
//        
//        if(counte == 0)
//            counte = 0;
//        else
//            counte = counte - 1;
//        
//        return counte;
//}