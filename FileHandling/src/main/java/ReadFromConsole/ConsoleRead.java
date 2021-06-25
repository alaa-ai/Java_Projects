/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReadFromConsole;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;


/**
 *
 * @author gt
 */
public class ConsoleRead {

    
    public static void main(String[] args) throws IOException{
         try{
            
            InputStreamReader r = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(r);  
            
            Writer w = new FileWriter("D:\\1st-AI- ITI\\Javz\\Day3\\Tasks\\ReadCons.txt");
            BufferedWriter buffer =new BufferedWriter(w);
            
            String name = " ";
            while (!name.equals("stop")){
                try{
                    System.out.println("Enter Data: ");
                    name = br.readLine();
                    System.out.println("Data is: " + name);
                    
                    if(!name.equals("stop")){
                        buffer.write(name+"\n");
                    }
                }catch (IOException ex){
                    ex.printStackTrace();
                }
                
        }
           
            buffer.close();
            br.close();
            r.close();
            
        }catch (IOException ex){
                    ex.printStackTrace();
                }
    }
}

