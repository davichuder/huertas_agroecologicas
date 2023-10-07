package com.rain_lovers.huertas_agroecologicas.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rain_lovers.huertas_agroecologicas.models.City;
import com.rain_lovers.huertas_agroecologicas.repositories.CityRepository;

import jakarta.transaction.Transactional;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    @Transactional
    public City saveCity(String name) {
        if (cityRepository.existsByName(name)) {
            // TO DO: Lanzar excepcion
            return null;
        }
        City city = new City(name);
        return cityRepository.save(city);
    }

    public City getCityByName(String string) {
        Optional<City> optional = cityRepository.findByName(string);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }
}
