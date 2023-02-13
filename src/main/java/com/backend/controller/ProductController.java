package com.backend.controller;

import com.backend.model.Product;
import com.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    public Page<Product> getAll(){
       return productService.getAll(PageRequest.of(0,3, Sort.by("id")));
    }

    @GetMapping ("/{id}")
    public Product findById(@PathVariable long id){
        return productService.findByID(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        productService.delete(id);
    }

    @PostMapping
    public Product save(@RequestBody Product product){
        return productService.save(product);
    }

    @PutMapping("/{id}")
    public Product edit(@RequestBody Product product){
        return productService.save(product);
    }

}
