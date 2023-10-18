package com.rain_lovers.huertas_agroecologicas.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rain_lovers.huertas_agroecologicas.models.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, String> {
    Optional<Comment> findByBody(String body);
}
