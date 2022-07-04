package com.projectmicroblog.microblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projectmicroblog.microblog.entity.Follow;
import com.projectmicroblog.microblog.entity.User;
import com.projectmicroblog.microblog.model.FollowModel;
import com.projectmicroblog.microblog.service.FollowService;

@RestController
@RequestMapping("/rest/follow")
public class FollowController {

    @Autowired
    private FollowService followService;

    @PostMapping("/saveFollow")
    public Follow saveFollow(@RequestBody FollowModel followModel) {
        return followService.saveFollow(followModel);
    }

    @GetMapping("/getFollowById")
    public Follow findById(@RequestParam Long followId) {
        return followService.findFollowById(followId);
    }

    @GetMapping("/isFollows")
    public boolean isFollows(
            @RequestParam(name = "followeeId") Long followeeId,
            @RequestParam(name = "followerId") Long followerId) {
        return followService.isFollows(followeeId, followerId);
    }

    @GetMapping("/getFollowers")
    public List<User> getFollowers(@RequestParam(name = "followeeId") Long followeeId) {
        return followService.findFollowers(followeeId);
    }
}
