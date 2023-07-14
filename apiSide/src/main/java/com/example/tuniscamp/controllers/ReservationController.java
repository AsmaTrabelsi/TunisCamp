package com.example.tuniscamp.controllers;

import com.example.tuniscamp.entities.*;
import com.example.tuniscamp.entities.ModelsDto.ReservationDto;
import com.example.tuniscamp.services.IEventService;
import com.example.tuniscamp.services.IUserService;
import com.example.tuniscamp.services.ReservationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Reservation Management")
@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequiredArgsConstructor
@RequestMapping("reservation")
public class ReservationController {
    private final ReservationService reservationService;

    private final ModelMapper modelMapper;
    private final IUserService iUserService;

    private final IEventService iEventService;
    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservations() {
        List<Reservation> reservations = reservationService.getAllReservations();
        return ResponseEntity.ok(reservations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable("id") int id) {
        Reservation reservation = reservationService.getReservationById(id);
        if (reservation != null) {
            return ResponseEntity.ok(reservation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Reservation addReservation(@RequestBody ReservationDto reservationDto) {
        Reservation reservation = modelMapper.map(reservationDto, Reservation.class);

        Event event = this.iEventService.getEventById(reservationDto.getIdEvent());
        reservation.setEvent(event);

        User user = this.iUserService.findUserByUsername(reservationDto.getUsername());
        reservation.setUser(user);


        reservationService.addReservation(reservation);
        return reservation;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable("id") int id) {
        Reservation reservation = reservationService.getReservationById(id);
        if (reservation != null) {
            reservationService.deleteReservation(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
