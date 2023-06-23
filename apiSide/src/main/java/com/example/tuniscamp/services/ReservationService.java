
package com.example.tuniscamp.services;
import org.springframework.stereotype.Service;

import com.example.tuniscamp.entities.Reservation;

import com.example.tuniscamp.repositories.ReservationRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor


public class ReservationService implements IReservationService {
    private final ReservationRepository reservationRepository;
    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation getReservationById(int id) {
        return reservationRepository.findById(id).orElse(null);
    }




    @Override
    public void addReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    @Override
    public void updateReservation(Reservation reservation) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateFeedback'");
    }



    @Override
    public void deleteReservation(int id) {
        reservationRepository.deleteById(id);

    }


}