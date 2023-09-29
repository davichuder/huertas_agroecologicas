package com.rain_lovers.huertas_agroecologicas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rain_lovers.huertas_agroecologicas.models.CropType;

@Repository
public interface CropTypeRepository extends JpaRepository<CropType, String> {

}
