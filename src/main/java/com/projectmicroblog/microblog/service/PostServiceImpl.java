package com.projectmicroblog.microblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
        if (postModel.getCaption().length() > 300) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "caption length exceeds 300 characters");
        }
        Long userId = postModel.getUserId();
        User user = userService.findById(userId);
        Post post = Post.builder()
                .caption(postModel.getCaption())
                .user(user)
                .build();
        return postRepository.save(post);
    }

    public Post findPostById(Long postId) {
        try {
            return postRepository.findById(postId).get();
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No Post found with given postId=" + postId);
        }
    }
}
