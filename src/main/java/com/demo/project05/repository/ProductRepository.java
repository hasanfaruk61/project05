package com.demo.project05.repository;

import com.demo.project05.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void saveProduct(Product product) {
        Product p1 = new Product();
        p1.setName(product.getName());
        p1.setCategory(product.getCategory());
        p1.setPhotoUrl(product.getPhotoUrl());
        p1.setDescription(product.getDescription());
        p1.setPrice(product.getPrice());

        entityManager.merge(product);

        System.out.println("Isleminiz gerceklestirilmistir");
    }

    public List<Product> findProductByName(String name) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);

        Root<Product> productRoot = cq.from(Product.class);
        cq.select(productRoot).where(cb.equal(productRoot.get("name"), name));

        return entityManager.createQuery(cq).getResultList();
    }
}
