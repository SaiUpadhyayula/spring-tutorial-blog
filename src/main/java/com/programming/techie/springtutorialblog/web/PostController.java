package com.programming.techie.springtutorialblog.web;

import com.programming.techie.springtutorialblog.dto.PostDto;
import com.programming.techie.springtutorialblog.service.PostService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blog")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(@RequestBody @Valid PostDto postDto) {
        postService.createPost(postDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PostDto> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{slug}")
    @ResponseStatus(HttpStatus.OK)
    public PostDto getPost(@PathVariable String slug) {
        return postService.getPost(slug);
    }
}
