package com.cinema.services;


import com.cinema.models.User;
import com.cinema.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
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

    public User getUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public void updateResetPasswordToken(String token,String email) throws UsernameNotFoundException{
        User user = userRepository.findByEmail(email);
        if(user != null){
            user.setResetPasswordToken(token);
            userRepository.save(user);
        }else {
            throw new UsernameNotFoundException("Could not find any customer with the email" +email);
        }
    }

    public User getByResetPasswordToken(String token){
        return userRepository.findByResetPasswordToken(token);
    }

    public void updatePassword(User user,String newPassword){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encoderPassword = passwordEncoder.encode(newPassword);
        user.setPassword(encoderPassword);
        user.setResetPasswordToken(null);
        userRepository.save(user);

    }
}