package com.practice.demo.service.impl;

import com.practice.demo.entity.Comment;
import com.practice.demo.entity.Post;
import com.practice.demo.payload.CommentDTO;
import com.practice.demo.payload.PostDTO;
import com.practice.demo.repository.PostRepository;
import com.practice.demo.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.Banner;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceimpl implements PostService {

    private PostRepository postRepository;
    private ModelMapper modelMapper;

    public PostServiceimpl(PostRepository postRepository, ModelMapper modelMapper){
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<PostDTO> getPosts() {
        List<Post> posts = postRepository.findAll();
        List<PostDTO> postList= posts.stream().map((post) -> mapToDTO(post)).collect(Collectors.toList());
        return postList;
    }

    @Override
    public PostDTO addPost(PostDTO postDTO) {
        Post post = postRepository.save(mapToEntity(postDTO));
        return mapToDTO(post);
    }

    private PostDTO mapToDTO(Post post){
        PostDTO postDTO = new PostDTO();
        postDTO = modelMapper.map(post, PostDTO.class);

        return postDTO;
    }

    private Post mapToEntity(PostDTO postDTO){
        Post post = new Post();
        post = modelMapper.map(postDTO, Post.class);
        return post;
    }
}
