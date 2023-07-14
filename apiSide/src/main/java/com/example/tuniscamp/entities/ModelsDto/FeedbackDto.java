package com.example.tuniscamp.entities.ModelsDto;

import com.example.tuniscamp.entities.CampPlace;
import lombok.*;

import javax.persistence.ManyToOne;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackDto {

    private Integer idFeedback;
    private int rating;
    private String comment ;
    private Date createAt ;

    private Integer idCampPlace;
    private String username;
}
