package com.backend.repo;

import com.backend.model.Image;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface IImageRepo extends PagingAndSortingRepository<Image,Long> {
    @Query(nativeQuery = true,value = "SELECT * from image where product_id = :id")
    Image findImageById(@Param("id") Long id);
}
