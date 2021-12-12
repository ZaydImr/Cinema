package com.cinema.services;

import com.cinema.dao.IGenericRepository;
import com.cinema.models.User;
import com.cinema.repositories.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService implements IGenericRepository<User, UUID> {
    private IUserRepository userRepository;
    public UserService(IUserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public List<User> GetAll() {
        return null;
    }

    @Override
    public void AddEntity(User obj) {

    }

    @Override
    public void UpdateEntity(User obj) {

    }

    @Override
    public User GetOneById(int id) {
        return null;
    }

    @Override
    public void DeleteEntity(int id) {

    }
}
