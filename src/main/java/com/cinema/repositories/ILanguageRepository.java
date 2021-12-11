package com.cinema.repositories;

import com.cinema.models.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ILanguageRepository extends JpaRepository<Language, UUID> {
}
