package com.projectmicroblog.microblog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projectmicroblog.microblog.entity.Reaction;

@Repository
public interface ReactionRepository extends JpaRepository<Reaction, Long> {

    @Query(value = "SELECT * FROM reaction WHERE post_id=?1 AND user_id=?2", nativeQuery = true)
    public Optional<Reaction> findByPostIdAndUserId(Long postId, Long userId);

    @Query(value = "SELECT * FROM reaction WHERE reply_id=?1 AND user_id=?2", nativeQuery = true)
    public Optional<Reaction> findByReplyIdAndUserId(Long replyId, Long userId);
}
