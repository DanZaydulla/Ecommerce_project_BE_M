package com.example.Ecommerce_project_BE.repository;

import com.example.Ecommerce_project_BE.model.Item;
import com.example.Ecommerce_project_BE.repository.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import static com.example.Ecommerce_project_BE.Utils.Constants.ITEM_TABLE_NAME;
@Repository
public class ItemRepositoryImpl implements ItemRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Item> rowMapper = (rs, rowNum) -> new Item(
            rs.getInt("item_id"),
            rs.getString("title"),
            rs.getString("photo_url"),
            rs.getDouble("price"),
            rs.getInt("quantity")
    );

    @Override
    public List<Item> findAll() {
        return jdbcTemplate.query("SELECT * FROM item", rowMapper);
    }

    @Override
    public Item findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM item WHERE item_id = ?", new Object[]{id}, rowMapper);
    }

    @Override
    public int save(Item item) {
        return jdbcTemplate.update("INSERT INTO item (title, photo_url, price, quantity) VALUES (?, ?, ?, ?)",
                item.getTitle(), item.getPhotoUrl(), item.getPrice(), item.getQuantity());
    }

    @Override
    public int update(Item item) {
        return jdbcTemplate.update("UPDATE item SET title = ?, photo_url = ?, price = ?, quantity = ? WHERE item_id = ?",
                item.getTitle(), item.getPhotoUrl(), item.getPrice(), item.getQuantity(), item.getItemId());
    }

    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM item WHERE item_id = ?", id);
    }
}

