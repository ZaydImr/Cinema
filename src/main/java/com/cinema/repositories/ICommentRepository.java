package com.cinema.repositories;

import com.cinema.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ICommentRepository extends JpaRepository<Comment, UUID> {
    void deleteCommentById(UUID id);

    Optional<Comment> findCommentById(UUID id);
}