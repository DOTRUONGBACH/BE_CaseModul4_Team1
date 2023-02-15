package com.backend.controller;


import com.backend.model.Product;
import com.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable long id){
        return productService.findProductById(id);
    }

    @PostMapping
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        productService.delete(id);
    }
    @PostMapping("/check/{name}")
    public ResponseEntity<Boolean> checkDuplicateName(@PathVariable String name){
        return new ResponseEntity<>(productService.checkDuplicateName(name), HttpStatus.OK);
    }
    @PostMapping("/upImg")
    public String upImg(@RequestParam MultipartFile fileImg) {
        String nameImg = fileImg.getOriginalFilename();
        try {
            FileCopyUtils.copy(fileImg.getBytes(), new File("C:\\Users\\dell\\Desktop\\Casemd4\\fe\\FE_CaseModul4_Team1\\images\\products\\" + nameImg));
            return "/images/products/" + nameImg;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
