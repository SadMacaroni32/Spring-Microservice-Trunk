package com.order.orderservice.service;

import org.springframework.stereotype.Service;

import com.order.orderservice.model.OrderModel;
import com.order.orderservice.repository.OrderRepository;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderModel> getAllOrders() {
        return orderRepository.findAll();
    }

    public List<OrderModel> getOrdersByUserId(Long userId) {
        return orderRepository.findByUserId(userId);
    }

    public OrderModel createOrder(OrderModel orderModel) {
        return orderRepository.save(orderModel);
    }

}
