package com.cinema.repositories;

import com.cinema.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ICommentRepository extends JpaRepository<Comment, UUID> {
    @Query("select c from Comment c where c.film.id = ?1")
    List<Comment> getCommentByFilmId(UUID id);
}
