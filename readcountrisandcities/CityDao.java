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
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author gt
 */
public class CityDao {
    List<Cities> cities;

    public CityDao(List<Cities> cities) {
        this.cities = cities;
    }

    public List<Cities> getCities() {
        return cities;
    }
    
    public List<String> getHighestPopulationCityOfEachCountry(String code)
    {
        return cities.stream().filter(value -> value.getCountryCode().equals(code))
                .sorted(Comparator.comparing(Cities::getPopulation).reversed())
                .limit(1)
                .map(Cities::getName)
                .collect(Collectors.toList());
    }
    
    public List<Cities> highestCapital(List<Countries> cn ,List<Cities> ci){
        
        List<Cities> cities=new ArrayList<>();
        List<Integer> p = new ArrayList<>(); 
        List<Integer> b = cn.stream().map(Countries::getCapital).collect(Collectors.toList());
        for( Integer x : b){
            int z = 0;
            if(x == -1){
                z += 1;
            }else{
                
                cities = (ci.stream().filter(c -> (c.getId())== x).collect(Collectors.toList()));
                
            }
             p.add( cities.stream().map(Cities::getPopulation).mapToInt(c->c).findFirst().orElseThrow(() -> new IllegalArgumentException("value not found")));  
        }
       
       Integer e = p.stream().mapToInt(c->c).max().getAsInt();
       
       List<Cities> s = ci.stream().filter(c -> c.getPopulation()== e).map(c->c).collect(Collectors.toList());
        return s;
        }

}
