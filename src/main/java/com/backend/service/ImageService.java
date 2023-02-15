package com.backend.service;

import com.backend.model.Image;
import com.backend.repository.IImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class ImageService {
    @Autowired
    IImageRepo imageRepo;

    public Image save(Image image){
        return imageRepo.save(image);
    }

}
