package com.example.tuniscamp.controllers;

import com.example.tuniscamp.entities.Product;
import com.example.tuniscamp.services.IProductService;
import com.example.tuniscamp.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("product")
public class ProductController {

    private final IProductService iProductService;
    @GetMapping
    public List<Product> getAll(){
        return iProductService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product get(@PathVariable int id){
        return iProductService.getProductById(id);
    }

    @PostMapping
    public void add(@RequestBody Product product){
        iProductService.addProduct(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        iProductService.deleteProduct(id);
    }

    @PutMapping
    public void update(@RequestBody Product product){
        iProductService.UpdateProduct(product);
    }
}
