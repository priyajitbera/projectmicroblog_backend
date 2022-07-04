package com.projectmicroblog.microblog.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.projectmicroblog.microblog.entity.Follow;
import com.projectmicroblog.microblog.entity.User;
import com.projectmicroblog.microblog.model.FollowModel;
import com.projectmicroblog.microblog.repository.FollowRepository;

@Service
public class FollowServiceImpl implements FollowService {

    @Autowired
    private FollowRepository followRepository;

    @Autowired
    private UserService userService;

    public Follow saveFollow(FollowModel followModel) {
        if (isFollows(followModel.getFolloweeId(), followModel.getFollowerId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        User follower = userService.findUserById(followModel.getFollowerId());
        User followee = userService.findUserById(followModel.getFolloweeId());

        Follow follow = Follow.builder()
                .follower(follower)
                .followee(followee)
                .build();
        try {
            return followRepository.save(follow);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    public Follow findFollowById(Long followId) {
        try {
            return followRepository.findById(followId).get();
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public boolean isFollows(Long followeeId, Long followerId) {
        return followRepository.findByFolloweeIdAndFollowerId(
                followeeId, followerId).isPresent();
    }

    public List<User> findFollowers(Long followeeId) {
        // get the list of Follow entity by followeeId
        List<Follow> followList = followRepository.findByFolloweeId(followeeId);
        // get followers from Follow entity objects
        // store in a list and return
        List<User> followerList = new ArrayList<>();
        for (Follow follow : followList) {
            followerList.add(follow.getFollower());
        }
        return followerList;
    }
}
