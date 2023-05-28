package com.example.tuniscamp.services;

import com.example.tuniscamp.entities.Event;
import com.example.tuniscamp.repositories.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService implements IEventService{
    private final EventRepository eventRepository;

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event getEventById(int id) {
        return eventRepository.findById(id).orElse(null);
    }

    @Override
    public void addEvent(Event event) {
        eventRepository.save(event);
    }

    @Override
    public void updateEvent(Event event) {

        eventRepository.save(event);
    }

    @Override
    public void deleteEvent(int id) {
        eventRepository.deleteById(id);
    }
}
