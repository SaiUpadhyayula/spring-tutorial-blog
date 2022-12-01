package com.programming.techie.springtutorialblog.mapper;

import com.programming.techie.springtutorialblog.client.SlugServiceClient;
import com.programming.techie.springtutorialblog.dto.PostDto;
import com.programming.techie.springtutorialblog.model.Post;
import com.programming.techie.springtutorialblog.model.PostDetails;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PostMapper {

    private final SlugServiceClient slugServiceClient;

    public PostMapper(SlugServiceClient slugServiceClient) {
        this.slugServiceClient = slugServiceClient;
    }

    public Post mapPost(PostDto postDto, Post post) {
        post.setTitle(postDto.title());
        PostDetails postDetails = new PostDetails();
        postDetails.setBody(postDto.body());
        postDetails.setPostStatus(postDto.postStatus());
        postDetails.setSlug(slugServiceClient.getSlug(post.getTitle()));
        postDetails.incrementViewCount();
        postDetails.setCreatedAt(LocalDateTime.now());
        post.setPostDetails(postDetails);
        return post;
    }

    public PostDto mapPostDto(Post post) {
        return new PostDto(post.getId(), post.getTitle(),
                post.getPostDetails().getBody(), post.getPostDetails().getSlug(), post.getPostDetails().getPostStatus(),
                post.getPostDetails().getCreatedAt(), post.getPostDetails().getUpdatedAt());
    }
}
