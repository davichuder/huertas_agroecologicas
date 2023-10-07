package com.rain_lovers.huertas_agroecologicas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import com.rain_lovers.huertas_agroecologicas.models.City;
import com.rain_lovers.huertas_agroecologicas.models.Country;
import com.rain_lovers.huertas_agroecologicas.models.Province;
import com.rain_lovers.huertas_agroecologicas.models.Residence;
import com.rain_lovers.huertas_agroecologicas.repositories.ResidenceRepository;

import jakarta.transaction.Transactional;

@Service
public class ResidenceService {
    @Autowired
    private ResidenceRepository residenceRepository;

    @Transactional
    public Residence saveResidence(Country country, Province province, City city, String street, String details,
            Point coords, int height) {
        // TO DO: Todas las verificaciones, y excepciones
        Residence residence = new Residence();
        residence.setCountry(country);
        residence.setProvince(province);
        residence.setCity(city);
        residence.setStreet(street);
        residence.setDetails(details);
        residence.setCoords(coords);
        residence.setHeight(height);
        return residenceRepository.save(residence);
    }
}
