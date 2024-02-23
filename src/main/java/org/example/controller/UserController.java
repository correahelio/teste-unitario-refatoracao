package org.example.controller;

import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<String> getAllUsers() {
        return userService.getUsers();
    }

    @PostMapping
    public void saveUser(@RequestBody String user) {

        if(user == null) {
            throw new IllegalArgumentException("Nome não pode ser nulo");
        }

        userService.addUser(user);
    }
}
