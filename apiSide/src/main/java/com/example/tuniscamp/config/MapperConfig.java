package com.example.tuniscamp.config;

import com.example.tuniscamp.entities.CampPlace;
import com.example.tuniscamp.entities.CampPlaceCategory;
import com.example.tuniscamp.entities.Event;
import com.example.tuniscamp.entities.ModelsDto.CampPlaceDto;
import com.example.tuniscamp.entities.ModelsDto.EventDto;
import com.example.tuniscamp.entities.ModelsDto.RelevantEvent;
import com.example.tuniscamp.entities.State;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.OneToMany;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class MapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.createTypeMap(EventDto.class, Event.class)
                .addMappings(mapper -> {
                    mapper.map(EventDto::getName, Event::setName);
                    mapper.map(EventDto::getDescription, Event::setDescription);
                    mapper.map(EventDto::getStartDate, Event::setStartDate);
                    mapper.map(EventDto::getEndDate, Event::setEndDate);
                    mapper.map(EventDto::getPrice, Event::setPrice);
                    mapper.map(EventDto::getCategory, Event::setCategory);
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

                });

         modelMapper.createTypeMap(CampPlaceDto.class, CampPlace.class)
                .addMappings(mapper -> {
                    mapper.map(CampPlaceDto::getName, CampPlace::setName);
                    mapper.map(CampPlaceDto::getEmail, CampPlace::setEmail);
                    mapper.map(CampPlaceDto::getTel, CampPlace::setTel);
                    mapper.map(CampPlaceDto::getAddress, CampPlace::setAddress);
                    mapper.map(CampPlaceDto::getState, CampPlace::setState);
                    mapper.map(CampPlaceDto::getCategory, CampPlace::setCategory);
                    /*mapper.map(src -> {
                        try {
                            return src.getImages().getBytes();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    },
                     */
                    mapper.map(src -> {
                        List<byte[]> images = new ArrayList<>();
                        List<MultipartFile> imageFiles = src.getImages();
                        if (imageFiles != null) {
                            for (MultipartFile image : imageFiles) {
                                try {
                                    images.add(image.getBytes());
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                        }
                        return images;},
                    CampPlace::setImages);

                });

                   /* mapper.map(src -> {
                        List<byte[]> images = new ArrayList<>();
                        List<MultipartFile> imageFiles = src.getImages();
                        if (imageFiles != null) {
                            for (MultipartFile image : imageFiles) {
                                try {
                                    images.add(image.getBytes());
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                        }
                        return images;
                    }, CampPlace::setImages);
                });*/
        return modelMapper;

    }
}
