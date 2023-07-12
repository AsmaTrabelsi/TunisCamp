package com.example.tuniscamp.repositories;

import com.example.tuniscamp.entities.CampPlace;
import com.example.tuniscamp.entities.CampPlaceCategory;
import com.example.tuniscamp.entities.State;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CampPlaceRepository extends JpaRepository<CampPlace,Integer> {
    List<CampPlace> findTop4ByCategory(CampPlaceCategory category);
    @Query("SELECT c FROM CampPlace c WHERE " +
            "(:search IS NULL OR c.name LIKE %:search% OR c.description LIKE %:search%) AND " +
            "c.category IN :categories AND " +
            "c.state IN :states")
    Page<CampPlace> findByCampPlaceCategoryInAndStateInWithSearch(
            @Param("categories") List<CampPlaceCategory> categories,
            @Param("states") List<State> states,
            @Param("search") String search,
            Pageable pageable);
}
