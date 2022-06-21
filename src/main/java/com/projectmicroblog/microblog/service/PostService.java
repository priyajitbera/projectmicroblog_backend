package com.projectmicroblog.microblog.service;

import com.projectmicroblog.microblog.entity.Post;
import com.projectmicroblog.microblog.model.PostModel;

public interface PostService {
    public Post savePost(PostModel postModel);
    public Post findPostById(Long postId);
}
