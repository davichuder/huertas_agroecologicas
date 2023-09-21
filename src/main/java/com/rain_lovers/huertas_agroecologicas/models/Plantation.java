package com.rain_lovers.huertas_agroecologicas.models;

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
@Table(name = "plantations")
public class Plantation {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

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