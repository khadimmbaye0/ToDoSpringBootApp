package com.firstappwithspringboot.todospringbootapp.services;

import com.firstappwithspringboot.todospringbootapp.entities.Project;
import com.firstappwithspringboot.todospringbootapp.entities.User;
import com.firstappwithspringboot.todospringbootapp.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Integer idUser) {
        User user = findUserById(idUser);
        if (user != null) {
            userRepository.deleteById(idUser);
            System.out.println("User deleted successfully");
        }
        else {
            System.out.println("User not found");
        }
    }

    public User findUserById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            System.out.println("User not found");
            return null;
        }
    }

}
