package com.cinema.repositories;

import com.cinema.models.ActorFilm;
import com.cinema.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IRoleRepository extends JpaRepository<Role, UUID> {
    Role getRoleByRole(String role);
}
