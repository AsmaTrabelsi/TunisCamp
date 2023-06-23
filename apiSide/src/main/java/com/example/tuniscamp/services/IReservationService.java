package com.example.tuniscamp.services;
import com.example.tuniscamp.entities.Reservation;

import java.util.List;

public interface IReservationService {
    List<Reservation> getAllReservations();
    Reservation getReservationById (int id);
    void addReservation(Reservation reservation);

    void updateReservation(Reservation reservation);

    void deleteReservation(int id);
}
