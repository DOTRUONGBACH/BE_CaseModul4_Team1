package com.backend.service;

import com.backend.model.ProductStatus;
import com.backend.repository.IProductStt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductSttService {
    @Autowired
    IProductStt iProductStt;
    public List<ProductStatus> getAll() {
        return (List<ProductStatus>) iProductStt.findAll();
    }
}
