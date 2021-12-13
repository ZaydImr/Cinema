package com.cinema.repositories;

import com.cinema.models.Nationality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface INationalityRepository extends JpaRepository<Nationality, UUID> {
    Optional<Nationality> findLanguageById(UUID id);

    void deleteLanguageById(UUID id);
}
