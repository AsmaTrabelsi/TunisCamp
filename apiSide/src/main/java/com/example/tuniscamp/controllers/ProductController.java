package com.example.tuniscamp.controllers;

import com.example.tuniscamp.entities.ModelsDto.ProductDto;
import com.example.tuniscamp.entities.Product;
import com.example.tuniscamp.entities.ProductCategory;
import com.example.tuniscamp.entities.ProductFile;
import com.example.tuniscamp.services.IProductService;
import com.example.tuniscamp.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("product")
public class ProductController {

    private final IProductService iProductService;
    private final ModelMapper modelMapper;

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


    @PostMapping("/addProduct")
    public Product addCampPlace(@ModelAttribute ProductDto productDto)  {
        Product product = modelMapper.map(productDto, Product.class);
        List<ProductFile> images = new ArrayList<ProductFile>();
        for(int i = 0; i<productDto.getFiles().size(); i++){
            try {
                images.add(new ProductFile(0, productDto.getFiles().get(i).getBytes()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        product.setFiles(images);
        iProductService.addProduct(product);
        return product;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        iProductService.deleteProduct(id);
    }

    @PutMapping
    public void update(@RequestBody Product product){
        iProductService.UpdateProduct(product);
    }

    @GetMapping("/categories")
    public List<ProductCategory> getCategories(){
        return iProductService.getCategories();
    }
}
