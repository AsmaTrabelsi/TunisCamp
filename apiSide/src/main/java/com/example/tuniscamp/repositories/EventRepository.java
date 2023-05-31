package com.example.tuniscamp.repositories;

import com.example.tuniscamp.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Integer> {
}
