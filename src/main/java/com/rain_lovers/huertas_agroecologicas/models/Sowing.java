package com.rain_lovers.huertas_agroecologicas.models;

import java.time.LocalDate;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "sowings")
public class Sowing {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @NotBlank
    private LocalDate sowing_date;

    @NotBlank
    private int sowing_ammount;

    @NotBlank
    private LocalDate harvest_estimated_date;

    @NotNull
    @OneToOne
    @JoinColumn(name = "sowing_id", referencedColumnName = "id")
    private SowingHarvest sowing_harvest;
}
