package com.example.tuniscamp.services;

import com.example.tuniscamp.entities.CampPlace;
import com.example.tuniscamp.entities.CampPlaceCategory;
import com.example.tuniscamp.entities.EventCategory;
import com.example.tuniscamp.entities.State;
import com.example.tuniscamp.repositories.CampPlaceRepository;
import com.example.tuniscamp.repositories.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor

public class CampPlaceService implements ICampPlaceService {
    private final CampPlaceRepository campPlaceRepository;
    private final ImageRepository imageRepository;
    @Override
    public List<CampPlace> getAllCampPlaces() {
        return campPlaceRepository.findAll();
    }

    @Override
    public CampPlace getCampPlaceById(int id) {
        return campPlaceRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void addCampPlace(CampPlace campPlace) {
        imageRepository.saveAll(campPlace.getImages());
        campPlaceRepository.saveAndFlush(campPlace);

    }

    @Override
    public void updateCampPlace(CampPlace campPlace) {
        campPlaceRepository.save(campPlace);

    }

    @Override
    public void deleteCampPlace(int id) {
        campPlaceRepository.deleteById(id);

    }


    @Override
    public List<CampPlaceCategory> getCategories() {
        List<CampPlaceCategory> categories = Arrays.asList(CampPlaceCategory.values());
        return categories;
    }
    @Override
    public List<State> getState() {
        List<State> states = Arrays.asList(State.values());
        return states;
    }

}
