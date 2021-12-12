package com.cinema.services;


import com.cinema.exceptions.ElementNotFoundException;
import com.cinema.models.Comment;
import com.cinema.repositories.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CommentService {
    private final ICommentRepository commentRepository;

    @Autowired
    public CommentService(ICommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }

    public Comment addComment(Comment comment){
        comment.setIdComment(UUID.fromString(UUID.randomUUID().toString()));
        return commentRepository.save(comment);
    }

    public List<Comment> getAllComments(){
        return commentRepository.findAll();
    }

    public Comment updateComment(Comment comment){
        return commentRepository.save(comment);
    }

    public Comment findCommentById(UUID id) throws Throwable {
        return commentRepository.findCommentById(id)
                .orElseThrow(() -> new ElementNotFoundException("Comment was not found !"));
    }

    public void deleteComment(UUID id){
        commentRepository.deleteCommentById(id);
    }
}
