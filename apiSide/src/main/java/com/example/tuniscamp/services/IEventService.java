package com.example.tuniscamp.services;

import com.example.tuniscamp.entities.Event;
import com.example.tuniscamp.entities.EventCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IEventService {

    List<Event>  getAllEvents();
    Page<Event> getFilteredEvents(
            List<EventCategory> categories,
            Double minPrice,
            Double maxPrice,
            Date startDate,
            Date endDate,
            String search,
            Pageable pageable);
    Event getEventById(int id);

    Event addEvent(Event event);

    void updateEvent(Event event);

    void deleteEvent(int id);
    List<EventCategory> getCategories();
    List<Event> getRelevantEvent(EventCategory category);


    List<Event> getEventsByCampPlace(Integer campPlaceId);
}
