package com.example.tuniscamp.controllers;

import com.example.tuniscamp.entities.CampPlace;
import com.example.tuniscamp.services.ICampPlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("campPlace")
public class CampPlaceController {
    private final ICampPlaceService iCampPlaceService ;
    @GetMapping
    public List<CampPlace> getAll(){
        return iCampPlaceService.getAllCampPlaces();
    }

    @GetMapping("/{id}")
    public CampPlace get(@PathVariable int id){
        return iCampPlaceService.getCampPlaceById(id);
    }
    @PostMapping
    public void add(@RequestBody CampPlace campPlace){
        iCampPlaceService.addCampPlace(campPlace);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        iCampPlaceService.deleteCampPlace(id);
    }
    @PutMapping
    public void update(@RequestBody CampPlace campPlace){
        iCampPlaceService.updateCampPlace(campPlace);
    }

}
