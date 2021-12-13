package com.cinema.services;

import com.cinema.dao.IGenericRepository;
import com.cinema.exceptions.ElementNotFoundException;
import com.cinema.models.Comment;
import com.cinema.repositories.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class CommentService implements IGenericRepository<Comment, UUID> {
    private final ICommentRepository commentRepository;

    @Autowired
    public CommentService(ICommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Comment> GetAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment AddEntity(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment UpdateEntity(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment GetOneById(UUID id) {
        return commentRepository.findCommentById(id)
                .orElseThrow(() -> new ElementNotFoundException("Comment was not found !"));
    }

    @Override
    public void DeleteEntity(UUID id) {
        commentRepository.deleteCommentById(id);
    }
}
