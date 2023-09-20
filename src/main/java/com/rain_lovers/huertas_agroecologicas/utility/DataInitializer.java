package com.rain_lovers.huertas_agroecologicas.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.rain_lovers.huertas_agroecologicas.services.RoleService;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    private RoleService roleService;

    @Override
    public void run(String... args) {
        roleService.loadRoles();
    }
}