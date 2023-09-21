package com.rain_lovers.huertas_agroecologicas.models;

import java.time.LocalDate;
import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import org.hibernate.annotations.GenericGenerator;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @NotBlank
    private String title;

    @NotBlank
    private String body;

    @NotNull
    private Image image;

    @NotNull
    private Boolean is_notice;

    @NotNull
    private LocalDate creation_date;

    @NotNull
    private Garden garden;

    @NotNull
    private Plantation plantation;

    @NotNull
    private Tag tag;

    @NotNull
    private ArrayList<Comment> comments;
}
