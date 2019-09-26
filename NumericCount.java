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
public class NumericCount {
    
    public int claclNumberComplexity(String code) {
      
        int count = 0;
        String regexNum = "[0-9]+";
        
        Pattern p = Pattern.compile(regexNum);
        Matcher m = p.matcher(code);
        
        while(m.find()) {
           count++;
        }
        
        return count;
    }
}
