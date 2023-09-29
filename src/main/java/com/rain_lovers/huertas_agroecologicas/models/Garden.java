package com.rain_lovers.huertas_agroecologicas.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

import java.util.ArrayList;

import org.hibernate.annotations.GenericGenerator;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Table(name = "gardens")
public class Garden {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @NotNull
    @OneToOne
    @JoinColumn(name = "residence_id", referencedColumnName = "id")
    private Residence residence;

    @NotBlank
    private Boolean accepted;

    @NotNull
    @OneToMany
    @JoinColumn(name = "garden_id", referencedColumnName = "id")
    private ArrayList<Plantation> plantation;
}
