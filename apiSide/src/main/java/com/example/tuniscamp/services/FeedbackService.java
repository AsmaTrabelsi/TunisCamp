package com.example.tuniscamp.services;

import org.springframework.stereotype.Service;

import com.example.tuniscamp.entities.Feedback;

import com.example.tuniscamp.repositories.FeedbackRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor


public class FeedbackService implements IFeedbackService {
    private final FeedbackRepository  feedbackRepository;
    @Override
    public List<Feedback> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }
    
    @Override
    public Feedback getFeedbackById(int id) {
        return feedbackRepository.findById(id).orElse(null);
    }
    

    

    @Override
    public void addFeedback(Feedback feedback) {
       feedbackRepository.save(feedback);
    }
    
    @Override
    public void updateFeedback(Feedback feedback) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateFeedback'");
    }
    

    
    @Override
    public void deleteFeedback(int id) {
        feedbackRepository.deleteById(id);
    
    }
    

}