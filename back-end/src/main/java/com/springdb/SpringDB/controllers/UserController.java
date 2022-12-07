package com.springdb.SpringDB.controllers;

import com.springdb.SpringDB.models.HttpResponse;
import com.springdb.SpringDB.models.User;
import com.springdb.SpringDB.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/user")
@CrossOrigin
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
            return new HttpResponse("", "Could not find User " + id, false);
        }
    }

    @PostMapping()
    public HttpResponse saveUser(@RequestBody User user) {
            if (getUser(user.getId()).isSuccess()) {
                return new HttpResponse("", "User already exists", false);
            } else {
                userService.saveUser(user);
                return new HttpResponse("", "User correctly created", true);
            }
    }
}
