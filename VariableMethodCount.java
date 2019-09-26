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
public class VariableMethodCount {
    
    String afterRegex, afterRegex1, afterRegex2, afterRegex3, afterRegex4, afterRegex5, afterRegex6, afterRegex7, afterRegex8, afterRegex9, afterRegex10, afterRegex11;
    ArrayList<String> ar = new ArrayList<>(); //arratlist to store names which should be counted java
    ArrayList<String> countarray = new ArrayList<>();  
    ArrayList<String> larray = new ArrayList<>(); 
    String word = "", lineword = "";
    String regword = "";
    
  public ArrayList<String> getMethodeWithDataType(String code) {    
          
       Pattern ptrn = Pattern.compile("long\\W+(\\w+)");         //get long variable count
       Matcher mc = ptrn.matcher(code);                         //get long method count
                                                               //get long array[], []array count
       while(mc.find()) {
         afterRegex = mc.group(1);
         afterRegex = afterRegex.replaceAll("\\(.*\\)", "");  // remove brackets
         //System.out.println(afterRegex);
         ar.add(afterRegex);

       }
         
       Pattern ptrn1 = Pattern.compile("int\\W+(\\w+)");       //get int variable count
       Matcher mc1 = ptrn1.matcher(code);                      //get int method count
                                                               //get int array[], []array count
       while(mc1.find()) {
         afterRegex1 = mc1.group(1);
         afterRegex1 = afterRegex1.replaceAll("\\(.*\\)", "");
         ar.add(afterRegex1);
         
       }
       
       Pattern ptrn2 = Pattern.compile("String\\W+(\\w+)");    //get String variable count
       Matcher mc2 = ptrn2.matcher(code);                         //get String method count
                                                               //get String array[], []array count
       while(mc2.find()) {
         afterRegex2 = mc2.group(1);
         if(!afterRegex2.contains("args")) {
            afterRegex2 = afterRegex2.replaceAll("\\(.*\\)", "");
             //System.out.println("After: " + afterRegex2);
            ar.add(afterRegex2);
         }
       }
       
       Pattern ptrn3 = Pattern.compile("char\\W+(\\w+)");       //get int variable count
       Matcher mc3 = ptrn3.matcher(code);                      //get int method count
                                                               //get int array[], []array count
       while(mc3.find()) {
         afterRegex3 = mc3.group(1);
         afterRegex3 = afterRegex3.replaceAll("\\(.*\\)", "");
         ar.add(afterRegex3);
       }
       
       Pattern ptrn4 = Pattern.compile("boolean\\W+(\\w+)");   //get boolean variable count
       Matcher mc4 = ptrn4.matcher(code);                      //get boolean method count
                                                               //get boolean array[], []array count
       while(mc4.find()) {
         afterRegex4 = mc4.group(1);
         afterRegex4 = afterRegex4.replaceAll("\\(.*\\)", "");
         ar.add(afterRegex4);
       }
       
       Pattern ptrn5 = Pattern.compile("float\\W+(\\w+)");     //get float variable count
       Matcher mc5 = ptrn5.matcher(code);                      //get float method count
                                                               //get float array[], []array count
       while(mc5.find()) {
         afterRegex5 = mc5.group(1);
         afterRegex5 = afterRegex5.replaceAll("\\(.*\\)", "");
         ar.add(afterRegex5);
       }
       
       Pattern ptrn6 = Pattern.compile("double\\W+(\\w+)");     //get double variable count
       Matcher mc6 = ptrn6.matcher(code);                       //get double method count
                                                                //get double array[], []array count
       while(mc6.find()) {
         afterRegex6 = mc6.group(1);
         afterRegex6 = afterRegex6.replaceAll("\\(.*\\)", "");
         ar.add(afterRegex6);
       }
       
       Pattern ptrn7 = Pattern.compile("void\\W+(\\w+)");                  // get method count return type is 'void'
       Matcher mc7 = ptrn7.matcher(code.replaceAll("\\(.*\\)", ""));    
      
        while(mc7.find()) {
            word = mc7.group(1);
            if(!"main".equals(word)) {
               afterRegex7 = mc7.group(1);
               //System.out.println(afterRegex7);
               ar.add(afterRegex7);
           }
       }    
        
        Pattern ptrn8 = Pattern.compile("short\\W+(\\w+)");     //get short variable count
        Matcher mc8 = ptrn8.matcher(code);                       //get short method count
                                                                //get short array[], []array count
        while(mc8.find()) {
         afterRegex8 = mc8.group(1);
         afterRegex8 = afterRegex8.replaceAll("\\(.*\\)", "");
         ar.add(afterRegex8);
       }
        
       return ar;
    }
  
    public int getCount(String line, ArrayList<String> ary) {
    
        int count = 0;
        for(int i = 0; i < ary.size(); i++) {
            lineword = ary.get(i);
            
            Pattern o = Pattern.compile(lineword);
            Matcher k = o.matcher(line);
            while(k.find()) {
                regword = k.group(0);
                System.out.println("Variable method name: " + regword);
              //  if(line.contains(" " + regword) || line.contains(regword + ";")) {
                     count++;
           //     }    
            }
        }
         return count;
    }    
    //get object class count and object count
    public ArrayList<String> getclassnobject(String code) {
          
        String objectClassWord1;
        ArrayList<String> arx = new ArrayList<>();
        
        Pattern ptrn = Pattern.compile("new\\W+(\\w+)");
        Matcher mc = ptrn.matcher(code.replaceAll("\\(.*\\)", "")); //remove double quotes
        
        //System.out.println(code.replaceAll("\\(.*\\)", ""));
        
        while(mc.find()) {
          objectClassWord1 = mc.group(1);
          //System.out.println("class " + objectClassWord1);
          arx.add(objectClassWord1);
        }
              
        return arx;
    }
    
    public int returnclasscount(String line, ArrayList<String> ars) {
        
        int count = 0;
        
        for(int i = 0; i < ars.size(); i++) {
            String w = ars.get(i);
            Pattern oo = Pattern.compile(w);
            Matcher kk = oo.matcher(line.replaceAll("\\(.*\\)", ""));//remove double quotes
            while(kk.find()){
                if(line.contains(w)) {
                    count++;
                }
            }
        }
        return count;
    }
    
    //get object words to an array
    public ArrayList<String> getClassObjects(String code, ArrayList<String> clarray) {  //parse class names array
    
        String objctword = "";
        String neword = "";
//        char c = 0; 
//        int number;
        ArrayList<String> obarray = new ArrayList<String>();
//        
        for(int i = 0; i < clarray.size(); i++) {
          String classnameword = clarray.get(i);
          
          Pattern ptrn = Pattern.compile(classnameword + "\\W+(\\w+)");
          Matcher mc = ptrn.matcher(code.replaceAll("\\(.*\\)", ""));  //remove double quotes
          
          while(mc.find()) {
              objctword = mc.group(1);
              Pattern ptrn1 = Pattern.compile(objctword + "\\W+(\\w+)");
              Matcher mc1 = ptrn1.matcher(code.replaceAll("\\(.*\\)", ""));  //remove double quotes
              
              while(mc1.find()) {
                  neword = mc1.group(1);
                 // System.out.println("New Word: " + neword);  
                 if(neword.contains("new")) {
                       //System.out.println("object word: " + objctword);
                       obarray.add(objctword);
                 }
              }
          }
              
        }
        return obarray;
    }
    
    public int calcClassObjectCount(String line, ArrayList<String> clasobj) {
        
        line = line.replaceAll("\\s+", "").replaceAll("\\(.*\\)", "");  //remove spaces and double quotes
        String word;
        int obcount = 0;
        
        for(int i = 0; i < clasobj.size(); i++) {
            word = clasobj.get(i);
            if(line.contains(word + ".") || line.contains(word + ";") || line.contains(word + ")") || line.contains("(" + word) || line.contains(word + "=") || line.contains("(" + word + ")")) {
                //System.out.println("Real object: " + word );
                obcount++;
            }
        }
        
       return obcount;
    }
}

        
//          
//            while(mc.find()) {
//                objctword = mc.group(1);
//                System.out.println(objctword);
//                number = mc.end();
//                c = code.charAt(number);
//               
//                    if(c == '=') {
//                       obarray.add(objctword);
//                        System.out.println("obj: " + objctword);
//                        System.out.println("objlast: " + c);
//                    }
//                
//            }
//        }
//        return obarray;  

             
    //get class object count
//    public int returnobjectCount(String code, ArrayList<String> classnames) {
//        int countq = 0;
//        int number;
//        char c = 0;
//        String objctword = "";
//        String ob = "";
//        ArrayList<String> ar = new ArrayList<>();
//       
//        ar = getclassnobject(code);
//        
//        for(int i = 0; i < ar.size(); i++) {
//            String word = ar.get(i);
//            
//            Pattern ptrn = Pattern.compile(word + "\\W+(\\w+)");
//            Matcher mc = ptrn.matcher(code.replaceAll("\\(.*\\)", ""));
//            
//            while(mc.find()) {
//               objctword = mc.group(1);
//               System.out.println(objctword);
//            
//               number = mc.end();
//               c = code.charAt(number); 
//               
//               if(c == '=' | c == ';' | c == '.' | c == ' ') {
//                   countq++;
//               }
//               
//            Pattern ptrn1 = Pattern.compile(objctword);
//            Matcher mc1 = ptrn1.matcher(code.replaceAll("\\(.*\\)", ""));
//            while(mc1.find()) {
//               number = mc.end();
//               c = code.charAt(number); 
//                
//               if(c == '=' | c == ';' | c == '.' | c == ' ') {
//                   countq++;
//               }
//            }
//               
//            }
//            
//            
//        }
//        
//        if(countq == 0)
//            countq = 0;
//        else
//            countq = countq - 1;
//        
//        return countq;
//
//
//    }   