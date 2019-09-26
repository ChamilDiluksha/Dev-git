/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaClassesNew;

import java.util.ArrayList;
import JavaClassesNew.Stack;
/**
 *
 * @author User
 */
public class RefDerefOperaterCount {
    
    int count1 = 0, count2 = 0;
    int fnl;
    
    public int returnDereferenceOfCount(String code) {
    
        char ch;
        
        Stack sc = new Stack(code.length());
        for(int i = 0; i < code.length(); i++) {
            ch = code.charAt(i);
            sc.push(ch);         
        }  
        
        while(!sc.isEmpty()) {
            char p = sc.pop();
            if(p == '*') {
                if(sc.peek() == ' '){
                    sc.pop();
                    if(sc.peek() == 't') {
                         sc.pop();
                        if(sc.peek() == 'n') {
                            sc.pop();
                            if(sc.peek() == 'i')       //from here to upper get int *variable
                                count1++;
                         }
                         else if(sc.peek() == 'a') {
                            sc.pop();
                            if(sc.peek() == 'o') {
                                sc.pop();
                                if(sc.peek() == 'l') {
                                   sc.pop();
                                   if(sc.peek() == 'f')   //from here to upper get float *variable
                                       count1++;
                                }
                            }
                         }
                    }
                    
                    else if(sc.peek() == 'e') {
                        sc.pop();
                        if(sc.peek() == 'l') {
                            sc.pop();
                            if(sc.peek() == 'b') {
                               sc.pop();
                               if(sc.peek() == 'u') {
                                   sc.pop();
                                   if(sc.peek() == 'o') {
                                       sc.pop();
                                       if(sc.peek() == 'd') {
                                             count1++;                //from here to upper get double *variable
                                       }
                                   }
                               }
                            }
                        }
                    }
                    
                    else if(sc.peek() == 'g') {
                        sc.pop();
                        if(sc.peek() == 'n') {
                            sc.pop();
                            if(sc.peek() == 'i') {
                                sc.pop();
                                if(sc.peek() == 'r') {
                                    sc.pop();
                                    if(sc.peek() == 't') {
                                        sc.pop();
                                        if(sc.peek() == 'S') {
                                            count1++;               //from here to upper get String *variable
                                        }
                                     }
                                }
                            }
                        }                   
                    }
                                        
                    else if(sc.peek() == 'r') {
                        sc.pop();
                        if(sc.peek() == 'a') {
                           sc.pop();
                           if(sc.peek() == 'h') {
                               sc.pop();
                               if(sc.peek() == 'c') {
                                   count1++;               //from here to upper get char *variable
                               }
                            }
                        }
                    }
                    
                    
                    else if(sc.peek() == 'n') {sc.pop();
                        if(sc.peek() == 'a') {
                            sc.pop();
                            if(sc.peek() == 'e') {
                               sc.pop();
                               if(sc.peek() == 'l') {
                                   sc.pop();
                                   if(sc.peek() == 'o') {
                                       sc.pop();
                                       if(sc.peek() == 'o') {
                                           sc.pop();
                                           if(sc.peek() == 'b') {
                                             count1++;                   //from here to upper get boolean *variable
                                           }
                                       }
                                   }
                               }
                            }
                        }
                    }
                }
               }
            
            
//            if(c1 == ' ' && c2 == 't' && c3 == 'n' && c4 == 'i')  {
//                count++;
//            }
//            else if(c1 == ' ' && c2 == 't' && c3 == 'a' && c4 == 'o' && c5 == 'l' && c6 == 'f') {
//                count++;
//            }
//            else if(c1 == ' ' && c2 == 'e' && c3 == 'l' && c4 == 'b' && c5 == 'u' && c6 == 'o' && c7 == 'd') {
//                count++;
//            }
//            else if(c1 == ' ' && c2 == 'g' && c3 == 'n' && c4 == 'i' && c5 == 'r' && c6 == 't' && c7 == 'S') {
//                count++;
//            }
//            else if(c1 == ' ' && c2 == 'r' && c3 == 'a' && c4 == 'h' && c5 == 'c') {
//                count++;
//            }
//            else if(c1 == ' ' && c2 == 'n' && c3 == 'a' && c4 == 'e' && c5 == 'l' && c6 == 'o' && c7 == 'o' && c8 == 'b') {
//                count++;
//            }
        }
        
        //System.out.println(count1);
        return count1;
    }
    
    public int returnReferenceOfCount(String code) {
       
        char ch1;
        
        Stack sc1 = new Stack(code.length());
        for(int i = 0; i < code.length(); i++) {
            ch1 = code.charAt(i);
            sc1.push(ch1);         
        }  
        
        while(!sc1.isEmpty()) {
           char p = sc1.pop();
            if(p == '&') {   
             if(sc1.peek() == ' ' && sc1.peek() != '&'){
                    sc1.pop();
                    if(sc1.peek() == 't') {
                         sc1.pop();
                        if(sc1.peek() == 'n') {
                            sc1.pop();
                            if(sc1.peek() == 'i')       //from here to upper get int *variable
                                count2++;
                         }
                         else if(sc1.peek() == 'a') {
                            sc1.pop();
                            if(sc1.peek() == 'o') {
                                sc1.pop();
                                if(sc1.peek() == 'l') {
                                   sc1.pop();
                                   if(sc1.peek() == 'f')   //from here to upper get float *variable
                                       count2++;
                                }
                            }
                         }
                    }
                    
                    else if(sc1.peek() == 'e') {
                        sc1.pop();
                        if(sc1.peek() == 'l') {
                            sc1.pop();
                            if(sc1.peek() == 'b') {
                               sc1.pop();
                               if(sc1.peek() == 'u') {
                                   sc1.pop();
                                   if(sc1.peek() == 'o') {
                                       sc1.pop();
                                       if(sc1.peek() == 'd') {
                                             count2++;                //from here to upper get double *variable
                                       }
                                   }
                               }
                            }
                        }
                    }
                    
                    else if(sc1.peek() == 'g') {
                        sc1.pop();
                        if(sc1.peek() == 'n') {
                            sc1.pop();
                            if(sc1.peek() == 'i') {
                                sc1.pop();
                                if(sc1.peek() == 'r') {
                                    sc1.pop();
                                    if(sc1.peek() == 't') {
                                        sc1.pop();
                                        if(sc1.peek() == 'S') {
                                            count2++;               //from here to upper get String *variable
                                        }
                                     }
                                }
                            }
                        }                   
                    }
                                        
                    else if(sc1.peek() == 'r') {
                        sc1.pop();
                        if(sc1.peek() == 'a') {
                           sc1.pop();
                           if(sc1.peek() == 'h') {
                               sc1.pop();
                               if(sc1.peek() == 'c') {
                                   count2++;               //from here to upper get char *variable
                               }
                            }
                        }
                    }
                    
                    
                    else if(sc1.peek() == 'n') {
                        sc1.pop();
                        if(sc1.peek() == 'a') {
                            sc1.pop();
                            if(sc1.peek() == 'e') {
                               sc1.pop();
                               if(sc1.peek() == 'l') {
                                   sc1.pop();
                                   if(sc1.peek() == 'o') {
                                       sc1.pop();
                                       if(sc1.peek() == 'o') {
                                           sc1.pop();
                                           if(sc1.peek() == 'b') {
                                             count2++;                   //from here to upper get boolean *variable
                                           }
                                       }
                                   }
                               }
                            }
                        }
                    }
                }
            
            }
        
        }
        //System.out.println(count2);
        return count2;
    }
    
}
