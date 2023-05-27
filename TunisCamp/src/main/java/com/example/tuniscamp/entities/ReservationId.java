package com.example.tuniscamp.entities;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ReservationId implements Serializable {
    private int userId;
    private int eventId;

}
