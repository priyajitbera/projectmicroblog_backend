package com.projectmicroblog.microblog.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projectmicroblog.microblog.entity.Follow;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Long> {

    @Query(value = "SELECT * FROM follow WHERE followee_id=?1 AND follower_id=?2", nativeQuery = true)
    public Optional<Follow> findByFolloweeIdAndFollowerId(Long followeeId, Long followerId);

    @Query(value = "SELECT * FROM follow WHERE followee_id=?1", nativeQuery = true)
    public List<Follow> findByFolloweeId(Long followeeId);
}
