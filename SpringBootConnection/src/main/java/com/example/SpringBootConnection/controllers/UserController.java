package com.example.SpringBootConnection.controllers;

import com.example.SpringBootConnection.models.HttpResponse;
import com.example.SpringBootConnection.models.User;
import com.example.SpringBootConnection.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping()
    public HttpResponse listAllUsers() {
        try {
            return new HttpResponse(userService.listAllUsers().toString(), "Users found", true);
        } catch (Exception e) {
            return new HttpResponse("", "No user exist", false);
        }
    }

    @GetMapping("/{id}")
    public HttpResponse getUser(@PathVariable int id) {
        try {
            return new HttpResponse(userService.getUser(id).toString(), "User found", true);
        } catch (Exception e) {
            return new HttpResponse("", "User doesn't exist", false);
        }
    }

    @PostMapping()
    public HttpResponse saveUser(@RequestBody User user) {
        try {
            getUser(user.getId());
            return new HttpResponse("", "User already exists", false);
        } catch (Exception e) {
            userService.saveUser(user);
            return new HttpResponse("", "User correctly created", true);
        }

    }

}
