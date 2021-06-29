/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readcountrisandcities;

import java.util.ArrayList;
import java.util.Comparator;
import static java.util.Comparator.reverseOrder;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author gt
 */
public class MixMappingClass {
    private static HashMap<String, List<Cities>> countryMap = new HashMap<>();

    public static HashMap<String, List<Cities>> getCountryMap() { return countryMap; }

    public static HashMap<String, List<Cities>> mappingCountry (List<Cities> cities, List<Countries> countries)
    {
        countries.forEach(country -> {
            List<Cities> cityList = cities.stream()
                    .filter(d -> d.getCountryCode().trim().equals(country.getCode()))
                    .collect(Collectors.toList());

            countryMap.put(country.getCode(), cityList);
        });
        return countryMap;
    }

}
