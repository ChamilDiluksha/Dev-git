/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaClassesNew;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class MainClass {
    
    int allcount = 0;
    int getv, getd, geti, getf, gets, getc, getl, getsh, getb;
    int lastcount = 0;
    int getpf, getpln, getco, getci, getIf, getFor, getWhile, getswi, getca, getcat, getend, getma, getarg, getsys, getou;
    int getnew, getthrows, getthrow, getdelete;
    int getcount = 0;
    String code;
            
    public int complexityOperators(String code) {
        char ch = 0;
        int count = 0;
        
        Stack sc = new Stack(code.length());
        for(int i = 0; i < code.length(); i++) {
            ch = code.charAt(i);
            sc.push(ch);         
        }   
        
        if(!code.contains("import")) {
        
        while(!sc.isEmpty()) {
            char character = sc.pop();
            if(character == '+') {            
                if(sc.peek() == '+') {       // arithmetic ++ operator
                    count++;
                    sc.pop();
                }
                else   // arithmetic + operator
                    count++; 
            }
            else if(character == '-') {  
                if(sc.peek() == '-') {       // arithmetic -- operator
                    count++;
                    sc.pop();
                }
                else if(sc.peek() != '-')    // arithmetic - operator
                    count++; 
            }
            else if(character == '*') {      // arithmetic * operator 
                count++;
            }
            else if(character == '/') {      // arithmetic / operator
                count++;
                sc.pop();
            }
            else if(character == '%'){       // arithmetic % operator
                count++;
                sc.pop();
            }
            else if(character == '=')  {      //relational operators 
                if(sc.peek() == '=') {       //relational == operator
                    count++;
                    sc.pop();
                }     
                else if(sc.peek() == '!') {   //relational != operator
                    count++;
                    sc.pop();
                }
                else if(sc.peek() == '>') {   //relational >= operator
                    sc.pop();
                    if(sc.peek() != '>') {    //relational >= operator
                        count++;
                        sc.pop();
                    }
                    else if(sc.peek() == '>') { //assignment >>= operator
                        count++;
                        sc.pop();
                        if(sc.peek() == '>') {  //assignment >>>= operator
                           count++;
                           sc.pop();
                        }
                    }
                }
                else if(sc.peek() == '<') {   //relational <= operator
                    sc.pop();
                    if(sc.peek() != '<') {    //relational <= operator
                        count++;
                        sc.pop();
                    }
                    else if(sc.peek() == '<') { //assignment <<= operator
                        count++;
                        sc.pop();
                    }
                }
                else if(sc.peek() == '+') {   //assignment += operator
                    count++;
                    sc.pop();
                }
                else if(sc.peek() == '-') {   //assignment -= operator
                    count++;
                    sc.pop();
                }
                else if(sc.peek() == '*') {   //assignment *= operator
                    count++;
                    sc.pop();
                }
                else if(sc.peek() == '/') {   //assignment /= operator
                    count++;
                    sc.pop();
                }
                else if(sc.peek() == '|') {   //assignment |= operator
                    count++;
                    sc.pop();
                }
                else if(sc.peek() == '&') {   //assignment &= operator
                    count++;
                    sc.pop();
                }
                else if(sc.peek() == '%') {   //assignment %= operator
                    count++;
                    sc.pop();
                }
                else if(sc.peek() == '^') {   //assignment ^= operator
                    count++;
                    sc.pop();
                }
                else                          //assignment = operator
                    count++;
            }   
            else if(character == '<')   {      //relational < operator
                if(sc.peek() != '<') {
                    count++;
                    sc.pop();
                }
                else if(sc.peek() == '<') {   //bitwise << operator
                    sc.pop();
                    if (sc.peek() != '<') {
                       count++;
                       sc.pop();
                    }
                    else if(sc.peek() == '<'){     //bitwise <<< operator
                        count++;
                        sc.pop();
                    }             
                }
            }
            else if(character == '>') {        //relational > operator
                if(sc.peek() != '-' && sc.peek() != '>') {
                      count++;
                      sc.pop();
                }
                else if(sc.peek() == '-') {  //miscellaneous -> operator
                      count++;
                      sc.pop();
                }
                else if(sc.peek() == '>') {  //bitwise >> operator
                    sc.pop();
                    if(sc.peek() != '>') {
                        count++;
                        sc.pop();
                    }    
                    else if(sc.peek() == '>'){     //bitwise >>> operator
                        count++;
                        sc.pop();
                    }
                }
            }
            else if(character == '&') {      //logical operators
                if(sc.peek() == '&'){        //logical && operator
                    count++;
                    sc.pop();              
                }    
            }
            else if(character == '|') {      //logical || operator
                if(sc.peek() == '|'){        
                    count++;
                    sc.pop();              
                }    
                else if(sc.peek() != '|')
                    count++;                  //bitwise | operator
            }
            else if(character == '!') {      //logical ! operator
               count++;
               sc.pop();
            } 
            else if(character == '^') {     //bitwise ^ operator
               count++;
               sc.pop();
            }
            else if(character == '~') {     //bitwise ~ operator
               count++;
               sc.pop();
            }
            else if (character == ',') {   //miscellaneoud operators
               count++;  
            }  
            else if (character == '.') {    //miscellaneous . operator
               count++;  
            } 
            else if(character == ':') {    //miscellaneous :: operator
               if(sc.peek() == ':')
                   count++;
            }
            else if(character == 'n') {   //get '\n' complexity
               if(sc.peek() == '\\')
                   count++;
            }
           else if(character == '\"') { 
               char nwc = 0;
               while(nwc != '\"') {
                   nwc = sc.pop();
               }
               sc.pop();
            }
           
     } // end of while
        }
        return count;
    }
    
    public int getCountDataTypeKeyWords(String getLine) {
    
        wordComplexityNew wc = new wordComplexityNew();
        
        getv = wc.getvoid(getLine);               //void count
        getd = wc.getdouble(getLine);            //double count
        geti = wc.getint(getLine);              //int count
        getf = wc.getfloat(getLine);             //float count
        gets = wc.getString(getLine);          //String count
        getc = wc.getchar(getLine);           //char count
        getl = wc.getlong(getLine);           //long count
        getsh = wc.getshort(getLine);          //short count
        getb = wc.getboolean(getLine);       //boolean count
         
        lastcount += getv + getd + geti + getf + gets + getc + getl + getsh + getb;
        return lastcount;
    }
    
    public int getCountOtherKeywords(String getLine) {
    
       wordComplexityNew w = new wordComplexityNew();
        
        getpf = w.getprintf(getLine);        //printf count
        getpln = w.getprintln(getLine);      //println count
        getco = w.getcout(getLine);        //cout count
        getci = w.getcin(getLine);         //cin count
        getIf = w.getif(getLine);            //if count
        getFor = w.getfor(getLine);             //for count
        getWhile = w.getwhile(getLine);           //while count
        getswi = w.getswitch(getLine);           //switch count
        getca = w.getcase(getLine);          //case count 
        getcat = w.getcatch(getLine);         //catch count
        getend = w.getendl(getLine);       //endl count
        getma = w.getmain(getLine);        //main count
        getarg = w.getargs(getLine);      //args count
        getsys = w.getsystem(getLine);         //System count
        getou = w.getOut(getLine);           //out count
        getnew = w.getnew(getLine);           
        getdelete = w.getdelete(getLine);
        getthrow = w.getthrow(getLine);
        getthrows = w.getthrows(getLine);
        
        getcount += getpf + getpln + getco + getci + getIf + getFor + getWhile + getswi + getca + getcat + getma + getarg + getsys + getou + getnew + getdelete + getthrow + getthrows;
        return getcount;
    }
    
    public int getNumericValues(String getLine) {
       
        NumericCount nc = new NumericCount();
        int number = nc.claclNumberComplexity(getLine.replaceAll("\".*\"", "")); //remove double quotes
        return number;
    }
    
    public int getVariableArrayMethodCount(String getLine, ArrayList<String> ar) {
     
        VariableMethodCount vm = new VariableMethodCount();
        int num = vm.getCount(getLine, ar);
        return num;
    }
    
    public int doubleQuotesCount(String getLine) {
        
       countDoubleQuotes c = new countDoubleQuotes();
       int countvalue = c.checkNoOfTextInDoubleCode(getLine);
       return countvalue;
    }
    
    public int getCountOfClass(String getLine, ArrayList<String> array) {
       
        JavaClassesNew.VariableMethodCount vme = new JavaClassesNew.VariableMethodCount();
        int co = vme.returnclasscount(getLine,array);
        return co;
    }
    
    public int getCountOfClassobjects(String getLine, ArrayList<String> array) {
       
        JavaClassesNew.VariableMethodCount vme = new JavaClassesNew.VariableMethodCount();
        int c = vme.calcClassObjectCount(getLine,array);
        return c;
    }
}
