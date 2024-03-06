package com.demo.project05.repository;

import com.demo.project05.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
    List<Order> findOrderByOrderNumber(String orderNumber);

    Order findOrderById(Long id);
}
