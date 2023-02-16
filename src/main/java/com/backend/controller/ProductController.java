package com.backend.controller;

import com.backend.model.Product;
import com.backend.model.query.GetImage;
import com.backend.model.query.SortSearchFilter;
import com.backend.model.query.TopProduct;
import com.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/show")
    public Page<Product> showAll(){
       return productService.showAll(PageRequest.of(0,8, Sort.by("id")));

    }

    @GetMapping("/sortASC")
    public Page<Product> sortByPriceASC(){
        return productService.showAll(PageRequest.of(0,8, Sort.by("price").ascending()));
    }

    @GetMapping("/sortDESC")
    public Page<Product> sortByPriceDESC(){
        return productService.showAll(PageRequest.of(0,8, Sort.by("price").descending()));
    }

    @GetMapping("/filterCategory1")
    public List<SortSearchFilter> filterCategory1(){
        return productService.FilterCategory1();
    }

    @GetMapping("/filterCategory2")
    public List<SortSearchFilter> filterCategory2(){
        return productService.FilterCategory2();
    }
    @GetMapping("/sortHighPrice")
    public List<SortSearchFilter> sortHighPrice(){
        return productService.sortHighPrice();
    }

    @GetMapping("/sortMediumPrice")
    public List<SortSearchFilter> sortMediumPrice(){
        return productService.sortMediumPrice();
    }

    @GetMapping("/sortLowPrice")
    public List<SortSearchFilter> sortLowPrice(){
        return productService.sortLowPrice();

    }

    @GetMapping("/topProduct")
    public List<TopProduct> topProduct(){
        return productService.topProduct();
    }

    @GetMapping("/image/{id}")
    public List<GetImage> getAllById(@PathVariable long id){
        return productService.getAllByImage(id);
    }

    @GetMapping("/search/{keys}")
    public List<SortSearchFilter> search(@PathVariable String keys){
        return productService.searchProduct(keys);
    }


}
