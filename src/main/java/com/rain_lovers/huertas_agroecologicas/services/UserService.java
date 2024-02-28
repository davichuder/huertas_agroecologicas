package com.rain_lovers.huertas_agroecologicas.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rain_lovers.huertas_agroecologicas.enums.RoleEnum;
import com.rain_lovers.huertas_agroecologicas.enums.StateEnum;
import com.rain_lovers.huertas_agroecologicas.models.Image;
import com.rain_lovers.huertas_agroecologicas.models.Post;
import com.rain_lovers.huertas_agroecologicas.models.Role;
import com.rain_lovers.huertas_agroecologicas.models.State;
import com.rain_lovers.huertas_agroecologicas.models.User;
import com.rain_lovers.huertas_agroecologicas.repositories.PostRepository;
import com.rain_lovers.huertas_agroecologicas.repositories.UserRepository;

import Exceptions.GeneralException;
import jakarta.transaction.Transactional;

/**
 * This is the Service class for the user entity
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleService roleService;

    @Autowired
    private StateService stateService;

    @Autowired
    private PostRepository postRepository;

    public User getUserByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            return user.get();
        }
        return null;
    }

    /**
     * This method should verify if the user is already deleted or not
     * 
     * @param email
     * @throws GeneralException
     * @throws Exception
     */
    public void verifyDeleted(User user) throws GeneralException {

        if (user.isDeleted()) {
            throw new GeneralException("Error, user not found");
        }
    }

    /**
     * This method should be able to validate if the parameters are null or not
     * 
     * @param email
     * @param password
     * @param name
     * @param lastname
     * @throws GeneralException
     * @throws Exception
     */
    public void parametersValidation(String email, String password, String name, String lastname)
            throws GeneralException, Exception {

        try {
            if (password == null || password.isEmpty() || password.trim().isEmpty()) {
                throw new GeneralException("Password cannot be null or empty");
            }
            ;
            if (email == null || email.isEmpty() || email.trim().isEmpty() ||
                    !email.contains("@")) {
                throw new GeneralException("Email cannot be null or empty or not contain @");
            }
            ;
            if (name == null || name.isEmpty() || name.trim().isEmpty()) {
                throw new GeneralException("Name cannot be null or empty");
            }
            ;
            if (lastname == null || lastname.isEmpty() || lastname.trim().isEmpty()) {
                throw new GeneralException("Last name cannot be null or empty");
            }
            ;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /**
     * This method should be able to create an user and save it on DB using the
     * Repository
     * 
     * @param email
     * @param password
     * @param name
     * @param lastName
     * @return
     * @throws GeneralException
     * @throws Exception
     */
    @Transactional
    public User saveUser(String email, String password, String name, String lastName)
            throws GeneralException, Exception {
        parametersValidation(email, password, name, lastName);
        Role role = roleService.getRoleByEnum(RoleEnum.ROLE_USER);
        State state = stateService.getStateByEnum(StateEnum.PENDING);
        stateService.getStateByEnum(StateEnum.PENDING);
        User user = new User(email, password, name, lastName, role, state);
        return userRepository.save(user);
    }

    /**
     * This method should modify the email of a user
     * 
     * @param email
     */
    @Transactional
    public void modifyEmail(String email, String emailChange) throws GeneralException {

        Optional<User> userFound = userRepository.findByEmail(email);
        verifyDeleted(userFound.get());
        if (userFound.isPresent()) {
            User user = userFound.get();
            user.setEmail(emailChange);
            userRepository.save(user);
        }
    }

    /**
     * This method should modify the password of a user
     * 
     * @param email
     * @param password
     */
    @Transactional
    public void modifyPassword(String email, String password) throws GeneralException {

        Optional<User> userFound = userRepository.findByEmail(email);
        verifyDeleted(userFound.get());
        if (userFound.isPresent()) {
            User user = userFound.get();
            user.setPassword(password);
            userRepository.save(user);
        }
    }

    /**
     * This method should modify the name of a user
     * 
     * @param email
     * @param name
     */
    @Transactional
    public void modifyName(String email, String name) throws GeneralException {

        Optional<User> userFound = userRepository.findByEmail(email);
        verifyDeleted(userFound.get());
        if (userFound.isPresent()) {
            User user = userFound.get();
            user.setName(name);
            userRepository.save(user);
        }
    }

    /**
     * This method should modify the Lastname of a user
     * 
     * @param email
     * @param lastname
     */
    @Transactional
    public void modifyLastname(String email, String lastname) throws GeneralException {

        Optional<User> userFound = userRepository.findByEmail(email);
        verifyDeleted(userFound.get());
        if (userFound.isPresent()) {
            User user = userFound.get();
            user.setLast_name(lastname);
            userRepository.save(user);
        }
    }

    /**
     * This method should modify the role of a user
     * 
     * @param email
     * @param role
     */
    @Transactional
    public void modifyRole(String email, Role role) throws GeneralException {

        Optional<User> userFound = userRepository.findByEmail(email);
        verifyDeleted(userFound.get());
        if (userFound.isPresent()) {
            User user = userFound.get();
            user.setRole(role);
            userRepository.save(user);
        }
    }

    /**
     * This method should modify the role of a user
     * 
     * @param email
     * @param image
     */
    @Transactional
    public void modifyImage(String email, Image image) throws GeneralException {

        Optional<User> userFound = userRepository.findByEmail(email);
        verifyDeleted(userFound.get());
        if (userFound.isPresent() && userFound.get().) {
            User user = userFound.get();
            user.setImage(image);
            userRepository.save(user);
        }
    }

    /**
     * This method should "delete" a user
     * 
     * @param email
     * @throws GeneralException
     */
    @Transactional
    public void deleteUser(String email) throws GeneralException {

        Optional<User> userFound = userRepository.findByEmail(email);
        verifyDeleted(userFound.get());
        if (userFound.isPresent()) {
            User user = userFound.get();
            user.setDeleted(true);
            userRepository.save(user);
        }
    }

    /**
     * This method should reactivate a user
     * 
     * @param email
     */
    @Transactional
    public void reactivateUser(String email) {

        Optional<User> userFound = userRepository.findByEmail(email);
        if (userFound.isPresent()) {
            User user = userFound.get();
            user.setDeleted(false);
            userRepository.save(user);
        }

    }

    public List<User> listOfUsers() {

        return userRepository.findAll();

    }

    /**
     * This method should be able to add posts to a user
     * 
     * @param user
     * @param post
     */
    @Transactional
    public void addPost(User user, Post post) {
        // TODO: excepcion para verificar user existente, y post no duplicado
        User user_update = userRepository.getById(user.getId());
        user_update.addPost(postRepository.getById(post.getId()));
    }
}
