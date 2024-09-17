package com.order.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.orderservice.model.OrderModel;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderModel, Long>{

    List<OrderModel> findByUserId(Long userId);

}
