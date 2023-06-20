package com.example.tuniscamp.services;

import com.example.tuniscamp.entities.Product;
import com.example.tuniscamp.entities.ProductCategory;
import com.example.tuniscamp.repositories.EventRepository;
import com.example.tuniscamp.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductService implements IProductService{
    private final ProductRepository productRepository;
    private final EventRepository eventRepository;

    @Override

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<ProductCategory> getCategories() {
        List<ProductCategory> categories = Arrays.asList(ProductCategory.values());
        return categories;
    }

    @Override
    public void addProduct(Product product) {
        productRepository.save(product);

    }

    @Override
    public void UpdateProduct(Product product) {
        productRepository.save(product);

    }

    @Override
    public void deleteProduct(int id) {
        eventRepository.deleteById(id);

    }

}
