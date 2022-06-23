package com.projectmicroblog.microblog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Follow {

    @Id
    @SequenceGenerator(name = "follow_sequence", sequenceName = "follow_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "follow_sequence")
    private Long followId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "follower_id", nullable = false)
    private User follower; // who is following

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "followee_id", nullable = false)
    private User followee; // who is beging followed
}
