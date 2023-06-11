package com.example.tuniscamp.entities.ModelsDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RelevantEvent {
    private Integer idEvent;
    private String name;

    private String campPlaceLocation;
}
