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
import java.util.stream.Collectors;

/**
 *
 * @author gt
 */
public class CountryDao {
    List<Countries> countries ;

    public CountryDao(List<Countries> countries) {
        this.countries = countries;
    }

    CountryDao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Countries> getCountries() {
        return countries;
    }

    public void setCountries(List<Countries> countries) {
        this.countries = countries;
    }
    

    
    
     public  List<Integer> getCountriesPopulation()
    {
        return countries.stream().map(Countries::getPopulation).collect(Collectors.toList()); //forEach(d -> System.out.println(d.getCountryName() + " : "+ d.getPopulation()));
    }
     
     public Double getAveragePopulation()
    {
        return countries.stream().mapToInt(Countries::getPopulation).average().getAsDouble();
    }

    public  Integer getMaxCountryPopulation()
    {
        return countries.stream().mapToInt(Countries::getPopulation).max().getAsInt();
    }
    
    
//
//    public static List<Countries> getCountryDataset()
//    {
//        return countries;
//    }
}
