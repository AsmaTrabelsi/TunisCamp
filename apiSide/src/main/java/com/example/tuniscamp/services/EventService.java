package com.example.tuniscamp.services;

import com.example.tuniscamp.entities.Event;
import com.example.tuniscamp.entities.EventCategory;
import com.example.tuniscamp.repositories.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventService implements IEventService{
    private final EventRepository eventRepository;

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findTop10ByOrderByStartDateDesc();
    }

    public Page<Event> getFilteredEvents(
            List<EventCategory> categories,
            Double minPrice,
            Double maxPrice,
            Date startDate,
            Date endDate,
            String search,
            Pageable pageable) {
        return eventRepository.findByCategoryInAndPriceBetweenAndStartDateBetweenWithSearch(
                categories,
                minPrice,
                maxPrice,
                startDate,
                endDate,
                search,
                pageable);
    }


    @Override
    public Event getEventById(int id) {
        return eventRepository.findById(id).orElse(null);
    }

    @Override
    public Event addEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public void updateEvent(Event event) {

        eventRepository.save(event);
    }

    @Override
    public void deleteEvent(int id) {
        eventRepository.deleteById(id);
    }

    @Override
    public List<EventCategory> getCategories() {
        List<EventCategory> categories = Arrays.asList(EventCategory.values());
        return categories;
    }

    @Override
    public List<Event> getRelevantEvent(EventCategory category) {
        return eventRepository.findTop4ByCategory(category);
    }

    @Override
    public List<Event> getEventsByCampPlace(Integer campPlaceId){
        return eventRepository.findTop10ByCampPlaceIdCampPlace(campPlaceId);
    }

    @Override
    public long eventCount(){
        return  this.eventRepository.count();
    }

}