package com.demo.project05.controller;

import com.demo.project05.entity.Order;
import com.demo.project05.entitydto.CreateOrderRequestDTO;
import com.demo.project05.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/orders/")
public class OrderRestController {
    private final OrderService orderService;

    public OrderRestController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("save")
    public ResponseEntity<String> createOrder(@RequestBody CreateOrderRequestDTO createOrderRequestDTO) {
        return orderService.saveOrder(createOrderRequestDTO);
    }

    @GetMapping("orderByOderNumberOrm")
    public List<Order> getOrderByOderNumberOrm(@RequestParam String orderNumber) {
        return orderService.getOrderByOderNumberOrm(orderNumber);
    }

    @GetMapping
    public void getOrderByOrderId(@RequestParam Long id) {
        orderService.getOrderByOrderId(id);
    }
}
