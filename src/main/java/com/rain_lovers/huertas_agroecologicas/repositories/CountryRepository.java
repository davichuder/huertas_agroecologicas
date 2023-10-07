package com.rain_lovers.huertas_agroecologicas.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rain_lovers.huertas_agroecologicas.models.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
    Boolean existsByName(String name);

    @Query("SELECT c FROM Country as c WHERE c.name = :name")
    Optional<Country> findByName(String name);
}
