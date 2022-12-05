package com.example.SpringBootConnection.services;

import com.example.SpringBootConnection.models.User;
import com.example.SpringBootConnection.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> listAllUsers() {
        return userRepository.findAll();
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User getUser(Integer id) {
        return userRepository.findById(id).get();
    }
}
