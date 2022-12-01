package com.programming.techie.springtutorialblog.dto;

import com.programming.techie.springtutorialblog.model.PostStatus;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record PostDto(String id, @NotBlank String title, @NotBlank String body,
                      String slug, PostStatus postStatus,
                      LocalDateTime createdAt, LocalDateTime updatedAt) {
}
