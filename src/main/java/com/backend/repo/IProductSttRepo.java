package com.backend.repo;

import com.backend.model.ProductStatus;
import org.springframework.data.repository.CrudRepository;

public interface IProductSttRepo extends CrudRepository<ProductStatus,Long> {
}
