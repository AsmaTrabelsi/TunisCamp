package com.example.tuniscamp.repositories;
import com.example.tuniscamp.entities.Feedback;

import com.example.tuniscamp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback,Integer> {
   // boolean existsByIdAndFeedbacks_CreatedBy(Integer campPlaceId, User user);

}
 


