package com.rain_lovers.huertas_agroecologicas.models;

import java.time.LocalDate;
import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import org.hibernate.annotations.GenericGenerator;
import jakarta.persistence.Id;
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
    @OneToOne
    @JoinColumn(name = "image_id", referencedColumnName = "id")
    private Image image;

    @NotNull
    private Boolean is_notice;

    @NotNull
    private LocalDate creation_date;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "crop_type_id", referencedColumnName = "id")
    private Garden garden;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "plantation_id", referencedColumnName = "id")
    private Plantation plantation;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "tag_id", referencedColumnName = "id")
    private Tag tag;

    @NotNull
    @OneToMany
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    private ArrayList<Comment> comments;
}
