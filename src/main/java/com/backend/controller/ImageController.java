package com.backend.controller;

import com.backend.model.Image;
import com.backend.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/images")
public class ImageController {
    @Autowired
    ImageService imageService;

    @GetMapping
    public List<Image> getAll(){
        return imageService.getAll();
    }
    @PostMapping
    public Image save(@RequestBody Image image){
        return imageService.save(image);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        imageService.delete(id);
    }

}
