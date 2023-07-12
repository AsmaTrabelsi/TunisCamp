package com.example.tuniscamp.controllers;

import com.example.tuniscamp.entities.ModelsDto.ProductDto;
import com.example.tuniscamp.entities.Product;
import com.example.tuniscamp.entities.ProductCategory;
import com.example.tuniscamp.entities.ProductFile;
import com.example.tuniscamp.services.IProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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

    @PostMapping("/addProduct")
    public Product addProduct(@ModelAttribute ProductDto productDto)  {
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
    @GetMapping("/categories")
    public List<ProductCategory> getCategories(){
        return iProductService.getCategories();
    }

    @GetMapping("/getSimilaireProduct/{category}")
    public List<Product> getProductByCategory(@PathVariable
                                                  ProductCategory category){
        return iProductService.getProductByCategory(category);
    }
    @GetMapping("/filteredProducts")
    public Page<Product> getFilteredProducts(
            @RequestParam(required = false) List<ProductCategory> categories,
            @RequestParam(required = false, defaultValue = "0.0") Double minPrice,
            @RequestParam(required = false, defaultValue = "100000.0") Double maxPrice,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "6") int size,
            @RequestParam(required = false,defaultValue = "id,asc") String sort,
            @RequestParam(required = false,defaultValue = "") String search

    ) {
        if (categories == null) {
            categories = Arrays.asList(ProductCategory.values());
        }

        Pageable pageable = PageRequest.of(page, size, getSort(sort));

        return iProductService.getFilteredProducts(
                categories,
                minPrice,
                maxPrice,
                search,
                pageable
        );
    }

    private Sort getSort(String sort) {
        String[] sortParams = sort.split(",");
        String property = sortParams[0];
        String direction = sortParams[1];
        return Sort.by(Sort.Direction.fromString(direction), property);
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
