package com.rain_lovers.huertas_agroecologicas.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rain_lovers.huertas_agroecologicas.enums.StateEnum;
import com.rain_lovers.huertas_agroecologicas.models.State;
import com.rain_lovers.huertas_agroecologicas.repositories.StateRepository;

import jakarta.transaction.Transactional;

@Service
public class StateService {
    @Autowired
    private StateRepository stateRepository;

    @Transactional
    public void loadStates() {
        List<State> newStates = Arrays.stream(StateEnum.values())
                .filter(stateName -> !stateRepository.findByName(stateName).isPresent())
                .map(State::new)
                .collect(Collectors.toList());
        stateRepository.saveAll(newStates);
    }

    public State getStateByEnum(StateEnum stateName) {
        Optional<State> state = stateRepository.findByName(stateName);
        if (state.isPresent()) {
            return state.get();
        }
        return null;
    }
}
