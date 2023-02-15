package com.backend.controller;

import com.backend.model.Product;
import com.backend.model.ProductStatus;
import com.backend.service.ProductService;
import com.backend.service.ProductSttService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/prStt")
public class ProductSttController {
    @Autowired
    ProductSttService productSttService;
    @GetMapping
    public List<ProductStatus> getAll() {
        return productSttService.getAll();
    }

}
