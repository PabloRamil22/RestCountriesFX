package com.ceica.restcountriesfx.Services;

import com.ceica.restcountriesfx.Models.CountryDTO;

import java.util.List;

public interface IResCountries {
    public String[] getRegions();
    public List<CountryDTO> getCountriesByRegion(String region);
    public CountryDTO getCountryByName(String name);
    public CountryDTO getCountryByCca3(String cca3);
}
