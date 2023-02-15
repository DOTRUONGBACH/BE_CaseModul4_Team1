package com.backend.repository;

import com.backend.model.Image;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IImageRepo extends PagingAndSortingRepository<Image,Long> {
}
