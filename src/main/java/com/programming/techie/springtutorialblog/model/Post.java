package com.programming.techie.springtutorialblog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private String id;
    private String title;
    private PostDetails postDetails;
}
