package com.order.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.orderservice.model.OrderModel;

public interface OrderRepository extends JpaRepository<OrderModel, String> {

}
