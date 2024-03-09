package com.example.Ecommerce_project_BE.repository;

import com.example.Ecommerce_project_BE.model.Order;
import com.example.Ecommerce_project_BE.model.Status;
import com.example.Ecommerce_project_BE.repository.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import static com.example.Ecommerce_project_BE.Utils.Constants.ORDER_TABLE_NAME;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void saveOrder(Order order) {
        String sql = "INSERT INTO " + ORDER_TABLE_NAME +
                " (customer_id, order_date, shipping_address, total_price, status) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                order.getCustomerId(),
                order.getOrderDate(),
                order.getShippingAddress(),
                order.getTotalPrice(),
                order.getStatus().toString());
    }

    @Override
    public Order findOrderById(Integer orderId) {
        String sql = "SELECT * FROM " + ORDER_TABLE_NAME + " WHERE order_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{orderId}, new OrderMapper());
    }

    @Override
    public List<Order> getAllOrders() {
        String sql = "SELECT * FROM " + ORDER_TABLE_NAME;
        return jdbcTemplate.query(sql, new OrderMapper());
    }

    @Override
    public void updateOrder(Order order) {
        String sql = "UPDATE " + ORDER_TABLE_NAME +
                " SET customer_id = ?, order_date = ?, shipping_address = ?, total_price = ?, status = ? WHERE order_id = ?";
        jdbcTemplate.update(sql,
                order.getCustomerId(),
                order.getOrderDate(),
                order.getShippingAddress(),
                order.getTotalPrice(),
                order.getStatus().toString(),
                order.getOrderId());
    }


    @Override
    public void deleteOrderById(Integer orderId) {
        String sql = "DELETE FROM " + ORDER_TABLE_NAME + " WHERE order_id = ?";
        jdbcTemplate.update(sql, orderId);
    }
}
