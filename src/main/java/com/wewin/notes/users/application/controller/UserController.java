package com.wewin.notes.users.application.controller;

import com.wewin.notes.users.domain.dto.UserDTO;
import com.wewin.notes.users.domain.port.UserServicePort;
import com.wewin.notes.users.infraestructure.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserServicePort userServicePort;

    @CrossOrigin
    @GetMapping("/list")
    List<User> getAllUsers() {
        return userServicePort.getAllUsers();
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    User addUser(@RequestBody UserDTO userDTO) {
        return userServicePort.addUser(userDTO);
    }

    @CrossOrigin
    @PutMapping("/update/{email}")
    User updateUser(@PathVariable String email, @RequestBody UserDTO userDTO) {
        return userServicePort.updateUser(email, userDTO);
    }

    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    void deleteUser(@PathVariable Long id) {
        userServicePort.deleteUser(id);
    }
}
