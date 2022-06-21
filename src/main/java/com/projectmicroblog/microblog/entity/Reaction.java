package com.projectmicroblog.microblog.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reaction {
    public static enum TYPE {LIKE, CELEBRATE, LOVE};
    @Id
    @SequenceGenerator(
        name = "reaction_sequence",
        sequenceName = "reaction_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "reaction_sequence"
    )
    private Long reactionId;
    private TYPE type = Reaction.TYPE.LIKE; //DEFAULT

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name="reply_id")
    private Reply reply;
}
