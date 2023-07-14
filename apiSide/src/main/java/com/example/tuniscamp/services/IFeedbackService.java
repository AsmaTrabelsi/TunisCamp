package com.example.tuniscamp.services;
import com.example.tuniscamp.entities.Feedback;

import java.util.List;

public interface IFeedbackService {
    List<Feedback> getAllFeedbacks();
    Feedback getFeedbackById (int id);
    void addFeedback (Feedback feedback);

    void deleteFeedback(int id);
    
}
