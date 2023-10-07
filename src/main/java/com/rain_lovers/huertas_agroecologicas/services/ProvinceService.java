package com.rain_lovers.huertas_agroecologicas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rain_lovers.huertas_agroecologicas.models.Province;
import com.rain_lovers.huertas_agroecologicas.repositories.ProvinceRepository;

import jakarta.transaction.Transactional;

@Service
public class ProvinceService {
    @Autowired
    private ProvinceRepository provinceRepository;

    @Transactional
    public Province saveProvince(String name) {
        if (provinceRepository.existsByName(name)) {
            // TO DO: Lanzar excepcion
            return null;
        }
        Province province = new Province(name);
        return provinceRepository.save(province);
    }
}
