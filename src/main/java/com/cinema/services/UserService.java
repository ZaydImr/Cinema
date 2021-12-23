package com.cinema.services;


import com.cinema.models.User;
import com.cinema.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService extends AbstractService<User, UUID> {

    @Autowired
    private IUserRepository userRepository;

    @Override
    protected JpaRepository<User, UUID> getRepository() {
        return userRepository;
    }

    public long getCountOfUsers(){
        return userRepository.count();
    }
}