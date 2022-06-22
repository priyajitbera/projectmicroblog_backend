package com.projectmicroblog.microblog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReactionModel {
    private String type;
    private Long userId;
    private Long postId;
    private Long replyId;
}
