package com.rain_lovers.huertas_agroecologicas.models;

import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Table(name = "plantation")
public class Plantation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private CropType cropType;

    @NotNull
    private Harvest harvest;

    @NotNull
    private CropVariety cropVariety;

    @NotNull
    private PlantationState plantationState;

    @NotBlank
    private String additional_notes;

    @NotNull
    private ArrayList<KgPrice> prices;

    @NotNull
    private ArrayList<Sowing> sowing;

}