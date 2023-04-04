package com.wewin.notes.users.domain.service;

import com.wewin.notes.users.domain.dto.UserDTO;
import com.wewin.notes.users.domain.ports.UserPersistencePort;
import com.wewin.notes.users.domain.ports.UserServicePort;
import com.wewin.notes.users.infraestructure.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServicePort {

    private final UserPersistencePort userPersistencePort;

    public UserService(UserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public List<User> getAllUsers() {
        return userPersistencePort.getAllUsers();
    }

    @Override
    public User addUser(UserDTO userDTO) {
        return userPersistencePort.addUser(userDTO);
    }

    @Override
    public User updateUser(String email, UserDTO userDTO) {
        return userPersistencePort.updateUser(email, userDTO);
    }

    @Override
    public void deleteUser(Long id) {
        userPersistencePort.deleteUser(id);
    }
}
