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
public class wordComplexityNew {
    
    public int getvoid(String code) {             //get 'void' complexity
       int count = 0;
       
       Pattern ptrn = Pattern.compile("void "); 
       Matcher mc = ptrn.matcher(code);
       
       while(mc.find()) {
         count++;
       }
       return count;
    }
    
    public int getdouble(String code) {             //get 'double' complexity
       int count = 0;                               
       
       Pattern ptrn = Pattern.compile("double |Double |DOUBLE ");
       Matcher mc = ptrn.matcher(code);
       
       while(mc.find()) {
         count++;
       }
       return count;
    }

    
    public int getint(String code) {             //get 'int' complexity
       int count = 0;
       
       Pattern ptrn = Pattern.compile("int |Int |Integer ");
       Matcher mc = ptrn.matcher(code);
       
       while(mc.find()) {
         count++;
       }
       return count;
    }
    
    public int getfloat(String code) {             //get 'float' complexity
       int count = 0;
       
       Pattern ptrn = Pattern.compile("float |Float |FLOAT ");
       Matcher mc = ptrn.matcher(code);
       
       while(mc.find()) {
         count++;
       }
       return count;
    }
    
    public int getString(String code) {             //get 'String' complexity
       int count = 0;
       
       Pattern ptrn = Pattern.compile("String |STRING ");
       Matcher mc = ptrn.matcher(code.replaceAll("\\[", "").replaceAll("\\]", ""));
       
       while(mc.find()) {
         count++;
       }
       return count;
    }
    
    public int getchar(String code) {             //get 'char' complexity
       int count = 0;
       
       Pattern ptrn = Pattern.compile("char ");
       Matcher mc = ptrn.matcher(code);
       
       while(mc.find()) {
         count++;
       }
       return count;
    }
    
    public int getlong(String code) {             //get 'long ' complexity
       int count = 0;
       
       Pattern ptrn = Pattern.compile("long |Long ");
       Matcher mc = ptrn.matcher(code);
       
       while(mc.find()) {
         count++;
       }
       return count;
    }
    
    public int getshort(String code) {             //get 'short ' complexity
       int count = 0;
       
       Pattern ptrn = Pattern.compile("short |Short ");
       Matcher mc = ptrn.matcher(code);
       
       while(mc.find()) {
         count++;
       }
       return count;
    }
    
    public int getboolean(String code) {             //get 'boolean' complexity
       int count = 0;
       
       Pattern ptrn = Pattern.compile("boolean |Boolean ");
       Matcher mc = ptrn.matcher(code);
       
       while(mc.find()) {
         count++;
       }
       return count;
    }
    
    public int getprintf(String code) {             //get 'printf' complexity
       int count = 0;
       
       Pattern ptrn = Pattern.compile("printf");
       Matcher mc = ptrn.matcher(code);
       
       while(mc.find()) {
         count++;
       }
       return count;
    }
    
    public int getprintln(String code) {             //get 'println' complexity
       int count = 0;
       
       Pattern ptrn = Pattern.compile("println");
       Matcher mc = ptrn.matcher(code.replaceAll("\\(.*\\)", "")); //remove brackets
       
       while(mc.find()) {
         count++;
       }
       return count;
    }
    
    public int getcout(String code) {             //get 'cout' complexity
       int count = 0;
       
       Pattern ptrn = Pattern.compile("cout");
       Matcher mc = ptrn.matcher(code);
       
       while(mc.find()) {
         count++;
       }
       return count;
    }
    
    public int getcin(String code) {             //get 'cin' complexity
       int count = 0;
       
       Pattern ptrn = Pattern.compile("cin");
       Matcher mc = ptrn.matcher(code);
       
       while(mc.find()) {
         count++;
       }
       return count;
    }
    
    public int getif(String code) {             //get 'if ' complexity
       int count = 0;
       
       Pattern ptrn = Pattern.compile("if");
       Matcher mc = ptrn.matcher(code);
       
       while(mc.find()) {
         count++;
       }
       return count;
    }
    
    public int getfor(String code) {             //get 'for ' complexity
       int count = 0;
       
       Pattern ptrn = Pattern.compile("for");
       Matcher mc = ptrn.matcher(code);
       
       while(mc.find()) {
         count++;
       }
       return count;
    }
    
    public int getwhile(String code) {             //get 'while ' complexity
       int count = 0;
       
       Pattern ptrn = Pattern.compile("while");
       Matcher mc = ptrn.matcher(code);
       
       while(mc.find()) {
         count++;
       }
       return count;
    }
 
    public int getswitch(String code) {             //get 'Switch' complexity
       int count = 0;
       
       Pattern ptrn = Pattern.compile("switch|Switch");
       Matcher mc = ptrn.matcher(code);
       
       while(mc.find()) {
         count++;
       }
       return count;
    }
    
public int getcase(String code) {             //get 'case' complexity
       int count = 0;
       
       Pattern ptrn = Pattern.compile("case");
       Matcher mc = ptrn.matcher(code);
       
       while(mc.find()) {
         count++;
       }
       return count;
    }

    public int getbreak(String code) {             //get 'break' complexity
       int count = 0;
       
       Pattern ptrn = Pattern.compile("break;");
       Matcher mc = ptrn.matcher(code);
       
       while(mc.find()) {
         count++;
       }
       return count;
    }
     
    public int getendl(String code) {             //get 'endl' complexity
       int count = 0;
       
       Pattern ptrn = Pattern.compile("endl");
       Matcher mc = ptrn.matcher(code);
       
       while(mc.find()) {
         count++;
       }
       return count;
    }   
    
    public int getmain(String code) {             //get 'main ' complexity
       int count = 0;
       
       Pattern ptrn = Pattern.compile("main");
       Matcher mc = ptrn.matcher(code.replaceAll("\\(.*\\)", ""));
       
       while(mc.find()) {
         count++;
       }
       return count;
    }
    
    public int getargs(String code) {             //get 'args ' complexity
       int count = 0;
       
       Pattern ptrn = Pattern.compile("args");
       Matcher mc = ptrn.matcher(code);
       
       while(mc.find()) {
         count++;
       }
       return count;
    }
    
    public int getsystem(String code) {             //get 'System ' complexity
       int count = 0;
       
       Pattern ptrn = Pattern.compile("System");
       Matcher mc = ptrn.matcher(code);
       
       while(mc.find()) {
         count++;
       }
       return count;
    }
    
    public int getOut(String code) {             //get 'out' complexity
       int count = 0;
       
       Pattern ptrn = Pattern.compile("out");
       Matcher mc = ptrn.matcher(code);
       
       while(mc.find()) {
         count++;
       }
       return count;
    }
    
    public int getcatch(String code) {             //get 'catch' complexity
       int count = 0;
       
       Pattern ptrn = Pattern.compile("catch");
       Matcher mc = ptrn.matcher(code);
       
       while(mc.find()) {
         count++;
       }
       return count;
    }
    
    // get keywords of weight 2
    public int getnew(String code) {             //get 'new' complexity
       int count = 0;
       
       Pattern ptrn = Pattern.compile("new");
       Matcher mc = ptrn.matcher(code);
       
       while(mc.find()) {
         count++;
       }
       return (count * 2);
    }
    
    public int getdelete(String code) {             //get 'delete' complexity
       int count = 0;
       
       Pattern ptrn = Pattern.compile("delete ");
       Matcher mc = ptrn.matcher(code);
       
       while(mc.find()) {
         count++;
       }
       return (count * 2);
    }
    
    public int getthrow(String code) {             //get 'throw' complexity
       int count = 0;
       
       Pattern ptrn = Pattern.compile("throw ");
       Matcher mc = ptrn.matcher(code);
       
       while(mc.find()) {
         count++;
       }
       return (count * 2);
    }
       
    public int getthrows(String code) {             //get 'throws' complexity
       int count = 0;
       
       Pattern ptrn = Pattern.compile("throws ");
       Matcher mc = ptrn.matcher(code);
       
       while(mc.find()) {
         count++;
       }
       return (count * 2);
    }
}
