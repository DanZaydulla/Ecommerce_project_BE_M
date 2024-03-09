package com.example.Ecommerce_project_BE.repository.mapper;

import com.example.Ecommerce_project_BE.model.Favorite;
import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FavoriteMapper implements RowMapper<Favorite> {

    @Override
    public Favorite mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Favorite(
                rs.getInt("customer_id"),
                rs.getInt("item_id")

        );



    }
}
