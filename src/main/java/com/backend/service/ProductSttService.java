package com.backend.service;

import com.backend.model.ProductStatus;
import com.backend.repo.IProductSttRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductSttService {
    @Autowired
    IProductSttRepo iProductStt;
    public List<ProductStatus> getAll() {
        return (List<ProductStatus>) iProductStt.findAll();
    }
}
