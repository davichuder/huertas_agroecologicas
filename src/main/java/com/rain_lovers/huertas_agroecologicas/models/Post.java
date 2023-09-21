package com.rain_lovers.huertas_agroecologicas.models;

import java.time.LocalDate;
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
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @NotBlank
    private String title;

    @NotBlank
    private String body;

    @NotBlank
    private Image image;

    @NotBlank
    private Boolean is_notice;

    @NotBlank
    private LocalDate creation_date;

    @NotNull
    private Garden garden;

    @NotNull
    private Plantation plantation;

    @NotNull
    private Tag tag;

    @Notnull
    private ArrayList<Comment> comments;
}
