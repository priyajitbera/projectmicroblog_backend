package com.projectmicroblog.microblog.service;

import com.projectmicroblog.microblog.entity.Reply;
import com.projectmicroblog.microblog.model.ReplyModel;

public interface ReplyService {

    public Reply saveReply(ReplyModel replyModel);

    public Reply findReplyById(Long replyId);

    public Reply updateReplyById(Long replyId, ReplyModel replyModel);

    public void deleteReplyById(Long replyId);
}
