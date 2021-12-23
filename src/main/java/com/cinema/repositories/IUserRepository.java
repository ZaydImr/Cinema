package com.cinema.repositories;

import com.cinema.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IUserRepository extends JpaRepository<User, UUID> {
    void deleteUserById(UUID id);
    Optional<User> findUserById(UUID id);
    Optional<User> findByEmail(String email);
}
