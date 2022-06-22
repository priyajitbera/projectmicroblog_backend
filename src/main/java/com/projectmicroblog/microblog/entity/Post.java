package com.projectmicroblog.microblog.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {
    
    @Id
    @SequenceGenerator(
        name="post_sequence",
        sequenceName = "post_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "post_sequence"
    )
    private Long postId;
    private String caption;

    @Column(nullable = false)
    @Builder.Default
    private Date creationDate = new Date();

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    // @OneToMany(mappedBy="post")
    // private List<Reply> replies;

    // @OneToMany(mappedBy = "post")
    // private List<Reaction> reactions;
}
