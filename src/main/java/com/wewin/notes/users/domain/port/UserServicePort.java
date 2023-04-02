package com.wewin.notes.users.domain.port;

import com.wewin.notes.users.domain.dto.UserDTO;
import com.wewin.notes.users.infraestructure.entity.User;

import java.util.List;

public interface UserServicePort {
    List<User> getAllUsers();
    User addUser(UserDTO userDTO);
    User updateUser(String email, UserDTO userDTO);
    void deleteUser(Long id);
}
