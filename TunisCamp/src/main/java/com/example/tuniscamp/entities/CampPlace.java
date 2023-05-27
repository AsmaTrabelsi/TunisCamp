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
public class CampPlace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer idCampPlace;
    private String name;
    private CampPlaceCategory category;

    private int tel;
    private String email;
    private String address;
    private State state;
    @OneToMany(mappedBy = "campPlace")
    private List<Event> events;
    @OneToMany(mappedBy = "campPlace")
    private List<Feedback> feedbacks;


}



















