package com.rain_lovers.huertas_agroecologicas.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rain_lovers.huertas_agroecologicas.models.City;

@Repository
public interface CityRepository extends JpaRepository<City, String> {
    Boolean existsByName(String name);

    @Query("SELECT c FROM City AS c WHERE c.name = :name")
    Optional<City> findByName(String name);
}
