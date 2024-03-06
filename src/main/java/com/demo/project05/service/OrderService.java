package com.demo.project05.service;

import com.demo.project05.entity.Order;
import com.demo.project05.entity.OrderProduct;
import com.demo.project05.entity.Product;
import com.demo.project05.entitydto.CreateOrderRequestDTO;
import com.demo.project05.repository.OrderProductRepository;
import com.demo.project05.repository.OrderRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductService productService;
    private final OrderProductRepository orderProductRepository;

    public OrderService(OrderRepository orderRepository, ProductService productService, OrderProductRepository orderProductRepository) {
        this.orderRepository = orderRepository;
        this.productService = productService;
        this.orderProductRepository = orderProductRepository;
    }

    public ResponseEntity<String> saveOrder(CreateOrderRequestDTO createOrderRequestDTO) {
        long productId = createOrderRequestDTO.getProductId();
        String orderDescription = createOrderRequestDTO.getOrderDescription();

        Order order = new Order();
        order.setOrderDescription(orderDescription);

        orderRepository.save(order);

        Product product = productService.findProductById(productId);

        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setOrder(order);
        orderProduct.setProduct(product);

        orderProductRepository.save(orderProduct);

        return ResponseEntity.ok("Order save isleminiz gerceklestirilmistir!");
    }

    public List<Order> getOrderByOderNumberOrm(String orderNumber) {
        return orderRepository.findOrderByOrderNumber(orderNumber);
    }

    public Order getOrderByOrderId(Long id) {
        return orderRepository.findOrderById(id);
    }
}
