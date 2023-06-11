package com.example.tuniscamp.repositories;

import com.example.tuniscamp.entities.Event;
import com.example.tuniscamp.entities.EventCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event,Integer> {
    List<Event> findAllByCategory(EventCategory category);
}
