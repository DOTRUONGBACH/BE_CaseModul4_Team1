package com.backend.controller;

import com.backend.model.Image;
import com.backend.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/images")
public class ImageController{

    @Autowired
    ImageService imageService;

    @GetMapping
    public List<Image> getAll(){
        return imageService.getAll();
    }
}
