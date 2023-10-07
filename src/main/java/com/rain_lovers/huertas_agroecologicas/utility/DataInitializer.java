package com.rain_lovers.huertas_agroecologicas.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.rain_lovers.huertas_agroecologicas.services.CityService;
import com.rain_lovers.huertas_agroecologicas.services.CountryService;
import com.rain_lovers.huertas_agroecologicas.services.ImageService;
import com.rain_lovers.huertas_agroecologicas.services.PlantationStateService;
import com.rain_lovers.huertas_agroecologicas.services.ProvinceService;
import com.rain_lovers.huertas_agroecologicas.services.RoleService;
import com.rain_lovers.huertas_agroecologicas.services.StateService;
import com.rain_lovers.huertas_agroecologicas.services.TagService;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    private RoleService roleService;

    @Autowired
    private TagService tagService;

    @Autowired
    private PlantationStateService plantationStateService;

    @Autowired
    private StateService stateService;

    @Autowired
    private ImageService imageService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private ProvinceService provinceService;

    @Autowired
    private CityService cityService;

    @Override
    public void run(String... args) {
        roleService.loadRoles();
        tagService.loadTags();
        plantationStateService.loadPlantationStates();
        stateService.loadStates();

        imageService.saveProfile(null);
        countryService.saveCountry("Argentina");
        provinceService.saveProvince("Buenos Aires");
        cityService.saveCity("Carlos Spegazzini");
    }
}