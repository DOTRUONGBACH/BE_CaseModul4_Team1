package com.backend.repo;


import com.backend.model.Product;
import com.backend.model.query.GetImage;
import com.backend.model.query.SortSearchFilter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductRepo extends PagingAndSortingRepository<Product,Long> {
    @Query(nativeQuery = true, value = "select product.id as idProduct, description, product.name as namep, price, category.name as nameCategory, product_status.name as nameStatus, url  from product join image on image.product_id = product.id JOIN category on product.category_id = category.id join product_status  on product_status.id = product_status_id WHERE product.id=:id")
    List<GetImage> getImageById(@Param("id") long id);

    @Query(nativeQuery = true, value ="select product.id as idProduct, product.name as namep, price, product_status.name as nameStatus  from product join product_status  on product_status.id = product_status_id WHERE product.name like concat('%',:name,'%')")
    List<SortSearchFilter> searchAllByName(@Param("name") String search);

    @Query(nativeQuery = true, value ="select product.id as idProduct, product.name as namep, price, product_status.name as nameStatus  from product join product_status  on product_status.id = product_status_id WHERE price <= 10 order by price asc")
    List<SortSearchFilter> sortLowPrice();

    @Query(nativeQuery = true, value ="select product.id as idProduct, product.name as namep, price, product_status.name as nameStatus  from product join product_status  on product_status.id = product_status_id WHERE price < 40 and price > 10 order by price asc")
    List<SortSearchFilter> sortMediumPrice();

    @Query(nativeQuery = true, value ="select product.id as idProduct, product.name as namep, price, product_status.name as nameStatus  from product join product_status  on product_status.id = product_status_id WHERE price >= 40 order by price asc")
    List<SortSearchFilter> sortHighPrice();

    @Query(nativeQuery = true, value ="SELECT product.id as idProduct, product.name as namep, price, product_status.name as nameStatus  from product join product_status  on product_status.id = product_status_id  WHERE product.category_id = 1")
    List<SortSearchFilter> category1();

    @Query(nativeQuery = true, value ="SELECT product.id as idProduct, product.name as namep, price, product_status.name as nameStatus  from product join product_status  on product_status.id = product_status_id  WHERE product.category_id = 2")
    List<SortSearchFilter> category2();
}
