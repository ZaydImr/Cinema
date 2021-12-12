package com.cinema.services;

import com.cinema.dao.IGenericRepository;
import com.cinema.models.Comment;
import com.cinema.repositories.ICommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CommentService implements IGenericRepository<Comment, UUID> {
    private ICommentRepository commentRepository;

    public CommentService(ICommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }


    @Override
    public List<Comment> GetAll() {
        return null;
    }

    @Override
    public void AddEntity(Comment obj) {

    }

    @Override
    public void UpdateEntity(Comment obj) {

    }

    @Override
    public Comment GetOneById(int id) {
        return null;
    }

    @Override
    public void DeleteEntity(int id) {

    }
}
