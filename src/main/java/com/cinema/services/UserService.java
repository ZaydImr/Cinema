package com.cinema.services;

import com.cinema.exceptions.ElementNotFoundException;
import com.cinema.models.Film;
import com.cinema.models.User;
import com.cinema.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final IUserRepository userRepository;

    @Autowired
    public UserService(IUserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User addUser(User user){
        user.setIdUser(UUID.fromString(UUID.randomUUID().toString()));
        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User updateUser(User user){
        return userRepository.save(user);
    }

    public User findUserById(UUID id) throws Throwable {
        return userRepository.findUserById(id)
                .orElseThrow(() -> new ElementNotFoundException("User was not found !"));
    }

    public void deleteUser(UUID id){
        userRepository.deleteUserById(id);
    }

}
