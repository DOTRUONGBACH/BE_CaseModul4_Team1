package com.backend.repo;

import com.backend.model.Image;
import org.springframework.data.repository.CrudRepository;


public interface IImageRepo extends CrudRepository<Image,Long> {

}
