package com.example.tuniscamp.controllers;

import com.example.tuniscamp.entities.CampPlace;
import com.example.tuniscamp.entities.Event;
import com.example.tuniscamp.entities.Feedback;
import com.example.tuniscamp.entities.ModelsDto.FeedbackDto;
import com.example.tuniscamp.services.FeedbackService;
import com.example.tuniscamp.services.ICampPlaceService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Feedback Management")
@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequiredArgsConstructor
@RequestMapping("feedback")
public class FeedbackController {
    private final FeedbackService feedbackService;
    private final ICampPlaceService iCampPlaceService ;
    private final ModelMapper modelMapper;


    @GetMapping
    public ResponseEntity<List<Feedback>> getAllFeedbacks() {
        List<Feedback> feedbacks = feedbackService.getAllFeedbacks();
        return ResponseEntity.ok(feedbacks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Feedback> getFeedbackById(@PathVariable("id") int id) {
        Feedback feedback = feedbackService.getFeedbackById(id);
        if (feedback != null) {
            return ResponseEntity.ok(feedback);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Feedback addFeedback(@RequestBody FeedbackDto feedbackDto) {
        Feedback feedback = modelMapper.map(feedbackDto, Feedback.class);

        CampPlace campPlace = this.iCampPlaceService.getCampPlaceById(feedbackDto.getIdCampPlace());
        feedback.setCampPlace(campPlace);
        feedbackService.addFeedback(feedback);
        return feedback;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeedback(@PathVariable("id") int id) {
        Feedback feedback = feedbackService.getFeedbackById(id);
        if (feedback != null) {
            feedbackService.deleteFeedback(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
