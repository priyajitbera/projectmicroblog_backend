package com.projectmicroblog.microblog.service;

import java.util.List;

import com.projectmicroblog.microblog.entity.Post;
import com.projectmicroblog.microblog.model.PostModel;

public interface PostService {
    public Post savePost(PostModel postModel);

    public Post findPostById(Long postId);

    public Post updatePostById(Long postId, PostModel postModel);

    public void deletePostById(Long postId);

    public List<Post> getPostsByUserId(Long userId);
}
