package com.example.tuniscamp.services;

import com.example.tuniscamp.entities.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProducts();

    Product getProductById(int id);

    void addProduct(Product product);

    void UpdateProduct(Product product);

    void deleteProduct(int id);
}
