package com.rain_lovers.huertas_agroecologicas.models;

import java.util.Collections;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;

    @OneToOne
    @JoinColumn(name = "image_id", referencedColumnName = "id")
    private Image image;

    @NotBlank
    private String name;

    @NotBlank
    private String last_name;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private List<Post> posts;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "state_id", referencedColumnName = "id")
    private State state;

    @NotNull
    private boolean application;

    public User(String email, String password, String name, String lastName, Role role, State state) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.last_name = lastName;
        this.posts = Collections.emptyList();
        this.role = role;
        this.image = null;
        this.application = false;
        this.state = state;
    }

    public void addPost(Post post) {
        this.posts.add(post);
    }
}