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
    @EmbeddedId
    private ReservationId id;
    @Setter(AccessLevel.NONE)
    private Integer idReservation;
    private Date date;
}
