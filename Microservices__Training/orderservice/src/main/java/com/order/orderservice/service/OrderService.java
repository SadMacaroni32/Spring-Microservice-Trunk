package com.order.orderservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.orderservice.dto.ProductDTO;
import com.order.orderservice.model.OrderModel;
import com.order.orderservice.repository.OrderRepository;
import com.order.orderservice.repository.ProductClient;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductClient productClient;

    public List<OrderModel> getAllOrders() {
        return orderRepository.findAll();
    }

    public OrderModel getOrderById(String id) {
        return orderRepository.findById(id).orElse(null);
    }

    public OrderModel addOrder(OrderModel order) {
        ProductDTO product = productClient.getProductById(order.getProductId());
        if (product != null) {
            return orderRepository.save(order);
        } else {
            throw new RuntimeException("Product not found!");
        }
    }

}
