/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complexity_measure_tool;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Programmer
 */
public class removeComment {
    
    public static String deleteComments2(String str) {
        StringBuilder sb = new StringBuilder(str.length());
        boolean inText = false;
        char previousCharacter = '\u0000';

        for (int i = 0; i < str.length(); ++i) {
            char currentCharacter = str.charAt(i);

            if (inText) {
                if (currentCharacter == '\"' && previousCharacter != '\\') {
                    inText = false;
                }
            } else {
                if (currentCharacter == '\"') {
                    if (previousCharacter == '\\') {
                        throw new RuntimeException("bad syntax");
                    }

                    inText = true;
                }

                if (currentCharacter == '/' && previousCharacter == '/') {
                    sb.deleteCharAt(sb.length() - 1);
                    break;
                }
            }

            sb.append(currentCharacter);
            previousCharacter = currentCharacter;
        }

        return sb.toString();
    }

    public static String deleteComments(String myString) {
        String newString = "";

        if (myString.contains("\"")) {
            if (myString.indexOf("\"") != 0) {

                String[] stringParts = myString.split("\"");

                for (int i = 0; i < stringParts.length; i++) {

                    if ((i & 1) == 0) {
                        Pattern commentaryPattern = Pattern.compile("(/\\*((.|\n)*?)\\*/)|//.*");

                        Matcher m = commentaryPattern.matcher(stringParts[i]);

                        newString += m.replaceAll("");
                    } else {
                        newString += "\"" + stringParts[i] + "\"";
                    }
                }
            }
        } else {
            Pattern commentaryPattern = Pattern.compile("(/\\*((.|\n)*?)\\*/)|//.*");

            Matcher m = commentaryPattern.matcher(myString);

            newString += m.replaceAll("");
        }

        return newString;
    }
}
