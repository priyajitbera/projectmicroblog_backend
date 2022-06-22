package com.projectmicroblog.microblog.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectmicroblog.microblog.entity.Post;
import com.projectmicroblog.microblog.entity.User;
import com.projectmicroblog.microblog.model.PostModel;
import com.projectmicroblog.microblog.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserService userService;

    public Post savePost(PostModel postModel) {
        Long userId = postModel.getUserId();
        User user = userService.findById(userId); // TODO: raise exception
        Post post = Post.builder()
                .caption(postModel.getCaption())
                .user(user)
                .build();
        System.out.println(user);
        System.out.println(post);
        return postRepository.save(post);
    }

    public Post findPostById(Long postId) {
        return postRepository.findById(postId).get(); // TODO: raise exception
    }
}
