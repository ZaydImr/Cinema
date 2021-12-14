package com.cinema.services;


import com.cinema.dao.IGenericRepository;
import com.cinema.exceptions.ElementNotFoundException;
import com.cinema.models.User;
import com.cinema.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class UserService extends AbstractService<User, UUID> {

    @Autowired
    private IUserRepository userRepository;

    @Override
    protected JpaRepository<User, UUID> getRepository() {
        return userRepository;
    }


 /*   @Override
    public List<User> GetAll() {
        return userRepository.findAll();
    }

    @Override
    public User AddEntity(User user) {
        return userRepository.save(user);
    }

    @Override
    public User UpdateEntity(User user) {
        return userRepository.save(user);
    }

    @Override
    public User GetOneById(UUID id) {
        return userRepository.findUserById(id)
                .orElseThrow(() -> new ElementNotFoundException("User was not found !"));
    }

    @Override
    public void DeleteEntity(UUID id) {
        userRepository.deleteUserById(id);
    }*/
}