package com.rain_lovers.huertas_agroecologicas.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rain_lovers.huertas_agroecologicas.enums.TagEnum;
import com.rain_lovers.huertas_agroecologicas.models.Comment;
import com.rain_lovers.huertas_agroecologicas.models.Post;
import com.rain_lovers.huertas_agroecologicas.models.Tag;
import com.rain_lovers.huertas_agroecologicas.repositories.CommentRepository;
import com.rain_lovers.huertas_agroecologicas.repositories.PostRepository;

import jakarta.transaction.Transactional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private TagService tagService;

    @Autowired
    private CommentRepository commentRepository;

    @Transactional
    public Post savePost(String title, String body, TagEnum tagName) {
        // TO DO: Lanzar excepcion si ya existe por titulo, y body
        Tag tag = tagService.getTagByEnum(tagName);
        Post post = new Post(title, body, tag);
        return postRepository.save(post);
    }

    @Transactional
    public Post getPostByTitle(String title) {
        Optional<Post> post = postRepository.findByTitle(title);
        if (post.isPresent()) {
            return post.get();
        }
        return null;
    }

    @Transactional
    public void addComment(Post post, Comment comment) {
        // TODO: Verificaciones de seguridad de post existente y comentario duplicado
        Post post_update = postRepository.getById(post.getId());
        post_update.addComment(commentRepository.getById(comment.getId()));
    }
}
