/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KagglePyramids;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author gt
 */
public class PyramidCSVDAO {

    public PyramidCSVDAO() {
    }

    
    public List<Pyramids> readPyramidsFromCSV(String fileName){
        List<Pyramids> pyramid = new ArrayList<>();
        try{
        Reader r = new FileReader(fileName);
        BufferedReader br = new BufferedReader(r);
        String line = br.readLine();
        if(line != null){
            System.out.println(line);
        }
        do{
            line = br.readLine();
            if(line != null){
                String[] attributes = line.split(",");
                Pyramids pr = createPyramid(attributes);
                pyramid.add(pr);
            }
        }while(line != null);
        
        }catch (IOException ex){
                    ex.printStackTrace();
        }
        return pyramid;
    }
    
    public Pyramids createPyramid(String[] metadata){
        String pharaoh = metadata[0];
        String modern_name = metadata[2];
        String site = metadata[4];
        double height = 0;
        if(metadata[7] != null && metadata[7].length()>0){
            height = Double.parseDouble(metadata[7]);
        }
        //create and return pyramid of this metadata
        Pyramids p = new Pyramids( height , modern_name , pharaoh, site );
       
        return p;
            
    }
    public class sortingByHight implements Comparator<Pyramids> {

        @Override
        public int compare(Pyramids a , Pyramids b) {
            Double h1 = a.getHeight();
            Double h2 = b.getHeight();
            int diff = h1.compareTo(h2);
            return diff;
            
        }
  
        
    }
    public List<Pyramids> sortOfList(String fileName)  throws IOException{
        List<Pyramids> pyr = new ArrayList<>();
        pyr = readPyramidsFromCSV(fileName);
        Collections.sort(pyr,new sortingByHight());
        return pyr;
    }

    
     public Map<String, Integer> mapSite(String fileName) throws IOException{
         Map<String, Integer> countNumSite = new HashMap<String, Integer>();
         List<Pyramids> pyramid1 = new ArrayList<>();
         pyramid1 = readPyramidsFromCSV(fileName);
         for(Pyramids p : pyramid1){
            String site = p.getSite();
            Integer numOfSite = countNumSite.get(site);
            if (numOfSite == null){
                numOfSite = 1;
            }else{
                numOfSite +=1 ;
            }
            countNumSite.put(site, numOfSite);
         }
         return countNumSite;
    
}
}
