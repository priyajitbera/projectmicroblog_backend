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
        User user = userService.findUserById(postModel.getUserId());
        Post post = Post.builder()
                .caption(postModel.getCaption())
                .user(user)
                .build();
        try {
            return postRepository.save(post);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    public Post findPostById(Long postId) {
        try {
            return postRepository.findById(postId).get();
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public Post updatePostById(Long postId, PostModel postModel) {
        Post post = findPostById(postId);
        post.setCaption(postModel.getCaption());
        post.setEdited(true);
        try {
            return postRepository.save(post);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    public void deletePostById(Long postId) {
        try {
            postRepository.deleteById(postId);
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
