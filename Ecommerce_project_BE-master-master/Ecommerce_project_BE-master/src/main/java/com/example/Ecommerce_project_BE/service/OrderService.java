package com.example.Ecommerce_project_BE.service;

import com.example.Ecommerce_project_BE.model.Order;
import com.example.Ecommerce_project_BE.model.OrderRequest;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface OrderService {

    void saveOrder(Order order);
    Order findOrderById(Integer orderId);
    List<Order> getAllOrders();
    void updateOrder(Order order);
    void deleteOrderById(Integer orderId);
}
