package com.backend.repository;

import com.backend.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface ICategory extends CrudRepository<Category,Long> {
}
