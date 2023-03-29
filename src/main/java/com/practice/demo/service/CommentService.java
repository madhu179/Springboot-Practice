package com.practice.demo.service;

import com.practice.demo.payload.CommentDTO;

public interface CommentService {

    CommentDTO getCommentById(long id);

    CommentDTO addComment(CommentDTO commentDTO, long id);
}
