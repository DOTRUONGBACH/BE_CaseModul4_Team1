package com.backend.repo;

import com.backend.model.Cart;
import org.springframework.data.repository.CrudRepository;

public interface ICartRepo extends CrudRepository<Cart,Long> {
}
