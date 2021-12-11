package com.cinema.services;

import com.cinema.repositories.IUserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private IUserRepository userRepository;
    public UserService(IUserRepository userRepository){
        this.userRepository = userRepository;
    }
}
