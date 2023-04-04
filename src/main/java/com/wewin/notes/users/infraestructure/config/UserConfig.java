package com.wewin.notes.users.infraestructure.config;

import com.wewin.notes.users.domain.ports.UserPersistencePort;
import com.wewin.notes.users.domain.ports.UserServicePort;
import com.wewin.notes.users.domain.service.UserService;
import com.wewin.notes.users.infraestructure.adapters.UserJpaAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean
    public UserPersistencePort userPersistencePort(){
        return new UserJpaAdapter();
    }

    @Bean
    public UserServicePort userServicePort(){
        return new UserService(userPersistencePort());
    }
}
