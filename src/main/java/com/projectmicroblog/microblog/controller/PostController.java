package com.projectmicroblog.microblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projectmicroblog.microblog.entity.Post;
import com.projectmicroblog.microblog.model.PostModel;
import com.projectmicroblog.microblog.service.PostService;

@RestController
@RequestMapping("/rest/post")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/savePost")
    public Post savePost(@RequestBody PostModel postModel) {
        return postService.savePost(postModel);
    }

    @GetMapping("/getPostById")
    public Post getPost(@RequestParam(name = "postId") Long postId) {
        return postService.findPostById(postId);
    }

    @PatchMapping("/updatePostById")
    public Post updatePostById(
            @RequestParam(name = "postId") Long postId,
            @RequestBody PostModel postModel) {

        return postService.updatePostById(postId, postModel);
    }

    @DeleteMapping("/deletePostById")
    public void deletePostById(@RequestParam(name = "postId") Long postId) {
        postService.deletePostById(postId);
    }
}
