package com.example.tuniscamp.controllers;

import com.example.tuniscamp.entities.Event;
import com.example.tuniscamp.services.IEventService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Event Management")
@RestController
@RequiredArgsConstructor
@RequestMapping("event")
public class EventController {

    private final IEventService iEventService;
    @GetMapping
    public List<Event> getAll(){
        return iEventService.getAllEvents();
    }

    @GetMapping("/{id}")
    public Event get(@PathVariable int id){
        return iEventService.getEventById(id);
    }
    @PostMapping
    public void add(@RequestBody Event event){
        iEventService.addEvent(event);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        iEventService.deleteEvent(id);
    }
    @PutMapping
    public void update(@RequestBody Event event){
        iEventService.updateEvent(event);
    }


}