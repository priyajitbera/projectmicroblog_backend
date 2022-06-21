package com.projectmicroblog.microblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projectmicroblog.microblog.entity.Post;
import com.projectmicroblog.microblog.model.PostModel;
import com.projectmicroblog.microblog.service.PostService;

@RestController
@RequestMapping("/post")
public class PostController {
    
    @Autowired
    private PostService postService;

    @RequestMapping("/savePost")
    public Post savePost( @RequestBody PostModel postModel){
        return postService.savePost(postModel);
    }

    @RequestMapping("/getPostByid")
    public Post getPost( @RequestParam(name = "postId") Long postId){
        return postService.findPostById(postId);
    }
}
