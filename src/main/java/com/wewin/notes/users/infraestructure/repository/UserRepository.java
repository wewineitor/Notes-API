package com.wewin.notes.users.infraestructure.repository;

import com.wewin.notes.users.infraestructure.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
