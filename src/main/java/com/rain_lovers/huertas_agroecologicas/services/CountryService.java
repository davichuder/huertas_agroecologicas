package com.rain_lovers.huertas_agroecologicas.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rain_lovers.huertas_agroecologicas.models.Country;
import com.rain_lovers.huertas_agroecologicas.repositories.CountryRepository;

import jakarta.transaction.Transactional;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    public Country saveCountry(String name) {
        if (countryRepository.existsByName(name)) {
            // TO DO: Lanzar excepcion
            return null;
        }
        Country country = new Country(name);
        return countryRepository.save(country);
    }

    public Country getCountryByName(String string) {
        Optional<Country> optional = countryRepository.findByName(string);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }
}
