package com.example.tuniscamp.entities.ModelsDto;

import com.example.tuniscamp.entities.*;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;
import javax.persistence.OneToMany;
import java.util.List;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CampPlaceDto {
    private Integer idCampPlace;
    private String name;
    private CampPlaceCategory category;
    private int tel;
    private String email;
    private String address;
    private State state;
    @OneToMany
    private  List<MultipartFile> images;
}
