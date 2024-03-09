package com.example.Ecommerce_project_BE.repository.mapper;

import com.example.Ecommerce_project_BE.model.Order;
import com.example.Ecommerce_project_BE.model.Status;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements RowMapper<Order> {
    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Order(
                rs.getInt("order_id"),
                rs.getInt("customer_id"),
                rs.getDate("order_date").toLocalDate(), // Converts SQL Date to LocalDate
                rs.getString("shipping_address"),
                rs.getDouble("total_price"),
                Status.valueOf(rs.getString("status")) // Assumes 'status' column matches enum names
        );
    }
}
