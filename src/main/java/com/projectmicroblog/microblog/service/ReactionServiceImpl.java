package com.projectmicroblog.microblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectmicroblog.microblog.entity.Post;
import com.projectmicroblog.microblog.entity.Reaction;
import com.projectmicroblog.microblog.entity.Reply;
import com.projectmicroblog.microblog.entity.User;
import com.projectmicroblog.microblog.model.ReactionModel;
import com.projectmicroblog.microblog.repository.ReactionRepository;

@Service
public class ReactionServiceImpl implements ReactionService {

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @Autowired
    private ReplyService replyService;

    @Autowired
    ReactionRepository reactionRepository;

    public Reaction saveReaction(ReactionModel reactionModel) {
        User user = userService.findById(reactionModel.getUserId());
        Reaction savedReaction;
        // for Reaction on Post
        if (reactionModel.getPostId() != null) {
            // check if post already reacted by user, to avoid duplication
            if (isReactedToPost(reactionModel.getPostId(), reactionModel.getUserId()))
                return null; // TODO: raise exception

            Post post = postService.findPostById(reactionModel.getPostId()); // TODO: raise exception
            Reaction reaction = Reaction.builder()
                    .user(user)
                    .post(post) // for Reaction on Post
                    .build();
            savedReaction = reactionRepository.save(reaction);
        }
        // for Reaction on Reply
        else {
            // check if reply arleady reacted by user, to avoid duplication
            if (isReactedToReply(reactionModel.getReplyId(), reactionModel.getUserId()))
                return null; // TODO: raise exception

            Reply reply = replyService.findReplyById(reactionModel.getReplyId()); // TODO: raise exception
            Reaction reaction = Reaction.builder()
                    .user(user)
                    .reply(reply) // for Reaction on Reply
                    .build();
            savedReaction = reactionRepository.save(reaction);
        }
        return savedReaction;
    }

    public Reaction findReactionById(Long reactionId) {
        return reactionRepository.findById(reactionId).get(); // TODO: raise exception
    }

    public boolean isReactedToPost(Long postId, Long userId) {
        return reactionRepository.findByPostIdAndUserId(postId, userId).isPresent();
    }

    public boolean isReactedToReply(Long replyId, Long userId) {
        return reactionRepository.findByReplyIdAndUserId(replyId, userId).isPresent();
    }
}
