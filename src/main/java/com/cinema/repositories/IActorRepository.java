package com.cinema.repositories;

import com.cinema.models.Actor;
import com.cinema.models.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface IActorRepository extends JpaRepository<Actor, UUID> {
    @Query("SELECT d FROM Actor d WHERE d.fullNameActor LIKE %?1%")
    List<Actor> getAllByKeyword(String fullname);
}
