package com.example.tuniscamp.entities.ModelsDto;

import com.example.tuniscamp.entities.Event;
import com.example.tuniscamp.entities.User;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDto {
    private Integer idReservation;
    private Date date;
    private String notes;
    private String username;
    private Integer idEvent;
}
