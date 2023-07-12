package com.example.tuniscamp.controllers;

import com.example.tuniscamp.entities.CampPlace;
import com.example.tuniscamp.entities.Event;
import com.example.tuniscamp.entities.EventCategory;
import com.example.tuniscamp.entities.ModelsDto.EventDto;
import com.example.tuniscamp.entities.ModelsDto.RelevantEvent;
import com.example.tuniscamp.services.ICampPlaceService;
import com.example.tuniscamp.services.IEventService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;

import java.util.*;

@Tag(name = "Event Management")
@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequiredArgsConstructor
@RequestMapping("event")
public class EventController {

    private final IEventService iEventService;
    private final ICampPlaceService iCampPlaceService ;
    private final ModelMapper modelMapper;

    @GetMapping
    public List<Event> getAll() {
        List<Event> events = iEventService.getAllEvents();
        return events;
    }

    @GetMapping("/categories")
    public List<EventCategory> getCategories() {
        return iEventService.getCategories();
    }

    @GetMapping("/{id}")
    public Event get(@PathVariable int id) {
        Event event = iEventService.getEventById(id);
        return event;
    }

    @PostMapping
    public Event addEvent(@ModelAttribute EventDto eventDto) {
        Event event = modelMapper.map(eventDto, Event.class);

        CampPlace campPlace = this.iCampPlaceService.getCampPlaceById(eventDto.getIdCampPlace());
        event.setCampPlace(campPlace);
        return iEventService.addEvent(event);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        iEventService.deleteEvent(id);
    }

    @PutMapping
    public void update(@RequestBody Event event) {
        iEventService.updateEvent(event);
    }

    @GetMapping("relevantEvent/{category}")
    public List<RelevantEvent> getRelevantEvent(@PathVariable  EventCategory category) {
        List<RelevantEvent> relevantEvents = new ArrayList<RelevantEvent>();
        for (Event event : iEventService.getRelevantEvent(category)) {
            RelevantEvent relevantEvent = modelMapper.map(event, RelevantEvent.class);
            relevantEvents.add(relevantEvent);
        }
        return relevantEvents;
    }



    @GetMapping("/filteredEvents")
    public Page<Event> getFilteredEvents(
            @RequestParam(required = false) List<EventCategory> categories,
            @RequestParam(required = false, defaultValue = "0.0") Double minPrice,
            @RequestParam(required = false, defaultValue = "100000.0") Double maxPrice,
            @RequestParam(required = false, defaultValue = "2020-01-01") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam(required = false, defaultValue = "2050-12-12") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "6") int size,
            @RequestParam(required = false,defaultValue = "id,asc") String sort,
            @RequestParam(required = false,defaultValue = "") String search

    ) {
        if (categories == null) {
            categories = Arrays.asList(EventCategory.values());
        }

        Pageable pageable = PageRequest.of(page, size, getSort(sort));

        return iEventService.getFilteredEvents(
                categories,
                minPrice,
                maxPrice,
                startDate,
                endDate,
                search,
                pageable
        );
    }

    @GetMapping("eventByCampPlace")
    public List<Event> getEventsByCampPlace(Integer campPlaceId){
        return iEventService.getEventsByCampPlace(campPlaceId);
    }
    private Sort getSort(String sort) {
        String[] sortParams = sort.split(",");
        String property = sortParams[0];
        String direction = sortParams[1];
        return Sort.by(Sort.Direction.fromString(direction), property);
    }
    @GetMapping("eventCount")
    public long getEventsCount(){
        return this.iEventService.eventCount();
    }


}