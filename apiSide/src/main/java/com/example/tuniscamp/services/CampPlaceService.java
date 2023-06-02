package com.example.tuniscamp.services;

import com.example.tuniscamp.entities.CampPlace;
import com.example.tuniscamp.repositories.CampPlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CampPlaceService implements ICampPlaceService {
    private final CampPlaceRepository campPlaceRepository;
    @Override
    public List<CampPlace> getAllCampPlaces() {
        return campPlaceRepository.findAll();
    }

    @Override
    public CampPlace getCampPlaceById(int id) {
        return campPlaceRepository.findById(id).orElse(null);
    }

    @Override
    public void addCampPlace(CampPlace campPlace) {
        campPlaceRepository.save(campPlace);

    }

    @Override
    public void updateCampPlace(CampPlace campPlace) {
        campPlaceRepository.save(campPlace);

    }

    @Override
    public void deleteCampPlace(int id) {
        campPlaceRepository.deleteById(id);

    }
}