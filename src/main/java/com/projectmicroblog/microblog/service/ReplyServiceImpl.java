package com.projectmicroblog.microblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.projectmicroblog.microblog.entity.Post;
import com.projectmicroblog.microblog.entity.Reply;
import com.projectmicroblog.microblog.entity.User;
import com.projectmicroblog.microblog.model.ReplyModel;
import com.projectmicroblog.microblog.repository.ReplyRepository;

@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @Autowired
    private ReplyRepository replyRepository;

    public Reply saveReply(ReplyModel replyModel) {
        // data validity check
        User user = userService.findUserById(replyModel.getUserId());
        Post post = postService.findPostById(replyModel.getPostId());
        Reply reply = Reply.builder()
                .user(user)
                .post(post)
                .reply(replyModel.getReply())
                .build();

        return replyRepository.save(reply);
    }

    public Reply findReplyById(Long replyId) {
        try {
            return replyRepository.findById(replyId).get();
        } catch (Exception exception) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No Reply found with replyId=" + replyId);
        }
    }

    public Reply updateReplyById(Long replyId, ReplyModel replyModel) {
        try {
            Reply reply = replyRepository.findById(replyId).get();
            reply.setReply(replyModel.getReply());
            return replyRepository.save(reply);
        } catch (Exception exection) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No Reply found with replyId=" + replyId);
        }
    }

    public void deleteReplyById(Long replyId) {
        try {
            replyRepository.deleteById(replyId);
        } catch (Exception exception) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "replyId=" + replyId + " is null or not present");
        }
    }
}
