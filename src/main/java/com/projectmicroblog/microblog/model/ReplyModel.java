package com.projectmicroblog.microblog.model;

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
}
