package com.wewin.notes.users.domain.ports;

import com.wewin.notes.users.domain.dto.UserDTO;
import com.wewin.notes.users.infraestructure.entity.User;

import java.util.List;

public interface UserPersistencePort {
    List<User> getAllUsers();
    User addUser(UserDTO userDTO);
    User updateUser(String email, UserDTO userDTO);
    void deleteUser(Long id);
}
