package com.springdb.SpringDB.controllers;

import com.springdb.SpringDB.models.HttpResponse;
import com.springdb.SpringDB.models.User;
import com.springdb.SpringDB.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping()
    public HttpResponse listAllUsers() {
        String userList = userService.listAllUsers().toString();

        if (userList.equals("[]")) {
            return new HttpResponse("", "No user exist", false);
        } else {
            return new HttpResponse(userList, "Users found", true);
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
        } else if (user.getFirstName().length() > 25) {
            return new HttpResponse("", "First name too long, has to bee 25 character maximum", false);
        } else if (user.getLastName().length() > 25) {
            return new HttpResponse("", "Last name too long, has to bee 25 character maximum", false);
        } else if (user.getPhoneNumber().length() > 20) {
            return new HttpResponse("", "Phone number too long, has to bee 20 character maximum", false);
        } else if (user.getEmail().length() > 25) {
            return new HttpResponse("", "Email too long, has to bee 25 character maximum", false);
        } else {
            userService.saveUser(user);
            return new HttpResponse("", "User correctly created", true);
        }
    }
}
