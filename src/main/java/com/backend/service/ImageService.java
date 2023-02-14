package com.backend.service;

import com.backend.model.Image;
import com.backend.model.Product;
import com.backend.repo.IImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {
    @Autowired
    IImageRepo iImageRepo;

    public List<Image> getAll() {
        return (List<Image>) iImageRepo.findAll();
    }
}
