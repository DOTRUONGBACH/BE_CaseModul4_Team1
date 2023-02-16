package com.backend.repo;

import com.backend.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface ICategoryRepo extends CrudRepository<Category,Long> {
}
