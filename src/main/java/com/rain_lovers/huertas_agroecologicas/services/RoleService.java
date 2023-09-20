package com.rain_lovers.huertas_agroecologicas.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rain_lovers.huertas_agroecologicas.enums.RoleEnum;
import com.rain_lovers.huertas_agroecologicas.models.Role;
import com.rain_lovers.huertas_agroecologicas.repositories.RoleRepository;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public void loadRoles() {
        for (RoleEnum roleName : RoleEnum.values()) {
            Optional<Role> role = roleRepository.findByName(roleName);
            if (!role.isPresent()) {
                Role newRole = new Role(roleName);
                roleRepository.save(newRole);
            }
        }
    }
}
