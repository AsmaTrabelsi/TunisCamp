package com.example.tuniscamp.config;

import com.example.tuniscamp.entities.*;
import com.example.tuniscamp.entities.ModelsDto.*;
import com.example.tuniscamp.entities.Product;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;


@Configuration
public class MapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.createTypeMap(EventDto.class, Event.class)
                .addMappings(mapper -> {
                    mapper.map(EventDto::getIdEvent, Event::setIdEvent);
                    mapper.map(EventDto::getName, Event::setName);
                    mapper.map(EventDto::getDescription, Event::setDescription);
                    mapper.map(EventDto::getStartDate, Event::setStartDate);
                    mapper.map(EventDto::getEndDate, Event::setEndDate);
                    mapper.map(EventDto::getPrice, Event::setPrice);
                    mapper.map(EventDto::getCategory, Event::setCategory);
                    mapper.map(EventDto::getVideoUrl, Event::setVideoUrl);
                    mapper.map(EventDto::getNbParticipant, Event::setNbParticipant);

                    mapper.map(src -> {
                        try {
                            return src.getImage().getBytes();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }, Event::setImage);
                });

        modelMapper.createTypeMap(Event.class,RelevantEvent.class)
                .addMappings(mapper ->{
                    mapper.map(Event::getIdEvent, RelevantEvent::setIdEvent);
                    mapper.map(Event::getName, RelevantEvent::setName);
                    mapper.map(src->src.getCampPlace().getAddress(), RelevantEvent::setCampPlaceLocation);
                    mapper.map(Event::getImage, RelevantEvent::setImage);


                });

    modelMapper.createTypeMap(CampPlaceDto.class, CampPlace.class).addMappings(
            mapper -> {
                mapper.map(CampPlaceDto::getName, CampPlace::setName);
                mapper.map(CampPlaceDto::getEmail, CampPlace::setEmail);
                mapper.map(CampPlaceDto::getTel, CampPlace::setTel);
                mapper.map(CampPlaceDto::getAddress, CampPlace::setAddress);
                mapper.map(CampPlaceDto::getState, CampPlace::setState);
                mapper.map(CampPlaceDto::getCategory, CampPlace::setCategory);
                mapper.map(CampPlaceDto::getDescription, CampPlace::setDescription);
                mapper.map(CampPlaceDto::getLongitude, CampPlace::setLongitude);
                mapper.map(CampPlaceDto::getLatitude, CampPlace::setLatitude);
            });


        //product auto mapper  (ProductDto => Product
        modelMapper.createTypeMap(ProductDto.class, Product.class)
                .addMappings(mapper -> {
                    mapper.map(ProductDto::getName, Product::setName);
                    mapper.map(ProductDto::getDescription, Product::setDescription);
                    mapper.map(ProductDto::getPrice, Product::setPrice);
                    mapper.map(ProductDto::getCategory, Product::setCategory);
                    mapper.map(ProductDto::getColor, Product::setColor);
                    mapper.map(ProductDto::getWeight, Product::setWeight);
                    mapper.map(ProductDto::getState, Product::setState);
                });


            modelMapper.createTypeMap(FeedbackDto.class,Feedback.class)
                .addMappings(mapper ->{
                    mapper.map(FeedbackDto::getRating, Feedback::setRating);
                    mapper.map(FeedbackDto::getComment, Feedback::setComment);
                    mapper.map(FeedbackDto::getCreateAt, Feedback::setCreateAt);
                });

        return modelMapper;
    }



    }

