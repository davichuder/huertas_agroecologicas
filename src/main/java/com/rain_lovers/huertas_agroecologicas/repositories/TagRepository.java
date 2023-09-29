package com.rain_lovers.huertas_agroecologicas.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rain_lovers.huertas_agroecologicas.enums.TagEnum;
import com.rain_lovers.huertas_agroecologicas.models.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, String> {
  Optional<Tag> findByName(TagEnum name);
}