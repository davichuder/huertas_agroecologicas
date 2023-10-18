package com.rain_lovers.huertas_agroecologicas.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rain_lovers.huertas_agroecologicas.enums.RoleEnum;
import com.rain_lovers.huertas_agroecologicas.enums.StateEnum;
import com.rain_lovers.huertas_agroecologicas.models.Post;
import com.rain_lovers.huertas_agroecologicas.models.Role;
import com.rain_lovers.huertas_agroecologicas.models.State;
import com.rain_lovers.huertas_agroecologicas.models.User;
import com.rain_lovers.huertas_agroecologicas.repositories.PostRepository;
import com.rain_lovers.huertas_agroecologicas.repositories.UserRepository;

import jakarta.transaction.Transactional;

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

    @Transactional
    public User saveUser(String email, String password, String name, String lastName){
        // TO DO: Todas las verificaciones, y excepciones
        Role role = roleService.getRoleByEnum(RoleEnum.ROLE_USER);
        State state = stateService.getStateByEnum(StateEnum.PENDING);
        stateService.getStateByEnum(StateEnum.PENDING);
        User user = new User(email, password, name, lastName, role, state);
        return userRepository.save(user);
    }

    @Transactional
    public User getUserByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            return user.get();
        }
        return null;
    }

    @Transactional
    public void addPost(User user, Post post) {
        // TODO: excepciopn para verificar user existnte, y post no duplicado
        User user_update = userRepository.getById(user.getId());
        user_update.addPost(postRepository.getById(post.getId()));
    }
}
