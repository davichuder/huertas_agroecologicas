package com.rain_lovers.huertas_agroecologicas.models;

import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import org.hibernate.annotations.GenericGenerator;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
    @ManyToOne
    @JoinColumn(name = "cropType_id", referencedColumnName = "id")
    private CropType cropType;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "harvest_id", referencedColumnName = "id")
    private Harvest harvest;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "cropVariety_id", referencedColumnName = "id")
    private CropVariety cropVariety;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "plantationState_id", referencedColumnName = "id")
    private PlantationState plantationState;

    @NotBlank
    private String additional_notes;

    @NotNull
    @OneToMany
    @JoinColumn(name = "plantation_id", referencedColumnName = "id")
    private ArrayList<KgPrice> prices;

    @NotNull
    @OneToMany
    @JoinColumn(name = "plantation_id", referencedColumnName = "id")
    private ArrayList<Sowing> sowing;
}