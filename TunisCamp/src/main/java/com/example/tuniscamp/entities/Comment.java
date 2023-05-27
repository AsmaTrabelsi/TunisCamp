package com.example.tuniscamp.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer idComment;
    private String comment;
    private Date createAt ;
    @ManyToOne
    private User user;
    @ManyToOne
    private Post post;


}
