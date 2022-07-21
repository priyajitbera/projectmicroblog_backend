package com.projectmicroblog.microblog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projectmicroblog.microblog.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query(value = "SELECT * FROM post WHERE user_id=?1", nativeQuery = true)
    public List<Post> findByUserId(Long userId);
}
