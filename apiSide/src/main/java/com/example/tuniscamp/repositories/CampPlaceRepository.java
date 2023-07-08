package com.example.tuniscamp.repositories;

import com.example.tuniscamp.entities.CampPlace;
import com.example.tuniscamp.entities.CampPlaceCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CampPlaceRepository extends JpaRepository<CampPlace,Integer> {
    List<CampPlace> findTop4ByCategory(CampPlaceCategory category);
}
