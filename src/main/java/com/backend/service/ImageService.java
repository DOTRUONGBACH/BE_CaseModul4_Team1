package com.backend.service;

import com.backend.model.Image;
import com.backend.repo.IImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {
    @Autowired
    IImageRepo imageRepo;

    public List<Image> getAll() {
        return (List<Image>) imageRepo.findAll();
    }
public Image save(Image image){
        return imageRepo.save(image);
}
public void delete(long id){
        imageRepo.delete(imageRepo.findImageById(id));
}
}
