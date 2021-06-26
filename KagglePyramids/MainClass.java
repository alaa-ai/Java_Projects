/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KagglePyramids;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author gt
 */
public class MainClass {
     public static void main(String[] args) throws IOException{
        PyramidCSVDAO pDAO = new PyramidCSVDAO();
        List<Pyramids> pyramid = pDAO.readPyramidsFromCSV("D:\\1st-AI- ITI\\Javz\\Day3\\Tasks\\Pyramids.csv");
         
          int i = 0;
          System.out.println("Before sorting");
        for(Pyramids p : pyramid){
            System.out.println("#"+(i++)+p);
        }
        System.out.println("\n\n\n");
        System.out.println("After sorting");

        List<Pyramids> pyr =pDAO.sortOfList("D:\\1st-AI- ITI\\Javz\\Day3\\Tasks\\Pyramids.csv");
        for (Pyramids p :pyr){
            System.out.println("#"+(i++)+p);    
        }
        


        Map<String, Integer> countNumSite = new HashMap<String, Integer>();
        countNumSite = pDAO.mapSite("D:\\1st-AI- ITI\\Javz\\Day3\\Tasks\\Pyramids.csv");
        countNumSite.forEach((k, v) -> System.out.println( k + "=" + v));
        System.out.println("\n\n\n");
        
     }
}
