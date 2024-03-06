package com.demo.project05.service;

import com.demo.project05.entity.OrderProduct;
import com.demo.project05.entity.Product;
import com.demo.project05.repository.OrderProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderProductService {
    private final OrderProductRepository orderProductRepository;
    private final OrderService orderService;
    public OrderProductService(OrderProductRepository orderProductRepository, OrderService orderService) {
        this.orderProductRepository = orderProductRepository;
        this.orderService = orderService;
    }

    public void getProductByOrderId(Long orderId) {
        List<OrderProduct> allByOrder = orderProductRepository.findOrderProductsByOrderId(orderId);
        for (OrderProduct orderProduct : allByOrder) {
            Product product = orderProduct.getProduct();
            System.out.println(product.getName());
        }
    }
}
