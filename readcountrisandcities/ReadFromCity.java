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
class ReadFromCity {
     public ReadFromCity() {
    }
    
    
    public  List<Cities>  readCitiesCSV(String path) throws IOException
    {
        List<Cities> cities = new ArrayList<>();
        try{
        Reader r = new FileReader(path);
        BufferedReader br = new BufferedReader(r);
        String line; // = br.readLine();
        String[] metadata;
        
        do{
            line = br.readLine();
            if(line != null){
               metadata = line.split(",");
               Cities city = new Cities(Integer.parseInt(metadata[0]),
                        metadata[1],
                        Integer.parseInt(metadata[2]),
                        metadata[3]);
                cities.add(city);
            }
        }while(line != null);
        
        }catch (IOException ex){
                    ex.printStackTrace();
        }
        return cities;
    }
}
