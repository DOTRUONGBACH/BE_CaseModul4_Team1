package com.backend.service;

import com.backend.model.Product;
import com.backend.repo.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {
    @Autowired
    IProductRepo iProductRepo;

    public Page<Product> getPage(Pageable pageable) {
        return iProductRepo.findAll(pageable);
    }
    public List<Product> getAll() {
        return (List<Product>) iProductRepo.findAll();
    }

    public Product save(Product product) {
        return iProductRepo.save(product);
    }

    public Product delete(long id) {
        Product product = findById(id);
        iProductRepo.deleteById(id);
        return product;
    }

    public Product findById(long id) {
        return iProductRepo.findById(id).get();
    }

}
