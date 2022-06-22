package com.projectmicroblog.microblog.service;

import com.projectmicroblog.microblog.entity.Reaction;
import com.projectmicroblog.microblog.model.ReactionModel;

public interface ReactionService {

    public Reaction saveReaction(ReactionModel reactionModel);

    public Reaction findReactionById(Long reactionId);

    public boolean isReactedToPost(Long postId, Long userId);

    public boolean isReactedToReply(Long replyId, Long UserId);
}
