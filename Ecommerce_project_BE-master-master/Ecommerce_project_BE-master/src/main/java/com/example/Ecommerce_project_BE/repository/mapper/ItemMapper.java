package com.example.Ecommerce_project_BE.repository.mapper;

import com.example.Ecommerce_project_BE.model.Item;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemMapper implements RowMapper<Item> {
    @Override
    public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Item(
                rs.getInt("item_id"),
                rs.getString("title"),
                rs.getString("photo_url"),
                rs.getDouble("price"),
                rs.getInt("quantity")
        );
    }
}
