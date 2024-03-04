package com.demo.project05.service;

import com.demo.project05.entity.Product;
import com.demo.project05.entitydto.ProductRequestDTO;
import com.demo.project05.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public String saveProduct(ProductRequestDTO productRequestDTO) {
        Optional<Product> existingProduct = productRepository.findByName(productRequestDTO.getName());
        if (existingProduct.isPresent()) {
            return "Bu ürün zaten kaydedilmiştir";
        }

        Product newProduct = new Product();
        newProduct.setName(productRequestDTO.getName());
        newProduct.setCategory(productRequestDTO.getCategory());
        newProduct.setPhotoUrl(productRequestDTO.getPhotoUrl());
        newProduct.setDescription(productRequestDTO.getDescription());
        newProduct.setPrice(productRequestDTO.getPrice());

        productRepository.save(newProduct);

        return "İşleminiz gerçekleştirildi";
    }

    public List<Product> getAllProducts() {
       return   productRepository.findAll();
    }
}
