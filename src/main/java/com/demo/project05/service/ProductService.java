package com.demo.project05.service;

import com.demo.project05.entity.Product;
import com.demo.project05.entitydto.CreateProductRequestDTO;
import com.demo.project05.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ResponseEntity<String> saveProduct(CreateProductRequestDTO createProductRequestDTO) {
        Product product = new Product();
        product.setName(createProductRequestDTO.getName());
        product.setCategory(createProductRequestDTO.getCategory());
        product.setPhotoUrl(createProductRequestDTO.getPhotoUrl());
        product.setDescription(createProductRequestDTO.getDescription());
        product.setPrice(createProductRequestDTO.getPrice());

        productRepository.save(product);

        return ResponseEntity.ok("Product save işleminiz Gerceklestirilmistir.");
    }

    public List<Product> getProductByName(String name) {
        return productRepository.findProductByName(name);
    }

    public Product findProductById(Long id) {
        return productRepository.findById(id).get();
    }
}
