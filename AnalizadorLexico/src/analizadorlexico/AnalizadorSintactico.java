/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorlexico;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author arman
 */
public class AnalizadorSintactico {
     public void obtenerArchivo() throws FileNotFoundException, IOException{
        ArrayList<String> programa = new ArrayList<String>();
        File f = new File ("C:\\Users\\arman\\Desktop\\analizador\\ProgramaMio.txt");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String line;
       // boolean pr = false;
        while((line = br.readLine()) != null){
            StringTokenizer st = new StringTokenizer(line);
            String c;
            c=st.nextToken();
            //String quote;
            //quote = "“";
            if(c.equals("#")){
                
                
            }else{
                   programa.add(c);
                while(st.hasMoreTokens()){
                    if(c.equals("\"")){
                        String frase;
                        c = st.nextToken();
                        frase = c;
                        System.out.println(frase);
                        while(!(c.equals("\""))){
                            c = st.nextToken();
                            if(!(c.equals("\"")))
                            frase = frase + " " + c;
                            
                        }
                       System.out.println(frase);
                        programa.add(frase);
                    }else{
                        c=st.nextToken();
                        if(!(c.equals("\"")))
                        programa.add(c);
                    }
                } 
                    }
            
        }
        br.close();
        fr.close();
        for(int i=0;i<programa.size();i++){
            //System.out.println(programa.get(i));
        }
        
    }
}
