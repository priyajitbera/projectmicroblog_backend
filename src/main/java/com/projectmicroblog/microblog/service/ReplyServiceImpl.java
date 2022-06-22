package com.projectmicroblog.microblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectmicroblog.microblog.entity.Post;
import com.projectmicroblog.microblog.entity.Reply;
import com.projectmicroblog.microblog.entity.User;
import com.projectmicroblog.microblog.model.ReplyModel;
import com.projectmicroblog.microblog.repository.ReplyRepository;

@Service
public class ReplyServiceImpl implements ReplyService{
    
    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @Autowired
    private ReplyRepository replyRepository;

    public Reply saveReply(ReplyModel replyModel){ //TODO: implement method

        User user = userService.findById(replyModel.getUserId()); //TODO: raise exception
        Post post = postService.findPostById(replyModel.getPostId()); //TODO: raise exception
        
        Reply reply = Reply.builder()
        .user(user)
        .post(post)
        .reply(replyModel.getReply())
        .build();
        
        return replyRepository.save(reply);
    }

    public Reply findReplyById(Long replyId){
        return replyRepository.findById(replyId).get();
    }
}
