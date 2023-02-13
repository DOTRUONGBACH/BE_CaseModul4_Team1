package com.backend.repo;

import com.backend.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IProductRepo extends PagingAndSortingRepository<Product,Long> {

}
