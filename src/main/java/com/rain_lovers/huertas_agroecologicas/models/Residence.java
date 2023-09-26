package com.rain_lovers.huertas_agroecologicas.models;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.geo.Point;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "residences")
public class Residence {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @NotNull
    private Country country;

    @NotNull
    private Province province;

    @NotNull
    private City city;

    @NotBlank
    private String street;

    @NotBlank
    private String details;

    @NotBlank
    private Point coords;

    @NotBlank
    private int height;
}
