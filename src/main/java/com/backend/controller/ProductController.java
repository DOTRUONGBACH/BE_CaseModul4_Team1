package com.backend.controller;

import com.backend.model.Product;
import com.backend.repo.IProductRepo;
import com.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    private IProductRepo iProductRepo;

    public List<Product> getAll() {
        return productService.getAll();
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        return productService.save(product);
    }

    @GetMapping("/{id}")
    public Product showEdit(@PathVariable long id) {
        return productService.findById(id);
    }

    @PutMapping("/{id}")
    public Product edit(@RequestBody Product product) {
        return productService.save(product);
    }

    @DeleteMapping("/{id}")
    public Product delete(@PathVariable long id) {
        return productService.delete(id);
    }
    @PostMapping("/upImg")
    public String upImg(@RequestParam MultipartFile fileImg) {
        String nameImg = fileImg.getOriginalFilename();
        try {
            FileCopyUtils.copy(fileImg.getBytes(), new File("/Users/johntoan98gmail.com/Desktop/Module 4/FE_C0922h1/img/" + nameImg));
            return "/img/" + nameImg;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
