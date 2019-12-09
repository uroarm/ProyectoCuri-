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
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Jose Manuel Patron
 */
public class lexico {
    
    private Scanner x;
   // public String programa;
    private String[] palabrasReservadas  = {"PROGRAMA", "FINPROG","SI", "ENTONCES", "SINO", "FINSI","REPITE","VECES","FINREP","IMPRIME","LEE"} ;
    private String [] operadoresRelacionales = {"<",">","=="};
    private String [] operadoresAritmeticos = {"+","-","*","/"};

    
    
    public ArrayList <String> obtenerArchivo() throws FileNotFoundException, IOException{
        
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
        
        String ruta = "C:\\Users\\arman\\Desktop\\analizador\\ProgramaLex.txt";
            File archivo = new File(ruta);
            BufferedWriter bw ;
        if(archivo.exists()) {
                try {
                    bw = new BufferedWriter(new FileWriter(archivo));
                    for(int i=0;i<programa.size();i++){
                    bw.write(programa.get(i));
                    bw.newLine();
                    }
                    bw.close();
                } catch (IOException ex) {
                    System.out.println("No hay archivo");
                }
            
        }
         
        return programa;
    }
       
}
