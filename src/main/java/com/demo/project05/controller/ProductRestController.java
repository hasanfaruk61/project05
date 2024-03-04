package com.demo.project05.controller;

import com.demo.project05.entity.Product;
import com.demo.project05.entitydto.ProductRequestDTO;
import com.demo.project05.service.ProductService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> saveProduct(@RequestBody ProductRequestDTO productDTO) {
        String response = productService.saveProduct(productDTO);

        return ResponseEntity.ok(response);
    }

    @GetMapping("products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

}
