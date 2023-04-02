package com.wewin.notes.users.domain.service;

import com.wewin.notes.users.domain.dto.UserDTO;
import com.wewin.notes.users.domain.port.UserServicePort;
import com.wewin.notes.users.infraestructure.entity.User;
import com.wewin.notes.users.infraestructure.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserService implements UserServicePort {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User addUser(UserDTO userDTO) {
        User user = new ModelMapper().map(userDTO, User.class);
        return userRepository.save(user);
    }

    @Override
    public User updateUser(String email, UserDTO userDTO) {
        User user = userRepository.findByEmail(email);
        new ModelMapper().map(userDTO, user);
        userRepository.save(user);
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
