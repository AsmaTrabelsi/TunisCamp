package com.example.tuniscamp.services;

import com.example.tuniscamp.entities.*;
import com.example.tuniscamp.entities.ModelsDto.CampPlaceSelectDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICampPlaceService {


    List<CampPlace> getAllCampPlaces();
    CampPlace getCampPlaceById (int id);
    void addCampPlace (CampPlace campPlace);

    void updateCampPlace(CampPlace campPlace);

    void deleteCampPlace(int id);
    List<CampPlaceCategory> getCategories();
    List<State> getState();
    List<CampPlace> getCampPlaceByCategory(CampPlaceCategory category);

    Page<CampPlace> getFiltredCampPlace(List <CampPlaceCategory> category,List <State> state, String search, Pageable pageable);


    //for home screen
    List<CampPlace> findTop5CampPlaces();
    long campPlacesCount();

    List<CampPlaceSelectDto> getCampPlaceSelect();
}
