package com.projectmicroblog.microblog.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.projectmicroblog.microblog.entity.Reply;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReplyModel {
    private String reply;
    private Long postId;
    private Long userId;

    public static void validateReply(String reply) {
        if (reply == null || reply.length() > Reply.REPLY_CHAR_LIMIT) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

}
