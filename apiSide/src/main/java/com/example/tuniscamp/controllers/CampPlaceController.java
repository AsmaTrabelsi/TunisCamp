package com.example.tuniscamp.controllers;

import com.example.tuniscamp.entities.*;
import com.example.tuniscamp.entities.ModelsDto.CampPlaceDto;
import com.example.tuniscamp.entities.ModelsDto.EventDto;
import com.example.tuniscamp.services.ICampPlaceService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("campPlace")
@CrossOrigin(origins = "http://localhost:4200/")
public class CampPlaceController {
    private final ModelMapper modelMapper;
    private final ICampPlaceService iCampPlaceService ;
    @GetMapping
    public List<CampPlace> getAll(){
        return iCampPlaceService.getAllCampPlaces();
    }

    @GetMapping("/{id}")
    public CampPlace get(@PathVariable int id){
        return iCampPlaceService.getCampPlaceById(id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        iCampPlaceService.deleteCampPlace(id);
    }
    @PutMapping
    public void update(@RequestBody CampPlace campPlace){
        iCampPlaceService.updateCampPlace(campPlace);
    }
    @PostMapping
    public CampPlace addCampPlace(@ModelAttribute CampPlaceDto campPlaceDto)  {
        CampPlace campPlace = modelMapper.map(campPlaceDto, CampPlace.class);
        List<Image> images = new ArrayList<Image>();
        for(int i = 0; i<campPlaceDto.getImages().size(); i++){

            try {
                images.add(new Image(0, campPlaceDto.getImages().get(i).getBytes()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        campPlace.setImages(images);
        iCampPlaceService.addCampPlace(campPlace);
        return campPlace;
    }
    @GetMapping("/categories")
    public List<CampPlaceCategory> getCategories(){
        return  iCampPlaceService.getCategories();
    }
    @GetMapping("/state")
        public List<State> getState(){
        return  iCampPlaceService.getState();
    }
}
