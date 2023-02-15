package com.backend.controller;

import com.backend.model.Image;
import com.backend.model.Product;
import com.backend.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/images")
public class ImageController {
    @Autowired
    ImageService imageService;

    @PostMapping
    public Image save(@RequestBody Image image) {
        return imageService.save(image);
    }
}
