package com.example.tuniscamp.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer idPost;
    private String post;
    private Date createAt ;
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

}
