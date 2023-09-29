package com.rain_lovers.huertas_agroecologicas.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rain_lovers.huertas_agroecologicas.enums.PlantationStateEnum;
import com.rain_lovers.huertas_agroecologicas.models.PlantationState;

@Repository
public interface PlantationStateRepository extends JpaRepository<PlantationState, String> {
  Optional<PlantationState> findByName(PlantationStateEnum name);}
  

  