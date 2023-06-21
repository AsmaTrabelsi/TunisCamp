package com.example.tuniscamp.controllers;

import com.example.tuniscamp.entities.Event;
import com.example.tuniscamp.entities.EventCategory;
import com.example.tuniscamp.entities.ModelsDto.EventDto;
import com.example.tuniscamp.entities.ModelsDto.RelevantEvent;
import com.example.tuniscamp.services.IEventService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Tag(name = "Event Management")
@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequiredArgsConstructor
@RequestMapping("event")
public class EventController {

    private final IEventService iEventService;
    private final ModelMapper modelMapper;

    @GetMapping
    public List<Event> getAll(){
        List<Event> events = iEventService.getAllEvents();
        return events;
    }

    @GetMapping("/categories")
    public List<EventCategory> getCategories(){
        return  iEventService.getCategories();
    }
    @GetMapping("/{id}")
    public Event get(@PathVariable int id){
        Event event = iEventService.getEventById(id);
        return event;
    }
    @PostMapping
    public Event addEvent(@ModelAttribute EventDto eventDto){
        Event event = modelMapper.map(eventDto, Event.class);
        return iEventService.addEvent(event);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        iEventService.deleteEvent(id);
    }
    @PutMapping
    public void update(@RequestBody Event event){
        iEventService.updateEvent(event);
    }

    @GetMapping("relevantEvent")
    public List<RelevantEvent> getRelevantEvent(EventCategory category){
        List<RelevantEvent> relevantEvents = new ArrayList<RelevantEvent>() ;
        for (Event event: iEventService.getRelevantEvent(category)) {
            RelevantEvent relevantEvent = modelMapper.map(event, RelevantEvent.class);
            relevantEvents.add(relevantEvent);
        }
        return  relevantEvents;
    }

}