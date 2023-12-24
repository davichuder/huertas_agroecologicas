package com.rain_lovers.huertas_agroecologicas.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.rain_lovers.huertas_agroecologicas.enums.RoleEnum;
import com.rain_lovers.huertas_agroecologicas.models.Role;
import com.rain_lovers.huertas_agroecologicas.repositories.RoleRepository;

@ExtendWith(MockitoExtension.class)
public class RoleServiceTest {

    @Mock
    private RoleRepository roleRepository;

    @InjectMocks
    private RoleService roleService;

    /**
     * This test should check if the method "getRoleByEnum" works well and returns a
     * role
     */
    @Test
    public void testGetRoleByEnum() {

        Role role = new Role(RoleEnum.ROLE_USER);

        Mockito.when(roleRepository.findByName(RoleEnum.ROLE_USER)).thenReturn(java.util.Optional.of(role));

        Role resultRole = roleService.getRoleByEnum(RoleEnum.ROLE_USER);

        Assertions.assertNotNull(resultRole, "Error, Role should not be null");
        Assertions.assertEquals(RoleEnum.ROLE_USER, resultRole.getName(), "Error, Role should be: ROLE_USER");

    }
}
