package com.example.tuniscamp.entities;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer idProduct;
    private String name;

    private String description;
    private String state;

    private double price;
    private boolean available;
    @Enumerated(EnumType.STRING)
    private ProductCategory category;
    private  double size;
    private  double weight ;
    private String color;

    @ManyToOne
    private User user;
    // uniDirectionnel
    @OneToMany
    private List<ProductFile> files;

}
