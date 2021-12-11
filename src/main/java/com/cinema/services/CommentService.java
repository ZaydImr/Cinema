package com.cinema.services;

import com.cinema.repositories.ICommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private ICommentRepository commentRepository;

    public CommentService(ICommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }
}
