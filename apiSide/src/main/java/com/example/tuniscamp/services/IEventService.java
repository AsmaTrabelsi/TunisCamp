package com.example.tuniscamp.services;

import com.example.tuniscamp.entities.Event;

import java.util.List;

public interface IEventService {

    List<Event>  getAllEvents();

    Event getEventById(int id);

    Event addEvent(Event event);

    void updateEvent(Event event);

    void deleteEvent(int id);
}
