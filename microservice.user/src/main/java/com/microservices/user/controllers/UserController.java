package com.microservices.user.controllers;


import com.microservices.user.entities.User;
import com.microservices.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUsers")
    public List<User> getUsers() {
        return userService.findAll();
    }

    @PostMapping("/create")
    public void create(@RequestBody User user){
        userService.save(user);
    }

    @DeleteMapping ("/delete/{id}")
    public void create(@PathVariable Long id){
        userService.deleteById(id);
    }

    @GetMapping("/search-by-role/{id}")
    public ResponseEntity<?> findByIdRole(@PathVariable Long id){
        return  ResponseEntity.ok(userService.findByRolId(id));
    }


}
