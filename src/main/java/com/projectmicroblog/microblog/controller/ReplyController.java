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

import com.projectmicroblog.microblog.entity.Reply;
import com.projectmicroblog.microblog.model.ReplyModel;
import com.projectmicroblog.microblog.service.ReplyService;

@RestController
@RequestMapping("/rest/reply")
public class ReplyController {

    @Autowired
    private ReplyService replyService;

    @PostMapping("/saveReply")
    public Reply saveReply(@RequestBody ReplyModel replyModel) {
        return replyService.saveReply(replyModel);
    }

    @GetMapping("/getReplyById")
    public Reply getReply(@RequestParam(name = "replyId") Long replyId) {
        return replyService.findReplyById(replyId);
    }

    @PatchMapping("/updateReplyById")
    public Reply updateReply(
            @RequestParam(name = "replyId") Long replyId,
            @RequestBody ReplyModel replyModel) {
        return replyService.updateReplyById(replyId, replyModel);
    }

    @DeleteMapping("/deleteReplyById")
    public void deleteReply(@RequestParam(name = "replyId") Long replyId) {
        replyService.deleteReplyById(replyId);
    }
}
