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
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer idReservation;
    private Date date;
    @ManyToOne
    private User user;
    @ManyToOne
    private Event event;
}
