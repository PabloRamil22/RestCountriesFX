package com.ceica.restcountriesfx.Services;

import com.ceica.restcountriesfx.Models.CountryDTO;

import java.util.ArrayList;
import java.util.List;

public class FakeRestCountriesService implements IResCountries{
    @Override
    public String[] getRegions() {
        return new String []  {"Europe", "Asia", "America","Oceania", "Africa", "Antartida" };

    }

    @Override
    public List<CountryDTO> getCountriesByRegion(String region) {
        List<CountryDTO> countryDTOList=new ArrayList<>();
        CountryDTO countryDTO=new CountryDTO();
        countryDTO.setName("Guinea Ecuatorial");
        countryDTOList.add(countryDTO);
        CountryDTO countryDTO1=new CountryDTO();
        countryDTO.setName("Camboya");
        countryDTOList.add(countryDTO1);
        return countryDTOList;
    }

    @Override
    public CountryDTO getCountryByName(String name) {
        CountryDTO countryDTO=new CountryDTO();
        countryDTO.setName("Guinea Ecuatorial");
        countryDTO.setCapital("Malabo");
        countryDTO.setRegion("Oeste");
        countryDTO.setCoin("Franco CFA de África Central");
        countryDTO.setPopulation(1634000);
        countryDTO.setFlag("https://es.vecteezy.com/png/12301134-bandera-de-guinea-ecuatorial-png");
        return countryDTO;
    }
}
