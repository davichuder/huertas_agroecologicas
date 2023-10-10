package com.rain_lovers.huertas_agroecologicas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rain_lovers.huertas_agroecologicas.models.Comment;
import com.rain_lovers.huertas_agroecologicas.models.User;
import com.rain_lovers.huertas_agroecologicas.repositories.CommentRepository;

import jakarta.transaction.Transactional;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Transactional
    public Comment saveCity(String body, User user) {
        // TO DO: Comprobacion de comentario duplicado
        Comment comment = new Comment(user, body);
        return commentRepository.save(comment);
    }
}
