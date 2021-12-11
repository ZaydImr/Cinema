package com.cinema.repositories;

import com.cinema.models.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IDirectorRepository extends JpaRepository<Director, UUID> {
}
