package com.rain_lovers.huertas_agroecologicas.services;

import java.util.Optional;

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
    public Comment saveComment(User user, String body) {
        // TO DO: Comprobacion de comentario duplicado
        Comment comment = new Comment(user, body);
        return commentRepository.save(comment);
    }

    @Transactional
    public Comment getCommentByBody(String body){
        Optional<Comment> comment = commentRepository.findByBody(body);
        if (comment.isPresent()) {
            return comment.get();
        }
        return null;
    }
}
