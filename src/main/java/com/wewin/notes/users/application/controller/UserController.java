package com.wewin.notes.users.application.controller;

import com.wewin.notes.users.domain.dto.UserDTO;
import com.wewin.notes.users.domain.port.UserServicePort;
import com.wewin.notes.users.infraestructure.entity.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@Tag(name = "Controlador de usuarios", description = "Operaciones para el manejo de usuarios en el manejador de notas")
public class UserController {
    @Autowired
    UserServicePort userServicePort;

    @CrossOrigin
    @GetMapping("/list")
    @Operation(summary = "Listar usuarios", description = "Lista todos los usuarios existentes")
    List<User> getAllUsers() {
        return userServicePort.getAllUsers();
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    @Operation(summary = "Agregar usuario", description = "Agrega un usuario nuevo")
    User addUser(@RequestBody UserDTO userDTO) {
        return userServicePort.addUser(userDTO);
    }

    @CrossOrigin
    @PutMapping("/update/{email}")
    @Operation(summary = "Actualizar usuario", description = "Actualiza un usuario existente a partir del email")
    User updateUser(@PathVariable String email, @RequestBody UserDTO userDTO) {
        return userServicePort.updateUser(email, userDTO);
    }

    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Eliminar usuario", description = "Elimina un usuario utilizando su ID como referencia")
    void deleteUser(@PathVariable Long id) {
        userServicePort.deleteUser(id);
    }
}
