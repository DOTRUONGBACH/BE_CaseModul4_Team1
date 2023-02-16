package com.backend.service;

import com.backend.model.Category;
import com.backend.repo.ICategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    ICategoryRepo category;
    public List<Category> getAll(){
        return (List<Category>) category.findAll();
    }
}
