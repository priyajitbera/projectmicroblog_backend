package com.projectmicroblog.microblog.service;

import java.util.List;

import com.projectmicroblog.microblog.entity.Follow;
import com.projectmicroblog.microblog.entity.User;
import com.projectmicroblog.microblog.model.FollowModel;

public interface FollowService {
    public Follow saveFollow(FollowModel followModel);

    public Follow findFollowById(Long followId);

    public boolean isFollows(Long followeeId, Long followerId);

    public List<User> findFollowers(Long foloweeId);
}
