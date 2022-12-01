package com.programming.techie.springtutorialblog.validation;

import com.programming.techie.springtutorialblog.model.Post;
import com.programming.techie.springtutorialblog.service.PostService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public record BlogPostTitleValidator(
        PostService postService) implements ConstraintValidator<DuplicateBlogTitle, Post> {

    @Override
    public void initialize(DuplicateBlogTitle constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Post post, ConstraintValidatorContext constraintValidatorContext) {
        if (!post.getTitle().isBlank() && postService.postExistsWithTitle(post.getTitle())) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("{TitleAlreadyExists}")
                    .addPropertyNode("title")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}
