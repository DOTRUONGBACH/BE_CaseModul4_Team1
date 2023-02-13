package com.backend.service;

import com.backend.model.Product;
import com.backend.repository.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    IProductRepo iProductRepo;

    public List<Product> getAll() {
        return (List<Product>) iProductRepo.findAll();
    }

    public Product save(Product product) {
        return iProductRepo.save(product);
    }

    public void delete(long id) {
        iProductRepo.deleteById(id);
    }

}
