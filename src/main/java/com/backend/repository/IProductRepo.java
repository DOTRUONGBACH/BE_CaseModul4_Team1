package com.backend.repository;

import com.backend.model.Product;
import org.springframework.data.repository.CrudRepository;


public interface IProductRepo extends CrudRepository<Product, Long> {
}
