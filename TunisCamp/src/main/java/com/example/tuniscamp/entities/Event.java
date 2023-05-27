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
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer idEvent;
    private String name;

    private String description;

    private Date startDate ;
    private Date endDate ;
    private  int nbParticipant;

    // bi
    @ManyToOne
    private User user ;

    // bi
    @ManyToOne
    private CampPlace campPlace;

















}
