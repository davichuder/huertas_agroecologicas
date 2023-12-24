package com.rain_lovers.huertas_agroecologicas.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.rain_lovers.huertas_agroecologicas.enums.RoleEnum;
import com.rain_lovers.huertas_agroecologicas.enums.StateEnum;
import com.rain_lovers.huertas_agroecologicas.models.Image;
import com.rain_lovers.huertas_agroecologicas.models.Role;
import com.rain_lovers.huertas_agroecologicas.models.State;
import com.rain_lovers.huertas_agroecologicas.models.User;
import com.rain_lovers.huertas_agroecologicas.repositories.UserRepository;

import Exceptions.GeneralException;

/**
 * This class was made for the tests of the methods in the class "UserService"
 */
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    // Here we mock the dependencies that we gonna use
    @Mock
    private RoleService roleServiceMock;

    @Mock
    private StateService stateServiceMock;

    @Mock
    private UserRepository userRepositoryMock;

    // This class is where the Mocks gonna be Injected
    @InjectMocks
    private UserService userServiceMock;

    @Captor
    private ArgumentCaptor<User> userCaptor;

    /**
     * This is a test for the method "saveUser" from the class "UserService"
     * there are two mocked classes which are Role and State
     * 
     * @Return should be a User
     */
    @Test
    @DisplayName("Testing if the user was created correctly")
    void testCreateUser() throws GeneralException, Exception {

        Role role = new Role(RoleEnum.ROLE_USER);
        Mockito.when(roleServiceMock.getRoleByEnum(RoleEnum.ROLE_USER)).thenReturn(role);

        State state = new State(StateEnum.PENDING);
        Mockito.when(stateServiceMock.getStateByEnum(StateEnum.PENDING)).thenReturn(state);

        Mockito.when(userRepositoryMock.save(Mockito.any(User.class))).thenReturn(new User());

        User resultUser = userServiceMock.saveUser("test@test.com", "doggie", "Raul", "Vasquez");

        assertNotNull(resultUser);

        Mockito.verify(userRepositoryMock).save(Mockito.any(User.class));
        Mockito.verify(userRepositoryMock).save(userCaptor.capture());

        // the variable "capturedUser" will save the data from what the "userCaptor"
        // will return
        // in this case, "capturedUser" will have a User.
        User capturedUser = userCaptor.getValue();

        assertEquals("test@test.com", capturedUser.getEmail(), "");
        assertEquals("doggie", capturedUser.getPassword());
        assertEquals("Raul", capturedUser.getName());
        assertEquals("Vasquez", capturedUser.getLast_name());
        assertEquals(role, capturedUser.getRole());
        assertEquals(state, capturedUser.getState());
    }

    /**
     * This test should check if the method "verifyDeleted" throws an error when the
     * user is deleted
     * 
     * @throws GeneralException
     */
    @Test
    @DisplayName("Testing the method that should verify if the user is deleted or not")
    void testVerifyDeleted() throws GeneralException {

        User userTest = new User();

        userTest.setDeleted(true);

        GeneralException exception = assertThrows(GeneralException.class,
                () -> userServiceMock.verifyDeleted(userTest));

        assertEquals("Error, user not found", exception.getMessage());
    }

    /**
     * This test should check if the "modifyEmail" is truly working and modifies the
     * email of a user
     * 
     * @throws GeneralException
     */
    @Test
    @DisplayName("Testing if the email of a user is modified correctly")
    void testModifyEmail() throws GeneralException {

        User userTest = new User();

        userTest.setEmail("Test@Test.com");
        userTest.setDeleted(false);

        Mockito.when(userRepositoryMock.findByEmail(userTest.getEmail())).thenReturn(Optional.of(userTest));

        userServiceMock.modifyEmail("Test@Test.com", "emailChanged@test.com");

        assertEquals("emailChanged@test.com", userTest.getEmail());
    }

    /**
     * This test should check if the method "modifyPassword" is truly working and
     * modifies the password of a user
     * 
     * @throws GeneralException
     */
    @Test
    @DisplayName("Testing if the password of a user is modified correctly")
    void testModifyPassword() throws GeneralException {

        User userTest = new User();

        userTest.setEmail("Test@Test.com");
        userTest.setPassword("test123");
        userTest.setDeleted(false);

        Mockito.when(userRepositoryMock.findByEmail(userTest.getEmail())).thenReturn(Optional.of(userTest));

        userServiceMock.modifyPassword(userTest.getEmail(), "test1");

        assertEquals("test1", userTest.getPassword());
    }

    /**
     * This test should check if the method "modifyName" is truly working and
     * modifies the name of a user
     * 
     * @throws GeneralException
     */
    @Test
    @DisplayName("Testing if the name of a user is modified correctly")
    void testModifyName() throws GeneralException {

        User userTest = new User();

        userTest.setEmail("test@test.com");
        userTest.setName("test");
        userTest.setDeleted(false);

        Mockito.when(userRepositoryMock.findByEmail(userTest.getEmail())).thenReturn(Optional.of(userTest));

        userServiceMock.modifyName(userTest.getEmail(), "nameChange");

        assertEquals("nameChange", userTest.getName());
    }

    /**
     * This test should check if the method "modifyLastname" is truly working and
     * modifies the lastname of a user
     * 
     * @throws GeneralException
     */
    @Test
    @DisplayName("Testing if the lastname of a user is modified correctly")
    void testModifyLastname() throws GeneralException {

        User userTest = new User();

        userTest.setEmail("test@test.com");
        userTest.setLast_name("tester");
        userTest.setDeleted(false);

        Mockito.when(userRepositoryMock.findByEmail(userTest.getEmail())).thenReturn(Optional.of(userTest));

        userServiceMock.modifyLastname(userTest.getEmail(), "tester2");

        assertEquals("tester2", userTest.getLast_name());
    }

    /**
     * This test should check if the method "modifyRole" is truly working and
     * modifies the role of a user
     * 
     * @throws GeneralException
     */
    @Test
    @DisplayName("Testing if the role of a user is modified correctly")
    void testModifyRole() throws GeneralException {

        User userTest = new User();

        Role role = new Role();
        role.setName(RoleEnum.ROLE_USER);
        Role role2 = new Role();
        role2.setName(RoleEnum.ROLE_ADMIN);

        userTest.setEmail("test@test.com");
        userTest.setRole(role);
        userTest.setDeleted(false);

        Mockito.when(userRepositoryMock.findByEmail(userTest.getEmail())).thenReturn(Optional.of(userTest));

        userServiceMock.modifyRole(userTest.getEmail(), role2);

        assertEquals(RoleEnum.ROLE_ADMIN, userTest.getRole().getName());
    }

    /**
     * This test should check if the method "modifyImage" is truly working and
     * modifies the image of a user
     * 
     * @throws GeneralException
     */
    @Test
    @DisplayName("Testing if the image of a user is modified correctly")
    void testModifyImage() throws GeneralException {

        User userTest = new User();

        Image image = new Image();
        image.setMime("image/jpeg");
        image.setName("imagen_original.jpg");

        Image image2 = new Image();
        image2.setMime("image/jpeg");
        image2.setName("changed_image.jpg");

        userTest.setEmail("test@test.com");
        userTest.setImage(image);
        userTest.setDeleted(false);

        Mockito.when(userRepositoryMock.findByEmail(userTest.getEmail())).thenReturn(Optional.of(userTest));

        userServiceMock.modifyImage(userTest.getEmail(), image2);

        assertEquals(image2.getMime(), userTest.getImage().getMime());
        assertEquals(image2.getName(), userTest.getImage().getName());
    }

    /**
     * This test should check if the method "deletedUser" is truly working and
     * delete a user
     * 
     * @throws GeneralException
     */
    @Test
    @DisplayName("Testing if the method for delete a user works well")
    void testDeletedUser() throws GeneralException {

        User userTest = new User();

        userTest.setEmail("test@test.com");

        Mockito.when(userRepositoryMock.findByEmail(userTest.getEmail())).thenReturn(Optional.of(userTest));

        userServiceMock.deleteUser(userTest.getEmail());

        assertEquals(true, userTest.isDeleted());
    }

    /**
     * This test should check if the method "ReactivateUser" is truly working and
     * reactivates a user
     * 
     * @throws GeneralException
     */
    @Test
    @DisplayName("Testing if the method for reactivate a user works well")
    void testReactivateUser() throws GeneralException {

        User userTest = new User();

        userTest.setEmail("test@test.com");
        userTest.setDeleted(true);

        Mockito.when(userRepositoryMock.findByEmail(userTest.getEmail())).thenReturn(Optional.of(userTest));

        userServiceMock.reactivateUser(userTest.getEmail());

        assertEquals(false, userTest.isDeleted());

    }

    /**
     * This test should check if the method "ListOfUsers" is truly working and
     * returns a list of users
     */
    @Test
    @DisplayName("Testing if the method to find all users works well")
    void testFindUsers() {

        Mockito.when(userRepositoryMock.findAll())
                .thenReturn(Arrays.asList(new User("juan.perez@example.com", "pass", "Juan Pérez", "López", null, null),
                        new User("maria.lopez@example.com", "pass2", "María López", "García", null, null)));

        List<User> users = userServiceMock.listOfUsers();

        assertEquals(2, users.size());

        assertEquals("juan.perez@example.com", users.get(0).getEmail());
        assertEquals("pass", users.get(0).getPassword());
        assertEquals("Juan Pérez", users.get(0).getName());
        assertEquals("López", users.get(0).getLast_name());

        assertEquals("maria.lopez@example.com", users.get(1).getEmail());
        assertEquals("pass2", users.get(1).getPassword());
        assertEquals("María López", users.get(1).getName());
        assertEquals("García", users.get(1).getLast_name());

    }
}