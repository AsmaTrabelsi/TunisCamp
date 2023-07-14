package com.example.tuniscamp.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long id;
    private String userId;
    private String firstName;
    private String lastName;
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String email;
    private String profileImageUrl;
    private int tel;
    private String address;
    private Date lastLoginDate;
    private Date lastLoginDateDisplay;
    private Date joinDate;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private State government;
    private String taxNum;
    //private String[] roles; //ROLE_USER ROLE_ADMIN
    private String role;
    private String[] authorities; //CRUD
    private boolean isActive;
    private boolean isNotLocked;

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
   // @OneToMany
    //private List<Feedback> feedbacks;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Reservation> reservations;


}
