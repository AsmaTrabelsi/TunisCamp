package com.example.tuniscamp.repositories;
import com.example.tuniscamp.entities.Reservation;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ReservationRepository  extends JpaRepository<Reservation,Integer>{
}
