
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Kalpani Abeysinghe
 */
public class Recursion {

    ArrayList<Boolean> outputboolean = new ArrayList<Boolean>();
    ArrayList<RecursionModel> RM = new ArrayList<RecursionModel>();
    
    public void recursionfinder() {
        
        
        
        ArrayList<String> mylist = new ArrayList<String>();
        
        
        
        StringBuffer sbf = new StringBuffer();
        int checksuum = 0;

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "C:\\Users\\Kalpani Abeysinghe\\Desktop\\myfile.txt"));
            String line = reader.readLine();
            while (line != null) {

                checksuum = checksuum+1;
                mylist.add(line);
                sbf.append(line);
//                System.out.println(line);
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        
        
        int size = mylist.size();

        String s[] = new String[size];
        int a = 0;
        
        
        

        for (String line : mylist) {
            s[a++] = line;
        }

            
        
        
        
//         for(int se =0; se < s.length; se++ ){
//             System.out.println(s[se]);
//         }
        String methodname = "";
        ArrayList<String> methodlist = new ArrayList<>();

        for (int i = 0; i < s.length; i++) {

            if (!(s[i].trim().isEmpty())) {

                String row = s[i];
                for (int j = 0; j < 20; j++) {
                    row = row.replace(" (", "(");
                }

                int pblc = row.split("public").length - 1;
                int pvt = row.split("private").length - 1;
                int prtd = row.split("protected").length - 1;
                String pblc_ar[] = row.split("public");
                String pvt_ar[] = row.split("private");
                String prtd_ar[] = row.split("protected");

                if ((pblc > 0) || (pvt > 0) || (prtd > 0)) {

                    String metd[] = "".split("");
                    if ((pblc > 0)) {
                        metd = pblc_ar[1].split("");
                    } else if ((pvt > 0)) {
                        metd = pvt_ar[1].split("");
                    } else if ((prtd > 0)) {
                        metd = prtd_ar[1].split("");
                    }

                    methodname = "";
                    int x = 0;

                    if (row.split("public static void main").length > 1) {
                        methodname = "Main Method";
                    } else {
                        for (int j = metd.length - 1; j >= 0; j--) {
                            if (metd[j].equals("(")) {
                                x = 1;
                            }
                            if (metd[j].equals(" ") && x == 1) {
                                break;
                            }
                            methodname = metd[j] + methodname;
                        }

                    }
                }

                String method_first[] = methodname.split("");
                String method_filter_name = "";
                int x = 0;
                for (int j = method_first.length - 1; j >= 0; j--) {

                    if (method_first[j].equals("(")) {
                        x = 1;
                    }
                    if (x == 1) {
                        method_filter_name = method_first[j] + method_filter_name;
                    }
                }

                if (method_filter_name.equals("")) {
                    method_filter_name = "hish asiu ivb vbvy bviybbi bei";
                }

                RecursionModel rmo = new RecursionModel();
                Vector v = new Vector();
                v.add(i + 1);
                    rmo.setLinno(i + 1);
                v.add(methodname.replaceAll("[{]", ""));
                    rmo.setMethodname(methodname.replaceAll("[{]", ""));
                v.add(row);
                    rmo.setStatement(row);
                if (row.contains(methodname)) {
                    v.add("-");
                        rmo.setCount("-");
                } else if (row.contains(method_filter_name)) {
                    methodlist.add(methodname.replaceAll("[{]", ""));
                    v.add("CP x 2");
                        rmo.setCount("CP x 2");
                } else {
                    v.add("-");
                         rmo.setCount("-");
                }
                System.out.println(v);
                RM.add(rmo);
            }
        }
        
        System.out.println("=====================");
//        System.out.println(RM.get(8).toString());

         
        try {
            for (String name : methodlist) {
                for (int i = 0; i < RM.size(); i++) {
                    if (RM.get(i).getMethodname().equals(name)) {

                        if ((RM.get(i).getStatement().contains(";")) || (RM.get(i).getStatement().contains("{"))) {

                            RM.get(i).setCount("CP X 2");
                        }
                        
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        int w = 1;
      for (RecursionModel line : RM) {
            System.out.println(line.toString());
            String out = line.getCount();
            Integer linenoc = line.getLinno();
            
            
           if (linenoc.equals(w)) {
              if (out.equals("CP X 2")) {
                  outputboolean.add(true);
              } else {
                  outputboolean.add(false);
              }
              w++;
          }else if(linenoc.equals(w+1)){
              outputboolean.add(false);
              if (out.equals("CP X 2")) {
                  outputboolean.add(true);
              } else {
                  outputboolean.add(false);
              }
              w= w+2;
               
           }else if(linenoc.equals(w+2)){
               outputboolean.add(false);
               outputboolean.add(false);
              if (out.equals("CP X 2")) {
                  outputboolean.add(true);
              } else {
                  outputboolean.add(false);
              }
              w=w+3;
           }else if(linenoc.equals(w+3)){
               outputboolean.add(false);
               outputboolean.add(false);
               outputboolean.add(false);
              if (out.equals("CP X 2")) {
                  outputboolean.add(true);
              } else {
                  outputboolean.add(false);
              }
              w=w+4;
           }
               
               
            
            
//            if(out.equals("CP X 2")){
//                outputboolean.add(true);
//            }else{
//                outputboolean.add(false);
//            }
    
     }   
      
      
        System.out.println("outpuuuuuuuuuuuut size ====="+outputboolean.size()+"checksumsssssssssssiiiiiiz" + checksuum);
      
      
        System.out.println("rrrrrrrrrrrrrrrrrrrrrrrrrr");
        
//      for (Boolean line : outputboolean) {
//          System.out.println(line);
//      }   

    }          
       
    
    public boolean getRecursion(int i){
        
        return outputboolean.get(i);
    }
     
   public String getMethodNamesR(int i){
        
        return RM.get(i).getMethodname();
    }
       

}


