package com.example.tuniscamp.services;

import com.example.tuniscamp.entities.Product;
import com.example.tuniscamp.entities.ProductCategory;
import com.example.tuniscamp.repositories.EventRepository;
import com.example.tuniscamp.repositories.ProductFileRepository;
import com.example.tuniscamp.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductService implements IProductService{
    private final ProductRepository productRepository;
    private final ProductFileRepository productFileRepository;

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
    @Transactional
    public void addProduct(Product product) {
        productFileRepository.saveAll(product.getFiles());
        productRepository.saveAndFlush(product);

    }
    @Override
    public List<Product> getProductByCategory(ProductCategory category){
        return productRepository.findTop4ByCategory(category);
    }
    @Override
    @Transactional
    public void UpdateProduct(Product product) {
        productFileRepository.saveAll(product.getFiles());
        productRepository.saveAndFlush(product);

    }
    @Override
    public Page<Product> getFilteredProducts(
            List<ProductCategory> categories,
            Double minPrice,
            Double maxPrice,
            String search,
            Pageable pageable){
        return productRepository.findByCategoryInAndPriceBetweenWithSearch(
                categories,
                minPrice,
                maxPrice,
                search,
                pageable);
    }
    @Override
    public void deleteProduct(int id) {
        productRepository.deleteById(id);

    }
}

