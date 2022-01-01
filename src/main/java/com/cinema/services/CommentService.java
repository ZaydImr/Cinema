package com.cinema.services;

import com.cinema.models.Comment;
import com.cinema.repositories.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CommentService extends AbstractService<Comment, UUID> {

    @Autowired
    private ICommentRepository commentRepository;

    @Override
    protected JpaRepository<Comment, UUID> getRepository() {
        return commentRepository;
    }

    public List<Comment> getCommentByFilmId(UUID id) {
        return commentRepository.getCommentByFilmId(id);
    }
}
