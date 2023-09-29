package com.rain_lovers.huertas_agroecologicas.models;

import java.util.ArrayList;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "harvests")
public class Harvest {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @NotBlank
    @Column(unique = true)
    private String name;

    @OneToMany
    @JoinColumn(name = "harvest_id", referencedColumnName = "id")
    private ArrayList<CropVariety> varieties;
}
