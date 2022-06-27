package com.projectmicroblog.microblog.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.projectmicroblog.microblog.entity.Post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostModel {
    private String caption;
    private Long userId;

    public static void validateCaption(String caption) {
        if (caption == null || caption.length() > Post.CAPTION_CHAR_LIMIT) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
