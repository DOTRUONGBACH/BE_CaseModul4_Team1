package com.backend.repo;


import com.backend.model.Product;
import com.backend.model.query.GetImage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductRepo extends PagingAndSortingRepository<Product,Long> {
    @Query(nativeQuery = true, value = "select product.id as idProduct, description, name, price, category_id as idCategory, product_status_id as idStatus, url  from product join image on image.product_id = product.id WHERE product.id=:id")
    List<GetImage> getImageById(@Param("id") long id);
}
