package com.projectmicroblog.microblog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectmicroblog.microblog.entity.Reply;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long> {

}
