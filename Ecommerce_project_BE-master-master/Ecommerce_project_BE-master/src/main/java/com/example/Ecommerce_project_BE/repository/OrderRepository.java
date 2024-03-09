package com.example.Ecommerce_project_BE.repository;

import com.example.Ecommerce_project_BE.model.Order;
import com.example.Ecommerce_project_BE.model.OrderRequest;

import java.util.List;

public interface OrderRepository {
    void saveOrder(Order order);
    Order findOrderById(Integer orderId);
    List<Order> getAllOrders();
    void updateOrder(Order order);
    void deleteOrderById(Integer orderId);
}
