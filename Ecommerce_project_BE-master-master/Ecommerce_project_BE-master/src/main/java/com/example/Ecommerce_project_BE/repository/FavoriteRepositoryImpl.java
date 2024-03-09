package com.example.Ecommerce_project_BE.repository;

import com.example.Ecommerce_project_BE.model.Favorite;
import com.example.Ecommerce_project_BE.repository.mapper.FavoriteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import static com.example.Ecommerce_project_BE.Utils.Constants.FAVORITE_TABLE_NAME;

@Repository
public class FavoriteRepositoryImpl implements FavoriteRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addFavorite(Favorite favorite) {
        String sql = "INSERT INTO " + FAVORITE_TABLE_NAME + " (customer_id, item_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, favorite.getCustomerId(), favorite.getItemId());
    }

    @Override
    public void removeFavorite(Integer customerId, Integer itemId) {
        String sql = "DELETE FROM " + FAVORITE_TABLE_NAME + " WHERE customer_id = ? AND item_id = ?";
        jdbcTemplate.update(sql, customerId, itemId);
    }

    @Override
    public List<Favorite> findFavoritesByCustomerId(Integer customerId) {
        String sql = "SELECT * FROM " + FAVORITE_TABLE_NAME + " WHERE customer_id = ?";
        return jdbcTemplate.query(sql, new FavoriteMapper(), customerId);
    }
}
