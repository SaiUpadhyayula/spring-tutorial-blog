package com.programming.techie.springtutorialblog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDetails {
    private PostStatus postStatus;
    private String body;
    private String slug;
    private Integer viewCount = 0;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public void incrementViewCount() {
        viewCount++;
    }
}
