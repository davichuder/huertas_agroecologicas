package com.rain_lovers.huertas_agroecologicas.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

import java.util.ArrayList;

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
@Table(name = "gardens")
public class Garden {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @NotNull
    private Home home;

    @NotBlank
    private Boolean accepted;

    @NotNull
    private ArrayList<Plantation> plantation;
}
