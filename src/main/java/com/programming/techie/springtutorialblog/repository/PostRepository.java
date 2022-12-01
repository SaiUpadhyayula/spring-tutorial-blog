package com.programming.techie.springtutorialblog.repository;

import com.programming.techie.springtutorialblog.model.Post;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Repository
public class PostRepository {
    private static final List<Post> IN_MEMORY_POSTS = new CopyOnWriteArrayList<>();

    public void save(Post post) {
        IN_MEMORY_POSTS.add(post);
    }

    public List<Post> findAll() {
        return IN_MEMORY_POSTS;
    }

    public Optional<Post> findBySlug(String slug) {
        return IN_MEMORY_POSTS.stream()
                .filter(post -> post.getPostDetails().getSlug().equals(slug))
                .findAny();
    }

    public boolean findByTitle(String title) {
        return IN_MEMORY_POSTS.stream().anyMatch(post -> post.getTitle().equals(title));
    }
}
