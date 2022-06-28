package com.projectmicroblog.microblog.service;

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
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Follower with followerId="
                            + followModel.getFollowerId()
                            + " already follows Followee with followeeId="
                            + followModel.getFolloweeId());
        }
        User follower = userService.findUserById(followModel.getFollowerId());
        User followee = userService.findUserById(followModel.getFolloweeId());

        Follow follow = Follow.builder()
                .follower(follower)
                .followee(followee)
                .build();

        return followRepository.save(follow);
    }

    public Follow findFollowById(Long followId) {
        try {
            return followRepository.findById(followId).get();
        } catch (Exception exception) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No Follow found for followId=" + followId);
        }
    }

    public boolean isFollows(Long followeeId, Long followerId) {
        return followRepository.findByFolloweeIdAndFollowerId(
                followeeId, followerId).isPresent();
    }
}
