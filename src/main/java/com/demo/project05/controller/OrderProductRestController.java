package com.demo.project05.controller;

import com.demo.project05.service.OrderProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/orderProducts/")
public class OrderProductRestController {
    private final OrderProductService orderProductService;

    public OrderProductRestController(OrderProductService orderProductService) {
        this.orderProductService = orderProductService;
    }

    @GetMapping("getProductByOrderId")
    public void getProductByOrderId(@RequestParam Long orderId) {
       orderProductService.getProductByOrderId(orderId);
    }
}
