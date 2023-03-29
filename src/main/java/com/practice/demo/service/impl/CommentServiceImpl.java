package com.practice.demo.service.impl;

import com.practice.demo.entity.Comment;
import com.practice.demo.entity.Post;
import com.practice.demo.exception.ResouceNotFoundException;
import com.practice.demo.payload.CommentDTO;
import com.practice.demo.repository.CommentRepository;
import com.practice.demo.repository.PostRepository;
import com.practice.demo.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private PostRepository postRepository;
    private ModelMapper modelMapper;

    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository, ModelMapper modelMapper){
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CommentDTO getCommentById(long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new ResouceNotFoundException("Comment","id",id));
        return mapToDTO(comment);
    }

    @Override
    public CommentDTO addComment(CommentDTO commentDTO, long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResouceNotFoundException("Post","id",id));
        Comment comment = mapToEntity(commentDTO);
        comment.setPost(post);
        comment = commentRepository.save(comment);
        return mapToDTO(comment);
    }

    public CommentDTO mapToDTO(Comment comment){
        CommentDTO commentDTO = modelMapper.map(comment, CommentDTO.class);
        return commentDTO;
    }

    public Comment mapToEntity(CommentDTO commentDTO){
        Comment comment = modelMapper.map(commentDTO, Comment.class);
        return comment;
    }
}
