package com.rain_lovers.huertas_agroecologicas.models;

import com.rain_lovers.huertas_agroecologicas.enums.StateEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import org.hibernate.annotations.GenericGenerator;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "states")
public class State {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private int id;

    @Enumerated(EnumType.STRING)
    @NotNull
    private StateEnum name;

    public State(StateEnum name) {
        this.name = name;
    }
}