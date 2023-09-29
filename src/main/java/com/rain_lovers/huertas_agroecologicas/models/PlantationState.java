package com.rain_lovers.huertas_agroecologicas.models;

import org.hibernate.annotations.GenericGenerator;

import com.rain_lovers.huertas_agroecologicas.enums.PlantationStateEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "plantation_states")
public class PlantationState {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Enumerated(EnumType.STRING)
    @NotNull
    private PlantationStateEnum name;

    public PlantationState(PlantationStateEnum name) {
        this.name = name;
    }
}
