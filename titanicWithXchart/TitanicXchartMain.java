/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package titanicWithXchart;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gt
 */
public class TitanicXchartMain {
    
        public static void main(String[] args) throws IOException{
            
        List<TitanicPassenger> allPassengers= new ArrayList<TitanicPassenger>();
        
        ObjectMapper objectMapper= new ObjectMapper();  //objectMapper is a class in python
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);  //don't get the unknown properties
        
        InputStream input = new FileInputStream ("D:\\1st-AI- ITI\\Javz\\Day5\\titanic.json");//Read JSON file
        allPassengers = objectMapper.readValue(input, new TypeReference<List<TitanicPassenger>>(){});
        
        for(TitanicPassenger x:allPassengers){
            System.out.println(x);
        }

        DAO pass = new DAO();
        
        System.out.println("***Gragh Passenger Ages****");
        pass.graphPassengerAges(allPassengers);
        
        System.out.println("***Gragh Passenger Class****");
        pass.graphPassengerClass(allPassengers);
        
        System.out.println("***Gragh Passenger Survived****");
        pass.graphPassengerSurvived(allPassengers);
                
        System.out.println("***Gragh Passenger Gender****");
        pass.graphPassengerSurvivedGender(allPassengers);

        
    }
}
