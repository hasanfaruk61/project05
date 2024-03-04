package com.demo.project05.controller;

import com.demo.project05.entity.Product;
import com.demo.project05.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class ProductRestController {

    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("products")
    public void saveProduct(@RequestBody Product product) {
        productService.saveProduct(product);
    }

    @GetMapping("getProductByName")
    public List<Product> getProductByName(@RequestParam String name){
        return productService.getProductByName(name);
    }
}
