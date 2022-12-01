package com.programming.techie.springtutorialblog.service;

import com.programming.techie.springtutorialblog.exception.PostNotFoundException;
import com.programming.techie.springtutorialblog.repository.PostRepository;
import com.programming.techie.springtutorialblog.dto.PostDto;
import com.programming.techie.springtutorialblog.mapper.PostMapper;
import com.programming.techie.springtutorialblog.model.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostMapper postMapper;
    private final PostRepository postRepository;

    public PostService(PostMapper postMapper, PostRepository postRepository) {
        this.postMapper = postMapper;
        this.postRepository = postRepository;
    }

    public void createPost(PostDto postDto) {
        Post post = new Post();
        post = postMapper.mapPost(postDto, post);
        postRepository.save(post);
    }

    public List<PostDto> getAllPosts() {
        return postRepository.findAll().stream()
                .map(postMapper::mapPostDto)
                .toList();
    }

    public PostDto getPost(String slug) {
        Post post = getPostBySlug(slug);
        return postMapper.mapPostDto(post);
    }

    private Post getPostBySlug(String slug) {
        return postRepository.findBySlug(slug)
                .orElseThrow(() -> new PostNotFoundException("Cannot find post by slug - " + slug));
    }

    public boolean postExistsWithTitle(String title) {
        return postRepository.findByTitle(title);
    }
}
