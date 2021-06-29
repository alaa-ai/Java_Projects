/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readcountrisandcities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gt
 */
class ReadFromCountry {
       public ReadFromCountry() {
    }
    
     public List<Countries> readCountriesCSV(String path) throws IOException
    {
        List<Countries> countries = new ArrayList<>();
        try{
        Reader r = new FileReader(path);
        BufferedReader br = new BufferedReader(r);
        String line ; 
        String[] parts;
        
        do{
            line = br.readLine();
            if(line != null){
                parts = line.split(",");
                   Countries country = new Countries(parts[0], parts[1],
                            parts[2], Integer.parseInt(parts[3]), (int) Double.parseDouble(parts[4]), Double.parseDouble(parts[5]),
                            Integer.parseInt(parts[6]));
                    countries.add(country);
            }
        }while(line != null);
        
        }catch (IOException ex){
                    ex.printStackTrace();
        }
        return countries;
    }
}
