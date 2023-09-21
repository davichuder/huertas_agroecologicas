package com.rain_lovers.huertas_agroecologicas.models;

import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import org.hibernate.annotations.GenericGenerator;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @ManyToOne
    @NotNull
    private Role role;

    @NotNull
    private Image image;

    @NotBlank
    private String name;

    @NotBlank
    private String last_name;

    @NotNull
    private ArrayList<Post> posts;

    @NotNull 
    private State state;

    @NotNull
    private boolean application;
}