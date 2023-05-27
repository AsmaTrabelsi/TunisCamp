package com.example.tuniscamp.entities;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer idUser;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int tel;
    private String address;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private State government;
    private String taxNum;

    // bi
    @ManyToOne
    private Role role;

    // bidirectionnel
    @OneToMany(mappedBy = "user")
    private List<Product> products;

    // bi
    @OneToMany(mappedBy = "user")
    private List<Event> events;

    // bi
    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    //bi
    @OneToMany(mappedBy = "user")
    private List<Comment> comments;
    //uni
    @OneToMany
    private List<Feedback> feedbacks;

    @OneToMany(mappedBy = "user")
    private List<Reservation> reservations;






}
