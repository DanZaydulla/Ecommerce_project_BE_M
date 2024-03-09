package com.example.Ecommerce_project_BE.service;

import com.example.Ecommerce_project_BE.model.Order;
import com.example.Ecommerce_project_BE.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void saveOrder(Order order) {
        orderRepository.saveOrder(order);
    }

    @Override
    public Order findOrderById(Integer orderId) {
        return orderRepository.findOrderById(orderId);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.getAllOrders();
    }

    @Override
    public void updateOrder(Order order) {
        orderRepository.updateOrder(order);
    }

    @Override
    public void deleteOrderById(Integer orderId) {
        orderRepository.deleteOrderById(orderId);
    }
}
