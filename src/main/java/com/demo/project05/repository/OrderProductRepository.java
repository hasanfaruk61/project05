package com.demo.project05.repository;

import com.demo.project05.entity.Order;
import com.demo.project05.entity.OrderProduct;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderProductRepository extends CrudRepository<OrderProduct, Long> {

    void findProductByOrderId(Long orderId);

    List<OrderProduct> findAllByOrder(Order order);

    @Query("SELECT po FROM OrderProduct po WHERE po.order.id = :orderId")
    List<OrderProduct> findOrderProductsByOrderId(Long orderId);
}
