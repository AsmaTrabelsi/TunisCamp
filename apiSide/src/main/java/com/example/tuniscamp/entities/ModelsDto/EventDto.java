package com.example.tuniscamp.entities.ModelsDto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Date;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EventDto {

    private Integer idEvent;
    private String name;

    private String description;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate ;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate ;
    private  int nbParticipant;

    private MultipartFile image;
    private double price;

}
