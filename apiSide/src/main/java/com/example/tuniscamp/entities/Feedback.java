package com.example.tuniscamp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer idFeedback;
    private int rating;
    private String comment ;
    private Date createAt ;
    @ManyToOne
    private CampPlace campPlace;

    @OneToOne
    private User user;


}