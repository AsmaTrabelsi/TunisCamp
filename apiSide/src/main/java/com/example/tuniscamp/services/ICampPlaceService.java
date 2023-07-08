package com.example.tuniscamp.services;

import com.example.tuniscamp.entities.*;

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


}
