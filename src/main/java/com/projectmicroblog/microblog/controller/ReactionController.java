package com.projectmicroblog.microblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projectmicroblog.microblog.entity.Reaction;
import com.projectmicroblog.microblog.model.ReactionModel;
import com.projectmicroblog.microblog.service.ReactionService;

@RestController
@RequestMapping("/rest/reaction")
public class ReactionController {

    @Autowired
    ReactionService reactionService;

    @PostMapping("/saveReaction")
    public Reaction saveReaction(@RequestBody ReactionModel reactionModel) {
        return reactionService.saveReaction(reactionModel);
    }

    @GetMapping("/getReactionById")
    public Reaction getReactionById(@RequestParam(name = "reactionId") Long reactionId) {
        return reactionService.findReactionById(reactionId);
    }

    @DeleteMapping("/deleteReactionById")
    public void deleteReactionById(@RequestParam(name = "reactionId") Long reactionId) {
        reactionService.deleteReactionById(reactionId);
    }
}
