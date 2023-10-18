package com.rain_lovers.huertas_agroecologicas.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rain_lovers.huertas_agroecologicas.models.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, String> {
    Optional<Post> findByTitle(String title);
}
