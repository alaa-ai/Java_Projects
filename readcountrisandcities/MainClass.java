/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readcountrisandcities;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *
 * @author gt
 */
public class MainClass {
    public static void main(String[] args) throws IOException
    {
        
        ReadFromCountry readcsv = new ReadFromCountry();
        List<Countries> country = readcsv.readCountriesCSV("D:\\1st-AI- ITI\\Javz\\Day4\\Countries.csv");       
        
        ReadFromCity readcsvcity = new ReadFromCity();
        List<Cities> city = readcsvcity.readCitiesCSV("D:\\1st-AI- ITI\\Javz\\Day4\\Cities.csv");
       
        
        CountryDao cnDao = new CountryDao(country);
        Double average = cnDao.getAveragePopulation();
        System.out.println("\n Average Population is : " + average);
        
        CityDao cityDAO = new CityDao(city);
        
        Integer max = cnDao.getMaxCountryPopulation();
        System.out.println("\n Maximum Population is : " + max);
      



        List<Integer> getcountrypop = cnDao.getCountriesPopulation();
        System.out.println("\n A List Of Countries Population: " + getcountrypop );
        
        
        List<String> getHighestPop = cityDAO.getHighestPopulationCityOfEachCountry(" USA");
        System.out.println("\n City of the Highest Population in USA has Population =  " + getHighestPop );
        
        HashMap<String, List<Cities>> countryMap = new HashMap<>();

        countryMap = MixMappingClass.mappingCountry(cityDAO.getCities() ,cnDao.getCountries());
        System.out.println("\n Mapping: " + countryMap);
        
       
        List<Cities> cit = new ArrayList<>();
        cit = cityDAO.highestCapital(country, city);
        
        System.out.println("\n Highest captial Population: " + cit);
        


}
}