package com.example.tuniscamp.repositories;

import com.example.tuniscamp.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository <Product, Integer> {
}
