package com.wewin.notes.users.application.controller;

import com.wewin.notes.users.domain.dto.UserDTO;
import com.wewin.notes.users.domain.port.UserServicePort;
import com.wewin.notes.users.infraestructure.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@Api(value = "Manejador de notas para distintos usuarios", description = "Operaciones para el manejo de usuarios en el manejador de notas")
public class UserController {
    @Autowired
    UserServicePort userServicePort;

    @CrossOrigin
    @GetMapping("/list")
    @ApiOperation(value = "Enlista todos los usuarios existentes", response = List.class)
    List<User> getAllUsers() {
        return userServicePort.getAllUsers();
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    @ApiOperation(value = "Agrega un usuario nuevo", response = List.class)
    User addUser(@RequestBody UserDTO userDTO) {
        return userServicePort.addUser(userDTO);
    }

    @CrossOrigin
    @PutMapping("/update/{email}")
    @ApiOperation(value = "Actualiza un usuario existente a partir del email", response = List.class)
    User updateUser(@PathVariable String email, @RequestBody UserDTO userDTO) {
        return userServicePort.updateUser(email, userDTO);
    }

    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Elimina un usuario utilizando su ID como referencia", response = List.class)
    void deleteUser(@PathVariable Long id) {
        userServicePort.deleteUser(id);
    }
}
