package com.backend.service;

import com.backend.model.Product;

import com.backend.model.query.GetImage;
import com.backend.model.query.SortSearchFilter;
import com.backend.model.query.TopProduct;
import com.backend.repo.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {
    @Autowired
    IProductRepo iProductRepo;

    public Page<Product> getAll(Pageable pageable) {
        return iProductRepo.findAll(pageable);
    }

    public List<SortSearchFilter> FilterCategory1() {
        return iProductRepo.category1();
    }

    public List<SortSearchFilter> FilterCategory2() {
        return iProductRepo.category2();
    }
    public List<SortSearchFilter> sortHighPrice() {
        return iProductRepo.sortHighPrice();
    }
    public List<SortSearchFilter> sortMediumPrice() {
        return iProductRepo.sortMediumPrice();
    }
    public List<SortSearchFilter> sortLowPrice() {
        return iProductRepo.sortLowPrice();
    }

    public List<TopProduct> topProduct() {
        return iProductRepo.topProduct();
    }

    public List<SortSearchFilter> searchProduct(String keys) {
        return iProductRepo.searchAllByName(keys);
    }
    public Product findByID(long id) {
        return iProductRepo.findById(id).get();
    }

    public Product save(Product product){
        return iProductRepo.save(product);
    }

    public void delete(long id){
        iProductRepo.deleteById(id);
    }

    public List<GetImage> getAllByImage(long id) {
        return iProductRepo.getImageById(id);
    }


}
