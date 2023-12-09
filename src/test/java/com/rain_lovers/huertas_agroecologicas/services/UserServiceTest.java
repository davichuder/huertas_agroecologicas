package com.rain_lovers.huertas_agroecologicas.services;

import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.rain_lovers.huertas_agroecologicas.models.User;
import com.rain_lovers.huertas_agroecologicas.models.Image;
import com.rain_lovers.huertas_agroecologicas.models.Role;
import com.rain_lovers.huertas_agroecologicas.models.State;

public class UserServiceTest {

    @Test
    @DisplayName("Testing if the user was created correctly")
    void testCreateUser() {

        String password = "test";
        String email = "test@test.com";
        String name = "test1";
        String last_name = "test2";

        Image mockImage = Mockito.mock(Image.class);
        Role mockRole = Mockito.mock(Role.class);
        State mockState = Mockito.mock(State.class);

        User user = new User();

        user.setPassword(password);
        user.setEmail(email);
        user.setName(name);
        user.setLast_name(last_name);
        user.setImage(mockImage);
        user.setRole(mockRole);
        user.setState(mockState);

        testParameters(password, email, name, last_name);

        assertAll("User creation",
                () -> Assertions.assertEquals("test", user.getPassword(), "Password should be `test`"),
                () -> Assertions.assertEquals("test@test.com", user.getEmail(), "Email should be `test@test.com`"),
                () -> Assertions.assertEquals("test1", user.getName(), "Name should be `test1`"),
                () -> Assertions.assertEquals("test2", user.getLast_name(), "Last name should be `test2`"),
                () -> Assertions.assertEquals(mockImage, user.getImage(), "Image should be `" + mockImage + "`"),
                () -> Assertions.assertEquals(mockRole, user.getRole(), "Role should be `" + mockRole + "`"),
                () -> Assertions.assertEquals(mockState, user.getState(), "State should be `" + mockState + "`"));

    }

    @Test
    @DisplayName("Testing if the parameters are valid")
    void testParameters(String Pass, String Email, String Name, String Last_name) {

        if (Pass == null || Pass.isEmpty() || Pass.trim().isEmpty()) {
            Assertions.fail("Password cannot be null or empty");
        }
        ;
        if (Email == null || Email.isEmpty() || Email.trim().isEmpty() ||
                !Email.contains("@")) {
            Assertions.fail("Email cannot be null or empty or not contain @");
        }
        ;
        if (Name == null || Name.isEmpty() || Name.trim().isEmpty()) {
            Assertions.fail("Name cannot be null or empty");
        }
        ;
        if (Last_name == null || Last_name.isEmpty() || Last_name.trim().isEmpty()) {
            Assertions.fail("Last name cannot be null or empty");
        }
        ;
    }
}