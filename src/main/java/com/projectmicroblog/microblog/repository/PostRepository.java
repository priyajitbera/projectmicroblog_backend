package com.projectmicroblog.microblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectmicroblog.microblog.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
