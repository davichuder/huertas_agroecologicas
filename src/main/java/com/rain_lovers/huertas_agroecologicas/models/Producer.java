package com.rain_lovers.huertas_agroecologicas.models;

import java.util.ArrayList;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Table(name = "producers")
public class Producer extends User {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @NotBlank
    private String phone;

    @NotNull
    @OneToOne
    @JoinColumn(name = "residence_id", referencedColumnName = "id")
    private Residence residence;

    @NotBlank
    @Size(max = 13)
    private String cuit;

    @OneToMany
    @JoinColumn(name = "producer_id", referencedColumnName = "id")
    private ArrayList<Garden> gardens;
}
