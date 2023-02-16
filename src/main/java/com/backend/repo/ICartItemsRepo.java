package com.backend.repo;

import com.backend.model.CartItems;
import com.backend.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICartItemsRepo extends CrudRepository<CartItems,Long> {
    @Query(nativeQuery = true, value = "select * from cart_items join cart where cart_items.cart_id = cart.id and account_id=:id")
    List<CartItems> findAllCartItemsByIdAccount(@Param("id") long id);
    CartItems findCartItemsById(Long id);
    CartItems findCartItemsByProduct(Product product);
    CartItems findCartItemsByProductAndCart_Id(Product product, Long id);
    void deleteAllByCart_Id(Long id);
    void deleteCartItemsByCart_Id(Long id);
}
