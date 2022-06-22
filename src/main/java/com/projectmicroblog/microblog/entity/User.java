package com.projectmicroblog.microblog.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.projectmicroblog.microblog.model.UserModel;

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
public class User {
    public static enum TYPE{INDIVIDUAL, ORGANIZATION};
    @Id
    @SequenceGenerator(
        name="user_sequence",
        sequenceName = "user_sequence",
        allocationSize = 1)
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "user_sequence"
    )
    private Long userId;

    @Column(nullable = false, unique = true)
    private String userName;

    @Column(nullable = false)
    private String firstName;
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Builder.Default
    private Boolean verified=false;

    @Builder.Default
    private TYPE type = TYPE.INDIVIDUAL; //DEFAULT

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    // @OneToMany(mappedBy = "user")
    // private List<Reply> replies;

    // @OneToMany(mappedBy = "user")
    // private List<Reaction> reactions;

}
