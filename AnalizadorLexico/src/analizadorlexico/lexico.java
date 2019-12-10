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
    
//    private Scanner x;
   // public String programa;
    private String[] palabrasReservadas  = {"PROGRAMA", "FINPROG","SI", "ENTONCES", "SINO", "FINSI","REPITE","VECES","FINREP","IMPRIME","LEE"} ;
    private String [] operadoresRelacionales = {"<",">","=="};
    private String [] operadoresAritmeticos = {"+","-","*","/"};

    private ArrayList<String> IDS = new ArrayList();
    private ArrayList<String> VAL = new ArrayList();
    private ArrayList<String> TXT = new ArrayList();
    private ArrayList<String> Tokens = new ArrayList();
    
    public void crearTokens(ArrayList<String> archivo){
        int index = 0;
        while (archivo.get(index) != null){
        StringTokenizer Stokens = new StringTokenizer(archivo.get(index));
        String token;
        
        while (Stokens.hasMoreTokens()){
            token = Stokens.nextToken();
            if(token.equals("#") != true){            
           Tokens.add(token);
            }
        }
       }
        
    }
    public void clasificar(ArrayList<String> tokens){
        //si son valores
         boolean isText = false;
         
        for (int i=0; i< tokens.size(); i++ ){
            if (esVal(tokens.get(i))&& isText == false){
                 VAL.add(tokens.get(i));
            }
            // si son textos
             if (tokens.get(i).charAt(0) == '"' ){
                 isText = true;
               if(tokens.get(i+1).charAt(0) != '"'){
                   TXT.add(tokens.get(i));
               }
               else{
                   isText = false;
               }
            }
             //si son identificadores
             if (esIde(tokens.get(i)) && isText == false ){
                 IDS.add(tokens.get(i));
             }
        }
        
    }
    public boolean esIde(String token){
        boolean esReservada = false;
        for (int i=0; i<palabrasReservadas.length;i++){
            if (token == palabrasReservadas[i]){
                esReservada = true;
                break; 
            }
        }
        if (esReservada == false){
                if ((token.charAt(0)>=65 && token.charAt(0)<=90) || (token.charAt(0)>=97 && token.charAt(0)<=122) ){
                    return true;
                }
        }
        return false;
    }
    public boolean esVal(String token){
       char [] valor = token.toCharArray();
        if (valor[0] == '0'){
         if (valor[1] == 'x'){
            return true;
         }   
        }
       return false;
   }
//    public ArrayList <String> obtenerArchivo() throws FileNotFoundException, IOException{
//        
//        ArrayList<String> programa = new ArrayList<String>();
//        File f = new File ("C:\\Users\\arman\\Desktop\\analizador\\ProgramaMio.txt");
//        FileReader fr = new FileReader(f);
//        BufferedReader br = new BufferedReader(fr);
//        String line;
//       // boolean pr = false;
//        while((line = br.readLine()) != null){
//            StringTokenizer st = new StringTokenizer(line);
//            String c;
//            c=st.nextToken();
//            //String quote;
//            //quote = "“";
//            if(c.equals("#")){
//                
//                
//            }else{
//                   programa.add(c);
//                while(st.hasMoreTokens()){
//                    if(c.equals("\"")){
//                        String frase;
//                        c = st.nextToken();
//                        frase = c;
//                        System.out.println(frase);
//                        while(!(c.equals("\""))){
//                            c = st.nextToken();
//                            if(!(c.equals("\"")))
//                            frase = frase + " " + c;
//                            
//                        }
//                       System.out.println(frase);
//                        programa.add(frase);
//                    }else{
//                        c=st.nextToken();
//                        if(!(c.equals("\"")))
//                        programa.add(c);
//                    }
//                } 
//                    }
//            
//        }
//        br.close();
//        fr.close();
//        for(int i=0;i<programa.size();i++){
//            //System.out.println(programa.get(i));
//        }
//        
//        String ruta = "C:\\Users\\arman\\Desktop\\analizador\\ProgramaLex.txt";
//            File archivo = new File(ruta);
//            BufferedWriter bw ;
//        if(archivo.exists()) {
//                try {
//                    bw = new BufferedWriter(new FileWriter(archivo));
//                    for(int i=0;i<programa.size();i++){
//                    bw.write(programa.get(i));
//                    bw.newLine();
//                    }
//                    bw.close();
//                } catch (IOException ex) {
//                    System.out.println("No hay archivo");
//                }
//            
//        }
//         
//        return programa;
//    }
       
   
   
       
    
} 

