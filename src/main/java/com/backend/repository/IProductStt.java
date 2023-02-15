package com.backend.repository;

import com.backend.model.ProductStatus;
import org.springframework.data.repository.CrudRepository;

public interface IProductStt extends CrudRepository<ProductStatus,Long> {
}
