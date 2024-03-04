package com.demo.project05.service;

import com.demo.project05.entity.Product;
import com.demo.project05.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void saveProduct(Product product) {
        productRepository.saveProduct(product);
    }

    public List<Product> getProductByName(String name) {
        return productRepository.findProductByName(name);
    }
}
