package com.rain_lovers.huertas_agroecologicas.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rain_lovers.huertas_agroecologicas.models.Province;

@Repository
public interface ProvinceRepository extends JpaRepository<Province, String> {
    Boolean existsByName(String name);

    @Query("SELECT p FROM Province AS p WHERE p.name = :name")
    Optional<Province> findByName(String name);
}
