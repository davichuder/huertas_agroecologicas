package com.rain_lovers.huertas_agroecologicas.services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rain_lovers.huertas_agroecologicas.enums.PlantationStateEnum;
import com.rain_lovers.huertas_agroecologicas.models.PlantationState;
import com.rain_lovers.huertas_agroecologicas.repositories.PlantationStateRepository;

import jakarta.transaction.Transactional;

@Service
public class PlantationStateService {
    @Autowired
    private PlantationStateRepository plantationStateRepository;

    @Transactional
    public void loadPlantationStates() {
        List<PlantationState> newPlantationStates = Arrays.stream(PlantationStateEnum.values())
                .filter(plantationStateName -> !plantationStateRepository.findByName(plantationStateName).isPresent())
                .map(PlantationState::new)
                .collect(Collectors.toList());
        plantationStateRepository.saveAll(newPlantationStates);
    }
}
