package com.backend.repository;
import com.backend.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface IProductRepository extends PagingAndSortingRepository<Product,Long> {
    @Query("SELECT p FROM Product p WHERE p.id = :id")
    Product findProductById(@Param("id") Long id);
    @Query("SELECT p FROM Product p WHERE p.name = :name")
    Product findProductByName(@Param("name") String name);
}
