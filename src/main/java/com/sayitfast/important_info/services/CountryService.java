package com.sayitfast.important_info.services;

import com.sayitfast.important_info.models.Country;
import com.sayitfast.important_info.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    //Return list of countries
    public List<Country> getCountries() {
        return countryRepository.findAll();
    }

    //SAve new country
    public void save(Country country) {
        countryRepository.save(country);
    }

    //get by id
    public Optional<Country> findById(int id) {
        return countryRepository.findById(id);
    }

    public void delete(Integer id) {
        countryRepository.deleteById(id);
    }

    public long getCountriesCount() {
        return countryRepository.count();
    }
}
