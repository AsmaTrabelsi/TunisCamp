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

    @Column(length = 1000)
    private String description;

    private Date startDate ;
    private Date endDate ;
    private  int nbParticipant;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] image;
    private double price;

    // bi
    @ManyToOne
    private User user ;

    @Enumerated(EnumType.STRING)
    private EventCategory category;
    // bi
    @ManyToOne
    private CampPlace campPlace;

    @OneToMany(mappedBy = "event")
    private List<Reservation> reservations;
















}
