package com.demo.project05.controller;

import com.demo.project05.entity.Product;
import com.demo.project05.entitydto.CreateProductRequestDTO;
import com.demo.project05.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products/")
public class ProductRestController {
    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("save")
    public ResponseEntity<String> saveProduct(@RequestBody CreateProductRequestDTO createProductRequestDTO) {
        return productService.saveProduct(createProductRequestDTO);
    }

    @GetMapping("productByName")
    public List<Product> getProductByName(@RequestParam String name){
        return productService.getProductByName(name);
    }

}
