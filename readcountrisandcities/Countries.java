/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readcountrisandcities;

/**
 *
 * @author gt
 */
public class Countries {
    
     private String code;
    private String countryName;
    private String continent;
    private int population;
    private double surfaceArea;
    private double gnp;
    private int capital;

    public Countries(String code, String countryName, String continent, int population, double surfaceArea, double gnp, int capitalId) {
        this.code = code;
        this.countryName = countryName;
        this.continent = continent;
        this.population = population;
        this.surfaceArea = surfaceArea;
        this.gnp = gnp;
        this.capital = capitalId;
    }
    
    
    

  

    public String getCode() {
        return code;
    }
    public String getCountryName() {
        return countryName;
    }
    public String getContinent() {
        return continent;
    }
    public double getSurfaceArea() {
        return surfaceArea;
    }
    public int getPopulation() {
        return  population;
    }
    public double getGnp() {
        return gnp;
    }
    public int getCapital() {
        return capital;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public void setGnp(double gnp) {
        this.gnp = gnp;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

    @Override
    public String toString() {
        return countryName + "[ " + code + " ]";
    }

    
}
