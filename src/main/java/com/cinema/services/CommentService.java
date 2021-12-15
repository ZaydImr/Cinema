package com.cinema.services;

import com.cinema.models.Comment;
import com.cinema.repositories.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CommentService extends AbstractService<Comment, UUID> {

    @Autowired
    private ICommentRepository commentRepository;

    @Override
    protected JpaRepository<Comment, UUID> getRepository() {
        return commentRepository;
    }

    /*@Override
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
    }*/
}
