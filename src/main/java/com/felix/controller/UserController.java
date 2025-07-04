package com.felix.controller;

import com.felix.exception.UserException;
import com.felix.model.User;
import com.felix.repository.UserRepository;
import com.felix.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {


    @Autowired
    public UserService userService;

    @PostMapping("/api/users")
    public ResponseEntity<User> createUser(@RequestBody @Valid User user){
        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("/api/users")
    public ResponseEntity<List<User>> getAllUsers(){
       List<User> users = userService.getAllUsers();
       return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @GetMapping("/api/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) throws UserException {
          User user = userService.getUserById(id);
          return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/api/users/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user ,@PathVariable("id") Long id) throws UserException {
        User updateUser = userService.updateUser(user, id);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    @DeleteMapping("/api/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) throws UserException {
     userService.deleteUser(id);
     return new ResponseEntity<>("User deleted successfully", HttpStatus.ACCEPTED);
    }

/*
    @GetMapping("/api/users")
    public User getUser(){
        User user = new User();
        user.setFullName("Mariano Manuel");
        user.setEmail("mariano@gmail.com");
        user.setPhone("+351929374017");
        user.setRole("admin");
        return user;
    }
 */
}
